package test;

import java.sql.SQLException;
import java.util.List;

import dao.DaoAutor;
import entidades.Autor;

public class testfindautor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoAutor dao= new DaoAutor();
		int idautor = 3;
		try {
			Autor a=dao.findAutorById(idautor);
			if (a!=null) {
				System.out.print(a.toString());
			} else {
				System.out.print("Codigo de autor no valido");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
