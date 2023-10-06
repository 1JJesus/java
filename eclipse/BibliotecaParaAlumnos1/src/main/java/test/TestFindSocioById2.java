package test;

import java.sql.SQLException;

import dao.DaoEjemplar;
import dao.DaoSocio;
import entidades.Ejemplar;
import entidades.Socio;

public class TestFindSocioById2 {

	public static void main(String[] args) {
		DaoSocio daosocio=new DaoSocio();
		try {
			Socio socio=DaoSocio.findSocioById(1);
			if(socio!=null) {
				System.out.println(socio.getIdsocio()
						          +"--"
						          + socio.getEmail()
						          +"--"
						          +socio.getNombre()
						          +"--"
			                      +socio.getDireccion()
			                      
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
