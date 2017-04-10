package test;

import static org.junit.Assert.*;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import DAO.CiudadDAO;
import DTO.Ciudad;
import exception.MyException;
import impl.CiudadDAOImpl;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configuration.xml")
public class CiudadDAOImplTest {
	@Autowired //Para injectar el objeto CiudadDAO, esto tambien lo inicializa
	CiudadDAO ciudadDAO;

	@Test
	public void testObtenerList() {
		List<Ciudad> lista = null;	//Creamos un objeto lista de Ciudad
		
		try{
			
			lista = ciudadDAO.obtener();	//Se inicializa la lista, con el metodo obtener, 
											//para traer las ciudades.
			assertTrue(lista.size()>0);		//Se valida que la lista tenga almenos un objeto
		}
		catch(MyException e){
			fail(e.getMessage());
		}
		
	}
	public void testObtenerCiudad() {
		Ciudad ciudad = null;	//Creamos un objeto de Ciudad
		
		try{
			
			ciudad = ciudadDAO.obtener(1L);	//Se inicializa la ciudad, con el metodo obtener(Long i), 
											//para traer las ciudades.
			assertTrue(ciudad!=null);		//Se valida que ciudad no sea null
			
		}
		catch(MyException e){
			fail(e.getMessage());			//Capturar el mensaje por si sucede un error
		}
		
	}

}
