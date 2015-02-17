package fr.sofnul.qoran.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;


public class QoranSQLiteDataSource implements DataSource {
	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(QoranSQLiteDataSource.class);
	static {
		log.info("Chargement de la class...");
		try {
			log.info("Chargement de la class org.sqlite.JDBC");
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			log.warn("Erreur lors du chargement de la classe org.sqlite.JDBC");
			e.printStackTrace();
		}
		log.info("Chargement de la class OK");
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		log.info("Début de la connexion...");
		log.info("fichier : " + getClass().getClassLoader().getResource("qoran.db"));
		Connection cnx = DriverManager.getConnection("jdbc:sqlite:" + getClass().getClassLoader().getResource("qoran.db"));
		log.info("Chargemen de la base " + getClass().getClassLoader().getResource("qoran.db"));
		log.info("connexion OK");
		return cnx;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}
}
