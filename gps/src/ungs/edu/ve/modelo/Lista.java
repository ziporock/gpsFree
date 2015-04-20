package ungs.edu.ve.modelo;

import java.io.Serializable;

public class Lista implements Serializable {

	
	private static final long serialVersionUID = 7046700483788788960L;
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
