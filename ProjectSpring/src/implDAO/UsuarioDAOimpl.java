package implDAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DAO.UsuarioDAO;
import DTO.Usuario;
import exception.MyException;

public class UsuarioDAOimpl implements UsuarioDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Usuario obtener(String login) throws MyException {

		Session session = null;
		Usuario usuario = new Usuario();

		try {
			session = sessionFactory.getCurrentSession();
			usuario = (Usuario) session.get(Usuario.class, login);

		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error consultando el usuario", e);

		} 
//		finally {
//			if (session != null) {
//				session.close();
//			}
//		}

		return usuario;

	}

}
