package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;

import conexiones.Conexion;
import entidades.Autor;

public class DaoAutor {

	public DaoAutor() {
		
	}
	
	public ArrayList<Autor>listadoAutores() throws SQLException,Exception{
		
		ArrayList<Autor> listadoAutores = new ArrayList<>();
		
		Conexion conexion=new Conexion();
		Connection con=null;
		ResultSet rs=null;
		Statement st=null;
		
		try {
			con=conexion.getConexion(); //obtener objeto java.sql.Connection
			st=con.createStatement(); // create objeto statement
			String ordenSQL = "SELECT * FROM AUTOR ORDER BY NOMBRE"; //preparamos las consultas
			rs = st.executeQuery(ordenSQL);
			while (rs.next()) {
				// Por cada fila obtenida, creamos un objeto autor
				// que añadimos al ArrayList listadoAutores.
				Autor miAutor = new Autor();
				miAutor.setIdautor(rs.getInt("IDAUTOR"));
				miAutor.setNombre(rs.getString("NOMBRE"));
				miAutor.setFechadenacimiento(rs.getDate("FECHANACIMIENTO"));
				listadoAutores.add(miAutor);
			}
		}
			catch (SQLException sqle) {
				sqle.printStackTrace();
				throw sqle;
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		finally {
			//liberamos los recursos en un finally para asegurarnos que se cierra
			// todo lo abierto
			if(rs != null)
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
	 * @return Autor	Datos del autor que consultamos
	 * @throws SQLException	Si se produce algun error
	 * @throws Exception
	 */
	public Autor findAutorById(int idautor) throws SQLException, Exception {
		Autor a=null;
		Conexion conexion=new Conexion();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Connection con=null;
		
		try {
			con=conexion.getConexion();
			String ordenSQL= "SELECT IDAUTOR, NOMBRE, FECHANACIMIENTO FROM AUTOR WHERE IDAUTOR=?";
			ps=con.prepareStatement(ordenSQL);
			ps.setInt(1, idautor);
			rs=ps.executeQuery(); // no incluir como parámetro de executeQuery el string ordenSQL
								  //porque ya está creada
			if(rs.next()) {
				a=new Autor();
				a.setIdautor(rs.getInt("IDAUTOR"));
				a.setNombre(rs.getString("NOMBRE"));
				a.setFechadenacimiento(rs.getDate("FECHANACIMIENTO"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//liberamos los recursos en un finally para asegurarnos que se cierra
			// todo lo abierto
			if(rs != null)
				rs.close();
			if (con != null)
				con.close();
		}
		return a;
		
	}
	
	//UPDATE
	public void modificarAutor(Autor a) throws SQLException, Exception {
		Conexion conexion=new Conexion();
		PreparedStatement ps=null;
		
		Connection con=null;
		
		try {
			con=conexion.getConexion();
			con.setAutoCommit(false);
			String ordenSQL = "UPDATE AUTOR SET NOMBRE=?, FECHANACIMIENTO=? WHERE IDAUTOR=?";
			ps = con.prepareStatement(ordenSQL);
			ps.setString(1, a.getNombre());
			ps.setDate(2, a.getFechadenacimiento());
			ps.setInt(3, a.getIdautor());
			int filas = ps.executeUpdate();
			con.commit();
			
			if (filas == 0) {
				System.out.print("No se pudo actualizar nada");
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		}
		finally {
			//liberamos los recursos en un finally para asegurarnos que se cierra
			// todo lo abierto
			if(ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
		
	}
	
	// DAR DE ALTA UN AUTOR
	public void addAutor(Autor a) throws SQLException, Exception {

		Conexion conexion=new Conexion();
		PreparedStatement ps=null;
		
		Connection con=null;
		
		try {
			con=conexion.getConexion();
			String ordenSQL = "INSERT INTO AUTOR VALUES(?,?,?)";
			ps = con.prepareStatement(ordenSQL);
			
			ps.setInt(1, a.getIdautor());
			ps.setString(2, a.getNombre());
			ps.setDate(3, a.getFechadenacimiento());
			
			int filas = ps.executeUpdate();
			
			if (filas == 0) {
				System.out.print("No se pudo actualizar nada");
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			//liberamos los recursos en un finally para asegurarnos que se cierra
			// todo lo abierto
			if(ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
	}	

}
