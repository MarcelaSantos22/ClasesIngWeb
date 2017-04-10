package DAO;

/**
 * Inteface con los metodos del DAO para ciudad
 * @author Yuri Marcela Quejada - ymarcela.quejada@udea.edu.co
 *
 */

import java.util.List;
import DTO.Ciudad;
import exception.MyException;

//Interfas definida por los usuarios
public interface CiudadDAO {

	// Entrega la lista completa en la bd ordenada por su nombre
	public List<Ciudad> obtener() throws MyException;

	// Obtener la información de una ciudad, dado su codigo
	public Ciudad obtener(Long i) throws MyException;

	// Insertar una nueva ciudad en la base de datos
	public void guardar(Ciudad ciudad) throws MyException;

	// Actualizar los datos de una ciudad en la base de datos
	public void modificar(Ciudad ciudad) throws MyException;

	// Eliminar una ciudad de la base de datos
	public void eliminar(Ciudad ciudad) throws MyException;

}
