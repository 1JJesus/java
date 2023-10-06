/**
 *   Paquete con todos los métodos relacionados con la gestión
 *   de préstamos. Opera fundamentalmente con la tabla PRESTAMO.
 *   Inicialmente lo vamos a usar para aprender a invocar a un
 *   procedimiento almacenado.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.Calendar;

import conexiones.Conexion;
import entidades.Ejemplar;
import entidades.Libro;
import entidades.Prestamo;
import entidades.Prestamold;
import entidades.Socio;
import excepciones.PrestamoException;

/**
 * @author Ortiz
 *
 */
public class DaoPrestamo {

	/**
	 * 
	 */
	public DaoPrestamo() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * 
	 * @param p Objeto préstamo con los datos del préstamo a dar de alta La fecha de
	 *          devolución del préstamo se calcula así: Tres días después de la
	 *          fecha de préstamo Si dicha fecha cae en sábado o domingo se pasa al
	 *          lunes de la semana siguiente.
	 * @throws PrestamoException : Excepciones que se generan según nuestras reglas
	 *                           de negocio 1. Código de ejemplar no válido 2.
	 *                           Código de socio no válido 3. Prestamo duplicado. 4.
	 *                           Socio con libros pendientes de devolución 5. Socio
	 *                           penalizado 6. Intento de pedir prestado dos
	 *                           ejemplares del mismo libro.
	 * @throws SQLException
	 * @throws Exception
	 */
	
	
	
	
	public void nuevoPrestamoJava(Prestamo p) throws PrestamoException,SQLException {
		String ordenSQL = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		DaoEjemplar daoejemplar = new DaoEjemplar();
		DaoSocio daosocio = new DaoSocio();
		Socio socio = null;
		int librosnodevueltos = 0;
		String fechapenalizacion;
		String isbn;
		Ejemplar ejemplar =null;
		DaoPrestamo daoprestamo=null;
		Prestamo prestamo=null;
		

		try {
			
			// 1. Comprobar que el código del ejemplar es válido.

			ejemplar = daoejemplar.findEjemplarById(p.getIdejemplar());
			if (ejemplar == null)
				throw new PrestamoException("Ejemplar no existente o dado de baja");

			
			
			// 2. Comprobar que el código de socio es válido
	        socio = DaoSocio.findSocioById(p.getIdsocio());
	        if (socio == null)
	            throw new PrestamoException("Código de socio no válido");
	        
	      //3. Comprobar si el ejemplar está prestado.
	        prestamo=DaoPrestamo.findPrestamoById(p.getIdejemplar());
	        if(prestamo!=null) 
	        	throw new PrestamoException("Libro en prestamo");
	        
	        Conexion miconex = new Conexion();
	        con = miconex.getConexion();
	        
	     // 4. Comprobar que el socio no tiene libros sin devolver
	        ordenSQL = "SELECT COUNT(*)PRESTAMOSNODEVUELTOS FROM PRESTAMO "
	        		+ "WHERE IDSOCIO=? "
	        		+ "AND TRUNC(FECHALIMITEDEVOLUCION)<TRUNC(SYSDATE)";
	        pst = con.prepareStatement(ordenSQL);
	        pst.setLong(1, p.getIdsocio());
	        rs = pst.executeQuery();
	        if (rs.next()) {
	        	librosnodevueltos = rs.getInt("PRESTAMOSNODEVUELTOS");
	        }
	        if (librosnodevueltos != 0)
	        	throw new PrestamoException("El socio: " + socio.getNombre() + " tiene " + librosnodevueltos + " libros sin devolver");
	        
	        rs.close();
	        pst.close();
	        
	     // 5. Socio penalizado cuya fecha de penalización no ha sido superada.
	        
	        ordenSQL = "SELECT TO_CHAR(LIMITEPENALIZACION, 'dd-mm-yyyy') FECHALIMITEPENALIZACION "
	                + "FROM SOCIOPENALIZADO "
	                + "WHERE IDSOCIO=? "
	                + "AND LIMITEPENALIZACION>SYSDATE";
	        
		    pst = con.prepareStatement(ordenSQL);
		    pst.setLong(1, p.getIdsocio());
		    rs = pst.executeQuery();
		    if (rs.next()) {
		        fechapenalizacion = rs.getString("FECHALIMITEPENALIZACION");
		        throw new PrestamoException(
		            "El socio: " + socio.getNombre() + " " + "está penalizado hasta *****Falta metodo buscar fechapenalizacion****");}
		    
		        rs.close();
		        pst.close();
	        
	        //6. Comprobar que el socio no está realizando un préstamo de un libro
		        // del que ya tiene un ejemplar en préstamo.
		        
		   ordenSQL = "SELECT COUNT(E.IDEJEMPLAR)NUMEJEMPLARES "
		   		+ "FROM PRESTAMO P, EJEMPLAR E "
		   		+ "WHERE P.IDEJEMPLAR=E.IDEJEMPLAR "
		   		+ "AND P.IDSOCIO=? "
		   		+ "AND e.ISBN==?";
		   	pst=con.prepareStatement(ordenSQL);
	        pst.setLong(1, p.getIdsocio());
	        pst.setInt(2, p.getIdejemplar());
	        rs=pst.executeQuery();
	        rs.next();
	        if (rs.getInt("NUMEJEMPLARES") != 0)
	        	throw new PrestamoException("El socio: " + socio.getNombre() + " ya dispone del libro " + ejemplar.getIsbn() + " en préstamo");
	        System.out.print("*********"+ejemplar.getIsbn());
	        System.out.print("*********"+rs.getInt("NUMEJEMPLARES"));
	        rs.close();
	        pst.close();
        		
        		
        		
        		
        		
        		
        		
	        
	        //Insertar prestamo
	        ordenSQL = "INSERT INTO PRESTAMO (idejemplar, idsocio, fechaprestamo, "
	        			+ "fechalimitedevolucion) VALUES (?, ?, ?, ?)";
	        pst = con.prepareStatement(ordenSQL);
	        
	        
	        // Obtenemos la fecha actual
	        LocalDate fechaActual = LocalDate.now();

	        // Calculamos la fecha de límite de devolución (5 días después de la fecha actual)
	        LocalDate fechaDevolucion = fechaActual.plusDays(5);
	        
	        
	        
			/*
				if(prestamo!=null) {
					System.out.println(prestamo.getIdejemplar()
							          +"--"
							          + prestamo.getIdsocio()
							          +"--"
							          +prestamo.getFechaprestamo()
							          +"--"
				                      +prestamo.getFechalimitedevolucion()
				                      
				                      );
				} else {
					System.out.println("Código de socio no válido");
				*/
	        
	        
	        
	        
	        
	        if (fechaDevolucion.getDayOfWeek().getValue()==6) {
	        	fechaActual.plusDays(2);
	        }
	        if(fechaDevolucion.getDayOfWeek().getValue()==7) {
	        	fechaActual.plusDays(1);
	        }
	       /* Timestamp fechaActualSQL = Timestamp.valueOf(fechaActual);
	        Timestamp fechaDevolucionSQL = Timestamp.valueOf(fechaDevolucion);*/
	        
	        
	        pst.setInt(1, p.getIdejemplar());
	        pst.setLong(2, p.getIdsocio());
	        pst.setDate(3, java.sql.Date.valueOf(fechaActual));
	        pst.setDate(4, Date.valueOf(fechaDevolucion));
	        
	        int filas = pst.executeUpdate();
	        
	        if (filas == 0) {
	            System.out.println("No se pudo insertar el préstamo");
	        }
			
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} finally {
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		}
	}

/**
 * Método duplicado para operar con la versión dos de la clase Prestamo
 * En este caso trabajaremos con la clase Prestamold que incluye las
 * fechas con el tipo de dato java.time.LocalDateTime
 * @param p
 * @throws PrestamoException
 * @throws SQLException
 */
	public void nuevoPrestamoJavaLocalDate(Prestamold p) throws PrestamoException,SQLException {
		String ordenSQL;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		DaoEjemplar daoejemplar = new DaoEjemplar();
		DaoSocio daosocio = new DaoSocio();
		Socio socio = null;
		int librosnodevueltos = 0;
		String fechapenalizacion;
		String isbn;
		Ejemplar ejemplar =null;
		
		try {
			
			// 1. Comprobar que el código del ejemplar es válido.
			ejemplar = daoejemplar.findEjemplarById(p.getIdejemplar());
			if (ejemplar == null)
				throw new PrestamoException("Ejemplar no existente o dado de baja");

			//2. Comprobar que el codigo de socio es valido
			
			
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} finally {
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		}
	}
	
