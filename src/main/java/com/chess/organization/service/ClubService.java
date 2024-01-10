/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chess.organization.service;

import com.chess.organization.model.Club;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */

public interface ClubService {
    Club save (Club club);
    List<Club> findAll();
    void delete (Long id);
   Optional<Club> findById (Long id);
   Club saveUnique(Club club);
}