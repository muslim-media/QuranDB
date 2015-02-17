package fr.sofnul.qoran.entity;

public class Sourate {
	
	/**
	 * Attributs
	 */
	private Integer idsourate;
	private String titreSourateFR;
	private String titreSourateAR;
	private Integer nbAya;
	private Integer startAya;
	
	/**
	 * 
	 */
	public Sourate() {
		super();
	}

	/**
	 * @param paramIdsourat
	 * @param paramTitreSourateFR
	 * @param paramTitreSourateAR
	 * @param paramNbAya
	 * @param paramStartAya
	 */
	public Sourate(Integer paramIdsourat, String paramTitreSourateFR, String paramTitreSourateAR, Integer paramNbAya, Integer paramStartAya) {
		super();
		idsourate = paramIdsourat;
		titreSourateFR = paramTitreSourateFR;
		titreSourateAR = paramTitreSourateAR;
		nbAya = paramNbAya;
		startAya = paramStartAya;
	}

	/**
	 * @return the idsourat
	 */
	public Integer getIdsourate() {
		return idsourate;
	}

	/**
	 * @param paramIdsourat the idsourat to set
	 */
	public void setIdsourate(Integer paramIdsourat) {
		idsourate = paramIdsourat;
	}

	/**
	 * @return the titreSourateFR
	 */
	public String getTitreSourateFR() {
		return titreSourateFR;
	}

	/**
	 * @param paramTitreSourateFR the titreSourateFR to set
	 */
	public void setTitreSourateFR(String paramTitreSourateFR) {
		titreSourateFR = paramTitreSourateFR;
	}

	/**
	 * @return the titreSourateAR
	 */
	public String getTitreSourateAR() {
		return titreSourateAR;
	}

	/**
	 * @param paramTitreSourateAR the titreSourateAR to set
	 */
	public void setTitreSourateAR(String paramTitreSourateAR) {
		titreSourateAR = paramTitreSourateAR;
	}

	/**
	 * @return the nbAya
	 */
	public Integer getNbAya() {
		return nbAya;
	}

	/**
	 * @param paramNbAya the nbAya to set
	 */
	public void setNbAya(Integer paramNbAya) {
		nbAya = paramNbAya;
	}

	/**
	 * @return the startAya
	 */
	public Integer getStartAya() {
		return startAya;
	}

	/**
	 * @param paramStartAya the startAya to set
	 */
	public void setStartAya(Integer paramStartAya) {
		startAya = paramStartAya;
	}
}
