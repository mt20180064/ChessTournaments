/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chess.organization.service;

import com.chess.organization.model.Game;
import com.chess.organization.model.Tournament;
import java.util.List;

/**
 *
 * @author user
 */
public interface GameService {
     List<Game> findByTournament (Tournament tournament);
}
