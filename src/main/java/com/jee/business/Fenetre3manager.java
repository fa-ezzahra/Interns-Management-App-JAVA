package com.jee.business;

import java.util.List;

public interface Fenetre3manager {

	 public List<String> getNomsStagiairesPourStage(String codeStage);
	 public void inscrireStagiaire(String nomStagiaire, String prenomStagiaire, String codeStage, char statutInscription);
}
