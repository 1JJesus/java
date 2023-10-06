package test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.DaoAutor;
import entidades.Autor;

public class TestDaoNuevoAutor {

	public static void main(String[] args) {
		
		DaoAutor dao=new DaoAutor();
		
		Autor autor=new Autor();
		autor.setNombre("Autor nuevo");
		
		// Para obtener un objeto LocalDate
		String strfechaNacimiento="2023-09-21"; // fecha compatible con formato de abajo
		DateTimeFormatter formatoDeFecha=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// obtener objeto LocalDate a partir de la fecha en formato String
		LocalDate localdate=LocalDate.parse(strfechaNacimiento,formatoDeFecha);
		
		// Tengo que obter un objeto java.sql.Date para mi objeto Autor
		// que es como lo tengo definido en la clase
		
		Date sqlDatefechaNacimiento=java.sql.Date.valueOf(localdate);
		autor.setFechanacimiento(sqlDatefechaNacimiento);	
		
		try {
			dao.insertaAutor(autor);
			System.out.println("Autor dado de alta correctamente....");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
