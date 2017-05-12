package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.org.glassfish.external.probe.provider.annotations.Probe;

import bl.UsuarioBL;
import exception.MyException;

@Path("usuario")
@Component
public class UsuarioWS {
	@Autowired
	UsuarioBL usuarioBL;
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String autenticar(@QueryParam("login")String login, @QueryParam("pws")String pws) {
		
		String retorno = "";
		
		try {
			usuarioBL.validateLogin(login, pws);
			
		} catch (MyException e) {
			return e.getMessage();
		}
		return retorno;
		
	}

}
