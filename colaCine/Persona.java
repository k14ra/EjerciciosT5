package pdf3;

import java.util.Objects;
import java.util.Random;

public class Persona {
	private int edad;

	public Persona() {
		Random r = new Random();
		edad = r.nextInt(74) + 7;
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
