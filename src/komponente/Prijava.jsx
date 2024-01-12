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

const deleteRegistration = async () => {
  try {
      const response = await axios.delete('http://localhost:8080/registration', {
          params: { id: prijava.id }
      });
      console.log('Registration deleted:', response.data);
      notifyyy();
  } catch (error) {
      console.error('Error deleting registration:', error);
  }
};
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
      <button onClick={deleteRegistration}>Odustani od turnira<ToastContainer/></button> : <button onClick={rez}>Vas rezultat</button>
      }
    </div>
    
    
 </div>
 </div> 

    )
}
export default Prijava