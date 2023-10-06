package test;

import java.sql.SQLException;

import dao.DaoPrestamo;
import entidades.Prestamold;

public class TestFindPrestamoPorIdLocalDateTime {

	public static void main(String[] args) {
		Prestamold prestamold;
		DaoPrestamo daoprestamo=new DaoPrestamo();
		try {
			prestamold=daoprestamo.findPrestamoByIdLocalDatetime(22);
			if(prestamold!=null)
				System.out.println(prestamold.toString());
			else
				System.out.println("El ejemplar indicado no está en prestamo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
