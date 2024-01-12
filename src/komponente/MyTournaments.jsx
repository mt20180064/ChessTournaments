import React, { useState, useEffect } from 'react';
import axios from 'axios';

const MyTournaments = ({ currentUser, turniri, igraci, TournamentData, prijave, Prijava }) => {
  console.log(currentUser);
    const [playerTournaments, setPlayerTournaments] = useState([]);

    useEffect(() => {
        const fetchPlayerTournaments = async () => {
            try {
                const response = await axios.get('http://localhost:8080/registration/playersTournaments', {
                    params: { playerId: currentUser.id }
                });
                setPlayerTournaments(response.data); 
            } catch (error) {
                console.error('Error fetching player tournaments:', error);
            }
        };

        fetchPlayerTournaments();
    }, [currentUser.id]); 

    return (
        <div>
            <div className="prijave" id="prijave">
                {playerTournaments.length === 0 ? (
                    <p>No tournaments found.</p>
                ) : (
                    playerTournaments.map(prijava => (
                        <Prijava key={prijava.id} prijava={prijava} turniri={turniri} igraci={igraci} kor = {currentUser} />
                    ))
                )}
            </div>
        </div>
    );
};

export default MyTournaments;

