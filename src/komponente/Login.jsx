import React from 'react';
import '../login.css';
import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


const Login = ({addUser, clubs}) => {
    const notifyy = () => toast("Pokušajte ponovo! Pogrešan imejl ili lozinka.");
    const notifyyy = () => toast("You successfully registered!");
    const notifyyyy = () => toast("Some data is missing or invalid. Try again");
    const [userPodaci, postaviPodatke]= useState({
        username:"",
        password:""
    });
    let navigacija = useNavigate();

    const [userPodaciR, setUserPodaciR]= useState({
        name:"",
        username:"",
        password:"",
        surname:"",
        category:"",
        rating:"",
        club:""
        
    });
    let navigacija2 = useNavigate();
    const obradiDogadjaj = (e) => {
      if (e.target.name === 'club') {
          const selectedClubId = e.target.value;
          const selectedClub = clubs.find(club => club.id.toString() === selectedClubId);
          setUserPodaciR({
              ...userPodaciR,
              club: selectedClub || null 
          });
      } else {
          setUserPodaciR({
              ...userPodaciR,
              [e.target.name]: e.target.value
          });
      }
  };
 
  const handleRegister = (e) => {
    e.preventDefault();
  
    handleSubmit();
};
           const handleSubmit = () => {

        axios.post("http://localhost:8080/player", userPodaciR)
            .then(response => {
                console.log(response.data);
                notifyyy();
                navigacija2 ("/Home");
            })
            .catch(error => {
                console.error(error);
                notifyyyy();
            });
    };



   function handleLogin(e){
    e.preventDefault();
    console.log(userPodaci);
    axios.post('http://127.0.0.1:8080/login', userPodaci)
  .then(response => {
    console.log("Ovo jeste dobro logovanje");
        addUser(response.data);
        if (response.data.userType=="player"){
        navigacija("/Home");
        return;}
        if (response.data.userType=="referee"){
            navigacija("/ref");
            return;
        }
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
const [selectedCategory, setSelectedCategory] = useState('');

const categories = ['VK', 'IV', 'III', 'II', 'I', 'MK', 'FM', 'IM', 'VM'];

const handleCategoryChange = (e) => {
    setSelectedCategory(e.target.value);
};

 return(
    <>
    <div className="gug">
    <div class="main">  	
		<input type="checkbox" id="chk" aria-hidden="true"></input>

    <div className="signup">
    <form>
        <label htmlFor="chk" aria-hidden="true">Registracija</label>
        <input 
            type="text" 
            name="name" 
            placeholder="Name" 
            required 
            
            onChange={obradiDogadjaj}
        />
          <input 
            type="text" 
            name="surname" 
            placeholder="Surname" 
            required 
            
            onChange={obradiDogadjaj}
        />
        <input 
            type="text" 
            name="username" 
            placeholder="Email" 
            required 
            
            onChange={obradiDogadjaj}
        />
        <input 
            type="password" 
            name="password" 
            placeholder="Lozinka" 
            required 
           
            onChange={obradiDogadjaj}
        />
        <input 
            type="number" 
            name="rating" 
            placeholder="rating" 
            required 
           
            onChange={obradiDogadjaj}
        />
       <select name="category" class="club" value={selectedCategory} onChange={obradiDogadjaj}>
                {categories.map((category, index) => (
                    <option key={index} value={category}>{category}</option>
                ))}
            </select>
        <select name="club" class="club" defaultValue="select a club" onChange={obradiDogadjaj}>
        <option value="" disabled selected hidden>Select a Club</option>
    {clubs.map((club, index) => (
        <option key={index} value={club.id}>{club.naziv}</option>
    ))}
</select>
       
        <button className="f" onClick={handleRegister}>Registruj se</button>
    </form>
</div>


			<div class="login">
				<form>
					<label for="chk" aria-hidden="true">Prijava</label>
					<input type="username" name="username" placeholder="username" required="" defaultValue = "ek" onInput={handleInput}></input>
					<input type="password" name="password" placeholder="Lozinka" required="" defaultValue="ek" onInput={handleInput}></input>
					<button className="f" onClick={handleLogin}>Prijavi se<ToastContainer/></button>
				</form>
			</div>
	</div>
   </div>
    </>
 )
}

export default Login
