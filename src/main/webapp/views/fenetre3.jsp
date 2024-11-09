<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<%@ page import="com.jee.beans.Stagiaire"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<jsp:useBean id="Fenetre3" class="com.jee.dao.Fenetre3daoimpl"/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription à un stage</title>
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
        <h1>Inscription à un stage</h1>
        
        <form action="#" method="post">
            <div class="form-group">
                <label for="codestage">Code Stage:</label>
                <input type="text" id="codestage" name="codestage" value="<%= request.getParameter("code") %>" >
            </div>
            <div class="form-group">
                <label for="dateDebut">Date de début:</label>
                <input type="text" id="dateDebut" name="dateDebut" placeholder="YYYY-MM-JJ" value="<%= request.getParameter("debut") %>">
            </div>
            <div class="form-group">
                <label for="dateFin">Date de fin:</label>
                <input type="text" id="dateFin" name="dateFin" placeholder="YYYY-MM-JJ" value="<%= request.getParameter("fin") %>">
            </div>
        </form>
            
            
        <form action="add.do" method="get"> 
           
           <div class="form-group">
                <label for="code">Code:</label>
                <input type="text" id="code" name="code" >
            </div>
            <div class="form-group">
                <label for="nom">Nom:</label>
                <input type="text" id="nom" name="nom" >
            </div>
            <div class="form-group">
                <label for="prenom">Prénom:</label>
                <input type="text" id="prenom" name="prenom" >
            </div>
            <div class="form-group">
                <label for="statut">Statut:</label>
                <input type="text" id="statut" name="statut">
            </div>
            <input type="submit" value="Validation" style="background-color: #ffa600; color: #fff; cursor: pointer; border: none; border-radius: 5px; padding: 10px 20px; transition: background-color 0.3s ease;"/>
              
        </form>
        <div class="btn-group">
            <button type="button" onclick="nouveauStagiaire()">Nouveau Stagiaire</button>
            <button type="button" onclick="retourListeStage()">Retour Liste Stage</button>
        </div>
    </div>
    <script>
        function retourListeStage() {
            // Redirect to fenetre1.jsp
            window.location.href = 'lister.do';
        }
        function nouveauStagiaire() {
            // Redirect to fenetre4.jsp
            window.location.href = 'arr.do';
        }
    </script>
</body>
</html>
