package test;

import java.sql.SQLException;
import java.util.List;

import dao.DaoAutor;
import entidades.Autor;

public class TestListadoAutores {

	public static void main(String[] args) {
		DaoAutor dao = new DaoAutor();
		try {
			List<Autor> listado = dao.listadoAutores();
			for(Autor a:listado)
				System.out.println(a.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
