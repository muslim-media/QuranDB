package fr.sofnul.qoran.entity;

public class Aya {
	private Integer idAya;
	private String ayaTxt;
	private Integer idSourat;
	private Integer idHisbe;

	public Integer getIdAya() {
		return idAya;
	}

	public void setIdAya(Integer idAya) {
		this.idAya = idAya;
	}

	public String getAyaTxt() {
		return ayaTxt;
	}

	public void setAyaTxt(String ayaTxt) {
		this.ayaTxt = ayaTxt;
	}

	public Integer getIdSourat() {
		return idSourat;
	}

	public void setIdSourat(Integer idSourat) {
		this.idSourat = idSourat;
	}

	public Integer getIdHisbe() {
		return idHisbe;
	}

	public void setIdHisbe(Integer idHisbe) {
		this.idHisbe = idHisbe;
	}
}
