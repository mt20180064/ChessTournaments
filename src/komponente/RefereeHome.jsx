import React from 'react';
import { NavLink } from 'react-router-dom';
import {Outlet} from 'react-router-dom';
import { useNavigate } from "react-router-dom";
import  { useState } from 'react';
import { Link } from 'react-router-dom';



const RefereeHome = ({currentUser,igraci,turniri,clubs}) => {
   
  const navigate = useNavigate();

  const goToTournament = () => {
    navigate(`/TournamentHome/${selectedTournament.id}`, { state: { tournament: selectedTournament } });
  };
    const [selectedTournament, setSelectedTournament] = useState(null);
    const handleRowClick = (tournament) => {
      setSelectedTournament(tournament);
    };

  const filteredTournaments = turniri.filter(tournament => 
    tournament.referee.id === currentUser.user.id && tournament.status === 'zavrsen'
  );

  const upcomingTournaments = turniri.filter (tournament =>
   tournament.referee.id===currentUser.user.id && tournament.status ==='aktivan' );

  

console.log(filteredTournaments);
  return (
    <>
   
      <h1>Sudijski modul</h1>

      <div className="labeluser">
      <text>Logged Referee:</text>
      <text>{currentUser.user.name + " " +currentUser.user.surname}</text>
    </div>
    <div classname="tableTournaments">
    <text>Finished tournaments</text>
    <table id = "tabelaZavrseni">
      <thead>
      <tr>
      <th>Registarski broj</th>
      <th>Turnir</th>
      <th>Mesto</th>
      <th>Tip</th>
      <th>Tempo</th>
      </tr>
      </thead>
      <tbody>
      {filteredTournaments.map(tournament => (
              <tr key={tournament.id}>
                <td>{tournament.id}</td>
                <td>{tournament.name}</td>
                <td>{tournament.place}</td>
                <td>{tournament.type}</td>
                <td>{tournament.pace}</td>
              </tr>
            ))}
      </tbody>
      </table>
      <text>Upcoming tournaments</text>
      <table>
        <thead>
        <tr>
      <th>Registarski broj</th>
      <th>Turnir</th>
      <th>Mesto</th>
      <th>Tip</th>
      <th>Tempo</th>
      </tr>
        </thead>
        <tbody>
          {upcomingTournaments.map(tournament => (
            <tr key={tournament.id} onClick={() => handleRowClick(tournament)}>
               <td>{tournament.id}</td>
                <td>{tournament.name}</td>
                <td>{tournament.place}</td>
                <td>{tournament.type}</td>
                <td>{tournament.pace}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
    {selectedTournament && (
        <button className="btn btn-primary" onClick={goToTournament}>
          Begin with tournament
        </button>
      )}
    
    
</>
  ); 
}

export default RefereeHome