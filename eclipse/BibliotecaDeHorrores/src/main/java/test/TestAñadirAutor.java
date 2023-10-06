package test;

import java.sql.SQLException;

import dao.DaoAutor;
import entidades.Autor;

public class TestAñadirAutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Autor nuevoAutor = new Autor();
		nuevoAutor.setIdautor(7);
	    nuevoAutor.setNombre("Prueba");

	    // Crear un objeto java.sql.Date con la fecha de nacimiento deseada (por ejemplo, '2000-01-15')
	    java.sql.Date fechaNacimiento = java.sql.Date.valueOf("2023-09-25");
	    nuevoAutor.setFechanacimiento(fechaNacimiento);

	    try {
	        // Llamar al método agregarAutor para agregar el nuevo autor a la base de datos
	        DaoAutor.agregarAutor(nuevoAutor);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
