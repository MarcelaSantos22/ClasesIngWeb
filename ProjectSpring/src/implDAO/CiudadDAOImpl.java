
package implDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DTO.Ciudad;
import exception.MyException;
import DAO.CiudadDAO;

// Clase para el DAO
public class CiudadDAOImpl implements CiudadDAO {
	private SessionFactory sessionFactory;
	private Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Ciudad> obtener() throws MyException {
		List<Ciudad> lista = new ArrayList<Ciudad>();
		session = null;
		Criteria criteria = null;

		try {
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Ciudad.class);
			lista = criteria.list();

		} catch (HibernateException e) {
			throw new MyException("Error consultando ciudades", e);
		}
		return lista;

	}

	@Override
	public Ciudad obtener(Long id) throws MyException {
		Ciudad ciudad = new Ciudad();
		session = null;

		try {
			session = sessionFactory.getCurrentSession();
			// Consulta para devolver una ciudad dependiendo del codigo
			/*
			 * Criteria criteria = session.createCriteria(Ciudad.class); //Para
			 * crear la consulta a la base de datos
			 * criteria.add(Restrictions.eq("codigo", id)); //Agregando
			 * condicion a la consulta ciudad = (Ciudad)criteria.uniqueResult();
			 * // uniqueResult retorna un objeto de tipo ob, y se utiliza cuando
			 * la consulta solo // arroje un solo valor.
			 */
			// Otra forma de hacer consultas
			ciudad = (Ciudad) session.get(Ciudad.class, id);

		} catch (HibernateException e) {
			throw new MyException("Error consultando ciudades", e);
		}

		return ciudad;
	}

	public void guardar(Ciudad ciudad) throws MyException {
		session = null;

		try {
			session = sessionFactory.getCurrentSession(); // Para conectarse a
															// la bd, va y busca
															// una coneccion que
															// este abierta y se
															// conecta
			/*
			 * tx = session.beginTransaction(); //Se inicia una nueva
			 * transaccion a la bd session.save(ciudad); //Se guarda la ciudad
			 * en la bd tx.commit(); //Para hacer persistente el cambio en la bd
			 */
		} catch (HibernateException e) {
			throw new MyException("Error ingresando la ciudad", e);
		}

	}

	public void modificar(Ciudad ciudad) throws MyException {
		session = null;

		try {
			session = sessionFactory.getCurrentSession();
			// tx = session.beginTransaction(); //Se inicia una nueva
			// transaccion a la bd
			// session.update(ciudad); //Se guarda la ciudad en la bd
			// tx.commit(); //Para hacer persistente el cambio en la bd

		} catch (HibernateException e) {
			throw new MyException("Error modificando la ciudad", e);
		}

	}

	public void eliminar(Ciudad ciudad) throws MyException {
		session = null;

		try {
			session = sessionFactory.getCurrentSession();
			// tx = session.beginTransaction(); //Se inicia una nueva
			// transaccion a la bd
			// session.delete(ciudad);; //Se guarda la ciudad en la bd
			// (saveOrUpdate: Cuando no se sabe si la instancia esta creada o
			// no)
			// tx.commit(); //Para hacer persistente el cambio en la bd

		} catch (HibernateException e) {
			throw new MyException("Error eliminando la ciudad", e);
		}

	}

}
