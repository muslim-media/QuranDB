package fr.sofnul.qoran.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

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
	public java.util.logging.Logger getParentLogger() throws SQLFeatureNotSupportedException {
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
