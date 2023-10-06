package test;

import java.sql.SQLException;

import dao.DaoEjemplar;
import dao.DaoPrestamo;
import dao.DaoSocio;
import entidades.Ejemplar;
import entidades.Prestamo;
import entidades.Socio;

public class TestConsultarSiEjemplarPrestado {

	public static void main(String[] args) {
		DaoPrestamo daoprestamo=new DaoPrestamo();
		try {
			Prestamo prestamo=DaoPrestamo.findPrestamoById(1);
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
