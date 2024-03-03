/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chess.organization.repository;

import com.chess.organization.model.Game;
import com.chess.organization.model.Registration;
import com.chess.organization.model.Tournament;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    public List<Game> findByTournament (Tournament tournament);
}
