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
    private Tournament TournamentID;
    @ManyToOne
    @JoinColumn(name = "playerid")
    private Player PlayerID;

    public Registration() {
    }

    public Registration(Long id, Tournament TournamentID, Player PlayerID) {
        this.id = id;
        this.TournamentID = TournamentID;
        this.PlayerID = PlayerID;
    }

   

    public Tournament getTournamentID() {
        return TournamentID;
    }

    public void setTournamentID(Tournament TournamentID) {
        this.TournamentID = TournamentID;
    }

    public Player getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(Player PlayerID) {
        this.PlayerID = PlayerID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
    
}
