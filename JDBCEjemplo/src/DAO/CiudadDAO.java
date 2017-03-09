package DAO;

import java.util.List;
import DTO.Ciudad;
import exception.ExceptionMarcela;


//Interfas definida por los usuarios
public interface CiudadDAO{

	//Entrega la lista completa en la bd ordenada por su nombre
	public List<Ciudad> obtener() throws ExceptionMarcela;
	
}
