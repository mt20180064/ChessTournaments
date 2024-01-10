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
import jakarta.persistence.Table;


/**
 *
 * @author Milena Kutch
 */
@Entity
@Table(name = "Referee")
public class Referee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refereeid")
    private Long id;
    @Column (name = "name")
    private String name;
    @Column (name = "surname")
    private String surname;
    @Column (name = "title")
    private String title;
    @Column (name = "username")
    private String username;
    @Column (name = "password")
    private String password;

    public Referee() {
    }

    public Referee(Long id, String name, String surname, String title, String username, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.username = username;
        this.password = password;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

   

    

   

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
