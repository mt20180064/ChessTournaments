/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.impl;

import com.chess.organization.model.Player;
import com.chess.organization.model.Registration;
import com.chess.organization.repository.RegistrationRepository;
import com.chess.organization.service.RegistrationService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class RegistrationServiceImpl implements RegistrationService{

    public RegistrationServiceImpl(com.chess.organization.repository.RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }
    private final RegistrationRepository registrationRepository;

    @Override
    public Registration save(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public List<Registration> findAll() {
         return registrationRepository.findAll();
    }

    @Override
    public void delete(Long id) {
     Optional<Registration> c = registrationRepository.findById(id);
        if (c.isPresent()){
            Registration r = c.get();
            registrationRepository.delete(r);
        }
    }

    @Override
    public Optional<Registration> findById(Long id) {
       return registrationRepository.findById(id);
    }

    @Override
    public Registration saveUnique(Registration registration) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Registration> findByPlayerID(Player playerId) {
       return registrationRepository.findByPlayerID(playerId);
    }
    
    
}
