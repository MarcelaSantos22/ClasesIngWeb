package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.ExceptionMarcela;

public class DataSources {

//Creo un elemento de conexion a base de datos
	
	public static Connection getConnection() throws ExceptionMarcela{
		Connection con = null;

			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ing_web","root","root");
			
			}catch (ClassNotFoundException e){
			
				throw new ExceptionMarcela("Driver no encontrado Hermano. Paila",e);
				// TODO: handle exception
			}catch (SQLException e) {
				throw new ExceptionMarcela("NO establecio conexion con esa vaina",e);// TODO: handle exception
			}
			return con;
	}
}
