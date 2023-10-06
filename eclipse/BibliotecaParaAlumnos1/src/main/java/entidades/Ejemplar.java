/**
 * 
 */
package entidades;

import java.sql.Date;

/**
 * @author Ortiz
 *
 */
public class Ejemplar {
	private int idejemplar;
	private Libro libro;
	private String baja;
	private int isbn;
	public Ejemplar() {

	}
	

	public Ejemplar(int idejemplar, Libro libro, String baja, int isbn) {
		super();
		this.idejemplar = idejemplar;
		this.libro = libro;
		this.baja = baja;
		this.isbn = isbn;
	}


	
	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public int getIdejemplar() {
		return idejemplar;
	}

	public void setIdejemplar(int idejemplar) {
		this.idejemplar = idejemplar;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public String getBaja() {
		return baja;
	}

	public void setBaja(String baja) {
		this.baja = baja;
	}

	





}

