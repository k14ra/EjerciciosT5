package edu.alonso.daw.tema5.nodos;

import java.util.Objects;

public class Nodo {
	
	private Integer info;
	private Nodo sig;
	
	public Nodo(Integer info) {
		this.info = info;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(Integer info) {
		this.info = info;
	}
	public Nodo getSig() {
		return sig;
	}
	public void setSig(Nodo sig) {
		this.sig = sig;
	}
	@Override
	public int hashCode() {
		return Objects.hash(info, sig);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodo other = (Nodo) obj;
		return info == other.info && Objects.equals(sig, other.sig);
	}

}
