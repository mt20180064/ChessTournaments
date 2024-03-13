/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chess.organization.service;

import com.chess.organization.dto.GameDTO;
import com.chess.organization.model.Game;
import com.chess.organization.model.Player;
import com.chess.organization.model.Tournament;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author user
 */
public interface TournamentService {
    Tournament save (Tournament tournament) throws Exception;
    List<Tournament> findAll();
    void delete (Long id);
  Tournament findById (Long id) throws Exception;
   Tournament saveUnique(Tournament tournament) throws Exception;
   List<Game> pairNextRound(Long tournamentId) throws Exception;
    public void processRoundResults(List<GameDTO> gameResults, Long tournamentId);
    public List<Player> getPlayersForTournament(Long tournamentId) ;
    public boolean havePlayedAgainstEachOther(Player player1, Player player2, List<Game> playedGames);
    public boolean alreadyThere(Game last, ArrayList<Game> helpList);
    public List<Game> getGamesPlayedOnTournament(Long tournamentId) throws Exception;
    
}
