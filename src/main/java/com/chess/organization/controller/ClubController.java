/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.controller;

import com.chess.organization.model.Club;
import com.chess.organization.service.ClubService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/club")
public class ClubController {
     private final ClubService clubService;


    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }
     
    @GetMapping("/all")
     List<Club> getAll (){
         return clubService.findAll();
     }
    
     @PostMapping("/save")
     Club save (Club club){
         return clubService.save(club);
     }
     
     
    
     
     @DeleteMapping
     void delete (Long id){
         
          clubService.delete(id);
     }
     
     @GetMapping("/{id}")
     Club findById(Long id){
         
        Optional<Club> opt = clubService.findById(id);
        if (opt.isPresent()){
            Club c = opt.get();
            return c;
        } return null;
     }
}
