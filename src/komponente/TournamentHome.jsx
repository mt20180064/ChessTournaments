import React from 'react';
import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import { useLocation } from 'react-router-dom';

const TournamentData = ({currentUser, igraci, clubs}) => {
    const [roundsPlayed, setRoundsPlayed] = useState(0); 
    const[roundActive, setRoundActive]=useState(0);
    const { tournamentId } = useParams();
    const location = useLocation();
    const tournament = location.state?.tournament;
    console.log(tournament);

    const [filteredPlayers, setFilteredPlayers] = useState([]);

    useEffect(() => {
            axios.get("http://localhost:8080/player/tournamentPlayers?tournamentId=3")
                .then((res) => {
                    setFilteredPlayers(res.data);
                    console.log(res.data); 
                })
                .catch((error) => {
                    console.error("Error fetching data:", error);
                });
    }, [filteredPlayers]);
    console.log(filteredPlayers);
  
return(

   <>
   <aria-label>Tournament name</aria-label> <aria-label>{tournament.name}</aria-label><p></p>
   <aria-label>Referee name</aria-label> <aria-label>{currentUser.user.name + " " + currentUser.user.surname}</aria-label><p></p>
   <aria-label>rounds played</aria-label> <aria-label>{roundsPlayed}</aria-label><p></p>
   <aria-label>active round</aria-label> <aria-label>{roundActive}</aria-label><p></p>

   <select name="players" class="players">
        <option value="" disabled selected>Players on this tournament</option>
    {filteredPlayers.map((player, index) => (
        <option key={index} value={player.id}>{player.name + " " + player.surname}</option>
    ))}
</select>          <button>Pair first round</button>

<table>
    <thead>
        <tr>
            <th>Table</th>
            <th>White</th>
            <th>Black</th>
            <th>Points White</th>
            <th>Points Black</th>
        </tr>
    </thead>
    <tbody>
        
    </tbody>
</table>
   </>
)
  
}

export default TournamentData
