/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.controller;

import com.chess.organization.dto.LoginRequestDto;
import com.chess.organization.model.Player;
import com.chess.organization.service.PlayerService;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/login")
public class LoginController {
    private final PlayerService playerService;

    public LoginController(PlayerService playerService) {
        this.playerService = playerService;
    }
    
  @PostMapping
public ResponseEntity<Player> login(@RequestBody LoginRequestDto loginRequest) {
    try {
        Optional<Player> p = playerService.findByUsername(loginRequest.getUsername());
        if (p.isPresent()) {
            Player player = p.get();
            if (playerService.checkPassword(player, loginRequest.getPassword())) {
                return ResponseEntity.ok(player);
            } else {
                throw new Exception("Wrong password");
            }
        } else {
            throw new Exception("This user does not exist");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

}
