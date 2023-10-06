package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import conexion.Conexion;
import entidades.Ejemplar;

public class DaoEjemplar {
	

	public Ejemplar findejemplarById (int idejemplar) throws SQLException  {
        Ejemplar a = null;
        Conexion conexion = new Conexion();
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
           // con = conexion.getConexion();
            Conexion miconex = new Conexion();
            con = miconex.getConexion();
            String orderSQL = "select idejemplar,e.isbn,l.idautor,l.titulo\n"
	            + "from ejemplar e,libro l\n"
	            + "where e.isbn=l.isbn\n"
	            + "and idejemplar=?\n"
	            + "and baja='N'";
            st = con.prepareStatment(orderSQL);
            st.setInt(1, idejemplar);
            rs = st.executeQuery()
            if (rs.next()) {
            	ejemplar = new Ejemplar();
            	ejemplar.setIdejemplar(rs.getInt("idejemplar"));
            	Libro libro=new Libro();
            	libro.setIsbn(rs.getString("ISBN"));
            	libro.setTitulo(rs.getString("TITULO"));
            	libro.setIdautor(rs.getInt("IDAUTOR"));
            	//asocio el ejemplar con su libro
            	ejemplar.setLibro(libro);
            	
            }
        }    		
        
        }
}
	
	
	
	
	
	
	
	
	
	
	
	
	

