package fr.sofnul.qoran.service;

import java.util.List;

import fr.sofnul.qoran.entity.Aya;
import fr.sofnul.qoran.entity.Sourate;
import fr.sofnul.qoran.iservice.IBuQoran;
import fr.sofnul.qoran.iservice.IDaoQoran;

public class BuQoran implements IBuQoran {
	/**
	 * Attributs
	 */
	private IDaoQoran daoQoran = new DaoQoran();
	
	@Override
	public Sourate getSourate(Sourate paramSourat) {
		return daoQoran.getSourate(paramSourat);
	}

	@Override
	public List<Sourate> getSouratesListe() {
		return daoQoran.getSouratesListe();
	}

	@Override
	public Aya getAya(Aya paramAya) {
		return daoQoran.getAya(paramAya);
	}

	@Override
	public List<Aya> getAyasDeSourate(Sourate paramSourate) {
		return daoQoran.getAyasDeSourate(paramSourate);
	}

	@Override
	public List<Aya> getAyasListe(Integer paramStartAya, Integer paramEndAya) {
		return daoQoran.getAyasListe(paramStartAya, paramEndAya);
	}
}