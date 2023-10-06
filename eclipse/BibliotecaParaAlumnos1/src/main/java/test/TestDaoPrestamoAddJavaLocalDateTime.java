/**
 * 
 */
package test;

import java.sql.SQLException;

import dao.DaoPrestamo;
import entidades.Prestamo;
import entidades.Prestamold;
import excepciones.PrestamoException;

/**
 * @author Ortiz
 *
 */
public class TestDaoPrestamoAddJavaLocalDateTime {

	/**
	 * 
	 */
	public TestDaoPrestamoAddJavaLocalDateTime() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DaoPrestamo dao=new DaoPrestamo();
		Prestamold prestamold=new Prestamold();
		prestamold.setIdejemplar(22);
		prestamold.setIdsocio(5L);
		try {
			dao.nuevoPrestamoJavaLocalDate(prestamold);
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
