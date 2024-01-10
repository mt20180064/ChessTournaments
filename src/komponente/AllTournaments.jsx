import React from 'react'

import "../Tabela.css";





const AllTournaments = ({TournamentData, currentUser, igraci, turniri}) => {
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  function nadji() {
    var unos, filter, table, tr, td, i, txtValue;
    unos = document.getElementById("ulaz");
    console.log(unos);
    console.log("to je unos");
    filter = unos.value.toUpperCase();
    table = document.getElementById("tabela");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}
  console.log(currentUser);
    console.log(igraci);
    console.log(turniri);
    
  return (
    
    <div>
    <div className="kol">
    <input type="text" id="ulaz" onKeyUp={nadji} placeholder="Pretraži turnire po nazivu"></input> 
    </div>
      <table id = "tabela">
      <thead>
      <tr>
      <th>Registarski broj</th>
      <th>Turnir</th>
      <th>Mesto</th>
      <th>Tip</th>
      <th>Tempo</th>
      <th>Prijava</th>
      </tr>
      </thead>
      
      <tbody>
      {turniri == null ? <></> : turniri.map(turnir=> (
        <TournamentData turnir={turnir} currentUser={currentUser} igraci = {igraci} />
    ))}
      </tbody>
      </table>
    </div>
  )
}

export default AllTournaments
