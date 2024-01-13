/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.controller;

import com.chess.organization.model.Player;
import com.chess.organization.model.Registration;
import com.chess.organization.model.Tournament;
import com.chess.organization.service.PlayerService;
import com.chess.organization.service.RegistrationService;
import com.chess.organization.service.TournamentService;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/player")
public class PlayerController {

    public PlayerController(com.chess.organization.service.PlayerService playerService, com.chess.organization.service.TournamentService tournamentService, com.chess.organization.service.RegistrationService registrationService) {
        this.playerService = playerService;
        this.tournamentService = tournamentService;
        this.registrationService = registrationService;
    }
    private final PlayerService playerService;
    private final TournamentService tournamentService;
    private final RegistrationService registrationService;
    
    
    @GetMapping
    public List<Player> getAll(){
        return playerService.findAll();
    }
    
    @PostMapping
    public Player add (@RequestBody Player player){
        return playerService.save(player);
    }
    
    @GetMapping("/tournamentPlayers")
    public List<Player> tournamentPlayers (@RequestParam Long tournamentId){
        Optional<Tournament> t =tournamentService.findById(tournamentId);
        LinkedList<Player> players = new LinkedList<>();
       if (t.isPresent()){
           Tournament tt = t.get();
          List<Registration> listOfRegs= registrationService.findByTournamentID(tt);
           for (Registration listOfReg : listOfRegs) {
               if (!players.contains(listOfReg.getPlayerID())){
                   players.add(listOfReg.getPlayerID());
               }
           }
       } return players;
    }
}
