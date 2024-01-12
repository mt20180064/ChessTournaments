import React from 'react';
import { useState, useEffect } from "react";
import axios from "axios";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Prijava = ({prijava, igraci, turniri, kor})=>{
  const notifyyy = () => toast("Obrisali ste prijavu.");
  const notifyyyy = () => toast("Niste osvojili nista na ovom turniru.");
  console.log("evo prijave sa kojom se radi:");
console.log(prijava);

function obrisi (){
  const FormData = require('form-data');
let data = new FormData();

let config = {
  method: 'delete',
  maxBodyLength: Infinity,
  url: 'http://127.0.0.1:8000/api/prijava/'+prijava.PrijavaID,

  data : data
};



axios.request(config)
.then((response) => {
  console.log(JSON.stringify(response.data));
})
.catch((error) => {
  console.log(error);
});
notifyyy();
}
function rez(){
  notifyyyy();
  }
 


  const [tur, setTur] = useState({});

  useEffect(() => {
    
      if (prijava && prijava.tournamentID) {
          setTur(prijava.tournamentID);
      }
  }, [prijava]); 
  
  

    return(
        
      <div className = "coco">
        
     <div className="card">
    <div className="card-header">
       {kor.name} {kor.surname} <br></br>kategorija:{kor.category} <br></br>rejting: {kor.rating}
    </div>
    <div className="card-body">
      <h5 className="card-title">{tur.name}</h5>
      <img className='slika' src={tur.Slika} alt="Lekcija"/>
      <p className="card-text">Mesto: {tur.place} <br></br>Tempo: {tur.pace} <br></br>Tip: {tur.type} <br></br>Status: {tur.status} </p>
      {tur.status=="aktivan" ?
      <button onClick={obrisi}>Odustani od turnira<ToastContainer/></button> : <button onClick={rez}>Vas rezultat</button>
      }
    </div>
    
    
 </div>
 </div> 

    )
}
export default Prijava