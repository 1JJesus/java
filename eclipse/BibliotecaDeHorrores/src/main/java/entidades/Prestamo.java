package entidades;

import java.sql.Date;

public class Prestamo {

	private int idejemplar;
	private long idsocio;
	//private LocalDateTime ldfechaprestamo;
	private Date fechalimitedevolucion;
	
	public Prestamo() {
		
	}

	public Prestamo(int idejemplar, long idsocio, Date fechalimitedevolucion) {
		this.idejemplar = idejemplar;
		this.idsocio = idsocio;
		this.fechalimitedevolucion = fechalimitedevolucion;
	}

	public int getIdejemplar() {
		return idejemplar;
	}

	public void setIdejemplar(int idejemplar) {
		this.idejemplar = idejemplar;
	}

	public long getIdsocio() {
		return idsocio;
	}

	public void setIdsocio(long idsocio) {
		this.idsocio = idsocio;
	}

	public Date getFechalimitedevolucion() {
		return fechalimitedevolucion;
	}

	public void setFechalimitedevolucion(Date fechalimitedevolucion) {
		this.fechalimitedevolucion = fechalimitedevolucion;
	}

	@Override
	public String toString() {
		return "Prestamo [idejemplar=" + idejemplar + ", idsocio=" + idsocio + ", fechalimitedevolucion="
				+ fechalimitedevolucion + "]";
	}
	
	
	
}
