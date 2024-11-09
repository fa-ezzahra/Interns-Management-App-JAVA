package com.jee.beans;

import java.sql.Date;
import java.time.LocalDate;

public class Stage {
	private  String codestage;
	private String typestage;
	private  LocalDate debutstage;
	private LocalDate finstage;
	private int nbplacestage;
	private int nbinscrit;
	public Stage() {
		
	}
	public Stage(String codestage, String typestage, LocalDate debutstage, LocalDate finstage, int nbplacestage, int nbinscrit) {
		super();
		this.codestage = codestage;
		this.typestage = typestage;
		this.debutstage = debutstage;
		this.finstage = finstage;
		this.nbplacestage = nbplacestage;
		this.nbinscrit = nbinscrit;
	}
	public String getCodestage() {
		return codestage;
	}
	public void setCodestage(String codestage) {
		this.codestage = codestage;
	}
	public String getTypestage() {
		return typestage;
	}
	public void setTypestage(String typestage) {
		this.typestage = typestage;
	}
	public LocalDate getDebutstage() {
		return debutstage;
	}
	public void setDebutstage(LocalDate debutstage) {
		this.debutstage = debutstage;
	}
	public LocalDate getFinstage() {
		return finstage;
	}
	public void setFinstage(LocalDate finstage) {
		this.finstage = finstage;
	}
	public int getNbplacestage() {
		return nbplacestage;
	}
	public void setNbplacestage(int nbplacestage) {
		this.nbplacestage = nbplacestage;
	}
	public int getNbinscrit() {
		return nbinscrit;
	}
	public void setNbinscrit(int nbinscrit) {
		this.nbinscrit = nbinscrit;
	}
	@Override
	public String toString() {
		return "Stage [codestage=" + codestage + ", typestage=" + typestage + ", debutstage=" + debutstage
				+ ", finstage=" + finstage + ", nbplacestage=" + nbplacestage + ", nbinscrit=" + nbinscrit + "]";
	}
	
	

}
