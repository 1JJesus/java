/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexiones.Conexion;
import entidades.Ejemplar;
import entidades.Libro;

/**
 * @author Ortiz
 *
 */
public class DaoEjemplar {

	/**
	 * 
	 */
	public DaoEjemplar() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param idejemplar Código del ejemplar a localizar
	 * @return
	 * @throws SQLException Posible errores de SQL que se produzcan
	 */
	public Ejemplar findEjemplarById(int idejemplar) throws SQLException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		//Ejemplar ejemplar = null;
		Ejemplar ejemplar = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSQL = "select idejemplar,e.baja,e.isbn,l.idautor,l.titulo "
					+ "from ejemplar e,libro l "
					+ "where e.isbn=l.isbn "
					+ "and idejemplar=? "
					+ "and baja='N'";
			st = con.prepareStatement(ordenSQL);
			st.setInt(1, idejemplar);
			rs = st.executeQuery();
			if (rs.next()) {
				ejemplar = new Ejemplar();
				ejemplar.setIdejemplar(rs.getInt("IDEJEMPLAR"));
				ejemplar.setIsbn(rs.getInt("ISBN"));
				ejemplar.setBaja(rs.getString("BAJA"));

				// Creamos el objeto libro y establecemos sus propiedades
				
				Libro libro=new Libro();
				libro.setIsbn(rs.getString("ISBN"));
				libro.setTitulo(rs.getString("TITULO"));
				libro.setIdautor(rs.getInt("IDAUTOR"));
				
				// asocio el ejemplar con su libro
				ejemplar.setLibro(libro);
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
		return ejemplar;
	}

}
