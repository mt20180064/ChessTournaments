/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chess.organization.service;

import com.chess.organization.dto.GameDTO;
import com.chess.organization.model.Game;
import com.chess.organization.model.Tournament;
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
   Optional<Tournament> findById (Long id);
   Tournament saveUnique(Tournament tournament);
   List<Game> pairNextRound(Long tournamentId) throws Exception;
    public void processRoundResults(List<GameDTO> gameResults, Long tournamentId);
}
