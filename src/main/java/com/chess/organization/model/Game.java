/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/**
 *
 * @author Milena Kutch
 */
@Entity
@Table (name= "game" , schema = "projekat")
public class Game {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
     private Long id;
    @Column (name="tableNumber")
    private int table;
   // private Referee referee;
    @ManyToOne
    @JoinColumn(name = "white")
    private Player white;
     @ManyToOne
    @JoinColumn(name = "black")
    private Player black;
    
    
    @ManyToOne
    @JoinColumn(name = "tournamentid")
    private Tournament tournament;
    @Column (name="points_white")
    private double pointswhite;
    @Column (name="points_black")
    private double pointsblack;

    public Game() {
    }

    public Game( int table, Player white, Player black,  double pointswhite, double pointsblack) {
        
        this.table = table;
       
        this.white = white;
        this.black = black;
        
       // this.tournament = tournament;
        this.pointswhite = pointswhite;
        this.pointsblack = pointsblack;
    }

    public Game(Player white, Player black) {
        this.white = white;
        this.black = black;
    }

 

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

 

    public Player getWhite() {
        return white;
    }

    public void setWhite(Player white) {
        this.white = white;
    }

    public Player getBlack() {
        return black;
    }

    public void setBlack(Player black) {
        this.black = black;
    }

   

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public double getPointswhite() {
        return pointswhite;
    }

    public void setPointswhite(double pointswhite) {
        this.pointswhite = pointswhite;
    }

    public double getPointsblack() {
        return pointsblack;
    }

    public void setPointsblack(double pointsblack) {
        this.pointsblack = pointsblack;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
