package com.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jee.beans.Stage;

public class Fenetre1daoimpl implements Fenetre1dao {
   
	public List<Stage> SelectAllStages()  {
    	try {
        List<Stage> stages = new ArrayList<Stage>();
        Connection cnx = MySQLConnection.getConnection();
        String sql = "SELECT * FROM stage";
        PreparedStatement statement = cnx.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String codestage = resultSet.getString("code_stage");
            String typestage = resultSet.getString("type_stage");
            LocalDate debutstage = resultSet.getDate("debut_stage").toLocalDate();
            LocalDate finstage = resultSet.getDate("fin_stage").toLocalDate();
            int nbplacestage = resultSet.getInt("nbplace_stage");
            int nbinscrit = resultSet.getInt("nbinscrit_stage");

            Stage stage = new Stage(codestage, typestage, debutstage, finstage, nbplacestage, nbinscrit);
            stages.add(stage);
        }

        resultSet.close();
        statement.close();

        return stages;
    	} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return null;
	}
}
    