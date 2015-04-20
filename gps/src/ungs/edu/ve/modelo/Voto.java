package ungs.edu.ve.modelo;

import java.io.Serializable;
import java.util.Date;

public class Voto implements Serializable{

	private static final long serialVersionUID = 6941196158305799522L;
	private long id;
	private Lista lista;
	private Date fechaVoto;
	private Terminal terminal;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Lista getLista() {
		return lista;
	}
	public void setLista(Lista lista) {
		this.lista = lista;
	}
	public Date getFechaVoto() {
		return fechaVoto;
	}
	public void setFechaVoto(Date fechaVoto) {
		this.fechaVoto = fechaVoto;
	}
	public Terminal getTerminal() {
		return terminal;
	}
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	
	
	
}
