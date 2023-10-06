package entidades;

import java.sql.Date;

public class Autor {
	
	private int idautor;
	private String nombre;
	private Date fechadenacimiento;
	
	public Autor() {
	}
	
	public Autor(int idautor, String nombre, Date fechadenacimiento) {
		super();
		this.idautor = idautor;
		this.nombre = nombre;
		this.fechadenacimiento = fechadenacimiento;
	}
	
	public int getIdautor() {
		return idautor;
	}
	
	public void setIdautor(int idautor) {
		this.idautor = idautor;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFechadenacimiento() {
		return fechadenacimiento;
	}
	
	public void setFechadenacimiento(Date fechadenacimiento) {
		this.fechadenacimiento = fechadenacimiento;
	}
	
	@Override
	public String toString() {
		return "Autor [idautor=" + idautor + ", nombre=" + nombre + ", fechadenacimiento=" + fechadenacimiento + "]";
	}
}
