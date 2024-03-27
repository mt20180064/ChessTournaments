/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.controller;

import com.chess.organization.dto.GameDTO;
import com.chess.organization.model.Player;
import com.chess.organization.model.Referee;
import com.chess.organization.model.Tournament;
import com.chess.organization.service.TournamentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author user
 */
@WebMvcTest(TournamentController.class)
@ActiveProfiles("test")
public class TournamentControllerTests {
    
     @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TournamentService tournamentService;

    
    
@Test
public void updateStatusSuccessTest() throws Exception {
    Long tournamentId = 1L;
    Tournament tournament = new Tournament(tournamentId, "Tournament Name", "aktivan");
    Tournament updatedTournament = new Tournament(tournamentId, "Tournament Name", "zavrsen");

    when(tournamentService.findById(tournamentId)).thenReturn(tournament);
    when(tournamentService.save(any(Tournament.class))).thenReturn(updatedTournament);
    mockMvc.perform(put("/tournament/updateStatus")
            .param("tournamentId", String.valueOf(tournamentId))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id", equalTo(tournamentId.intValue())))
            .andExpect(jsonPath("$.status", equalTo("zavrsen")));

    verify(tournamentService, times(1)).save(tournament);
}
@Test
public void updateStatusTournamentNotFoundTest() throws Exception {
    Long tournamentId = 2L;
    
    when(tournamentService.findById(tournamentId)).thenThrow(new Exception("Tournament not found"));

    mockMvc.perform(put("/updateStatus")
            .param("tournamentId", String.valueOf(tournamentId))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());

    verify(tournamentService, times(0)).save(any(Tournament.class));
}

}
