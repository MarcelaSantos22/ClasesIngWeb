package bl;

import java.util.Date;
import java.util.List;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.transaction.annotation.Transactional;

import DAO.ClienteDAO;
import DAO.UsuarioDAO;
import DTO.Cliente;
import DTO.Usuario;
import exception.MyException;

@Transactional
public class ClienteBL {
	// Creamos las instancias
	private ClienteDAO clienteDAO;
	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	// Obtener una lista con todos los clientes
	public List<Cliente> obtener() throws MyException {
		return clienteDAO.obtener();
	}

	// Crear un nuevo cliente y guardarlo
	public void guardar(String cedula, String nombres, String apellidos, String email, String usuarioCrea)
			throws MyException {
		EmailValidator emailvalidator = EmailValidator.getInstance();

		// Validar que los campos ingresados no esten vacios
		if ((cedula == null) || ("".equals(cedula))) {
			throw new MyException("La cedula no puede ser vacia");
		}
		if ((nombres == null) || ("".equals(nombres))) {
			throw new MyException("Los nombres no pueden ser vacios");
		}
		if ((apellidos == null) || ("".equals(apellidos))) {
			throw new MyException("Los nombres no pueden ser vacios");
		}
		if ((email == null) || ("".equals(email))) {
			throw new MyException("El email no puede ser vacio");
		}
		// validar que el correo electronico sea valido
		else if (!emailvalidator.isValid(email)) {
			throw new MyException("Ingrese un email valido");
		}
		if ((usuarioCrea == null) || ("".equals(usuarioCrea))) {
			throw new MyException("El usuario no puede ser vacio");
		}

		// Validar que el usuarioCrea exista
		Usuario usuario = usuarioDAO.obtener(usuarioCrea);
		if (usuario == null) {
			throw new MyException("El usuario no existe en el sistema");
		}

		// Seteamos los elementos para guardar el nuevo cliente
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean.FALSE);

		clienteDAO.guardar(cliente);
	}

}
