<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Création Stagiaire</title>
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
            width: 80%;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 30px;
            text-align: center; 
        }
        .container h1 {
            color: #333;
            margin-top: 0;
        }
        .form-group {
            margin-bottom: 20px;
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
        .form-group input[type="number"],
        .form-group .radio-inputs {
            flex: 2;
            display: flex;
            align-items: center;
        }
        .form-group input[type="text"],
        .form-group input[type="number"] {
            width: 100%;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .radio-inputs {
            display: flex;
            align-items: center;
        }
        .radio-inputs input[type="radio"] {
            margin: 0 5px 0 0;
        }
        .radio-inputs label {
            margin: 0 15px 0 5px;
        }
        .btn-group {
            margin-top: 20px;
            text-align: center;
        }
        .btn-group button {
            margin: 0 10px;
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Création Stagiaire</h1>
        <form action="ajouter.do" method="get">
            <div class="form-group">
                <label for="nom">Nom:</label>
                <input type="text" id="nom" name="nom">
            </div>
            <div class="form-group">
                <label for="prenom">Prénom:</label>
                <input type="text" id="prenom" name="prenom">
            </div>
            <div class="form-group">
                <label for="anneeNaissance">Année de Naissance:</label>
                <input type="text" id="anneeNaissance" name="anneeNaissance" pattern="\d{4}-\d{2}-\d{2}" placeholder="YYYY-MM-JJ">
            </div>
            <div class="form-group">
                <label for="diplome">Diplôme:</label>
                <input type="text" id="diplome" name="diplome">
            </div>
            <div class="form-group">
                <label>Sexe:</label>
                <div class="radio-inputs">
                    <input type="radio" id="femme" name="sexe" value="f">
                    <label for="femme">Femme</label>
                    <input type="radio" id="homme" name="sexe" value="h">
                    <label for="homme">Homme</label>
                </div>
            </div>
            <div class="btn-group">
                <button type="submit">Création</button>
                <button type="button" onclick="InscriptionStage()">Retour Inscription</button>
                <button type="button" onclick="retourDebut()">Retour Début</button>
            </div>
        </form>
    </div>
    <script>
        function InscriptionStage() {
            // Redirect to fenetre1.jsp
            window.location.href = 'add.do';
        }
        function retourDebut() {
            // Redirect to fenetre4.jsp
            window.location.href = 'login.do';
        }
    </script>
</body>
</html>
    