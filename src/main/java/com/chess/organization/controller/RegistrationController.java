/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.controller;

import com.chess.organization.model.Player;
import com.chess.organization.model.Registration;
import com.chess.organization.service.PlayerService;
import com.chess.organization.service.RegistrationService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author user
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {

    public RegistrationController(com.chess.organization.service.RegistrationService registrationService, com.chess.organization.service.PlayerService playerService) {
        this.registrationService = registrationService;
        this.playerService = playerService;
    }
   private final RegistrationService registrationService;
   private final PlayerService playerService;
   
   @GetMapping
   public List<Registration> getAll(){
       return registrationService.findAll();
   }
   
   @GetMapping ("/playersTournaments")
   public List<Registration> getForPlayer (@RequestParam Long playerId){
       Optional<Player> p = playerService.findById(playerId);
       if (p.isPresent()){
           Player pp=p.get();
           return registrationService.findByPlayerID(pp);
       }
       return null;
   }
    
   @DeleteMapping
   public void delete (@RequestParam Long id){
      registrationService.delete(id);
   }
   
   
   @PostMapping
   public Registration add (@RequestBody Registration registration){
     return registrationService.save(registration);
   }
}
