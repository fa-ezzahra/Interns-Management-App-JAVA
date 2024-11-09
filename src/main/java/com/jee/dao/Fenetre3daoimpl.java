package com.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jee.beans.Stage;

public class Fenetre3daoimpl implements Fenetre3dao {

	
	public List<String> getNomsStagiairesPourStage(String codeStage) {
        List<String> nomsStagiaires = new ArrayList<>();
        try {
        	Connection cnx = MySQLConnection.getConnection();

        	String sql = "SELECT stagiaire.nom_stagiaire " +
                         "FROM inscription " +
                         "JOIN stagiaire ON inscription.num_stagiaire = stagiaire.num_stagiaire " +
                         "WHERE inscription.code_stage = ?";
            
         
            try (PreparedStatement statement = cnx.prepareStatement(sql)) {
                statement.setString(1, codeStage);
                

                try (ResultSet resultSet = statement.executeQuery()) {

                	while (resultSet.next()) {
                        String nomStagiaire = resultSet.getString("nom_stagiaire");
                        nomsStagiaires.add(nomStagiaire);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return nomsStagiaires;
    }
	
	 
	
	
	
	
	public void inscrireStagiaire(String nomStagiaire, String prenomStagiaire, String codeStage, char statutInscription) {

		try  {
        	Connection cnx = MySQLConnection.getConnection();

        	String sqlCheckPlaces = "SELECT nbinscrit_stage, nbplace_stage FROM stage WHERE code_stage = ?";

        	String sqlFindStagiaire = "SELECT num_stagiaire FROM stagiaire WHERE nom_stagiaire = ? AND prenom_stagiaire = ?";

        	String sqlInsertInscription = "INSERT INTO inscription (code_stage, num_stagiaire, date_inscrip, statut_inscrip, code_position) VALUES (?, ?, ?, ?, ?)";

            String sqlUpdateNbinscrit = "UPDATE stage SET nbinscrit_stage = nbinscrit_stage + 1 WHERE code_stage = ?";
            

            try (PreparedStatement statementCheckPlaces = cnx.prepareStatement(sqlCheckPlaces)) {
                statementCheckPlaces.setString(1, codeStage);

                try (ResultSet resultSet = statementCheckPlaces.executeQuery()) {
                    if (resultSet.next()) {
                        int nbInscrits = resultSet.getInt("nbinscrit_stage");
                        int nbPlaces = resultSet.getInt("nbplace_stage");
                        char codePosition;

                        if (nbInscrits >= nbPlaces) {
                            codePosition = '3'; 
                        } else {
                            codePosition = '2'; 
                        }

                        try (PreparedStatement statementFindStagiaire = cnx.prepareStatement(sqlFindStagiaire)) {
                            statementFindStagiaire.setString(1, nomStagiaire);
                            statementFindStagiaire.setString(2, prenomStagiaire);

                            try (ResultSet resultSetStagiaire = statementFindStagiaire.executeQuery()) {
                                if (resultSetStagiaire.next()) {
                                    int numStagiaire = resultSetStagiaire.getInt("num_stagiaire");

                                    try (PreparedStatement statementInsertInscription = cnx.prepareStatement(sqlInsertInscription)) {
                                        statementInsertInscription.setString(1, codeStage);
                                        statementInsertInscription.setInt(2, numStagiaire);
                                        statementInsertInscription.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
                                        statementInsertInscription.setString(4, String.valueOf(statutInscription));
                                        statementInsertInscription.setString(5, String.valueOf(codePosition));

                                        statementInsertInscription.executeUpdate();

                                        try (PreparedStatement statementUpdateNbinscrit = cnx.prepareStatement(sqlUpdateNbinscrit)) {
                                            statementUpdateNbinscrit.setString(1, codeStage);

                                            statementUpdateNbinscrit.executeUpdate();
                                        }
                                    }
                                } else {
                                    System.out.println("Stagiaire non trouvé.");
                                }
                            }
                        }
                    } else {
                        System.out.println("Aucun stage trouvé pour le code " + codeStage);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
