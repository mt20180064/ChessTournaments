/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.model;




/**
 *
 * @author user
 */
public abstract class Institution {
    private final Long id;
    private final String naziv;
    private final String grad;
    
    public Institution(Builder builder) {
        this.id = builder.id;
        this.naziv = builder.naziv;
        this.grad = builder.grad;
    }
    
    public abstract static class Builder<T extends Builder<T>> {

        private final Long id;
        private final String naziv;
        private String grad;
       

        public Builder(Long id, String naziv) {
            this.id = id;
            this.naziv = naziv;
        }

        public T grad(String grad) {
            this.grad = grad;
            return self();
        }

       

        protected abstract T self();

        public abstract Institution build();

    }

  
}
