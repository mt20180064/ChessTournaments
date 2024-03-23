/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.controller;

import com.chess.organization.dto.GameDTO;
import com.chess.organization.model.Game;
import com.chess.organization.model.Player;


import com.chess.organization.model.Tournament;
import com.chess.organization.service.TournamentService;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/tournament")
public class TournamentController {

    public TournamentController(com.chess.organization.service.TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }
    private final TournamentService tournamentService;
   
    @GetMapping
    public List<Tournament> getAll(){
        return tournamentService.findAll();
    }
    
   
      @GetMapping("/pairNextRound")
    public ResponseEntity<?> pairNextRound(@RequestParam Long tournamentId) {
        try {
           
           List<Game> nextRoundGames = tournamentService.pairNextRound(tournamentId);
            return ResponseEntity.ok(nextRoundGames);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error pairing next round: " + e.getMessage());
        }
    }
    @PostMapping("/submitRoundResults")
    public ResponseEntity<?> submitRoundResults(@RequestBody List<GameDTO> gameResults, @RequestParam Long tournamentId) {
    try {
        tournamentService.processRoundResults(gameResults, tournamentId);
        return ResponseEntity.ok().build();
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Error processing round results: " + e.getMessage());
    }
}

@PutMapping("/updateStatus")
public ResponseEntity<Tournament> updateStatus (@RequestParam Long tournamentId) throws Exception{
        Tournament t = tournamentService.findById(tournamentId);

    t.setStatus("zavrsen");
    Tournament tournamentUpdated = tournamentService.save(t);
    return new ResponseEntity<>(tournamentUpdated, HttpStatus.OK);
}


@PostMapping("/save")
	public @ResponseBody ResponseEntity<Tournament> save(@RequestBody Tournament t) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(tournamentService.save(t));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
