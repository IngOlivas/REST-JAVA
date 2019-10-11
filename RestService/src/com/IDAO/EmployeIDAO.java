package com.IDAO;

import java.util.List;

import com.model.EmployeObject;

public interface EmployeIDAO {

	public boolean registrar(EmployeObject employe);
	public List<EmployeObject> obtener();	
	public boolean actualizar(EmployeObject employe);
	public boolean eliminar(EmployeObject employe);
}
