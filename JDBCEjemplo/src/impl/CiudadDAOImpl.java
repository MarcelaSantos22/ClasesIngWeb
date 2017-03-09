package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Ciudad;
import exception.ExceptionMarcela;
import DAO.CiudadDAO;
import DAO.DataSources;

// Clase para el DAO
public class CiudadDAOImpl implements CiudadDAO{

	@Override
	public List<Ciudad> obtener() throws ExceptionMarcela {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		List<Ciudad> lista = new ArrayList<Ciudad>();
		
		try{
			con = DataSources.getConnection();
			ps =con.prepareStatement("Select * From Ciudades");
			rs = ps.executeQuery();
			while (rs.next()){
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				lista.add(ciudad);
			 }
			}catch (SQLException e) {
				throw new ExceptionMarcela("Error Consultante",e);
			}finally {
				try{
					if(rs!=null){
						rs.close();
					}
					if(ps!=null){
						ps.close();
					}
					if(con!=null){
						con.close();
					}
			}catch (SQLException e) {
				throw new ExceptionMarcela("Error cerrando",e);
			}
		}
		return lista;
	}
}