import React from 'react';
import axios from "axios";
import { useState, useEffect } from "react";


const MyTournaments = ({currentUser, turniri, igraci, TournamentData, prijave, Prijava}) => {
  
  const [kor, setKor]=useState({
    email:currentUser.email
  });
  useEffect(()=>{
    igraci.map((igrac) =>{
          if(igrac.email == kor.email){
            console.log("email igraca:")
            console.log(igrac.email);
            console.log("email usera:")
            console.log(kor.email);
           
             setKor(igrac);
              console.log(kor);
      }
    });
  },[kor]);
  console.log("sada je ulogovan:");
  console.log(kor);


  const [prijavem, setPrijavem]=useState();
  useEffect(()=>{
    console.log(kor.IgracID);
      if(prijavem==null){
        let t = kor.IgracID;
          axios.get("http://127.0.0.1:8000/api/prijava/0/igrac").then((res)=>{
            
              setPrijavem(res.data.prijava);
              console.log(prijavem);
          });
      }
  },[prijavem]);
console.log(prijavem);
  
  
  return (
    <div>
      <div className="prijave" id="prijave" >
      {prijavem == null ? <></> : prijavem.map(prijava=> (
        <Prijava prijava={prijava}  turniri={turniri} igraci = {igraci} />
    ))}
          
               
    </div>
    </div>
  )
}

export default MyTournaments
