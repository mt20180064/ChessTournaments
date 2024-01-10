/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.impl;

import com.chess.organization.model.Club;
import com.chess.organization.repository.ClubRepository;
import com.chess.organization.service.ClubService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class ClubServiceImpl implements ClubService{

    public ClubServiceImpl(com.chess.organization.repository.ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
    private final ClubRepository clubRepository;
    
    
    @Override
    public Club save(Club club) {
       
        return clubRepository.save(club);
    }

    @Override
    public List<Club> findAll() {
        
        return clubRepository.findAll();
    }

    @Override
    public void delete(Long id) {
       
        Optional<Club> opt= clubRepository.findById(id);
        Club c = opt.get();
        if (opt.isPresent()){
            clubRepository.delete(c);
        }
    }

    @Override
    public Optional<Club> findById(Long id) {
        return clubRepository.findById(id);
    }

    @Override
    public Club saveUnique(Club club) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
