import React from 'react';
import '../login.css';
import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


const Login = ({addUser, igraci}) => {
    const notifyy = () => toast("Pokušajte ponovo! Pogrešan imejl ili lozinka.");
    const notifyyy = () => toast("uspesno ste se registrovali. Prijavite se na sistem!");
    const notifyyyy = () => toast("Vec postoji korisnik sa tim emailom.");
    const [userPodaci, postaviPodatke]= useState({
        username:"stevie",
        password:"stevie"
    });
    let navigacija = useNavigate();

    const [userPodaciR, postaviPodatkeR]= useState({
        name:"",
        username:"",
        password:""
    });
    let navigacija2 = useNavigate();
    function obradiDogadjaj(e){
        let noviUserPodaci=userPodaciR;
        noviUserPodaci[e.target.name]=e.target.value;
        console.log(noviUserPodaci);
        postaviPodatke(noviUserPodaci);
    }
 
   function handleRegister(e){
    e.preventDefault();
    axios
    .post("http://127.0.0.1:8000/api/register",userPodaciR).then(res=>{
        console.log(res.data);
        if (res.data.success===true){
            
            notifyyy();
            navigacija2("/Login");
          } else if (res.data.success===false){
              notifyyyy();
          }
        
        
    });

    }
   function handleLogin(e){
    e.preventDefault();
    console.log(userPodaci);
    axios.post('http://127.0.0.1:8080/login', userPodaci)
  .then(response => {
    console.log("Ovo jeste dobro logovanje");
        addUser(response.data);
        navigacija("/Home");
        return;
  })
  .catch(error => {
    if (error.response) {
    console.log("Ovo nije dobro logovanje");
    notifyy();
    return;
    }
  });
  }
    
    

    function handleInput(e){
      e.preventDefault();
    postaviPodatke(prevState => ({
        ...prevState,
        [e.target.name]: e.target.value
    }));
}


    

 return(
    <>
    <div className="gug">
    <div class="main">  	
		<input type="checkbox" id="chk" aria-hidden="true"></input>

			<div class="signup">
				<form>
					<label for="chk" aria-hidden="true">Registracija</label>
					<input type="name" name="name" placeholder="Korisnicko ime" required="" defaultValue = "player" onInput={obradiDogadjaj}></input> 
					<input type="email" name="email" placeholder="Email" required="" defaultValue = "player0@gmail.com" onInput={obradiDogadjaj}></input>
					<input type="password" name="password" placeholder="Lozinka" required="" defaultValue = "1111111" onInput={obradiDogadjaj}></input>
					<button className="f" onClick={handleRegister}>Registruj se</button>
				</form>
			</div>

			<div class="login">
				<form>
					<label for="chk" aria-hidden="true">Prijava</label>
					<input type="username" name="username" placeholder="username" required="" defaultValue = "stevi" onInput={handleInput}></input>
					<input type="password" name="password" placeholder="Lozinka" required="" defaultValue="stevi" onInput={handleInput}></input>
					<button className="f" onClick={handleLogin}>Prijavi se<ToastContainer/></button>
				</form>
			</div>
	</div>
   </div>
    </>
 )
}

export default Login
