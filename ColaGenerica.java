package edu.alonso.daw.tema5.cola.generica;

import edu.alonso.daw.tema5.nodos.NodoGenerico;

public class ColaGenerica<T> {
	
	// null <- último <- penúltimo <- ... <- primero
	//			^								^
	//			|								|
	//		encolar							desencolar
	
	
	private NodoGenerico<T> primero;
	private NodoGenerico<T> ultimo;
	
	private int size;
	
	public ColaGenerica() {
		this.primero = this.ultimo = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	/**Inserta un elemento al final de la cola
	 * @param info
	 */
	public void enqueue(T info) {
		NodoGenerico<T> nuevo = new NodoGenerico<>(info);
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
	public T dequeue() {
		if(!isEmpty()) {
			// Guardo la información
			T info = primero.getInfo();
			
			// Creo un aux para eliminar la referencia
			NodoGenerico<T> aux = primero;
			
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
	public T front() {
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

	private void firstElement(NodoGenerico<T> nodo) {
		if(nodo.equals(ultimo)) { // Caso base
			System.out.print(nodo.getInfo());
		} else {
			firstElement(nodo.getSig());
			System.out.print(" <- " + nodo.getInfo());
		}
		
	}
}
