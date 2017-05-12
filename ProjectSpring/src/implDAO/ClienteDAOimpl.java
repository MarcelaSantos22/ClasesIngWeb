package implDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import DAO.ClienteDAO;
import DTO.Cliente;
import exception.MyException;

public class ClienteDAOimpl implements ClienteDAO {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Cliente> obtener() throws MyException {
		session = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		Criteria criteria = null;

		try {
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Cliente.class);
			criteria.addOrder(Order.asc("fechaCreacion"));

			clientes = criteria.list();
		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error consultando los clientes", e);
		}

		return clientes;
	}

	@Override
	public Cliente obtener(String cedula) throws MyException {
		Cliente cliente = new Cliente();
		session = null;
		try {
			session = sessionFactory.getCurrentSession();
			cliente = (Cliente) session.get(Cliente.class, cedula);

		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error consultando los clientes", e);
		}

		return cliente;

	}

	@Override
	public void guardar(Cliente cliente) throws MyException {
		session = null;

		try {
			session = sessionFactory.getCurrentSession();
			// transaction = session.beginTransaction();
			// session.save(cliente);
			// transaction.commit();

		} catch (HibernateException e) {

			throw new MyException("Ocurrio un error guardando el cliente", e);
		}
	}

	@Override
	public void modificar(Cliente cliente) throws MyException {
		session = null;
		transaction = null;

		try {
			session = sessionFactory.getCurrentSession();
			// transaction = session.beginTransaction();
			// session.update(cliente);
			// transaction.commit();

		} catch (HibernateException e) {
			throw new MyException("Ocurrio un error actualizando el cliente", e);
		}

	}

}
