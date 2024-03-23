/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



/**
 *
 * @author Milena Kutch
 */

@Entity
@Table(name="club-spring")
public class Club extends Institution{
    
    @Column (name="tip")
private  String tip;

    public Club(Builder builder) {
        super(builder);
        this.tip=builder.tip;
    }

    public Club() {
        
    }

    public Club(String tip) {
        this.tip = tip;
    }

    
    public static class Builder extends Institution.Builder<Builder> {

        
        private String tip = "n/a";

        public Builder(Long id, String naziv, String tip) {
            super(id, naziv);
            this.tip = tip;
        }

       

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Club build() {
            return new Club(this);
        }

    }
    
       

  
    
}
