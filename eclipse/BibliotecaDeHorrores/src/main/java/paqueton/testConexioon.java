package paqueton;

import java.sql.Connection;
import java.sql.SQLException;

import conexion.Conexion;

public class testConexioon {

	public static void main(String[] args) {
		Conexion Conexion = new Conexion();
		
		try {
			Connection con = Conexion.getConexion();
			if (con!=null) {
				System.out.print("Conexion establecida");
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
