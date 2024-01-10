/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
public class Round {
    private int id;
    private int redni;
    private Tournament tournament;
    private ArrayList<Game> games;

    public Round(int id, int redni, Tournament tournament, ArrayList<Game> games) {
        this.id = id;
        this.redni = redni;
        this.tournament = tournament;
        this.games = games;
    }

    
   

   

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Round{" + "redni=" + redni + ", tournament=" + tournament + ", games=" + games + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRedni() {
        return redni;
    }

    public void setRedni(int redni) {
        this.redni = redni;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    
    
    
}
