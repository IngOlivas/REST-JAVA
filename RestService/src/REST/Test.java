package REST;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConexionPSQL;
public class Test {

	public static void main(String[] args) {

		try {
			Connection conexion = ConexionPSQL.crearConexion();
			Statement statement = null;

			statement = conexion.createStatement();
			ResultSet rs = statement.executeQuery(ConsultasSQL.verEmpleados);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");

				System.out.println("ID = " + id);
				System.out.println("NOMBRE = " + nombre);
				System.out.println("APELLIDO = " + apellido);
			}

			rs.close();
			statement.close();
			conexion.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.print("Consulta realizada correctamente!!!");
	}

}
	