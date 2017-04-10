package DAO;

/**
 * Inteface con los metodos del DAO para cliente
 * @author Yuri Marcela Quejada - ymarcela.quejada@udea.edu.co
 *
 */

import java.util.List;

import DTO.Cliente;
import exception.MyException;

public interface ClienteDAO {

	// Entrega la lista de clientes ordenados por su fecha
	public List<Cliente> obtener() throws MyException;

	// Obtener la información de un cliente, dada su cedula
	public Cliente obtener(String cedula) throws MyException;

	// Insertar un nuevo cliente en la base de datos
	public void guardar(Cliente cliente) throws MyException;

	// Actualizar los datos de un cliente en la base de datos
	public void modificar(Cliente cliente) throws MyException;

}
