package com.jee.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class test3 {

	public static void main(String[] args) throws SQLException {
       
        Fenetre3dao dao = new Fenetre3daoimpl();

        
            List<String> stagiaires = dao.getNomsStagiairesPourStage("0");

            for (String stagiaire : stagiaires) {
                System.out.println(stagiaire);
            }
        
           dao.inscrireStagiaire("chadia", "azzouzi", "0",'d');
            
       
	}
}
