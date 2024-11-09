package com.jee.business;

import java.sql.SQLException;
import java.util.List;

import com.jee.beans.Stage;
import com.jee.dao.Fenetre1dao;
import com.jee.dao.Fenetre1daoimpl;

public class Fenetre1businessimpl implements Fenetre1manager {
	    private Fenetre1dao fenetre1dao;
	    
	    
	    public Fenetre1businessimpl() {
	       
	    }

	    public Fenetre1businessimpl(Fenetre1dao fenetre1dao) {
	        this.fenetre1dao = fenetre1dao;
	    }


	    public Fenetre1dao getFenetre1dao() {
			return fenetre1dao;
		}

		public void setFenetre1dao(Fenetre1dao fenetre1dao) {
			this.fenetre1dao = fenetre1dao;
		}

		
	    @Override
	    public List<Stage> selectAllStages() throws SQLException {
	        return fenetre1dao.SelectAllStages();
	    }
	}


