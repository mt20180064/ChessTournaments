/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.controller;


import com.chess.organization.service.RefereeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/referee")
public class RefereeController {

    public RefereeController(com.chess.organization.service.RefereeService refereeService) {
        this.refereeService = refereeService;
    }
    private final RefereeService refereeService;
    
    
}
