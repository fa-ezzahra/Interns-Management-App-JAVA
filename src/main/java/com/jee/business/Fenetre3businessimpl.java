package com.jee.business;

import java.sql.SQLException;
import java.util.List;

import com.jee.dao.Fenetre3dao;
import com.jee.dao.Fenetre3daoimpl;

public class Fenetre3businessimpl implements Fenetre3manager {
    private Fenetre3dao fenetre3dao;

    public Fenetre3dao getFenetre3dao() {
		return fenetre3dao;
	}

	public void setFenetre3dao(Fenetre3dao fenetre3dao) {
		this.fenetre3dao = fenetre3dao;
	}

	public Fenetre3businessimpl() {
        this.fenetre3dao = new Fenetre3daoimpl();
    }

    public Fenetre3businessimpl(Fenetre3dao fenetre3dao) {
        this.fenetre3dao = fenetre3dao;
    }

    @Override
    public List<String> getNomsStagiairesPourStage(String codeStage) {
        return fenetre3dao.getNomsStagiairesPourStage(codeStage);
    }

    @Override
    public void inscrireStagiaire(String nomStagiaire, String prenomStagiaire, String codeStage, char statutInscription) {
        fenetre3dao.inscrireStagiaire(nomStagiaire, prenomStagiaire, codeStage, statutInscription);
    }
}
