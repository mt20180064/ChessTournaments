/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.controller;

import com.chess.organization.model.Game;
import com.chess.organization.model.Player;
import com.chess.organization.model.Registration;
import com.chess.organization.model.Round;
import com.chess.organization.model.Tournament;
import com.chess.organization.service.PlayerService;
import com.chess.organization.service.RegistrationService;
import com.chess.organization.service.TournamentService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
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
@RequestMapping("/player")
public class PlayerController {

    public PlayerController(com.chess.organization.service.PlayerService playerService, com.chess.organization.service.TournamentService tournamentService, com.chess.organization.service.RegistrationService registrationService) {
        this.playerService = playerService;
        this.tournamentService = tournamentService;
        this.registrationService = registrationService;
    }
    private final PlayerService playerService;
    private final TournamentService tournamentService;
    private final RegistrationService registrationService;
    
    
    @GetMapping
    public List<Player> getAll(){
        return playerService.findAll();
    }
    
    @PostMapping
    public Player add (@RequestBody Player player){
        return playerService.save(player);
    }
    
    @GetMapping("/tournamentPlayers")
    public List<Player> tournamentPlayers (@RequestParam Long tournamentId){
        Optional<Tournament> t =tournamentService.findById(tournamentId);
        LinkedList<Player> players = new LinkedList<>();
       if (t.isPresent()){
           Tournament tt = t.get();
          List<Registration> listOfRegs= registrationService.findByTournamentID(tt);
           for (Registration listOfReg : listOfRegs) {
               if (!players.contains(listOfReg.getPlayerID())){
                   players.add(listOfReg.getPlayerID());
               }
           }
       } return players;
    }
    @GetMapping("/pair")
    public List<Game> pairFirstRound(@RequestParam Long tid) throws Exception {
        int table=1;
        List<Player> playingchecked = tournamentPlayers(tid);
        ArrayList<Game> partije = new ArrayList<>();
        ArrayList<Player> vecIsparovani= new ArrayList<>();
        if (playingchecked == null){
            throw new Exception ("None players joined this tournament");
        } else{
            if (playingchecked.size()%2!=0){
                Player unpaired = new Player();
                        unpaired.setName("nesparen");
                        unpaired.setSurname("");
                        unpaired.setPoints(0.0);
                        unpaired.setRating(-1);
            playingchecked.add(unpaired);
            
                System.out.println("DODAT NESPAREN");
            }
            
            Collections.sort(playingchecked, new Comparator<Player>(){
            public int compare (Player igr1, Player igr2){
                if (igr1.getRating()<igr2.getRating()){
                    return 1;
                }
                return -1;
            }
        });
            
            System.out.println(playingchecked);
       for (Player igrac : playingchecked) {
                for (Player igrac1 : playingchecked) {
                   // System.out.println(igrac);
               if (igrac==igrac1)
                   continue;
               
              if (!vecIsparovani.contains(igrac) && !vecIsparovani.contains(igrac1)){
                  Game p = new Game(table++, igrac, igrac1,  1,0);
                  partije.add(p);
               
                  vecIsparovani.add(p.getWhite());
                  vecIsparovani.add(p.getBlack());
                 
                  
                  
              } else continue;}}
            System.out.println(partije);
               return partije;
               
    } 
}



            
        
            

            
           

           

            
           
            
     
    }




