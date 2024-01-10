/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.model;

import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Milena Kutch
 */
public class Game {
     private int id;
    private int table;
    private Referee referee;
    private Player white;
    private Player black;
    private Round round;
    private Tournament tournament;
    private double pointswhite;
    private double pointsblack;

    public Game() {
    }

    public Game( int table, Player white, Player black, Round round,  double pointswhite, double pointsblack) {
        
        this.table = table;
       
        this.white = white;
        this.black = black;
        this.round = round;
       // this.tournament = tournament;
        this.pointswhite = pointswhite;
        this.pointsblack = pointsblack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
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

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
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

}
