
import './App.css';
import './NavBar.css';
import './Home.css';
import { useState, useEffect } from "react";
import axios from "axios";
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import NavBar from './komponente/NavBar';
import Home from './komponente/Home';
import Login from './komponente/Login';
import 'react-toastify/dist/ReactToastify.css';
import AllTournaments from './komponente/AllTournaments';
import MyTournaments from './komponente/MyTournaments';
import TournamentData from './komponente/TournamentData';
import Prijava from './komponente/Prijava';
import Blog from './komponente/Blog';
import RefereeHome from './komponente/RefereeHome';





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
                 console.log(res.data)
                setPrijave(res.data);
                console.log(prijave);
            })
            .catch ((error)=>{
                console.error("error in registrations", error);
            });
        }
    },[prijave]);

    const[currentUser, setCurrentUser]=useState();

        function addUser(u) {
            setCurrentUser(u);
        }
        console.log(currentUser);

        const [clubs, setClubs] = useState([]);

useEffect(() => {
    axios.get('http://localhost:8080/club/all')
        .then(response => {
            setClubs(response.data); 
        })
        .catch(error => {
            console.error('Error fetching clubs:', error);
        });
}, []);
  console.log(clubs);
 

  

  return (
    <BrowserRouter>
    <Routes>
    <Route path="/" element={<NavBar currentUser={currentUser}/>} >
    <Route path="Home" element={<Blog/>}></Route>
    
    <Route path="AllTournaments" element={<AllTournaments TournamentData={TournamentData} currentUser={currentUser} igraci={igraci} turniri={turniri}/>}></Route>
    console.log(currentUser); <Route path="MyTournaments" element={<MyTournaments currentUser={currentUser} igraci={igraci} turniri={turniri} TournamentData={TournamentData} prijave={prijave} Prijava={Prijava}/>}></Route>
    
    </Route>
    <Route path="Login" element={<Login addUser={addUser} igraci={igraci} clubs={clubs}/>}></Route>
    <Route path="ref" element = {<RefereeHome addUser={addUser} igraci={igraci} turniri={turniri} clubs ={clubs}/>}></Route>

    </Routes>
    </BrowserRouter>
    
    
  );
}

export default App;
 