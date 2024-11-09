package com.jee.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.jee.beans.Stage;

public class test2 {

	 public static void main(String[] args) throws SQLException {
	   
		 
	        Fenetre2dao dao = new Fenetre2daoimpl();

	        
	            List<String> stagiaires = dao.selectStagiaire("0");

	            for (String stagiaire : stagiaires) {
	                System.out.println(stagiaire);
	            }
	        
	            
	       
	            
	 }
	 }
