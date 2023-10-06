package test;

import dao.DaoEjemplar;
import entidades.Ejemplar;

public class Testfindejemplar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DaoEjemplar daoejemplar=new DaoEjemplar();
		try {
			Ejemplar ejemplar=daoejemplar.findejemplarById(18);
			if(ejemplar!=null) {
				System.out.println(ejemplar.getIdejemplar()
						+"--"
						+ejemplar.getLibro().getIsbn()
						+"--"
						+ejemplar.getLibro().getTitulo()

						);
			}
		}
		
		
		
	}

}
