package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import DAO.ClienteDAO;
import DTO.Cliente;
import exception.MyException;
import impl.ClienteDAOImpl;

public class ClienteDAOImplTest {

	@Test
	public void testObtener() {
		ClienteDAO clienteDAO = null;
		List<Cliente> resultado = null;
		
		try {
			clienteDAO =  new ClienteDAOImpl();
			resultado = clienteDAO.obtener();
			
			for (Cliente cliente : resultado) {
				
				System.out.println(cliente.getNombres()+" "+cliente.getApellidos());
			}
			
			assertTrue(resultado.size()>0);
			
		} catch (MyException e) {
			// TODO: handle exception
			fail(e.getMessage());
		}

	}

}
