/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chess.organization.service;

import com.chess.organization.model.Player;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author user
 */
public interface PlayerService {
     Player save (Player player);
    List<Player> findAll();
    void delete (Long id);
   Player findById (Long id) throws Exception;
   Player saveUnique(Player player);
   Player findByUsername (String username);

    boolean checkPassword(Player player, String password);
}
