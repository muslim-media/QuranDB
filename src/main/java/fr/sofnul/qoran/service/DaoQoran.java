package fr.sofnul.qoran.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.sofnul.qoran.entity.Aya;
import fr.sofnul.qoran.entity.Sourate;
import fr.sofnul.qoran.iservice.IDaoQoran;
import fr.sofnul.qoran.util.QoranSQLiteDataSource;

public class DaoQoran implements IDaoQoran {
	private final static Logger log = Logger.getLogger(DaoQoran.class);
	private QoranSQLiteDataSource qoranDB = new QoranSQLiteDataSource();
	
	@Override
	public Sourate getSourate(Sourate paramSourat) {
		log.info("Début de la récuperation de la sourate");
		Sourate sourate = null;
		Connection connection = null; 
		try {
			log.info("Début de la connexion...");
			connection = qoranDB.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM sourate WHERE id = ?");
			log.info("Préparation des arguments...");
			pstmt.setInt(1, paramSourat.getIdsourate().intValue());
			ResultSet resultSet = pstmt.executeQuery();
			log.info("Recuperation des sourates dans le retour de la requete...");
			while (resultSet.next()) {
				sourate = new Sourate();
				sourate.setIdsourate(Integer.parseInt(resultSet.getString("id")));
				sourate.setTitreSourateFR(resultSet.getString("titre_fr"));
				sourate.setTitreSourateAR(resultSet.getString("titre_ar"));
				sourate.setNbAya(Integer.parseInt(resultSet.getString("nb_aya")));
				sourate.setStartAya(Integer.parseInt(resultSet.getString("start_aya")));
			}
			log.info("sourate trouvée: " + sourate.getTitreSourateFR());
		} catch (SQLException e) {
			log.warn("Erreur lors de la transaction dans la base !");
			sourate = null;
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sourate;
	}
	
	@Override
	public List<Sourate> getSouratesListe() {
		List<Sourate> sourateListe = new ArrayList<Sourate>();
		Sourate sourate = null;
		Connection connection = null; 
		try {
			connection = qoranDB.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM sourate");
			ResultSet resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				sourate = new Sourate();
				sourate.setIdsourate(Integer.parseInt(resultSet.getString("id")));
				sourate.setTitreSourateFR(resultSet.getString("titre_fr"));
				sourate.setTitreSourateAR(resultSet.getString("titre_ar"));
				sourate.setNbAya(Integer.parseInt(resultSet.getString("nb_aya")));
				sourate.setStartAya(Integer.parseInt(resultSet.getString("start_aya")));
				// Ajout à la liste
				sourateListe.add(sourate);
			}
		} catch (SQLException e) {
			sourateListe = null;
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sourateListe;
	}
	
	@Override
	public Aya getAya(Aya paramAya) {
		List<Aya> ayaListe = getAyasListe(paramAya.getIdAya(), paramAya.getIdAya());
		return ayaListe.get(0);
	}
	
	@Override
	public List<Aya> getAyasDeSourate(Sourate paramSourat) {
		return getAyasListe(paramSourat.getStartAya(), paramSourat.getNbAya() + paramSourat.getStartAya() - 1);
	}
	
	@Override
	public List<Aya> getAyasListe(Integer paramStartAya, Integer paramEndAya) {
		List<Aya> ayaListe = new ArrayList<Aya>();
		Aya aya = null;
		Connection connection = null; 
		try {
			connection = qoranDB.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM aya WHERE id BETWEEN ? AND ?");
			pstmt.setInt(1, paramStartAya.intValue());
			pstmt.setInt(2, paramEndAya.intValue());
			ResultSet resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				aya = new Aya(); // nouvelle aya
				aya.setIdAya(Integer.parseInt(resultSet.getString("id"))); // recuperation de l'ID de l'aya
				aya.setAyaTxt(resultSet.getString("ayaTxt")); // recupération du contenu de l'aya
				ayaListe.add(aya); // Ajout à la liste
			}
		} catch (SQLException e) {
			ayaListe = null;
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ayaListe;
	}
}