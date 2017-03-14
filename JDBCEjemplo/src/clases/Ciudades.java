package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	/*public class Ciudades {
public static void main(String[] args) {
		consultarCiudades();
		
		 * try { Class.forName("com.mysql.jdbc.Driver");
		 *
		 * Connection con =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/ing_web",
		 * "root", "root"); PreparedStatement ps =
		 * con.prepareStatement("select * from ciudades");
		 *
		 * ResultSet rs = ps.executeQuery();
		 *
     * while (rs.next()) { System.out.println(rs.getString("codigo") + ": "
		 * + rs.getString("Nombre")); } } catch (ClassNotFoundException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }catch
		 * (SQLException e) { e.printStackTrace(); }
		 
		
	}*/ 

	/*public static void consultarCiudades() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

      			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ing_web", "root", "root"); // se crea la coneccóon a la bd.
      			ps = con.prepareStatement("select * from ciudades"); // Se crea una consulta para la base de datos.
      			rs = ps.executeQuery(); // Se ejecuta la consulta.

      			while (rs.next()) {
      				//System.out.println(rs.getString("codigo") + ": " + rs.getString("Nombre"));
      			}
      		} 
		catch (ClassNotFoundException e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		} 
		catch (SQLException e) {
      			e.printStackTrace();
      		} 
		finally { // Finalmente se cierra la coneccin a la base de datos.
      			try { // Se deben cerrar en orden ascendente, desde la ultima
      					// variable que se creo hasta la primera.
      				rs.close();
      				ps.close();
              con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}*/
