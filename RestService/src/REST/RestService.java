package REST;

import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.DAO.EmployeDAO;
import com.model.EmployeObject;


import javax.ws.rs.Produces;

@Path("/MyRestService")
@ApplicationPath("/resources")
public class RestService extends Application{
	
	EmployeDAO empleados = new EmployeDAO();
	
	 // http://localhost:8080/RestService/resources/MyRestService/HolaCompa
	 @GET
	 @Path("/HolaCompa")
	 public String HolaCompa() {
		 return "Fierro compa, Jalese jalese";
	 }
	
	// http://localhost:8080/RestService/resources/MyRestService/Object
	@GET
	@Path("/Object")
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeObject getObject()
	{
		return new EmployeObject(1,"Ing.Ricardo","Contreras");
	}

	// http://localhost:8080/RestService/resources/MyRestService/verEmpleados
	 @GET
	 @Path("/verEmpleados")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<EmployeObject> VerEmpleado() {
    
		 List<EmployeObject> verEmpleados =  empleados.obtener();
	     return verEmpleados; 
   }	
	 
}
