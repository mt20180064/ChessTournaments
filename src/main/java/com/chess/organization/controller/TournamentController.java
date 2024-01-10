/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.controller;

import com.chess.organization.model.Tournament;
import com.chess.organization.service.TournamentService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
