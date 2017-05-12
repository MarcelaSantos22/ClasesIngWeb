package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import DTO.Cliente;
import bl.ClienteBL;
import exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuration.xml")

public class ClienteBLTest {
	@Autowired // Para injectar el objeto ClienteDAO, esto tambien lo inicializa
	ClienteBL clienteBL;
	
	@Test
	public void testObtenerList() {
		List<Cliente> lista = null; // Creamos un objeto lista de Ciudad

		try {

			lista = clienteBL.obtener(); // Se inicializa la lista, con el metodo obtener, para traer las
											// ciudades.
			assertTrue(lista.size() > 0); // Se valida que la lista tenga
											// almenos un objeto

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

}
