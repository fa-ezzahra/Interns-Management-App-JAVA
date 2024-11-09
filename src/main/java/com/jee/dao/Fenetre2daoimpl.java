package com.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jee.beans.Stagiaire;

public class Fenetre2daoimpl implements Fenetre2dao {

	
	    public List<String> selectStagiaire(String codeStage) {
	        List<String> stagiaires = new ArrayList<>();
	        
	        try {
	        	Connection cnx = MySQLConnection.getConnection();
	            String query = "SELECT s.* FROM stagiaire s " +
	                           "JOIN inscription i ON s.num_stagiaire = i.num_stagiaire " +
	                           "WHERE i.code_stage = ?";
	            PreparedStatement statement = cnx.prepareStatement(query);
	            statement.setString(1, codeStage);
	            ResultSet resultSet = statement.executeQuery();
	         
	            while (resultSet.next()) {
	                String nom = resultSet.getString("nom_stagiaire");
	                String prenom = resultSet.getString("prenom_stagiaire");
	                String stagiaire= nom+" "+prenom;
	                stagiaires.add(stagiaire);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	        return stagiaires;
	    }
	

}