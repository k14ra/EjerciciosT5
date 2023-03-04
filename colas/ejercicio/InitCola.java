package edu.alonso.daw.tema5.colas.ejercicio;

public class InitCola {

	
	public static void main(String[] args) {
		Cola cola = new Cola();
		
		cola.enqueue(1);
		cola.enqueue(2);
		cola.enqueue(3);
		cola.enqueue(4);
		cola.enqueue(5);
		
		cola.print();
		
		System.out.println("Extraigo el primer elemento: " + cola.dequeue());
		cola.print();
		
		System.out.println("Extraigo el primer elemento sin eliminarlo (vieja visillo): " + cola.front());
		cola.print();
	}
}
