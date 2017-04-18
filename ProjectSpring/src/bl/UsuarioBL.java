package bl;

import DAO.UsuarioDAO;
import DTO.Usuario;
import exception.MyException;

public class UsuarioBL {

	private UsuarioDAO usuarioDAO;

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	//Validar que el usuario ingresado exista, y que la contraseña este correcta
	public boolean validateLogin(String login, String pws) throws MyException {
		Usuario usuario = usuarioDAO.obtener(login);

		if (usuario == null) {
			throw new MyException("El usuario no existe en el sistema");
		} else if (usuario.getContrasena().equals(pws)) {
			return true;
		} else {
			return false;
		}
	}
}
