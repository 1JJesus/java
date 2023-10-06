package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import conexiones.Conexion;
import entidades.Ejemplar;
import entidades.Libro;
import entidades.Socio;
import excepciones.BloqueoOptimistaException;

public class DaoSocio {

	public static Socio findSocioById(long l) throws SQLException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		//Ejemplar ejemplar = null;
		Socio socio = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSQL = "select IDSOCIO,EMAIL,NOMBRE,DIRECCION "
					+ "from socio "
					+ "where idsocio=?";
                    
			st = con.prepareStatement(ordenSQL);
			st.setLong(1, l);
			rs = st.executeQuery();
			if (rs.next()) {
				socio = new Socio();
				socio.setIdsocio(rs.getInt("IDSOCIO"));
				socio.setEmail(rs.getString("EMAIL"));
				socio.setNombre(rs.getString("Nombre"));
				socio.setDireccion(rs.getString("Direccion"));
				
			}
		} catch (SQLException se) {
			throw se;
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();

		}
		return socio;
	}

}
