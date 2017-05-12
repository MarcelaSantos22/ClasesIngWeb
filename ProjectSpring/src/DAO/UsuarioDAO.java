package DAO;

/**
 * Interface con los metodos del DAO para usuario
 * @author Yuri Marcela Quejada - ymarcela.quejada@udea.edu.co
 *
 */


import DTO.Usuario;
import exception.MyException;

public interface UsuarioDAO {

	// Obtener la información de un usuario dado su login
	public Usuario obtener(String login) throws MyException;

}
