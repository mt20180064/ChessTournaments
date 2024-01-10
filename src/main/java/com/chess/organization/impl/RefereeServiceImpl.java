/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.impl;

import com.chess.organization.model.Referee;
import com.chess.organization.repository.RefereeRepository;
import com.chess.organization.service.RefereeService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class RefereeServiceImpl implements RefereeService{

    public RefereeServiceImpl(com.chess.organization.repository.RefereeRepository RefereeRepository) {
        this.RefereeRepository = RefereeRepository;
    }
    private final RefereeRepository RefereeRepository;
    
    @Override
    public Referee save(Referee referee) {
      return RefereeRepository.save(referee);
    }

    @Override
    public List<Referee> findAll() {
     return RefereeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
       Optional<Referee> c = RefereeRepository.findById(id);
        if (c.isPresent()){
            Referee r = c.get();
            RefereeRepository.delete(r);
        }
    }

    @Override
    public Optional<Referee> findById(Long id) {
      return RefereeRepository.findById(id);
    }

    @Override
    public Referee saveUnique(Referee referee) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
