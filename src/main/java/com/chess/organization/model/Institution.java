/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;




/**
 *
 * @author user
 */
@MappedSuperclass
public abstract class Institution {
     @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    private  Long id;
     @Column(name = "naziv")
    private  String naziv;
     @Column(name = "grad")
    private  String grad;

    public Institution() {
    }
    
    public Institution(Builder builder) {
        this.id = builder.id;
        this.naziv = builder.naziv;
        this.grad = builder.grad;
    }
    
    public abstract static class Builder<T extends Builder<T>> {

        private  Long id;
        private  String naziv;
        private String grad;
       

        public Builder(Long id, String naziv) {
            this.id = id;
            this.naziv = naziv;
        }

        public T grad(String grad) {
            this.grad = grad;
            return self();
        }

       
public T id(Long id) {
            this.id= id;
            return self();
        }
        protected abstract T self();

        public abstract Institution build();

    }

  
}
