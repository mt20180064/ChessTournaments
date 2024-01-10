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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milena Kutch
 */
@Entity
@Table(name = "club-spring")
public class Club{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    @Column(name = "naziv")
private String naziv;
    @Column(name = "grad")
private String grad;
    
        @OneToMany(mappedBy = "club")
    private List<Player> players;

    public Club() {
    }

    public Club(Long id, String naziv, String grad) {
        this.id = id;
        this.naziv = naziv;
        this.grad = grad;
    }

    
   

    @Override
    public String toString() {
        return naziv;
    }

    
    
    


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
