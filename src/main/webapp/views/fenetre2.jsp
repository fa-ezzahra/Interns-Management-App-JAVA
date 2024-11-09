<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<%@ page import="com.jee.beans.Stagiaire"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<jsp:useBean id="Fenetre2" class="com.jee.dao.Fenetre2daoimpl"/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Détails du Stage</title>

    <style>
        body {
            font-family: "Verdana", "Geneva", sans-serif;
            margin: 0;
            padding: 0;
            background-color: orange;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            width: 500px;
            height: 500px;
            line-height-step: 10px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 30px;
        }
        .container h1 {
            color: #333;
            margin-top: 0;
        }
        .form-group {
            margin-bottom: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .form-group label {
            flex: 1;
            text-align: right;
            margin-right: 20px;
        }
        .form-group input[type="text"],
        .form-group input[type="date"] {
            flex: 2;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .btn-group {
            margin-top: 20px;
        }
        .btn-group button {
            margin: 20px 10px;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: #ffa600;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .btn-group button:hover {
            background-color: #74b300;
        }
        table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

table th,
table td {
    padding: 10px;
    text-align: center;
    border-bottom: 1px solid #ddd;
}

table th {
    background-color: #ffa600;
    color: #fff;
    font-weight: bold;
}

table tr:nth-child(even) {
    background-color: #f3f3f3;
}

table tr:hover {
    background-color: #e9ecef;
}
    </style>
</head>
<body>
    <div class="container">
        <h1>Details du Stage</h1>
        <form action="#" method="post">
            <div class="form-group">
                <label for="codeStage">Code du Stage:</label>
                <input type="text" id="codeStage" name="codeStage" value="<%= request.getParameter("code") %>">
            </div>
            <div class="form-group">
                <label for="dateDebut">Date de début:</label>
                <input type="date" id="dateDebut" name="dateDebut" value="<%= request.getParameter("debut") %>">
            </div>
            <div class="form-group">
                <label for="dateFin">Date de fin:</label>
                <input type="date" id="dateFin" name="dateFin" value="<%= request.getParameter("fin") %>">
            </div>
            <div class="btn-group">
                <h2>Liste des Stagiaires:</h2>
                <table>
            <thead>
                <tr>
                    <th>Nom et Prenom</th>
                    
                </tr>
            </thead>
            <tbody>
               <% List<String> stagiaires =(List<String>)request.getAttribute("stagiaires");
              
        if(stagiaires != null) {
          for(String stagiaire : stagiaires) {
           %>
         <tr>
             <td><%= stagiaire %></td>
         </tr>
         <% 
    }
}
        %>
               
            </tbody>
        </table>
                 <button type="button" onclick="inscription()">Nouvelle inscription</button>
                <button type="button" onclick="retourListeStage()">Retour Liste Stage</button>
                
            </div>
        </form>
    </div>
    <script>
    function showDetails(codeStage, typeStage, debutStage, finStage) {
        document.getElementById("codeStage").value = codeStage;
        document.getElementById("typeStage").value = typeStage;
        document.getElementById("dateDebut").value = debutStage;
        document.getElementById("dateFin").value = finStage;
        document.getElementById("myModal").style.display = "block";
    }
    
    function inscription() {
    	// Get the values of code, debut, and fin
        var code = document.getElementById("codeStage").value;
        var debut = document.getElementById("dateDebut").value;
        var fin = document.getElementById("dateFin").value;
        
        // Construct the URL with parameters
        var url = 'add.do?code=' + encodeURIComponent(code) + '&debut=' + encodeURIComponent(debut) + '&fin=' + encodeURIComponent(fin);
        
        // Rediriger vers la page fenetre1.jsp
        window.location.href = url;
    }
    function retourListeStage() {
        // Rediriger vers la page fenetre1.jsp
        window.location.href = 'login.do';
    }


</script>
</body>
</html>