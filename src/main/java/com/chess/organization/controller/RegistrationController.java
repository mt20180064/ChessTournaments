/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.controller;

import com.chess.organization.model.Registration;
import com.chess.organization.service.RegistrationService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {

    public RegistrationController(com.chess.organization.service.RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
   private final RegistrationService registrationService;
   
   
   @GetMapping
   public List<Registration> getAll(){
       return registrationService.findAll();
   }
}
