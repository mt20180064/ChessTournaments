/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.service;

import com.chess.organization.model.Referee;
import com.chess.organization.model.Tournament;
import com.chess.organization.repository.RefereeRepository;
import com.chess.organization.repository.TournamentRepository;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



/**
 *
 * @author user
 */
@SpringBootTest
public class TournamentServiceTests {
    
    @Autowired
    private  TournamentService tournamentService;
    
    @MockBean
    private TournamentRepository tournamentRepository;
    
    @MockBean
    private RefereeRepository refereeRepository;
    
    @MockBean
    private RefereeService refereeService;
    
    @Test
    public void testSaveMethodSuccessfull() throws Exception{
        
        Tournament t = new Tournament(8l, "tournament1", "belgrade", "kategorni", "1h", "aktivan","balkan");
		
		when(tournamentRepository.save(t)).thenReturn(t);
		when(tournamentRepository.findById(t.getId())).thenReturn(Optional.empty());
		Tournament u = tournamentService.save(t);
		assertNotNull(u);
		assertEquals(t, u);
    }
    
         @Test
	public void saveFailureBecauseNameIsNullTest() {
		Tournament t = new Tournament(3l, null, "belgrade", "kategorni", "1h", "aktivan", "balkan");
		when(tournamentRepository.save(t));
		assertThrows(Exception.class, () -> {
			tournamentService.save(t);
		});
	}
        
    
@Test
public void saveFailureBecauseRefereeDoesNotExistTest() {
    Long nonExistentRefereeId = 99L; 
    Referee nonExistentReferee = new Referee();
    nonExistentReferee.setId(nonExistentRefereeId);
    Tournament tournamentWithInvalidReferee = new Tournament(2L, "Tournament Name", "Location", "Category", "Duration", "Status", nonExistentReferee, "Region");

    when(refereeRepository.findById(nonExistentRefereeId)).thenReturn(Optional.empty());
    
    assertThrows(Exception.class, () -> {
        tournamentService.save(tournamentWithInvalidReferee);
    });
}
      
}
