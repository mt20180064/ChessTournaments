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
import com.chess.organization.repository.RefereeRepository;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import static org.springframework.util.ObjectUtils.isEmpty;

/**
 *
 * @author user
 */
@Service
public class TournamentServiceImpl implements TournamentService{

    public TournamentServiceImpl(TournamentRepository tournamentRepository, PlayerRepository playerRepository, GameRepository gameRepository, RegistrationRepository registrationRepository, RefereeRepository refereeRepository) {
        this.TournamentRepository = tournamentRepository;
        this.playerRepository=playerRepository;
        this.gameRepository=gameRepository;
        this.RegistrationRepository = registrationRepository;
        this.refereeRepository=refereeRepository;
    }

  private final RefereeRepository refereeRepository;
   private final TournamentRepository TournamentRepository;
   private final PlayerRepository playerRepository;
   private final GameRepository gameRepository;
   private final RegistrationRepository RegistrationRepository;

   
    
   
    @Override
    public Tournament save(Tournament tournament) throws Exception {
        if (isEmpty(refereeRepository.findById(tournament.getReferee().getId()))) 
            throw new Exception ("tournament must have valid refereeid");
       
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
    public Tournament findById(Long id) throws Exception {
        Optional <Tournament> t = TournamentRepository.findById(id);
        if (t.isEmpty()){
            throw new Exception ("there is no tournament with this id");
        } 
        Tournament tour = t.get();
         return tour;
    }

    @Override
    public Tournament saveUnique(Tournament tournament) throws Exception {
        if (tournament.getName()==null) throw new Exception ("tournament must have a name");
        return TournamentRepository.save(tournament);
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

    @Override
    public List<Player> getPlayersForTournament(Long tournamentId)  {
        try {
            Tournament t =findById(tournamentId);
            System.out.println(t.getName());
            LinkedList<Player> players = new LinkedList<>();
            
            
            List<Registration> listOfRegs= RegistrationRepository.findByTournamentID(t);
            for (Registration listOfReg : listOfRegs) {
                if (!players.contains(listOfReg.getPlayerID())){
                    players.add(listOfReg.getPlayerID());
                }
            }
            System.out.println(players);
            return players;
        } catch (Exception ex) {
            Logger.getLogger(TournamentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }

    @Override
    public List<Game> getGamesPlayedOnTournament(Long tournamentId) throws Exception {
        Optional<Tournament> t = TournamentRepository.findById(tournamentId);
        if (t.isEmpty()){
            throw new Exception("Non existing tournament");
            
        } 
        Tournament tournament = t.get();
        List<Game> tournamentGames = gameRepository.findByTournament(tournament);
        return tournamentGames;
    }

    @Override
    public boolean havePlayedAgainstEachOther(Player player1, Player player2, List<Game> playedGames) {
       
     return playedGames.stream()
            .anyMatch(game -> (game.getWhite().equals(player1) && game.getBlack().equals(player2)) ||
                              (game.getWhite().equals(player2) && game.getBlack().equals(player1)));
    
    }


    @Override
    public boolean alreadyThere(Game last, ArrayList<Game> helpList) {
        for (Game game : helpList) {
                    if (game.getWhite()==last.getBlack() || game.getBlack()==last.getWhite()||game.getWhite()==last.getWhite()||game.getBlack()==last.getBlack()) return true;
                    
                } return false;
    }

    

   
    
    
}
