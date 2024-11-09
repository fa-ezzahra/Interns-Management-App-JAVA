package com.jee.dao;

import java.time.LocalDate;

import com.jee.beans.Stagiaire;

public interface Fenetre4dao {
	public void insererStagiaire(String nom, String prenom, LocalDate dateNaissance, String diplome, char sexe);
	

}