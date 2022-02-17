package fr.sofnul.qoran.service;

import fr.sofnul.qoran.entity.Aya;
import fr.sofnul.qoran.entity.Sourate;
import fr.sofnul.qoran.iservice.IBuQoran;
import fr.sofnul.qoran.iservice.IDaoQoran;

import java.util.List;

public class BuQoran implements IBuQoran {
	private final IDaoQoran daoQoran = new DaoQoran();
	
	@Override
	public Sourate getSourate(Sourate sourat) {
		return daoQoran.getSourate(sourat);
	}

	@Override
	public List<Sourate> getSouratesListe() {
		return daoQoran.getSouratesListe();
	}

	@Override
	public Aya getAya(Aya aya) {
		return daoQoran.getAya(aya);
	}

	@Override
	public List<Aya> getAyasDeSourate(Sourate sourate) {
		return daoQoran.getAyasDeSourate(sourate);
	}

	@Override
	public List<Aya> getAyas(Integer startAya, Integer endAya) {
		return daoQoran.getAyas(startAya, endAya);
	}
}