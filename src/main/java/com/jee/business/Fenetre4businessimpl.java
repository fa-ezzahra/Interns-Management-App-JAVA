package com.jee.business;

import java.time.LocalDate;

import com.jee.dao.Fenetre4dao;
import com.jee.dao.Fenetre4daoimpl;

public class Fenetre4businessimpl implements Fenetre4manager {
    private Fenetre4dao fenetre4dao;

    public Fenetre4dao getFenetre4dao() {
		return fenetre4dao;
	}

	public void setFenetre4dao(Fenetre4dao fenetre4dao) {
		this.fenetre4dao = fenetre4dao;
	}

	public Fenetre4businessimpl() {
        this.fenetre4dao = new Fenetre4daoimpl();
    }

    public Fenetre4businessimpl(Fenetre4dao fenetre4dao) {
        this.fenetre4dao = fenetre4dao;
    }

    public void insererStagiaire(String nom, String prenom, LocalDate dateNaissance, String diplome, char sexe) {
        fenetre4dao.insererStagiaire(nom, prenom, dateNaissance, diplome, sexe);
    }
}
