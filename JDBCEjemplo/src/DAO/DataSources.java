package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.MyException;

public class DataSources {
	private static Connection con = null; //Creo un elemento de conexion a base de datos
	
	
	private static Connection getConnection() throws MyException{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ing_web","root","root");	
			}
			catch (ClassNotFoundException e){
				throw new MyException("Driver no encontrado ",e);
			}
			catch (SQLException e) {
				throw new MyException("NO establecio conexion",e);
			}
			return con;
	}
	
	public static Connection getSingletonConnection()  throws MyException{
		if (con == null) {
			con = new DataSources().getConnection();				
		}else{
			System.out.println("Error");
		}
		
		return con;
	}

}
