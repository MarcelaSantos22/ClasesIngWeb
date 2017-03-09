package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para almacenar la información del cliente
 * @author Yuri Quejada
 * Servlet implementation class Guardar
 */
//@WebServlet("/Guardar")
public class Guardar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
     public Guardar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out =null;
		out=response.getWriter();


		String nombre;
		String primerApellido;
		String segundoApellido;
		String cedula;
		String genero;
		String email;

		nombre =request.getParameter("nombres");
		primerApellido =request.getParameter("primerApellido");
		segundoApellido =request.getParameter("segundoApellido");
		cedula =request.getParameter("cedula");
		genero =request.getParameter("genero");
		email =request.getParameter("email");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta content=\"charset=UTF-8\" />");
		out.println("	<title>Informacion del usuario</title>");
		out.println("	<style type=\"text/css\">");
		out.println("		body {");
		out.println("			background: #01DFA5;");
		out.println("		}");
		out.println("		h1 {");
		out.println("			text-align: center;");
		out.println("			font: bold small-caps 100% serif;");
		out.println("			font-size: 40px;");
		out.println("		}");
		out.println("		table {");
		out.println("			background-color: #87C489;");
		out.println("			width: 500px;");
		out.println("			height: 200px;");
		out.println("			padding: 10px;");
		out.println("			margin: 40px auto;");
		out.println("			border-radius: 15px;");
		out.println("			font: small-caps 50% fantasy;");
		out.println("		}");
		out.println("		table tr{");
		out.println("			margin: 20px auto;");
		out.println("			text-align: left;");
		out.println("			font-size: 20px;");
		out.println("		}");
		out.println("		table td{");
		out.println("			background-color: #");
		out.println("			font-size: 16px;");
		out.println("		}");
		out.println("	</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>Información del Usuario</h1><br>");
		out.println("	<table>");
		out.println("		<tr>");
		out.println("			<th>Nombres</th>");
		out.println("			<td>"+nombre+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<th>Primer Apellido</th>");
		out.println("			<td>"+primerApellido+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<th>Segundo Apellido</th>");
		out.println("			<td>"+segundoApellido+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<th>Cedula</th>");
		out.println("			<td>"+cedula+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<th>Genero</th>");
		out.println("			<td>"+genero+"</td>");
		out.println("		</tr>");
		out.println("		<tr>");
		out.println("			<th>Email</th>");
		out.println("			<td>"+email+"</td>");
		out.println("		</tr>	");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}
