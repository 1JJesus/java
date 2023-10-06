package test;

import java.sql.SQLException;

import dao.DaoEjemplar;
import entidades.Ejemplar;

public class TestFindEjemplarById {

	public static void main(String[] args) {
		DaoEjemplar daoejemplar=new DaoEjemplar();
		try {
			Ejemplar ejemplar=daoejemplar.findEjemplarById(1998);
			if(ejemplar!=null) {
				System.out.println(ejemplar.getIdejemplar()
						          +"--"
						          + ejemplar.getBaja()
						          +"--"
						          +ejemplar.getLibro().getIsbn()
						          +"--"
			                      +ejemplar.getLibro().getTitulo()
			                      
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
