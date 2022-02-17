package fr.sofnul.qoran.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QoranSQLiteDataSource implements DataSource {

	private final static Logger LOGGER = LoggerFactory.getLogger(QoranSQLiteDataSource.class);

	static {
		LOGGER.debug("Chargement de la class...");
		try {
			LOGGER.debug("Chargement de la class org.sqlite.JDBC");
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			LOGGER.warn("Erreur lors du chargement de la classe org.sqlite.JDBC");
			e.printStackTrace();
		}
		LOGGER.debug("Chargement de la class OK");
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		LOGGER.debug("Début de la connexion...");
		LOGGER.debug("fichier : " + getClass().getClassLoader().getResource("qoran.db"));
		Connection cnx = DriverManager.getConnection("jdbc:sqlite:" + getClass().getClassLoader().getResource("qoran.db"));
		LOGGER.debug("Chargemen de la base " + getClass().getClassLoader().getResource("qoran.db"));
		LOGGER.debug("connexion OK");
		return cnx;
	}

	@Override
	public PrintWriter getLogWriter() {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) {
	}

	@Override
	public void setLoginTimeout(int seconds) {
	}

	@Override
	public int getLoginTimeout() {
		return 0;
	}

	@Override
	public java.util.logging.Logger getParentLogger() {
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) {
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) {
		return null;
	}
}
