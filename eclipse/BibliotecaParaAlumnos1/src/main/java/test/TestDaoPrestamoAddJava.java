/**
 * 
 */
package test;

import java.sql.SQLException;

import dao.DaoPrestamo;
import entidades.Prestamo;
import excepciones.PrestamoException;

/**
 * @author Ortiz
 *
 */
public class TestDaoPrestamoAddJava {

	/**
	 * 
	 */
	public TestDaoPrestamoAddJava() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DaoPrestamo dao=new DaoPrestamo();
		Prestamo prestamo=new Prestamo();
		prestamo.setIdejemplar(3);
		prestamo.setIdsocio(6L);
		try {
			dao.nuevoPrestamoJava(prestamo);
			System.out.println("Préstamo realizado correctamente");
			
		} catch (PrestamoException e) {
             System.out.println("Error: "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}

	
	}

}
