import React from 'react';
import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';






const TournamentData = ({ turnir, kor}) => {

  
const notify = () => toast("Uspešno ste se prijavili na turnir!");


  let navigate = useNavigate();

  function dodavanje() {
    if (!turnir || !kor) {
    
        navigate('/Login');
        return; 
    }
    const registrationData = {
        tournamentID: turnir,
        playerID: kor
    };
   
    axios.post('http://127.0.0.1:8080/registration', registrationData)
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            if (response.data.success === true) {
                console.log("Prijavili ste se na turnir!");
                navigate("/MyTournaments");
            }
        })
        .catch(function (error) {
            console.log(error);
        });
}

  
return(

    <tr>
    <td>{turnir.id}</td>
    <td>{turnir.name}</td>
    <td>{turnir.place}</td>
    <td>{turnir.type}</td>
    <td>{turnir.pace}</td>
    
    {turnir.status=="aktivan" ?
    <td><button onClick={() => {
      notify();
      dodavanje();
     
    }}>Pridruži se turniru</button> <ToastContainer/></td> : <td>Ovaj turnir je završen.</td>}
     
    
    
    </tr>
)
  
}

export default TournamentData
