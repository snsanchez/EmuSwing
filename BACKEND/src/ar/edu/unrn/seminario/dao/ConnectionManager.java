package ar.edu.unrn.seminario.dao;

import com.mysql.jdbc.Connection;

public class ConnectionManager {

	public static void connect() {
		
	}

	public static void disconnect() {
		
	}

	public static void reconnect() {
		disconnect();
		connect();
	}

	public static Connection getConnection() {
		return null;
	}

}
