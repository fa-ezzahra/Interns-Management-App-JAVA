package com.jee.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class test4 {
 
	
	public static void main(String[] args) throws SQLException {
        
        Fenetre4dao dao = new Fenetre4daoimpl();

        
           
        
            dao.insererStagiaire("faty", "nouha", LocalDate.of(2003, 05, 12), "ds", 'f');
            
       
            
        }
}
