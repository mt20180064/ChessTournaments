/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.dto;

/**
 *
 * @author user
 */
public class GameDTO {
    private Long whitePlayerId;
    private Long blackPlayerId;
    private Double pointsWhite;
    private Double pointsBlack;
    private Long tableNumber;

    public Long getWhitePlayerId() {
        return whitePlayerId;
    }

    public void setWhitePlayerId(Long whitePlayerId) {
        this.whitePlayerId = whitePlayerId;
    }

    public Long getBlackPlayerId() {
        return blackPlayerId;
    }

    public void setBlackPlayerId(Long blackPlayerId) {
        this.blackPlayerId = blackPlayerId;
    }

    public Double getPointsWhite() {
        return pointsWhite;
    }

    public void setPointsWhite(Double pointsWhite) {
        this.pointsWhite = pointsWhite;
    }

    public Double getPointsBlack() {
        return pointsBlack;
    }

    public void setPointsBlack(Double pointsBlack) {
        this.pointsBlack = pointsBlack;
    }

    public Long getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Long tableNumber) {
        this.tableNumber = tableNumber;
    }

    public GameDTO(Long whitePlayerId, Long blackPlayerId, Double pointsWhite, Double pointsBlack) {
        this.whitePlayerId = whitePlayerId;
        this.blackPlayerId = blackPlayerId;
        this.pointsWhite = pointsWhite;
        this.pointsBlack = pointsBlack;
    }

    public GameDTO(Long whitePlayerId, Long blackPlayerId, Double pointsWhite, Double pointsBlack, Long tableNumber) {
        this.whitePlayerId = whitePlayerId;
        this.blackPlayerId = blackPlayerId;
        this.pointsWhite = pointsWhite;
        this.pointsBlack = pointsBlack;
        this.tableNumber = tableNumber;
    }

    public GameDTO() {
    }

    
}