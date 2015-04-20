package ungs.edu.ve.modelo;

import java.io.Serializable;

public class Votante implements Serializable{


	private static final long serialVersionUID = 2713148938496240970L;
	private long id;
	private String tipo;
	private String nroDocumento;
	private String apellido;
	private String nombre;
	private Claustro claustro;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Claustro getClaustro() {
		return claustro;
	}
	public void setClaustro(Claustro claustro) {
		this.claustro = claustro;
	}
	
	
	
	
	
}
