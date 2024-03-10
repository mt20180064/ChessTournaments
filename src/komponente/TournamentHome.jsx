import React from 'react';
import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import { useLocation } from 'react-router-dom';
import GameRow from './GameRow';
import styled from 'styled-components';

const InfoContainer = styled.section`
  border: 2px solid #720808;
  border-radius: 8px;
  padding: 20px;
  margin-bottom: 20px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
`;

const InfoRow = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  margin-bottom: 10px;
`;

const InfoTitle = styled.h2`
  color: #720808;
  font-size: 24px;
  margin-right: 10px;
`;

const InfoText = styled.p`
  color: #333;
  font-size: 18px;
  flex-grow: 1;
  text-align: left;
  margin: 0;
`;

const TournamentHome = ({currentUser, igraci, clubs}) => {
  const [playerPoints, setPlayerPoints] = useState({});
    const [roundsPlayed, setRoundsPlayed] = useState(0); 
    const[roundActive, setRoundActive]=useState(0);
    const { tournamentId } = useParams();
    const location = useLocation();
    const tournament = location.state?.tournament;
    console.log(tournament);
    const [isRoundFinished, setIsRoundFinished] = useState(false);
    const updateGameResults = (gameId, player, points) => {
        setFirstRoundPairs(currentPairs =>
            currentPairs.map(game => {
                if (game.id === gameId) {
                    return {
                        ...game,
                        pointsWhite: player === 'white' ? points : game.pointsWhite,
                        pointsBlack: player === 'black' ? points : game.pointsBlack, 
                    };
                }
                return game;
            })
        );
    };

    const submitRoundResults = () => {
        const gameResults = firstRoundPairs.map(game => ({
            whitePlayerId: game.white.id,
            blackPlayerId: game.black.id,
            pointsWhite: game.pointswhite,
            pointsBlack: game.pointsblack,
            tableNumber: game.table
        }));
        let updatedPoints = { ...playerPoints };
        firstRoundPairs.forEach(game => {
            const { white, black } = game;
            updatedPoints[white.id] = (updatedPoints[white.id] || 0) + game.pointsWhite;
            updatedPoints[black.id] = (updatedPoints[black.id] || 0) + game.pointsBlack;
        });
    
        setPlayerPoints(updatedPoints);
        axios.post("http://localhost:8080/tournament/submitRoundResults", gameResults, {
            params: { tournamentId: tournamentId }
        })
        .then(() => {
          setIsRoundFinished(true);
          setRoundsPlayed(prevRounds => prevRounds + 1);
        })
        .catch((error) => {
            console.error("Error submitting round results: ", error);
        });
    };
      const pairNextRound = () => {
        if (roundActive - 1 >= filteredPlayers.length - 1) { 
          const finishTournament = window.confirm("You can't pair anymore. Finish the tournament?");
          if (finishTournament) {
            const rankedPlayers = rankPlayers();
    
            const winners = rankedPlayers.slice(0, 3);
        
            tournament.first = winners[0] ? winners[0].id : null;
            tournament.second = winners[1] ? winners[1].id : null;
            tournament.third = winners[2] ? winners[2].id : null;

            axios.post(`http://localhost:8080/tournament/updateStatus`, {
        tournamentId: tournamentId,
        status: 'zavrsen', 
    })
    .then(response => {
        console.log("Tournament status updated to finished:", response.data);
        
    })
    .catch(error => {
        console.error("Error updating tournament status:", error);
    });
            alert(`Tournament finished!\n1st: ${winners[0] ? winners[0].name : "N/A"}\n2nd: ${winners[1] ? winners[1].name : "N/A"}\n3rd: ${winners[2] ? winners[2].name : "N/A"}`);
              setPlayerPoints({});
              console.log("Tournament finished");
          } else {
              
              console.log("Tournament continues");
          }
          return; 
      }
        axios.get("http://localhost:8080/tournament/pairNextRound", {
            params: { tournamentId: tournamentId }
        })
        .then((res) => {
         
            setFirstRoundPairs(res.data);
           
            setCurrentRound(res.data);
           
            incrementRoundActive();
            setIsRoundFinished(false);
        })
        .catch((error) => {
            console.error("Error pairing next round: ", error);
        });
    };
    const generateRandomPoints = (maxRounds) => {
      const points = [];
      for (let i = 0; i <= maxRounds; i += 0.5) {
        points.push(i);
      }
    
   
      for (let i = points.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [points[i], points[j]] = [points[j], points[i]];
      }
    
      return points;
    };
    
    const rankPlayers = () => {
      const maxPoints = roundsPlayed; 
      const randomPoints = generateRandomPoints(maxPoints);
    
      const playersArray = filteredPlayers.map((player, index) => {
       
        const points = randomPoints[index % randomPoints.length];
        return {
          ...player,
          points: points,
        };
      });
    
   
      const sortedPlayers = playersArray.sort((a, b) => b.points - a.points);
    
      return sortedPlayers;
    };
    
  
      const [currentRound, setCurrentRound] = useState([]);
     
      const handleUpdateGame = (gameId, field, value) => {
        setFirstRoundPairs(currentPairs => 
          currentPairs.map(game => 
            game.id === gameId ? { ...game, [field]: value } : game
          )
        );
      };
      const [rankVisible, setRankVisible] = useState(false);
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
  <InfoContainer>
      <InfoRow>
        <InfoTitle>Tournament:</InfoTitle>
        <InfoText>{tournament.name}</InfoText>
      </InfoRow>
      <InfoRow>
        <InfoTitle>Referee:</InfoTitle>
        <InfoText>{currentUser.user.name + " " + currentUser.user.surname}</InfoText>
      </InfoRow>
      <InfoRow>
        <InfoTitle>Rounds Played:</InfoTitle>
        <InfoText>{roundsPlayed}</InfoText>
      </InfoRow>
      <InfoRow>
        <InfoTitle>Active Round:</InfoTitle>
        <InfoText>{roundActive}</InfoText>
      </InfoRow>
    </InfoContainer>

   <select name="players" class="players">
        <option value="" disabled selected>Players on this tournament</option>
    {filteredPlayers.map((player, index) => (
        <option key={index} value={player.id}>{player.name + " " + player.surname}</option>
    ))}
</select>          <button onClick={showTable} disabled = {pairFirstRound} >Pair first round</button>
<button onClick={() => setRankVisible(prev => !prev)}>Rank</button>
{pairFirstRound && (
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
      {firstRoundPairs.map(game => (
        <GameRow key={game.id} game={game} onUpdate={updateGameResults} />
      ))}
    </tbody>
  </table>
)}

<button className="btn-finish" onClick={submitRoundResults} disabled={!pairFirstRound || isRoundFinished}>Finish the round</button>
<button className="pair-next" onClick={pairNextRound} disabled={!pairFirstRound || !isRoundFinished}>Pair next round</button>

{rankVisible && (
    <div>
        <h2>Player Rankings</h2>
        <ol>
            {rankPlayers().map(player => (
                <li key={player.id}>
                    {player.name} {player.surname} - Points: {player.points}
                </li>
            ))}
        </ol>
    </div>
)}

   </>
)
  
}

export default TournamentHome
