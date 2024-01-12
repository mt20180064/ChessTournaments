import React from 'react';
import { NavLink } from 'react-router-dom';
import {Outlet} from 'react-router-dom';
import { useNavigate } from "react-router-dom";


const NavBar = ({currentUser}) => {

	let navigate = useNavigate();

    const handleMyTournamentsClick = (e) => {
        e.preventDefault(); 
        if (!currentUser) {
            
            navigate('/Login');
        } else {
           
            navigate('/MyTournaments');
        }
    };
  return (
    <>
    <nav>
      <h1>Dobrodošli u bazu aktuelnih šahovskih turnira!</h1>
<hr />
<div id="menucase">
  <div id="stylefour">
    <ul>
      <li><NavLink to="/Home" class="current">Početna</NavLink></li>
      <li><NavLink to="/Login">Prijavi se</NavLink></li>
      <li><NavLink to="/AllTournaments">Svi turniri</NavLink></li>
	  <li><a href="/MyTournaments" onClick={handleMyTournamentsClick}>Moji Turniri</a></li>
      
    </ul>
  </div>
</div>
    </nav>
    <Outlet/>
    
    
    
<script src="app.js"></script>

<footer class="footer-distributed">
<h1>Prijavite se brzo i jednostavno na svaki</h1>
			<div class="footer-left">

				<h3>Šahovski<span>Turnir</span></h3>

				<p class="footer-links">
					<a href="#">Početna</a>
					·
					<a href="#">Blog</a>
					·

					<a href="#">O nama</a>
				
					·
					<a href="#">Kontakt</a>
				</p>

				<p class="footer-company-name">ŠahovskiTurnir © 2023</p>

				<div class="footer-icons">

					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-linkedin"></i></a>
					<a href="#"><i class="fa fa-github"></i></a>

				</div>

			</div>

			<div class="footer-right">

				<p>Kontaktirajte nas</p>

				<form action="#" method="post">

					<input type="text" name="email" placeholder="Email"></input>
					<textarea name="message" placeholder="Poruka"></textarea>
					<button>Pošalji</button>

				</form>

			</div>

		</footer>
</>
  )
}

export default NavBar
