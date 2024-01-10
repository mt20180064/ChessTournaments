import React from 'react';
import { useState, useEffect } from "react";
import axios from "axios";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Prijava = ({prijava, igraci, turniri})=>{
  const notifyyy = () => toast("Obrisali ste prijavu.");
  const notifyyyy = () => toast("Niste osvojili nista na ovom turniru.");
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
  const [kor, setKor]=useState({
  });
  useEffect(()=>{
    igraci.map((igrac) =>{
          if(igrac.IgracID == prijava.IgracID){
            console.log("igrac:")
            console.log(igrac.IgracID);
            console.log("igrac iz prijave:")
            console.log(prijava.IgracID);
           
             setKor(igrac);
              console.log(kor);
      }
    });
  },[kor]);
  console.log("sada je ulogovan:");
  console.log(kor);


 const [tur, setTur]=useState({
  });
  useEffect(()=>{
    turniri.map((turnir) =>{
          if(turnir.TurnirID == prijava.TurnirID){
            console.log("turnir:")
            console.log(turnir.TurnirID);
            console.log("turnir prijava:")
            console.log(prijava.TurnirID);
           
             setTur(turnir);
              console.log(tur);
      }
    });
  },[tur]);
  console.log("sada je turnir");
  console.log(tur);

    return(
        
      <div className = "coco">
        
     <div className="card">
    <div className="card-header">
       {kor.ime} {kor.prezime} <br></br>kategorija:{kor.kategorija} <br></br>rejting: {kor.rejting}
    </div>
    <div className="card-body">
      <h5 className="card-title">{tur.Naziv}</h5>
      <img className='slika' src={tur.Slika} alt="Lekcija"/>
      <p className="card-text">Mesto: {tur.Nesto} <br></br>Tempo: {tur.Tempo} <br></br>Tip: {tur.Tip} <br></br>Status: {tur.Status} </p>
      {tur.Status=="aktivan" ?
      <button onClick={obrisi}>Odustani od turnira<ToastContainer/></button> : <button onClick={rez}>Vas rezultat</button>
      }
    </div>
    
    
 </div>
 </div> 

    )
}
export default Prijava