package com.jee.beans;

import java.sql.Date;
import java.time.LocalDate;

public class Stagiaire {
	private String numStagiaire;
    private String nomStagiaire;
    private String prenomStagiaire;
    private char sexeStagiaire;
    private LocalDate dateNaissanceStagiaire;
    private String diplomeStagiaire;

    // Constructeur
    public Stagiaire(String numStagiaire, String nomStagiaire, String prenomStagiaire, char sexeStagiaire, LocalDate dateNaissanceStagiaire, String diplomeStagiaire) {
        this.numStagiaire = numStagiaire;
        this.nomStagiaire = nomStagiaire;
        this.prenomStagiaire = prenomStagiaire;
        this.sexeStagiaire = sexeStagiaire;
        this.dateNaissanceStagiaire = dateNaissanceStagiaire;
        this.diplomeStagiaire = diplomeStagiaire;
    }

    // Getters et Setters
    public String getNumStagiaire() {
        return numStagiaire;
    }

    public void setNumStagiaire(String numStagiaire) {
        this.numStagiaire = numStagiaire;
    }

    public String getNomStagiaire() {
        return nomStagiaire;
    }

    public void setNomStagiaire(String nomStagiaire) {
        this.nomStagiaire = nomStagiaire;
    }

    public String getPrenomStagiaire() {
        return prenomStagiaire;
    }

    public void setPrenomStagiaire(String prenomStagiaire) {
        this.prenomStagiaire = prenomStagiaire;
    }

    public char getSexeStagiaire() {
        return sexeStagiaire;
    }

    public void setSexeStagiaire(char sexeStagiaire) {
        this.sexeStagiaire = sexeStagiaire;
    }

    public LocalDate getDateNaissanceStagiaire() {
        return dateNaissanceStagiaire;
    }

    public void setDateNaissanceStagiaire(LocalDate dateNaissanceStagiaire) {
        this.dateNaissanceStagiaire = dateNaissanceStagiaire;
    }

    @Override
	public String toString() {
		return "Stagiaire [numStagiaire=" + numStagiaire + ", nomStagiaire=" + nomStagiaire + ", prenomStagiaire="
				+ prenomStagiaire + ", sexeStagiaire=" + sexeStagiaire + ", dateNaissanceStagiaire="
				+ dateNaissanceStagiaire + ", diplomeStagiaire=" + diplomeStagiaire + "]";
	}

	public String getDiplomeStagiaire() {
        return diplomeStagiaire;
    }

    public void setDiplomeStagiaire(String diplomeStagiaire) {
        this.diplomeStagiaire = diplomeStagiaire;
    }
}
