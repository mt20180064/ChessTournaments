/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.impl;

import com.chess.organization.model.Player;
import com.chess.organization.repository.PlayerRepository;
import com.chess.organization.service.PlayerService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    public PlayerServiceImpl(com.chess.organization.repository.PlayerRepository PlayerRepository) {
        this.PlayerRepository = PlayerRepository;
    }
    private final PlayerRepository PlayerRepository;
    
    @Override
    public Player save(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Player> findAll() {
        return PlayerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Player> findById(Long id) {
        return PlayerRepository.findById(id);
    }

    @Override
    public Player saveUnique(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Player> findByUsername(String username) {
       return PlayerRepository.findByUsername(username);
    }

    @Override
    public boolean checkPassword(Player player, String password) {
       if (player.getPassword().equals(password)) return true;
       return false;
    }
    
}
;