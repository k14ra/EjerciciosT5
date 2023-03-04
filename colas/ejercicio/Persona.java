package edu.alonso.daw.tema5.colas.ejercicio;

import java.util.Objects;

public class Persona implements Comparable<Persona>{

	private int edad;
	
	public Persona(int edad) {
		this.edad = edad;
	}

	@Override
	public int compareTo(Persona o) {
		return this.edad > o.edad ? 1: this.edad < o.edad ? 1: 0;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return edad == other.edad;
	}

	@Override
	public String toString() {
		return "Persona [edad=" + edad + "]";
	}

	

	
}
