package com.amplexor.csv.testread;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TriathlonResult {
	
	private int rang;
	
	private int dossard;
	
	private String nom;
	
	private String tps;
	
	private String cat;
	
	private int rgCat;
	
	private int rgS;
	
	private String equipe;
	
	private String tod;
	
	private String swim, cycle, run;
	
	@JsonProperty("Rg")
	public int getRang() {
		return rang;
	}
	
	public void setRang(int rang) {
		this.rang = rang;
	}
	
	@JsonProperty("Dos.")
	public int getDossard() {
		return dossard;
	}
	
	
	public void setDossard(int dossard) {
		this.dossard = dossard;
	}
	
	@JsonProperty("NOM Prénom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@JsonProperty("Tps")
	public String getTps() {
		return tps;
	}

	public void setTps(String tps) {
		this.tps = tps;
	}
	
	@JsonProperty("Cat")
	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
	
	@JsonProperty("Rg/Cat")
	public int getRgCat() {
		return rgCat;
	}
	
	public void setRgCat(int rgCat) {
		this.rgCat = rgCat;
	}
	
	@JsonProperty("Rg/S")
	public int getRgS() {
		return rgS;
	}
	
	public void setRgS(int rgS) {
		this.rgS = rgS;
	}
	
	@JsonProperty("Equipe")
	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	
	@JsonProperty("TOD")
	public String getTod() {
		return tod;
	}

	public void setTod(String tod) {
		this.tod = tod;
	}
	
	@JsonProperty("Swim")
	public String getSwim() {
		return swim;
	}

	public void setSwim(String swim) {
		this.swim = swim;
	}
	
	@JsonProperty("Cycle")
	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	
	@JsonProperty("Run")
	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}


}
