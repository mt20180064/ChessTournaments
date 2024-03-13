/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chess.organization.service;

import com.chess.organization.model.Player;
import com.chess.organization.model.Referee;
import com.chess.organization.model.Registration;
import com.chess.organization.model.Tournament;
import com.chess.organization.repository.RefereeRepository;
import com.chess.organization.repository.RegistrationRepository;
import com.chess.organization.repository.TournamentRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
    
    @MockBean
    private RegistrationRepository registrationRepository;
    
    @Test
    public void testSaveMethodSuccessfull() throws Exception{
        
        Tournament t = new Tournament(8l, "tournament1", "belgrade", "kategorni", "1h", "aktivan","balkan");
		
		when(tournamentRepository.save(t)).thenReturn(t);
		when(tournamentRepository.findById(t.getId())).thenReturn(Optional.empty());
		Tournament u = tournamentService.saveUnique(t);
		assertNotNull(u);
		assertEquals(t, u);
    }
    
        @Test
public void saveFailureBecauseNameIsNullTest() {
    Tournament t = new Tournament(3L, null, "belgrade", "kategorni", "1h", "aktivan", "balkan");
 
    assertThrows(Exception.class, () -> {
        tournamentService.saveUnique(t);
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

@Test
    public void findAllTournamentsTest() {
        
        Tournament tournament1 = new Tournament(4L, "Tournament One", "Location One", "Category One", "Duration One", "Status One", "Region One");
        Tournament tournament2 = new Tournament(5L, "Tournament Two", "Location Two", "Category Two", "Duration Two", "Status Two", "Region Two");
        List<Tournament> mockTournaments = Arrays.asList(tournament1, tournament2);

        when(tournamentRepository.findAll()).thenReturn(mockTournaments);
        List<Tournament> tournaments = tournamentService.findAll();
        assertEquals(mockTournaments, tournaments, "mock tournaments should be returned.");
        verify(tournamentRepository, times(1)).findAll(); 
    }
       @Test
    public void deleteTournamentWhenPresentTest() {
        Long tournamentId = 1L;
        Tournament tournament = new Tournament(tournamentId, "Tournament Name", "Location One", "Category One", "Duration One", "Status One", "Region One"); 
        when(tournamentRepository.findById(tournamentId)).thenReturn(Optional.of(tournament));

        tournamentService.delete(tournamentId);

        verify(tournamentRepository, times(1)).delete(tournament);
    }

    @Test
    public void doNotDeleteTournamentWhenNotPresentTest() {
        Long tournamentId = 2L;
        when(tournamentRepository.findById(tournamentId)).thenReturn(Optional.empty());

        tournamentService.delete(tournamentId);

        verify(tournamentRepository, never()).delete(any(Tournament.class));
    }
    
    @ParameterizedTest
@CsvFileSource(resources = "/registrations.csv", numLinesToSkip = 1, delimiter = ';')
public void getPlayersForTournamentTest(Long tournamentid, Long playerid) {

    Tournament tournament = new Tournament(tournamentid);
    Player player = new Player(playerid);
    Registration registration = new Registration(tournament, player);
    when(tournamentRepository.findById(tournamentid)).thenReturn(Optional.of(tournament));
    when(registrationRepository.findByTournamentID(tournament)).thenReturn(List.of(registration));

  
    List<Player> players = tournamentService.getPlayersForTournament(tournamentid);
    assertTrue(players.stream().anyMatch(p -> p.getId().equals(playerid)), "The list should contain the registered player.");
}
    
    
      @Test
    public void getPlayersForTournamentRemoveDuplicatesTest() {
        Long tournamentId = 1L; 
        Tournament tournament = new Tournament(tournamentId);
        when(tournamentRepository.findById(tournamentId)).thenReturn(Optional.of(tournament));
        
       
        Player player1 = new Player(15L); 
        Player player2 = new Player(13L); 
        Player duplicatePlayer1 = new Player(15L); 
        
        List<Registration> registrations = Arrays.asList(
            new Registration(tournament, player1),
            new Registration(tournament, duplicatePlayer1),
            new Registration(tournament, player2)
        );
        
        when(registrationRepository.findByTournamentID(tournament)).thenReturn(registrations);
        
        List<Player> players = tournamentService.getPlayersForTournament(tournamentId);
        
        assertEquals(2, players.size(), "Duplicate players should be removed.");
        assertTrue(players.contains(player1), "The list should contain player 1.");
        assertTrue(players.contains(player2), "The list should contain player 2.");
    }


}
