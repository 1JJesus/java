package test;


import java.sql.SQLException;
import java.util.List;

import dao.DaoAutor;
import entidades.Autor;

public class TestListadoBiblio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoAutor dao= new DaoAutor();
		try {
			List<Autor>listado=dao.ListadoAutores();
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
