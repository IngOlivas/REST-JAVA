package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.IDAO.EmployeIDAO;
import com.connection.ConexionPSQL;
import com.model.EmployeObject;
import REST.ConsultasSQL;

public class EmployeDAO implements EmployeIDAO {

	@Override
	public boolean registrar(EmployeObject employe) {

		boolean registrar = false;
		Statement stm = null;
		Connection con = null;

		String sql = "INSERT INTO TABLE_EMPLOYES VALUES ('" + employe.getId() + "','" + employe.getNombre() + "','"
				+ employe.getApellido() + "')";

		try {
			con = ConexionPSQL.crearConexion();
			stm = con.createStatement();
			stm.execute(sql);
			registrar = true;
			stm.close();
			con.close();
		} catch (Exception e) {

			System.out.println("ERROR: Clase EmployeDAO, metodo registrar!!!");
			e.printStackTrace();
		}

		return registrar;
	}

	@Override
	public List<EmployeObject> obtener() {

		Connection co = null;
		Statement stm = null;
		ResultSet rs = null;

		// String sql = "SELECT * FROM TABLE_EMPLOYES";

		List<EmployeObject> listaCliente = new ArrayList<EmployeObject>();

		try {
			co = ConexionPSQL.crearConexion();
			stm = co.createStatement();
			rs = stm.executeQuery(ConsultasSQL.verEmpleados);

			while (rs.next()) {

				EmployeObject e = new EmployeObject();
				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setApellido(rs.getString(3));
				listaCliente.add(e);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCliente;
	}

	@Override
	public boolean actualizar(EmployeObject employe) {

		Connection connect = null;
		Statement stm = null;

		boolean actualizar = false;

		String sql = "UPDATE TABLE_EMPLOYES SET id= '" + employe.getId() + "' , nombre = '" + employe.getNombre()
				+ "', apellido = '" + employe.getApellido() + "', WHERE id = " + employe.getId();

		try {

			connect = ConexionPSQL.crearConexion();
			stm = connect.createStatement();
			stm.execute(sql);
			actualizar = true;
		} catch (Exception e) {
			System.out.println("ERROR: Clase EmployeDAO, metodo actualizar!!!");
			e.printStackTrace();
		}

		return actualizar;
	}

	@Override
	public boolean eliminar(EmployeObject employe) {

		Connection connect = null;
		Statement stm = null;

		boolean eliminar = false;

		String sql = "DELETE FROM TABLE_EMPLOYES WHERE id =" + employe.getId();

		try {
			connect = ConexionPSQL.crearConexion();
			stm = connect.createStatement();
			stm.execute(sql);
			eliminar = true;
		} catch (Exception e) {

			System.out.println("ERROR: CLase EmployeDAO, metodo eliminar!!!");
			e.printStackTrace();
		}

		return eliminar;
	}
}
