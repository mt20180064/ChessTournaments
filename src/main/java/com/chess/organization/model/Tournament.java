/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.ResultSet;
import java.util.LinkedList;
import jakarta.persistence.Transient;

/**
 *
 * @author Milena Kutch
 */
@Entity
@Table (name = "tournament")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "tournamentid")
    private Long id;
    @Column (name = "naziv")
    private String name;
    @Column (name = "mesto")
    private String place;
    @Column (name = "tip")
    private String type;
    @Column (name = "tempo")
  private String pace;
    @Column (name="status")
    private String status;
    
    @Transient
  private LinkedList<Game> games = new LinkedList<>();
    @Transient
  private LinkedList<Round> rounds = new LinkedList<>();
  @Transient
    private LinkedList<Player> players;
  @ManyToOne
   @JoinColumn(name = "refereeid")
  private Referee referee;
 
  @Transient
  private Player prvi;
  @Transient
  private Player drugi;
  @Transient
  private Player treci;
  @Transient
  private int gamesPlayed;
  @Column (name = "region")
  private String region;

    public Tournament() {
    }

    public Tournament(Long id, String name, String place, String type, String pace, LinkedList<Game> games, LinkedList<Player> players, Referee referee, String status, String region) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.type = type;
        this.pace = pace;
        this.games = games;
        this.players = players;
        this.referee = referee;
        this.status = status;
        this.region = region;
    }

    public Tournament(Long id, String name, String place, String type, String pace, String status, Referee referee, String region) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.type = type;
        this.pace = pace;
        this.status = status;
        this.referee = referee;
        this.region = region;
    }

    public Tournament(Long id, String name, String place, String type, String pace, String status, String region) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.type = type;
        this.pace = pace;
        this.status = status;
        this.region = region;
    }

    public Tournament(Long tournamentId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPace() {
        return pace;
    }

    public void setPace(String pace) {
        this.pace = pace;
    }

    public LinkedList<Game> getGames() {
        return games;
    }

    public void setGames(LinkedList<Game> games) {
        this.games = games;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Player getPrvi() {
        return prvi;
    }

    public void setPrvi(Player prvi) {
        this.prvi = prvi;
    }

    public Player getDrugi() {
        return drugi;
    }

    public void setDrugi(Player drugi) {
        this.drugi = drugi;
    }

    public Player getTreci() {
        return treci;
    }

    public void setTreci(Player treci) {
        this.treci = treci;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

   

    @Override
    public String toString() {
        return name;
    }

    public LinkedList<Round> getRounds() {
        return rounds;
    }

    public void setRounds(LinkedList<Round> rounds) {
        this.rounds = rounds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  
  
}
