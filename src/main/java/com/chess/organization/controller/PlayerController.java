/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.controller;

import com.chess.organization.model.Player;
import com.chess.organization.service.PlayerService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/player")
public class PlayerController {

    public PlayerController(com.chess.organization.service.PlayerService playerService) {
        this.playerService = playerService;
    }
    private final PlayerService playerService;
    
    
    @GetMapping
    public List<Player> getAll(){
        return playerService.findAll();
    }
}
