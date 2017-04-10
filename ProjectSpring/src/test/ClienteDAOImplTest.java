package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import DAO.ClienteDAO;
import DTO.Cliente;
import DTO.Direccion;
import DTO.Usuario;
import exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuration.xml")

public class ClienteDAOImplTest {
	@Autowired // Para injectar el objeto ClienteDAO, esto tambien lo inicializa
	ClienteDAO clienteDAO;
	
	Cliente cliente = null;

	@Test
	public void testGuardar() {
		
		Usuario usuarioCrea = null;

		try {
			cliente = new Cliente();
			cliente.setCedula("1146437892");
			cliente.setNombres("Yuri");
			cliente.setApellidos("Quejada Santos");
			cliente.setEmail("ymarcela.quejada@udea.edu.co");

			usuarioCrea = new Usuario();
			usuarioCrea.setLogin("elver");

			cliente.setUsuarioCrea(usuarioCrea);
			cliente.setFechaCreacion(new Date());
			cliente.setEliminado(Boolean.FALSE);

			clienteDAO.guardar(cliente);

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testModificar() {
		Usuario usuarioCrea = null;

		try {
			cliente = new Cliente();
			cliente.setCedula("1146437892");
			cliente.setNombres("Yuri Marcela");
			cliente.setApellidos("Quejada Santos");
			cliente.setEmail("ymarcela.quejada@udea.edu.co");

			usuarioCrea = new Usuario();
			usuarioCrea.setLogin("elver");

			cliente.setUsuarioCrea(usuarioCrea);
			cliente.setFechaCreacion(new Date());
			cliente.setEliminado(Boolean.FALSE);

			clienteDAO.modificar(cliente);

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	

	@Test
	public void testObtenerCliente() {

		try {
			cliente = new Cliente();
			cliente = clienteDAO.obtener("1146437892");

			System.out.println(
					cliente.getNombres() + " " + cliente.getApellidos() + ": " + cliente.getUsuarioCrea().getNombres());

			for (Direccion direccion : cliente.getDirecciones()) {
				System.out.println(direccion.getDireccion());
			}
			assertTrue(cliente != null);

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
}