	/**
	 * 
	 * @param idejemplar Código del ejemplar del prestamo a localizar
	 * @return Un objeto préstamo con los datos del préstamo correspondientes al
	 *         ejemplar idejemplar
	 * @throws SQLException Errores que se den en el proceso
	 * @throws Exception
	 */
	public Prestamo findPrestamoByIdLocalDatetime(int idejemplar) throws SQLException{
		
		return null;
	}
	
	
	/**  
	 * Método buscar prestamo por idejemplar reescrito para una correspondencia
	 *   con objetos LocalDateTime para las columnas FECHAPRESTAMO 
	 *   Y FECHALIMITEDEVOLUCION.
	 * 
	 * 
	 */
	public static Prestamo findPrestamoById(int idprestamo) throws SQLException{
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		//Ejemplar ejemplar = null;
		Prestamo prestamo = null;
		try {
			Conexion miconex = new Conexion();
			con = miconex.getConexion();
			String ordenSQL = "select idejemplar, idsocio, fechaprestamo, fechalimitedevolucion "
					+ "from prestamo "
					+ "where idejemplar=?";
			st = con.prepareStatement(ordenSQL);
			st.setInt(1, idprestamo);
			rs = st.executeQuery();
			if (rs.next()) {
				prestamo = new Prestamo();
				prestamo.setIdejemplar(rs.getInt("idejemplar"));//(rs.getInt("IDEJEMPLAR"));
				prestamo.setIdsocio(rs.getInt("idsocio"));
				prestamo.setFechaprestamo(rs.getDate("fechaprestamo"));
				prestamo.setFechalimitedevolucion(rs.getDate("fechalimitedevolucion"));

				
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
			return prestamo;
	}
}
