package ungs.edu.ve.modelo;

import java.io.Serializable;

public class Claustro implements Serializable{

	
	private static final long serialVersionUID = 5395621208737195128L;
	private long id;
	private String nombre;
	private String descripcion;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
}
