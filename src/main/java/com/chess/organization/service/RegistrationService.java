/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.chess.organization.service;

import com.chess.organization.model.Registration;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */

public interface RegistrationService {
    Registration save (Registration registration);
    List<Registration> findAll();
    void delete (Long id);
   Optional<Registration> findById (Long id);
   Registration saveUnique(Registration registration);
}
