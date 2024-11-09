<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="com.jee.beans.Stage"%>
<%@page import="java.util.List"%>
<jsp:useBean id="Fenetre1" class="com.jee.dao.Fenetre1daoimpl"/>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8" />
<title>Inscription à un Stage | By Code Info</title>
<link rel="stylesheet" href="style.css" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
<style>
body {
  font-family: "Verdana", "Geneva", sans-serif;
  margin: 0;
  padding: 0;
  background-color: orange;
}
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
.main {
  width: 80%;
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  padding: 30px;
}
.main h1 {
  text-align: center;
  color: #333;
}
.action-buttons {
  text-align: center;
  margin-bottom: 20px;
}
.action-buttons button {
  margin: 0 10px;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  background-color: #ffa600;
  color: #fff;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.action-buttons button:hover {
  background-color: #74b300;
}
.attendance-list {
  margin-top: 20px;
}
.table {
  width: 100%;
  border-collapse: collapse;
  margin: 20px 0;
}
.table th, .table td {
  padding: 10px;
  text-align: center;
  border-bottom: 1px solid #ddd;
}
.table th {
  background-color: #ffa600;
  color: #fff;
  font-weight: bold;
}
.table tr:nth-child(even) {
  background-color: #f3f3f3;
}
.table tr:hover {
  background-color: #e9ecef;
}
.table button {
  padding: 6px 20px;
  border-radius: 5px;
  cursor: pointer;
  background-color: #ffa600;
  color: #fff;
  border: none;
  transition: background-color 0.3s ease;
}
.table button:hover {
  background-color: #b37a00;
}
.modal {
  display: none;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.5);
}
.modal-content {
  background-color: #fefefe;
  margin: 15% auto;
  padding: 20px;
  border: 1px solid #888;
  border-radius: 10px;
  width: 80%;
}
.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}
.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}
.more-details-button {
  margin-top: 20px;
  text-align: center;
}
.more-details-button button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  background-color: #ffa600;
  color: #fff;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.more-details-button button:hover {
  background-color: #b37a00;
}
</style>

</head>

<body>
<div class="container">
<section class="main">
  <h1>Inscription à un Stage</h1>
  <section class="attendance">
    <div class="attendance-list">
      
      <% 
      List<Stage> dl = (List<Stage>)request.getAttribute("dl");
      %>
      
      <table class="table" id="stageTable">
        <thead>
          <tr>
            <th>N°</th>
            <th>Type</th>
            <th>Date de Début</th>
            <th>Date de Fin</th>
            <th>Nbplace_Stage</th>
            <th>Inscriptions</th>
          </tr>
        </thead>
        
        <% if(dl != null) {
          for(int i = 0; i < dl.size(); i++) {
            %>
            <tr  onclick="redirectToStage('<%= dl.get(i).getCodestage() %>', '<%= dl.get(i).getTypestage() %>', '<%= dl.get(i).getDebutstage() %>', '<%= dl.get(i).getFinstage() %>')">
              <td><%= dl.get(i).getCodestage() %></td>
              <td><%= dl.get(i).getTypestage() %></td>
              <td><%= dl.get(i).getDebutstage() %></td>
              <td><%= dl.get(i).getFinstage() %></td>
              <td><%= dl.get(i).getNbplacestage() %></td>
              <td><%= dl.get(i).getNbinscrit() %></td>
            </tr>
            <% 
          }
        } %>
      </table>
    </div>
  </section>
  <div class="action-buttons">
    <button onclick="sortTableByDate()">Lister par Date</button>
    <button onclick="sortTableByType()">Lister par Type</button>
    <a href="login1.html"><button>Fin</button>
  </div>
</section>
</div>

<div id="myModal" class="modal">
<div class="modal-content">
  <span class="close" onclick="closeModal()">&times;</span>
  <p id="modalText"></p>
  <div class="more-details-button">
    <button onclick="openNewWindow()">Plus de détails</button>
  </div>
</div>
</div>

<script>
function redirectToStage(stageId, stageType, debutStage, finStage) {
	  // Rediriger vers fenetre2.jsp en passant l'ID, le type du stage, la date de début et la date de fin comme paramètres
	  window.location.href = 'lister.do?code=' + stageId + '&type=' + encodeURIComponent(stageType) + '&debut=' + encodeURIComponent(debutStage) + '&fin=' + encodeURIComponent(finStage);
	}

</script>

<script>
    const compare = (ids, asc) => (row1, row2) => {
      const tdValue = (row, ids) => row.children[ids].textContent.trim();
      const tri = (v1, v2) => {
        return v1 !== '' && v2 !== '' && !isNaN(v1) && !isNaN(v2) ? v1 - v2 : v1.localeCompare(v2, 'fr', { numeric: true });
      };
      return tri(tdValue(asc ? row1 : row2, ids), tdValue(asc ? row2 : row1, ids));
    };

    function sortTableByDate() {
      const tbody = document.querySelector('tbody');
      const trs = tbody.querySelectorAll('tr');
      const ths = document.querySelectorAll('th');
      const index = Array.from(ths).indexOf(ths[3]);
      const sortedRows = Array.from(trs).sort(compare(index, true));
      tbody.innerHTML = '';
      sortedRows.forEach(row => tbody.appendChild(row));
    }

    function sortTableByType() {
      const tbody = document.querySelector('tbody');
      const trs = tbody.querySelectorAll('tr');
      const ths = document.querySelectorAll('th');
      const index = Array.from(ths).indexOf(ths[1]);
      const sortedRows = Array.from(trs).sort(compare(index, true));
      tbody.innerHTML = '';
      sortedRows.forEach(row => tbody.appendChild(row));
    }

    function openModal(dateDebut, dateFin) {
  const modal = document.getElementById('myModal');
  const modalText = document.getElementById('modalText');
  const currentDate = new Date();
  const startDate = new Date(dateDebut);
  const endDate = new Date(dateFin);
  
  // Vérifiez si la date de fin est postéri
  if (endDate < currentDate) {
	    modalText.textContent = 'Les inscriptions pour ce stage sont terminées.';
	  } else if (startDate > currentDate) {
	    // Vérifiez si la date de début est postérieure à la date actuelle
	    modalText.textContent = 'Les inscriptions ne sont pas encore ouvertes pour ce stage.';
	  } else {
	    // Si les inscriptions sont ouvertes, affichez les détails du stage
	    modalText.textContent = 'Les inscriptions sont ouvertes pour ce stage.';
	  }
	  
	  // Afficher le modal
	  modal.style.display = 'block';
	}


	    function closeModal() {
	      const modal = document.getElementById('myModal');
	      modal.style.display = 'none';
	    }
	    
	    function openNewWindow() {
	      // Ajoutez ici le code pour ouvrir une nouvelle fenêtre avec plus de détails sur le stage
	      alert('Ouvrir une nouvelle fenêtre avec plus de détails sur le stage...');
	    }
	  </script>


</body>
</html>