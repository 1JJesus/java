/**
 *    Correspondencia con la tabla PRESTAMO
 */
package entidades;

import java.sql.Date;
import java.sql.Timestamp;

import java.time.LocalDateTime;

/**
 * @author Ortiz
 *
 */
public class Prestamo {
    private int idejemplar; //propiedades o atributos
    private long idsocio;

	private Date fechaprestamo; 
    private Date fechalimitedevolucion;
	
    /*private Timestamp fechaprestamo; 
    private Timestamp fechalimitedevolucion;*/
   
	public Prestamo() {
		// TODO Auto-generated constructor stub
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





	public Date getFechaprestamo() {
		return fechaprestamo;
	}





	public void setFechaprestamo(Date fechaprestamo) {
		this.fechaprestamo = fechaprestamo;
	}





	public Date getFechalimitedevolucion() {
		return fechalimitedevolucion;
	}





	public void setFechalimitedevolucion(Date fechalimitedevolucion) {
		this.fechalimitedevolucion = fechalimitedevolucion;
	}





	@Override
	public String toString() {
		return "Prestamo [idejemplar=" + idejemplar + ", idsocio=" + idsocio + ", fechaprestamo=" + fechaprestamo
				+ ", fechalimitedevolucion=" + fechalimitedevolucion + "]";
	}






}
