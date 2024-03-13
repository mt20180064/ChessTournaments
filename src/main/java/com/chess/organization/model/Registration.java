/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
@Entity
@Table(name = "Registration")
public class Registration{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tournamentid")
    private Tournament tournamentID;
    @ManyToOne
    @JoinColumn(name = "playerid")
    private Player playerID;

    public Registration() {
    }

    public Registration(Long id, Tournament tournamentID, Player playerID) {
        this.id = id;
        this.tournamentID = tournamentID;
        this.playerID = playerID;
    }

    public Registration(Tournament tournamentID, Player playerID) {
        this.tournamentID = tournamentID;
        this.playerID = playerID;
    }

 

    

   

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tournament getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(Tournament tournamentID) {
        this.tournamentID = tournamentID;
    }

    public Player getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Player playerID) {
        this.playerID = playerID;
    }

    
    
    
}
