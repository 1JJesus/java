package entidades;

public class Ejemplar {

	 private int idejemplar;
	 private String isbn;

	public Ejemplar() {
		
	}

	public Ejemplar(int idejemplar, String isbn) {
		this.idejemplar = idejemplar;
		this.isbn = isbn;
	}

	public int getIdejemplar() {
		return idejemplar;
	}

	public void setIdejemplar(int idejemplar) {
		this.idejemplar = idejemplar;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Ejemplar [idejemplar=" + idejemplar + ", isbn=" + isbn + "]";
	}

	
	
	
	
}
