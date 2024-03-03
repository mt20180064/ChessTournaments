import React from 'react';
import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import { useLocation } from 'react-router-dom';

const TournamentHome = ({currentUser, igraci, clubs}) => {
    const [roundsPlayed, setRoundsPlayed] = useState(0); 
    const[roundActive, setRoundActive]=useState(0);
    const { tournamentId } = useParams();
    const location = useLocation();
    const tournament = location.state?.tournament;
    console.log(tournament);

    const submitRoundResults = () => {
        const gameResults = firstRoundPairs.map(game => ({
            whitePlayerId: game.white.id,
            blackPlayerId: game.black.id,
            pointsWhite: game.pointswhite,
            pointsBlack: game.pointsblack,
            tableNumber: game.table
        }));
    
        axios.post("http://localhost:8080/tournament/submitRoundResults", gameResults, {
            params: { tournamentId: tournamentId }
        })
        .then(() => {
            // Ovde možete dodati logiku za prelazak na sledeće kolo
        })
        .catch((error) => {
            console.error("Error submitting round results: ", error);
        });
    };
      const pairNextRound = () => {
        axios.get("http://localhost:8080/tournament/pairNextRound", {
            params: { tournamentId: tournamentId }
        })
        .then((res) => {
            // Pretpostavimo da želite da ažurirate state sa novim parovima
            setFirstRoundPairs(res.data);
            // Potencijalno ažuriranje ostalih state-ova, kao što su trenutni rundi i sl.
            setCurrentRound(res.data);
           // setPairFirstRound(true); // Ako želite da omogućite prikaz rezultata
            incrementRoundActive();
        })
        .catch((error) => {
            console.error("Error pairing next round: ", error);
        });
    };
      const [currentRound, setCurrentRound] = useState([]);
     

    const [filteredPlayers, setFilteredPlayers] = useState([]);
    const incrementRoundActive = () => {
        setRoundActive(prevRoundActive => prevRoundActive + 1);
      };
    useEffect(() => {
            axios.get("http://localhost:8080/player/tournamentPlayers", {
                params: { tournamentId: tournamentId }
            })
                .then((res) => {
                    setFilteredPlayers(res.data);
                    console.log(res.data); 
                })
                .catch((error) => {
                    console.error("Error fetching data:", error);
                });
    }, [tournamentId]);
    
    const [firstRoundPairs, setFirstRoundPairs]=useState([]);
    //const pairFirstRound = () => {
        useEffect(()=> {
            axios.get("http://localhost:8080/player/pair", {
                params: { tid: tournamentId }
            })
            .then ((res)=>{
                setFirstRoundPairs(res.data);
                console.log(firstRoundPairs);
            })
            .catch((error) =>
            {console.error("error fetching data: ", error);
        });
        }, [tournamentId]);
     // };
   const [pairFirstRound, setPairFirstRound]= useState(false);
   const showTable = () => {
    setPairFirstRound(true);
    incrementRoundActive();
};
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
</select>          <button onClick={showTable} disabled = {pairFirstRound} >Pair first round</button>

{pairFirstRound && (<table>
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
    {firstRoundPairs.map(game => (
              <tr key={game.id}>
                <td>{game.table}</td>
                <td>{game.white.name}</td>
                <td>{game.black.name}</td>
                <td>{game.pointswhite}</td>
                <td>{game.pointsblack}</td>
              </tr>
            ))}
    </tbody>
</table>)}

<button className="btn-finish" onClick={submitRoundResults} disabled={!pairFirstRound}>Finish the round</button> <button className="pair-next" onClick={pairNextRound} disabled={!pairFirstRound}>Pair next round</button>

   </>
)
  
}

export default TournamentHome
