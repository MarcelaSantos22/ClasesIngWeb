package DAO;

import java.util.List;

import DTO.Cliente;
import exception.MyException;

public interface ClienteDAO {
	/* Entrega la lista de clientes ordenados por su fecha
	 * 
	 */
	
	public List<Cliente> obtener() throws MyException;
	
	public void guardar(Cliente cliente) throws MyException;

}
