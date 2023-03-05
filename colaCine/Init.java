package pdf3;

import java.util.Random;

public class Init {
	public static void main(String[] args) {
		Random numPersonas = new Random();
		Cola colaCine = new Cola();
		for (int i = 0; i <= numPersonas.nextInt(101); i++) {
			Persona persona = new Persona(); // 73 y luego le sumas 7 para dar 80 y da del 7 al 80
			colaCine.enqueue(persona);
		}
		colaCine.print();
		SalaCine sala01 = new SalaCine(colaCine);
		System.out.println(sala01.calcTotal());

	}
}
