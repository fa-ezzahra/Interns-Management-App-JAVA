package com.jee.business;

import java.sql.SQLException;
import java.util.List;

import com.jee.dao.Fenetre2dao;
import com.jee.dao.Fenetre2daoimpl;

public class Fenetre2businessimpl implements Fenetre2manager {
    private Fenetre2dao fenetre2dao;

    public Fenetre2dao getFenetre2dao() {
		return fenetre2dao;
	}

	public void setFenetre2dao(Fenetre2dao fenetre2dao) {
		this.fenetre2dao = fenetre2dao;
	}

	public Fenetre2businessimpl() {
        
    }

    public Fenetre2businessimpl(Fenetre2dao fenetre2dao) {
        this.fenetre2dao = fenetre2dao;
    }

    @Override
    public List<String> selectStagiaire(String codeStage) {
        return fenetre2dao.selectStagiaire(codeStage);
    }
}
