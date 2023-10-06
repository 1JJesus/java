package test;

import java.sql.SQLException;
import java.time.LocalDate;

import dao.DaoAutor;
import entidades.Autor;

public class añadir_años {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoAutor dao= new DaoAutor();
		
		int idautor=7;
		Autor a = null;
		try {
			a = dao.findAutorById(idautor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LocalDate fechaactual=a.getFechanacimiento();
		
		fechaactual=fechaactual.plusYears(55);
		
		a.setDTfechanacimiento(java.sql.Date.valueOf(fechaactual));
		dao.update(a);
		
		
	}

}
