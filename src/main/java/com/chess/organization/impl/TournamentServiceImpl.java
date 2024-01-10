/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.impl;

import com.chess.organization.model.Tournament;
import com.chess.organization.repository.TournamentRepository;
import com.chess.organization.service.TournamentService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class TournamentServiceImpl implements TournamentService{

    public TournamentServiceImpl(com.chess.organization.repository.TournamentRepository TournamentRepository) {
        this.TournamentRepository = TournamentRepository;
    }

  
   private final TournamentRepository TournamentRepository;
   
    @Override
    public Tournament save(Tournament tournament) {
        return TournamentRepository.save(tournament);
    }

    @Override
    public List<Tournament> findAll() {
       return TournamentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<Tournament> c = TournamentRepository.findById(id);
        if (c.isPresent()){
            Tournament t = c.get();
            TournamentRepository.delete(t);
        }
               
    }

    @Override
    public Optional<Tournament> findById(Long id) {
         return TournamentRepository.findById(id);
    }

    @Override
    public Tournament saveUnique(Tournament tournament) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
