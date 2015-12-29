package fr.sofnul.qoran.entity;

public class Sourate {
	
	private Integer idsourate;
	private String titreSourateFR;
	private String titreSourateAR;
	private Integer nbAya;
	private Integer startAya;

	public Integer getIdsourate() {
		return idsourate;
	}

	public void setIdsourate(Integer idsourate) {
		this.idsourate = idsourate;
	}

	public String getTitreSourateFR() {
		return titreSourateFR;
	}

	public void setTitreSourateFR(String titreSourateFR) {
		this.titreSourateFR = titreSourateFR;
	}

	public String getTitreSourateAR() {
		return titreSourateAR;
	}

	public void setTitreSourateAR(String titreSourateAR) {
		this.titreSourateAR = titreSourateAR;
	}

	public Integer getNbAya() {
		return nbAya;
	}

	public void setNbAya(Integer nbAya) {
		this.nbAya = nbAya;
	}

	public Integer getStartAya() {
		return startAya;
	}

	public void setStartAya(Integer startAya) {
		this.startAya = startAya;
	}
}
