package ar.edu.unrn.seminario.dao;

import java.sql.Connection;
import com.mysql.jdbc.Connection;

public class ConnectionManager {
    private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL_DB = "jdbc:mysql://localhost:3306/";
	protected static String DB = "emuswing_db";
	protected static String user = "seminario";
	protected static String pass = "supermario";
	protected static Connection conn = null;

	public static void connect() {
	try {
				conn = DriverManager.getConnection(URL_DB + DB, user, pass);
			} catch (SQLException sqlEx) {
				System.out.println("No se ha podido conectar a " + URL_DB + DB + ". " + sqlEx.getMessage());
				System.out.println("Error al cargar el driver");
			}
		}

	public static void disconnect() {
	    if (conn != null) {
				try{
				conn.close();
				conn = nul;
			}catch (SQLException e){
			    e.printStackTrace();
			}
		}
	}

	public static void reconnect() {
		disconnect();
		connect();
	}

	public static Connection getConnection() {
	    if (conn == null) {
			connect();
	    }
	    return conn;
	}

}
