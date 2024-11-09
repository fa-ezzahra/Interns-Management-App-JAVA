package com.jee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.jee.beans.Stagiaire;

public class Fenetre4daoimpl implements  Fenetre4dao {
    

	
	
	
	
	public void insererStagiaire(String nom, String prenom, LocalDate dateNaissance, String diplome, char sexe) {
	    if (dateNaissance != null) { 

	    	int dernierNumero = getLastStagiaireNumero() + 1;


	    	try  {
	            Connection cnx = MySQLConnection.getConnection();
	            String sql = "INSERT INTO stagiaire (num_stagiaire, nom_stagiaire, prenom_stagiaire, sexe_stagiaire, dnaiss_stagiaire, diplo_stagiaire) VALUES (?, ?, ?, ?, ?, ?)";
	            PreparedStatement statement = cnx.prepareStatement(sql);
	            statement.setInt(1, dernierNumero);
	            statement.setString(2, nom);
	            statement.setString(3, prenom);
	            statement.setString(4, String.valueOf(sexe));
	            statement.setDate(5, java.sql.Date.valueOf(dateNaissance)); 
	            statement.setString(6, diplome);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } else {

	    	System.out.println("La date de naissance est null. Impossible d'insérer le stagiaire dans la base de données.");
	    }
	}

	private int getLastStagiaireNumero() {
        int dernierNumero = 0;
        try  {
        	Connection cnx = MySQLConnection.getConnection();
            String sql = "SELECT MAX(num_stagiaire) FROM stagiaire";
            PreparedStatement statement = cnx.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                dernierNumero = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dernierNumero;
    }
}