/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chess.organization.service;


import com.chess.organization.model.Referee;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author user
 */
public interface RefereeService {
     Referee save (Referee referee);
    List<Referee> findAll();
    void delete (Long id);
   Optional<Referee> findById (Long id);
   Referee saveUnique(Referee referee);
}
