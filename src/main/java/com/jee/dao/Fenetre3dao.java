package com.jee.dao;

import java.util.List;

public interface Fenetre3dao {

	public List<String> getNomsStagiairesPourStage(String codeStage);
	public void inscrireStagiaire(String nomStagiaire, String prenomStagiaire, String codeStage, char statutInscription);
}
