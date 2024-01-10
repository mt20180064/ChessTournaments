import logo from './logo.svg';
import './App.css';
import './NavBar.css';
import './Home.css';
import { useState, useEffect } from "react";
import axios from "axios";
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import NavBar from './komponente/NavBar';
import Home from './komponente/Home';
import Login from './komponente/Login';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import AllTournaments from './komponente/AllTournaments';
import MyTournaments from './komponente/MyTournaments';
import TournamentData from './komponente/TournamentData';
import Prijava from './komponente/Prijava';
import Blog from './komponente/Blog';




function App() {
  
  const [turniri, setTurniri] = useState();

useEffect(() => {
    if (turniri == null) {
        axios.get("http://localhost:8080/tournament")
            .then((res) => {
                console.log(res.data);
                setTurniri(res.data);
            })
            .catch((error) => {
                console.error("Error fetching tournaments:", error);
            });
    }
}, [turniri]);

   


    const [igraci, setIgraci] = useState();

    useEffect(() => {
        if (igraci == null) {
            axios.get("http://127.0.0.1:8080/player")
                .then((res) => {
                    setIgraci(res.data);
                    console.log(res.data); 
                })
                .catch((error) => {
                    console.error("Error fetching data:", error);
                });
        }
    }, [igraci]);

    const [prijave, setPrijave]=useState();
    useEffect(()=>{
        if(prijave==null){
            axios.get("http://127.0.0.1:8080/registration").then((res)=>{
              
                setPrijave(res.data.data);
                console.log(prijave);
            });
        }
    },[prijave]);

    const[currentUser, setCurrentUser]=useState();
    function addUser(u){ 
      if(igraci != null){
        console.log(igraci);
          igraci.map((igrac) =>{
              if(igrac.username == u.username){
                console.log("email igraca:")
                console.log(igrac.username);
                console.log("email usera:")
                console.log(u.username);
                console.log(igrac);
                 setCurrentUser(igrac);
                  console.log(currentUser);   
              };
          });
      };
     setCurrentUser(u);
     console.log(u);
  }
  
 

  

  return (
    <BrowserRouter>
    <Routes>
    <Route path="/" element={<NavBar/>} >
    <Route path="Home" element={<Blog/>}></Route>
    
    <Route path="AllTournaments" element={<AllTournaments TournamentData={TournamentData} igraci={igraci} turniri={turniri}/>}></Route>
    <Route path="MyTournaments" element={<MyTournaments currentUser={currentUser} igraci={igraci} turniri={turniri} TournamentData={TournamentData} prijave={prijave} Prijava={Prijava}/>}></Route>
    
    </Route>
    <Route path="Login" element={<Login addUser={addUser} igraci={igraci}/>}></Route>
    
    </Routes>
    </BrowserRouter>
    
    
  );
}

export default App;
