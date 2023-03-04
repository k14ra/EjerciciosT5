package edu.alonso.daw.tema5.colas;

import edu.alonso.daw.tema5.nodos.Nodo;

//ejercicio cola de cine, pdf tema5_3

public class Cola {
	
	// null <- último <- penúltimo <- ... <- primero
	//			^								^
	//			|								|
	//		encolar							desencolar
	
	
	private Nodo primero;
	private Nodo ultimo;
	
	private int size;
	
	public Cola() {
		this.primero = this.ultimo = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	/**Inserta un elemento al final de la cola
	 * @param info
	 */
	
	public void enqueue(Integer info) {
		Nodo nuevo = new Nodo(info);
		if(isEmpty()) {
			primero = ultimo = nuevo;
		} else {
			ultimo.setSig(nuevo);
			ultimo = nuevo;
		}
		size++;
	}
	
	/**Extrae el primer elemento de la cola
	 * @return info o null en caso de que la cola esté vacía.
	 */
	public Integer dequeue() {
		if(!isEmpty()) {
			// Guardo la información
			Integer info = primero.getInfo();
			
			// Creo un aux para eliminar la referencia
			Nodo aux = primero;
			
			// Muevo el puntero del primero al "segundo"
			primero = primero.getSig();
			
			// Borro el puntero del primero "anterior"
			aux.setSig(null);
			
			size--;
			return info;
		}
		
		return null;
	}

	
	/**Extrae el primer elemento de la cola, sin eliminarlo
	 * @return info o null en caso de que la cola esté vacía.
	 */
	public Integer front() {
		if(!isEmpty()) {
			return primero.getInfo();
		}
		return null;
	}
	
	
	public void print() {
		System.out.println("La cola contiene: ");
		
		if(isEmpty()) {
			System.out.println("Está vacía");
		} else {
			System.out.print("\"último\" ===> ");
			firstElement(primero);
			System.out.print(" <=== \"primero\"\n");
		}
	}

	private void firstElement(Nodo nodo) {
		if(nodo.equals(ultimo)) { // Caso base
			System.out.print(nodo.getInfo());
		} else {
			firstElement(nodo.getSig());
			System.out.print(" <- " + nodo.getInfo());
		}
		
	}
}
