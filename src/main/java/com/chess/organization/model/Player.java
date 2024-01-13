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
@Table (name="players")
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerid")
    private Long id;
    @Column(name = "ime")
    private String name;
    @Column(name = "prezime")
    private String surname;
    @Column(name = "kategorija")
    private String category;
    @Column(name = "rejting")
    private int rating;
    @ManyToOne
    @JoinColumn(name = "KlubID")
    private Club club;
    @Column (name = "username")
    private String username;
    @Column (name = "password")
    private String password;
    
    @Transient
    private LinkedList<Player> protivnici;
    @Transient
    private double points;
    @Transient
    private LinkedList<Player> candidates = new LinkedList<>();
            

    public Player() {
        this.protivnici = new LinkedList<>();
    }

    public Player(Long id, String name, String surname, String category, int rating, Club club) {
        this.protivnici = new LinkedList<>();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.category = category;
        this.rating = rating;
        this.club = club;
      
    }
    
    

 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public LinkedList<Player> getProtivnici() {
        return protivnici;
    }

    public void setProtivnici(LinkedList<Player> protivnici) {
        this.protivnici = protivnici;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

  

    @Override
    public String toString() {
        return name+" "+surname;
    }

   

   @Override
public boolean equals(Object obj) {
   
    if (this == obj) {
        return true;
    }
    if (!(obj instanceof Player)) {
        return false;
    }

    Player other = (Player) obj;
    return this.id == other.id;
}


    public LinkedList<Player> getCandidates() {
        return candidates;
    }

    public void setCandidates(LinkedList<Player> candidates) {
        this.candidates = candidates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
