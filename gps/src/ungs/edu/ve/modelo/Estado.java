package ungs.edu.ve.modelo;

import java.io.Serializable;

public class Estado implements Serializable {


	private static final long serialVersionUID = -4820439270286168919L;
	private long id;
	private String codigo;
	private String descripcion;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
