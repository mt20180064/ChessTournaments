/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.impl;

import com.chess.organization.dto.GameDTO;
import com.chess.organization.model.Game;
import com.chess.organization.model.Player;
import com.chess.organization.model.Registration;
import com.chess.organization.model.Tournament;
import com.chess.organization.repository.GameRepository;
import com.chess.organization.repository.PlayerRepository;
import com.chess.organization.repository.RegistrationRepository;
import com.chess.organization.repository.TournamentRepository;
import com.chess.organization.service.TournamentService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class TournamentServiceImpl implements TournamentService{

    public TournamentServiceImpl(com.chess.organization.repository.TournamentRepository TournamentRepository, com.chess.organization.repository.PlayerRepository playerRepository, com.chess.organization.repository.GameRepository gameRepository, com.chess.organization.repository.RegistrationRepository RegistrationRepository) {
        this.TournamentRepository = TournamentRepository;
        this.playerRepository=playerRepository;
        this.gameRepository=gameRepository;
        this.RegistrationRepository = RegistrationRepository;
    }

  
   private final TournamentRepository TournamentRepository;
   private final PlayerRepository playerRepository;
   private final GameRepository gameRepository;
   private final RegistrationRepository RegistrationRepository;
   
    @Override
    public Tournament save(Tournament tournament) {
        return TournamentRepository.save(tournament);
    }

    @Override
    public List<Tournament> findAll() {
       return TournamentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<Tournament> c = TournamentRepository.findById(id);
        if (c.isPresent()){
            Tournament t = c.get();
            TournamentRepository.delete(t);
        }
               
    }

    @Override
    public Optional<Tournament> findById(Long id) {
         return TournamentRepository.findById(id);
    }

    @Override
    public Tournament saveUnique(Tournament tournament) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
 
    @Override
    public List<Game> pairNextRound(Long tournamentId) throws Exception {
        int tableNumber = 1;
    List<Player> players = getPlayersForTournament(tournamentId);
    List<Game> playedGames = getGamesPlayedOnTournament (tournamentId);
    players.sort(Comparator.comparing(Player::getPoints).reversed());
   ArrayList<Player> pla= new ArrayList<>();
                    ArrayList<Game> helpList=new ArrayList<>();
                     for (Player player : players) {
                         pla.add(player);
                     }
                     for (Player player : pla) {
                         for (Player player1 : pla) {
                             if (player==player1) continue;
                             if (!player.getProtivnici().contains(player1) && !havePlayedAgainstEachOther(player1, player, playedGames)){
                                 player.getCandidates().add(player1);
                             Game last = new Game (0, player,player.getCandidates().getFirst(),1,0);
                             
                             if (!alreadyThere(last,helpList)){
                                 last.setTable(tableNumber++);
                             helpList.add(last);
                             } else continue;  
                             }}}
                     if (helpList.size()*2==players.size()){
                       return helpList; } 
                     else {
                       for (Player player : players) {
                             Collections.shuffle(player.getCandidates());  
                         }
                       try {
                             pairNextRound(tournamentId); 
                       } catch (StackOverflowError soe){System.out.println("soe");}
                     } return pairNextRound(tournamentId);
    }

    @Override
    public void processRoundResults(List<GameDTO> gameResults, Long tournamentId) {
          List<Game> games = new ArrayList<>();
          Optional<Tournament> t = TournamentRepository.findById(tournamentId);
          if (t.isPresent()){
              Tournament tournament = t.get();
        for (GameDTO gameDTO : gameResults) {
            Player whitePlayer = playerRepository.findById(gameDTO.getWhitePlayerId())
                    .orElseThrow(() -> new RuntimeException("Player not found"));
            Player blackPlayer = playerRepository.findById(gameDTO.getBlackPlayerId())
                    .orElseThrow(() -> new RuntimeException("Player not found"));

            Game game = new Game();
            game.setWhite(whitePlayer);
            game.setBlack(blackPlayer);
            game.setPointswhite(gameDTO.getPointsWhite());
            game.setPointsblack(gameDTO.getPointsBlack());
            game.setTournament(tournament); 
            
            
            games.add(game);
        }

        gameRepository.saveAll(games); 
    }
    }

    private List<Player> getPlayersForTournament(Long tournamentId) {
        Optional<Tournament> t =findById(tournamentId);
        LinkedList<Player> players = new LinkedList<>();
       if (t.isPresent()){
           Tournament tt = t.get();
          List<Registration> listOfRegs= RegistrationRepository.findByTournamentID(tt);
           for (Registration listOfReg : listOfRegs) {
               if (!players.contains(listOfReg.getPlayerID())){
                   players.add(listOfReg.getPlayerID());
               }
           }
       } return players;
    }

    private List<Game> getGamesPlayedOnTournament(Long tournamentId) throws Exception {
        Optional<Tournament> t = TournamentRepository.findById(tournamentId);
        if (t.isEmpty()){
            throw new Exception("Non existing tournament");
            
        } 
        Tournament tournament = t.get();
        List<Game> tournamentGames = gameRepository.findByTournament(tournament);
        return tournamentGames;
    }

    private boolean havePlayedAgainstEachOther(Player player1, Player player2, List<Game> playedGames) {
       
     return playedGames.stream()
            .anyMatch(game -> (game.getWhite().equals(player1) && game.getBlack().equals(player2)) ||
                              (game.getWhite().equals(player2) && game.getBlack().equals(player1)));
    
    }


    private boolean alreadyThere(Game last, ArrayList<Game> helpList) {
        for (Game game : helpList) {
                    if (game.getWhite()==last.getBlack() || game.getBlack()==last.getWhite()||game.getWhite()==last.getWhite()||game.getBlack()==last.getBlack()) return true;
                    
                } return false;
    }

    

   
    
    
}
