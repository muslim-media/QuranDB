package fr.sofnul.qoran.iservice;

import fr.sofnul.qoran.entity.Aya;
import fr.sofnul.qoran.entity.Sourate;

import java.util.List;

public interface IBuQoran {
	Sourate getSourate(Sourate sourat);

	List<Sourate> getSouratesListe();

	Aya getAya(Aya aya);

	List<Aya> getAyasDeSourate(Sourate sourate);

	List<Aya> getAyas(Integer startAya, Integer endAya);
}
