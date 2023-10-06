package entidades;

import java.time.LocalDateTime;

public class Prestamold {
	
    private int idejemplar; 
    private long idsocio;
    
	private LocalDateTime fechaprestamo; 
    private LocalDateTime fechalimitedevolucion;
    
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
	public LocalDateTime getFechaprestamo() {
		return fechaprestamo;
	}
	public void setFechaprestamo(LocalDateTime fechaprestamo) {
		this.fechaprestamo = fechaprestamo;
	}
	public LocalDateTime getFechalimitedevolucion() {
		return fechalimitedevolucion;
	}
	public void setFechalimitedevolucion(LocalDateTime fechalimitedevolucion) {
		this.fechalimitedevolucion = fechalimitedevolucion;
	}
	@Override
	public String toString() {
		return "Prestamold [idejemplar=" + idejemplar + ", idsocio=" + idsocio + ", fechaprestamo=" + fechaprestamo
				+ ", fechalimitedevolucion=" + fechalimitedevolucion + "]";
	}
    
      

}
