package bl;

import org.springframework.transaction.annotation.Transactional;

import DAO.UsuarioDAO;
import DTO.Usuario;
import exception.MyException;

@Transactional
public class UsuarioBL {

	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	//Validar que el usuario ingresado exista, y que la contrase�a este correcta
	public void validateLogin(String login, String pws) throws MyException {
		if ((login == null) || ("".equals(login))) {
			throw new MyException("Usuario o Contrase�a Incorrecto");
		}
		if ((pws == null) || ("".equals(pws))) {
			throw new MyException("Usuario o Contrase�a Incorrecto");
		}
		
		
		Usuario usuario = usuarioDAO.obtener(login);

		if (usuario == null) {
			throw new MyException("Usuario o Contrase�a Incorrecto");
		} else if (!usuario.getContrasena().equals(pws)) {
			throw new MyException("Usuario o Contrase�a Incorrecto");
		}
	}
}
