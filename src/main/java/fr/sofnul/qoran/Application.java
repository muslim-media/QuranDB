package fr.sofnul.qoran;

import fr.sofnul.qoran.entity.Aya;
import fr.sofnul.qoran.entity.Sourate;
import fr.sofnul.qoran.iservice.IBuQoran;
import fr.sofnul.qoran.service.BuQoran;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public final class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        IBuQoran quran = new BuQoran();

        // Recuperation des la liste de sosurates
        List<Sourate> sourates = quran.getSouratesListe();
        LOG.info("Taille de la liste: " + sourates.size());
        for (Sourate sourate : sourates) {
            LOG.info("- " + sourate.getIdsourate() + " - " + sourate.getTitreSourateFR());
        }

        // Sourate 10
        Sourate sourate10 = new Sourate();
        sourate10.setIdsourate(10);
        sourate10 = quran.getSourate(sourate10);
        LOG.info("Sourate 10 FR: " + sourate10.getTitreSourateFR());
        LOG.info("Sourate 10 AR: " + sourate10.getTitreSourateAR());
        LOG.info("Sourate 10 nbAya: " + sourate10.getNbAya());
        LOG.info("Sourate 10 start aya: " + sourate10.getStartAya());


        // Récuperation des ayates de la sourate 10
        logAyas(quran.getAyasDeSourate(sourate10));
        // ATTENTION aà l'OutOfMemory
        logAyas(quran.getAyas(3000, 3010));
        // Récupera ayate al korsi
        Aya aya = new Aya();
        aya.setIdAya(262);
        logAya(quran.getAya(aya));
    }

    private static void logAya(Aya aya) {
        LOG.info(aya.getIdAya() + ": " + aya.getAyaTxt());
    }
    private static void logAyas(List<Aya> ayas) {
        for (Aya aya : ayas) {
            logAya(aya);
        }
    }
}
