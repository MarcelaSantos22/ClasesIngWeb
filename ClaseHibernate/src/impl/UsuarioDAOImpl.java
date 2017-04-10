package impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import DAO.DataSource;
import DAO.UsuarioDAO;
import DTO.Usuario;
import exception.MyException;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	public Usuario obtener(String login) throws MyException
	{
		Usuario usuario= new Usuario();
		Session session = null;
		try{
			session = DataSource.getInstance().getSession();
	
			usuario = (Usuario) session.get(Usuario.class,login);
		}
		catch(HibernateException e)
		{
			throw new MyException("Error consultando los usuarios", e);
		}
		return usuario;
	}

}