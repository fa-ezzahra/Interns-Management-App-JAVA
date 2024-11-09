package com.jee.beans;

import java.time.LocalDate;

public class Inscription {


private String codeStage;
private int numStagiaire;
private LocalDate dateInscription;
private char statutInscription;
private char codePosition;

// Constructeur
public Inscription(String codeStage, int numStagiaire, LocalDate dateInscription, char statutInscription, char codePosition) {
    this.codeStage = codeStage;
    this.numStagiaire = numStagiaire;
    this.dateInscription = dateInscription;
    this.statutInscription = statutInscription;
    this.codePosition = codePosition;
}

// Getters et Setters
public String getCodeStage() {
    return codeStage;
}

public void setCodeStage(String codeStage) {
    this.codeStage = codeStage;
}

public int getNumStagiaire() {
    return numStagiaire;
}

public void setNumStagiaire(int numStagiaire) {
    this.numStagiaire = numStagiaire;
}

public LocalDate getDateInscription() {
    return dateInscription;
}

public void setDateInscription(LocalDate dateInscription) {
    this.dateInscription = dateInscription;
}

public char getStatutInscription() {
    return statutInscription;
}

public void setStatutInscription(char statutInscription) {
    this.statutInscription = statutInscription;
}

public char getCodePosition() {
    return codePosition;
}

public void setCodePosition(char codePosition) {
    this.codePosition = codePosition;
}
}