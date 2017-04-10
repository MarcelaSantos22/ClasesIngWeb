package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import DAO.UsuarioDAO;
import DTO.Ciudad;
import DTO.Usuario;
import exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuration.xml")

public class UsuarioDAOImplTest {
	@Autowired // Para injectar el objeto UsuarioDAO, esto tambien lo inicializa
	UsuarioDAO usuarioDAO;

	@Test
	public void testObtener() {
		Usuario usuario = null;

		try {
			usuario = usuarioDAO.obtener("elver");

			System.out.println(usuario.getNombres() + " " + usuario.getRol().getNombre());

			assertTrue(usuario != null);

		} catch (MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
