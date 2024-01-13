/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.controller;

import com.chess.organization.dto.LoginRequestDto;
import com.chess.organization.model.Player;
import com.chess.organization.model.Referee;
import com.chess.organization.service.PlayerService;
import com.chess.organization.service.RefereeService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    private final PlayerService playerService;
    private final RefereeService refereeService;

    public LoginController(PlayerService playerService, com.chess.organization.service.RefereeService refereeService) {
        this.playerService = playerService;
        this.refereeService = refereeService;
    }
    
    
    
    
    
  @PostMapping
public ResponseEntity<Map<String,Object>> login(@RequestBody LoginRequestDto loginRequest) throws Exception {
       HashMap<String,Object> userMap = new HashMap<>();
       Referee ref = refereeService.findByUsername(loginRequest.getUsername());
        if (ref!=null){
            if (ref.getPassword().equals(loginRequest.getPassword())) {
                userMap.put ("user", ref);
                userMap.put("userType", "referee");
                return new ResponseEntity<>(userMap, HttpStatus.OK);
            }
            else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            Player p = playerService.findByUsername(loginRequest.getUsername());
            if (p!=null){
                if (p.getPassword().equals(loginRequest.getPassword())){
                    userMap.put("user", p);
                    userMap.put("userType", "player");
                    return new ResponseEntity<>(userMap, HttpStatus.OK);
                }
            } else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } throw new Exception ("There is no user with this username");
}

}
