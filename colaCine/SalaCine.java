package pdf3;

public class SalaCine {
	private Cola cola;
	private final int PRECIO714 = 3;
	private final int PRECIO1517 = 4;
	private final int PRECIO1880 = 5;
	private int precioTotal = 0;

	public SalaCine(Cola cola) {
		this.cola = cola;
	}

	public String calcTotal() {
		int contador = cola.size();
		for (int i = 0; i < contador; i++) {
			if (cola.front().getEdad()< 15) {
				precioTotal += PRECIO714;
				cola.dequeue();
			} else if (cola.front().getEdad() > 14 && cola.front().getEdad() < 18) {
				precioTotal += PRECIO1517;
				cola.dequeue();
			} else if (cola.front().getEdad() <=80) {
				precioTotal += PRECIO1880;
				cola.dequeue();
			}
		}
		return "La sala a producido "+precioTotal+" €";

	}
}
