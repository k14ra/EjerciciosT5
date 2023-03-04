package edu.alonso.daw.tema5.nodos;

import java.util.Objects;

public class NodoGenerico<T> {
	
	private T info;
	private NodoGenerico<T> sig;
	
	public NodoGenerico(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public NodoGenerico<T> getSig() {
		return sig;
	}
	public void setSig(NodoGenerico<T> sig) {
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
		NodoGenerico<T> other = (NodoGenerico<T>) obj;
		return Objects.equals(info, other.info) && Objects.equals(sig, other.sig);
	}

	
	
	
	
	
	

}
