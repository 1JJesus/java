package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import conexiones.Conexion;
import entidades.Autor;

public class DaoAutor {
	public DaoAutor() {

	}

	public ArrayList<Autor> listadoAutores() throws SQLException, Exception {

		ArrayList<Autor> listadoAutores = new ArrayList<>();
		Conexion conexion = new Conexion();
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		try {
			con = conexion.getConexion(); // obtener objeto java.sql.Connection
			st = con.createStatement(); // create objeto statement
			String ordenSQL = "SELECT * FROM AUTOR ORDER By NOMBRE"; // preparamos la consulta a la bbdd
			rs = st.executeQuery(ordenSQL);
			while (rs.next()) {
				// Por cada fila obtenida, creamos un objeto autor
				// que añadimos al ArrayList listadoAutores.
				Autor miAutor = new Autor();
				miAutor.setIdautor(rs.getInt("IDAUTOR"));
				miAutor.setNombre(rs.getString("NOMBRE"));
				miAutor.setFechanacimiento(rs.getDate("FECHANACIMIENTO"));
				listadoAutores.add(miAutor);
			}
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			// liberamos los recursos en un finally para asegurarnos que se cierra
			// todo lo abierto
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		}
		return listadoAutores;
	}

	/**
	 * 
	 * @param idautor
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Autor findAutorById(int idautor) throws SQLException, Exception {
		Autor a = null;
		Conexion conexion = new Conexion();
		PreparedStatement ps = null;
		ResultSet rs = null;

		Connection con = null;

		try {
			con = conexion.getConexion();
			String ordenSQL = "SELECT IDAUTOR,NOMBRE,FECHANACIMIENTO FROM AUTOR" + 
			                  " WHERE IDAUTOR=?";
			ps = con.prepareStatement(ordenSQL);
			ps.setInt(1, idautor);
			rs = ps.executeQuery();// no incluir como parametro de executeQuery el string ordenSQL
			if (rs.next()) { // lo hemos hecho aqui con.prepareStatement(ordenSQL);
				a = new Autor();
				a.setIdautor(rs.getInt("IDAUTOR"));
				a.setNombre(rs.getString("NOMBRE"));
				a.setFechanacimiento(rs.getDate("FECHANACIMIENTO"));
				a.setLdfechanacimiento(rs.getObject("FECHANACIMIENTO",LocalDate.class));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// liberamos los recursos en un finally para asegurarnos que se cierra
			// todo lo abierto
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		return a;

	}
	
	   public void insertaAutor(Autor a) throws SQLException, Exception {
	        Connection con=null;
	        PreparedStatement st=null;
	        try {
	            Conexion miconex = new Conexion();
	            con = miconex.getConexion();
	            con.setAutoCommit(false);
	            String ordenSQL = "INSERT INTO AUTOR VALUES(S_AUTOR.NEXTVAL,?,?)";
	            st = con.prepareStatement(ordenSQL);
	            st.setString(1, a.getNombre());
	            st.setDate(2,a.getFechanacimiento());
	            st.executeUpdate();
	            con.commit();
	            st.close();
	            con.close();
	        } catch (SQLException se) {
	        	se.printStackTrace();
	            throw se;
	        } catch (Exception e) {
	        	e.printStackTrace();
	            throw e;
	        }
	        finally{
	         	if(st!=null)
	                st.close();
	         	if(con!=null)
	                con.close();
	        }
	    }
	   
		public int modificarAutor(Autor a) throws SQLException, Exception{
	        Connection con=null;
	        PreparedStatement pst=null;
	        int autormodificado;

	        try {
	            Conexion miconex = new Conexion();
	            con = miconex.getConexion();
	            con.setAutoCommit(false);
	            String ordenSQL = "UPDATE AUTOR SET NOMBRE=?,FECHANACIMIENTO=?"+
	            				  " WHERE IDAUTOR=?";
	            pst = con.prepareStatement(ordenSQL);
	            pst.setString(1, a.getNombre());
	            pst.setDate(2, a.getFechanacimiento());
	            pst.setInt(3,a.getIdautor());
	            autormodificado=pst.executeUpdate();  // no se pasa la orden como parámetro porque ya
	            con.commit();

	        } catch (SQLException se) {
	        	se.printStackTrace();
	            throw se;
	        } catch (Exception e) {
	        	e.printStackTrace();
	            throw e;
	        }
	        finally{
	         	if(pst!=null)
	         		
	                pst.close();
	         	if(con!=null)
	                con.close();
	        }	
			return autormodificado;

		}

}
