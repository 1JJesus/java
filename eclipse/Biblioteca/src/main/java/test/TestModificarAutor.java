package test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.DaoAutor;
import entidades.Autor;

public class TestModificarAutor {

	public static void main(String[] args) {
		DaoAutor dao=new DaoAutor();
		
		int idautoramodificar=7;
		
		Autor autor;
		try {
			autor = dao.findAutorById(idautoramodificar);
	        LocalDate fechaactual=autor.getLdfechanacimiento();
	        LocalDate fecha4aniosmas=fechaactual.plusYears(4);
			autor.setFechanacimiento(java.sql.Date.valueOf(fecha4aniosmas));
			dao.modificarAutor(autor);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
