package test;

import java.sql.SQLException;

import dao.DaoAutor;
import entidades.Autor;

public class TestAutorPorId {

	public static void main(String[] args) {
		DaoAutor dao = new DaoAutor();
		int idautor=122;
		try {
			Autor a=dao.findAutorById(idautor);
			if(a!=null)
				System.out.println(a.toString());
			    // desde el controlador
			    // guardar el objeto a
			    // redirigir a la capa de presentacion
			else
				System.out.println("Codigo de autor no válido..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
