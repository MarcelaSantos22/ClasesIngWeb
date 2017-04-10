package DAO;

import java.util.List;

import DTO.Usuario;
import exception.MyException;

public interface UsuarioDAO {

	public Usuario obtener(String login) throws MyException;

}
