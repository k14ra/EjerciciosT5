package edu.alonso.daw.tema5.lista;

import edu.alonso.daw.tema5.Lista;
import edu.alonso.daw.tema5.nodos.Nodo;

public class ListaEnlazadaSimple implements Lista {

	private Nodo primero;
	private int numElementos;

	public ListaEnlazadaSimple() {
		this.primero = null;
		this.numElementos = 0;
	}

	@Override
	public boolean isEmpty() {
//		return primero == null;
		return numElementos == 0;
	}

	@Override
	public Integer getFirst() {
		if (!isEmpty()) {
			return this.primero.getInfo();
		}
		return null;
	}

	@Override
	public Integer getLast() {
		if (!isEmpty()) {
			Nodo aux = this.primero;
			while (aux.getSig() != null) {
				aux = aux.getSig();
			}
			return aux.getInfo();
		}
		return null;
	}

	@Override
	public void insertAtBegin(Integer info) {
		Nodo nuevo = new Nodo(info);
		if (!isEmpty()) {
			nuevo.setSig(this.primero);
		}
		this.primero = nuevo;
		this.numElementos++;
	}

	@Override
	public void insertAtEnd(Integer info) {
		Nodo nuevo = new Nodo(info);

		if (isEmpty()) {
			// Lista vacía
			this.primero = nuevo;
		} else {
			Nodo aux = this.primero;
			while (aux.getSig() != null) {
				aux = aux.getSig();
			}
			aux.setSig(nuevo);
		}
		this.numElementos++;
	}

	@Override
	public void insertAtPosition(Integer info, int index) {
		if (index <= this.numElementos && index >= 0) {
			if (isEmpty()) {
				insertAtBegin(info);
			} else {
				if (index == 0) {
					// Inserto al principio
					insertAtBegin(info);
				} else if (index == this.numElementos) {
					insertAtEnd(info);
				} else {
					// Inserto en algun punto "intermedio"
					Nodo nuevo = new Nodo(info);
					Nodo aux = this.primero;
					for (int i = 1; i < index; i++) {
						aux = aux.getSig();
					}
					nuevo.setSig(aux.getSig());
					aux.setSig(nuevo);
					this.numElementos++;
				}
			}
		}

	}

	@Override
	public boolean containsInfo(Integer info) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getElementAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean removeByInfo(Integer info) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAt(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void print() {
		System.out.println("La lista contiene:");
		if (isEmpty()) {
			System.out.println("La lista está vacía");
		} else {
			Nodo aux = this.primero;
			while (aux.getSig() != null) {
				System.out.print(aux.getInfo() + " -> ");
				aux = aux.getSig();
			}
			System.out.println(aux.getInfo());
		}

	}

	@Override
	public boolean clearList() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return numElementos;
	}

}
