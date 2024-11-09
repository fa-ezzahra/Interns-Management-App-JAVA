package com.jee.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.jee.beans.Stage;

public class test {

    public static void main(String[] args) throws SQLException {
        
        Fenetre1dao dao = new Fenetre1daoimpl();

        
            List<Stage> stages = dao.SelectAllStages();

            for (Stage stage : stages) {
                System.out.println(stage);
            }
        
            
       
         
    }
}