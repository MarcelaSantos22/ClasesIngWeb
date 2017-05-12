package services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DTO.Cliente;
import bl.ClienteBL;
import dto.ClienteJersey;
import exception.MyException;

@Path("Cliente")
@Component
public class ClienteWS {

	@Autowired
	ClienteBL clienteBL;

	@POST
	@Produces(MediaType.TEXT_HTML)
	public void guardar(@QueryParam("identificacion") String cedula, @QueryParam("nombres") String nombres,
			@QueryParam("apellidos") String apellidos, @QueryParam("correo") String email,
			@QueryParam("usuarioCrea") String usuarioCrea) throws RemoteException {

		try {
			clienteBL.guardar(cedula, nombres, apellidos, email, usuarioCrea);
		} catch (MyException e) {
			throw new RemoteException("Error creando el cliente");
			// TODO: handle exception
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteJersey> obtener() throws RemoteException {
		List<ClienteJersey> respuesta = new ArrayList<ClienteJersey>();

		try {
			for (Cliente cliente : clienteBL.obtener()) {
				ClienteJersey clienteJersey = new ClienteJersey(cliente.getCedula(), cliente.getNombres(),
						cliente.getApellidos(), cliente.getEmail());

				respuesta.add(clienteJersey);

			}
		} catch (MyException e) {

			throw new RemoteException("promblema consultando");
		}
		return respuesta;

	}

}