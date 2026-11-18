package ar.edu.unrn.seminario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import ar.edu.unrn.seminario.exception.ConexionBaseDeDatosException;

public class ConnectionManager {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL_DB = "jdbc:mysql://localhost:3306/emuswing_db";
    private static final String USER = "emuswing";
    private static final String PASS = "supermario";
	protected static Connection conn = null;

	public static void connect() {
	try {
				conn = DriverManager.getConnection(URL_DB, USER, PASS);
			} catch (SQLException sqlEx) {
				conn = null;
				throw new ConexionBaseDeDatosException("No se ha podido conectar a " + URL_DB + ". " + sqlEx.getMessage());
			}
		}

	public static void disconnect() {
	    if (conn != null) {
				try{
				conn.close();
			}catch (SQLException e){
			    e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

	public static void reconnect() {
		disconnect();
		connect();
	}

	public static Connection getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = null;
				connect();
			}
		} catch (SQLException e) {
			conn = null;
			connect();
		}
		return conn;
	}

}
