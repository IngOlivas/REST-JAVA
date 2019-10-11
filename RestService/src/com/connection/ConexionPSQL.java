package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
//import java.sql.Statement;

public class ConexionPSQL {

	static final String URL = "jdbc:postgresql://localhost:5432/BDEmployes";
	static final String USER = "postgres";
	static final String PASS = "Elpapi1234";

	public static Connection crearConexion() throws ClassNotFoundException, SQLException  {
		Class.forName("org.postgresql.Driver");
		Connection conexion = DriverManager.getConnection(URL, USER, PASS);
		if (conexion != null) {
			System.out.print("Conexion establecida...");
		}
		return conexion;
	}
}
