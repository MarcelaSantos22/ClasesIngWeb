package impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import DAO.ClienteDAO;
import DAO.DataSource;
import DTO.Cliente;
import exception.MyException;

public class ClienteDAOImpl implements ClienteDAO{

	@Override
	public List<Cliente> obtener() throws MyException {
		// TODO Auto-generated method stub
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = null;
		Criteria criteria = null;
		
		try {
			session = DataSource.getInstance().getSession();
			criteria = session.createCriteria(Cliente.class);
			criteria.addOrder(Order.asc("fechaCreacion"));
			//Consulta = SELECT * Clientes Order By FechaCreacion asc
			
			clientes = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			throw new MyException("Error consultando la lista de clientes", e);
		}
		
		return clientes;
	}

	@Override
	public void guardar(Cliente cliente) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			
			session.save(cliente);
			
			tx.commit();
			
		} catch (MyException e) {
			throw new MyException("Ocurrio unn error guardando el cliente", e);
		}
		
	}

}
