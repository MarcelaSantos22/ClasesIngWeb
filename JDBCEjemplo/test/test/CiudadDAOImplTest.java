package test;

import static org.junit.Assert.*;



import org.junit.Test;

import DAO.CiudadDAO;
import DTO.Ciudad;
import exception.MyException;
import impl.CiudadDAOImpl;
import java.util.List;

public class CiudadDAOImplTest {

	@Test
	public void testObtenerList() {
		CiudadDAO ciudadDAO = null; //Creamos un objeto de CiudadDAO
		List<Ciudad> lista = null;	//Creamos un objeto lista de Ciudad
		
		try{
			ciudadDAO = new CiudadDAOImpl(); //Se inicializa CiudadDAO, llamando el constructor de 
											//CiudadDAOImpl.
			lista = ciudadDAO.obtener();	//Se inicializa la lista, con el metodo obtener, 
											//para traer las ciudades.
			assertTrue(lista.size()>0);		//Se valida que la lista tenga almenos un objeto
		}
		catch(MyException e){
			fail(e.getMessage());
		}
		
	}
	public void testObtenerCiudad() {
		CiudadDAO ciudadDAO = null; //Creamos un objeto de CiudadDAO
		Ciudad ciudad = null;	//Creamos un objeto de Ciudad
		
		try{
			ciudadDAO = new CiudadDAOImpl(); //Se inicializa CiudadDAO, llamando el constructor de 
											//CiudadDAOImpl.
			ciudad = ciudadDAO.obtener(1L);	//Se inicializa la ciudad, con el metodo obtener(Long i), 
											//para traer las ciudades.
			assertTrue(ciudad!=null);		//Se valida que ciudad no sea null
			
		}
		catch(MyException e){
			fail(e.getMessage());			//Capturar el mensaje por si sucede un error
		}
		
	}

}
