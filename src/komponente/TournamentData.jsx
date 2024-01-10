import React from 'react';
import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';






const TournamentData = ({turnir,  igraci}) => {

  
const notify = () => toast("Uspešno ste se prijavili na turnir!");

//console.log(currentUser);

 // const [kor, setKor]=useState({
    //username:currentUser.username
  //});
   /*useEffect(()=>{
    igraci.map((igrac) =>{
          if(igrac.username == kor.username){
            console.log("email igraca:")
            console.log(igrac.username);
            console.log("email usera:")
            console.log(kor.username);
           
             setKor(igrac);
              console.log(kor);
      }
    });
  },[kor]);
  console.log("sada je ulogovan:");
  console.log(kor); */


  const FormData = require('form-data');
let data = new FormData();
data.append('TurnirID', turnir.tournamentid);
//data.append('IgracID', kor.IgracID);

  let navigate=useNavigate();

  function dodavanje(){
    var config = {
      method: 'post',
      url: 'http://127.0.0.1:8000/api/prijava',
      
      data: data,
      
  };
  
  axios(config)
  .then(function (response) {
      console.log(JSON.stringify(response.data));
      if(response.data.success == true){
      // showMessage("Uspesno ste se prijavili!", "success", "center", 2000, false);
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
