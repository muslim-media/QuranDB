package fr.sofnul.qoran.service;

import fr.sofnul.qoran.entity.Aya;
import fr.sofnul.qoran.entity.Sourate;
import fr.sofnul.qoran.iservice.IDaoQoran;
import fr.sofnul.qoran.util.QoranSQLiteDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoQoran implements IDaoQoran {
	private final static Logger LOGGER = LoggerFactory.getLogger(DaoQoran.class);
	private final QoranSQLiteDataSource qoranDB = new QoranSQLiteDataSource();
	
	@Override
	public Sourate getSourate(Sourate paramSourat) {
		LOGGER.info("Début de la récupération de la sourate");
		Sourate sourate = new Sourate();
		Connection connection = null;
		try {
			LOGGER.info("Début de la connexion...");
			connection = qoranDB.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM sourate WHERE id = ?");
			LOGGER.info("Préparation des arguments...");
			pstmt.setInt(1, paramSourat.getIdsourate());
			ResultSet resultSet = pstmt.executeQuery();
			LOGGER.info("Recuperation des sourates dans le retour de la requete...");
			while (resultSet.next()) {
				sourate.setIdsourate(Integer.parseInt(resultSet.getString("id")));
				sourate.setTitreSourateFR(resultSet.getString("titre_fr"));
				sourate.setTitreSourateAR(resultSet.getString("titre_ar"));
				sourate.setNbAya(Integer.parseInt(resultSet.getString("nb_aya")));
				sourate.setStartAya(Integer.parseInt(resultSet.getString("start_aya")));
			}
			LOGGER.info("sourate trouvée: " + sourate.getTitreSourateFR());
		} catch (SQLException e) {
			LOGGER.warn("Erreur lors de la transaction dans la base !");
			sourate = null;
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sourate;
	}
	
	@Override
	public List<Sourate> getSouratesListe() {
		List<Sourate> sourateListe = new ArrayList<>();
		Sourate sourate = new Sourate();
		Connection connection = null;
		try {
			connection = qoranDB.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM sourate");
			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
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
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sourateListe;
	}
	
	@Override
	public Aya getAya(Aya paramAya) {
		List<Aya> ayas = getAyas(paramAya.getIdAya(), paramAya.getIdAya());
		return ayas.get(0);
	}
	
	@Override
	public List<Aya> getAyasDeSourate(Sourate paramSourat) {
		return getAyas(paramSourat.getStartAya(), paramSourat.getNbAya() + paramSourat.getStartAya() - 1);
	}
	
	@Override
	public List<Aya> getAyas(Integer paramStartAya, Integer paramEndAya) {
		List<Aya> ayas = new ArrayList<>();
		Connection connection = null;
		try {
			connection = qoranDB.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM aya WHERE id BETWEEN ? AND ?");
			pstmt.setInt(1, paramStartAya);
			pstmt.setInt(2, paramEndAya);
			ResultSet resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				Aya aya = new Aya();
				aya.setIdAya(Integer.parseInt(resultSet.getString("id")));
				aya.setAyaTxt(resultSet.getString("ayaTxt"));
				ayas.add(aya);
			}
		} catch (SQLException e) {
			ayas = null;
			LOGGER.error(e.getMessage(), e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
		return ayas;
	}
}