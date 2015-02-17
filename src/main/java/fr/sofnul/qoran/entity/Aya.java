package fr.sofnul.qoran.entity;

public class Aya {
	/**
	 * Attributs
	 */
	private Integer idAya;
	private String ayaTxt;
	private Integer idSourat;
	private Integer idHisbe;
	/**
	 * Constructeur
	 */
	public Aya() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param paramIdAya
	 * @param paramAyaTxt
	 * @param paramIdSourat
	 * @param paramIdHisbe
	 */
	public Aya(Integer paramIdAya, String paramAyaTxt, Integer paramIdSourat, Integer paramIdHisbe) {
		super();
		idAya = paramIdAya;
		ayaTxt = paramAyaTxt;
		idSourat = paramIdSourat;
		idHisbe = paramIdHisbe;
	}
	/**
	 * @return the idAya
	 */
	public Integer getIdAya() {
		return idAya;
	}
	/**
	 * @param paramIdAya the idAya to set
	 */
	public void setIdAya(Integer paramIdAya) {
		idAya = paramIdAya;
	}
	/**
	 * @return the ayaTxt
	 */
	public String getAyaTxt() {
		return ayaTxt;
	}
	/**
	 * @param paramAyaTxt the ayaTxt to set
	 */
	public void setAyaTxt(String paramAyaTxt) {
		ayaTxt = paramAyaTxt;
	}
	/**
	 * @return the idSourat
	 */
	public Integer getIdSourat() {
		return idSourat;
	}
	/**
	 * @param paramIdSourat the idSourat to set
	 */
	public void setIdSourat(Integer paramIdSourat) {
		idSourat = paramIdSourat;
	}
	/**
	 * @return the idHisbe
	 */
	public Integer getIdHisbe() {
		return idHisbe;
	}
	/**
	 * @param paramIdHisbe the idHisbe to set
	 */
	public void setIdHisbe(Integer paramIdHisbe) {
		idHisbe = paramIdHisbe;
	}
}
