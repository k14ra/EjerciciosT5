package edu.alonso.daw.tema5.videoclub;

import java.util.List;
import java.util.Scanner;

public class Init {

	public static void main(String[] args) {
		VideoClub vc = new VideoClub();

		Scanner sc = new Scanner(System.in);
		char opt;

		vc.aniadirCliente(new Cliente(12345, "Fran"));
		vc.aniadirCliente(new Cliente(12346, "Madera"));

		vc.aniadirPelicula(new Pelicula("1", "Moonligth"));
		vc.aniadirPelicula(new Pelicula("2", "Es por tu bien"));
		vc.aniadirPelicula(new Pelicula("3", "La la land"));
		vc.aniadirPelicula(new Pelicula("4", "El guardián invisible"));

		do {
			System.out.println("----MENÚ----");
			System.out.println("1-Préstamo");
			System.out.println("2-Devolución");
			System.out.println("3-Lista de Morosos");
			System.out.println("4-Lista de Préstamos");
			System.out.println("5-Lista de Películas");
			System.out.println("6-Salir");

			do {
				System.out.print("Introduzca la opción deseada: ");
				opt = sc.nextLine().charAt(0);
			} while (opt < '1' || opt > '6');

			String codPelicula;
			Pelicula p;

			switch (opt) {
			case '1':
				System.out.println("NUEVO PRÉSTAMO");
				System.out.println("Introduzca el código de la película: ");

				codPelicula = sc.nextLine();

				p = vc.buscarPelicula(codPelicula);

				if (p != null) {
					// Puedo realizar el préstamo, de momento...
					if (!vc.isPrestada(codPelicula)) {
						// Pido el carnet al cliente
						System.out.print("Introduzca el número de carnet: ");
						int numCarnet = Integer.valueOf(sc.nextLine());

						Cliente c = vc.buscarCliente(numCarnet);
						if (c != null) {
							if (vc.aniadirPrestamo(new Prestamo(c, p))) {
								System.out.println("Préstamo realizado con éxito.");
							} else {
								System.err.println("Error al realizar el préstamo.");
							}
						} else {
							System.err.println("Aun no eres socio del videoclub.");
						}

					} else {
						System.err.println("La película ya está prestada.");
					}
				} else {
					System.err.println("No disponemos de esa película en el videoclub");
				}

				break;
			case '2':
				System.out.println("DEVOLUCIÓN");
				System.out.println("Introduzca el código de la película: ");

				codPelicula = sc.nextLine();
				p = vc.buscarPelicula(codPelicula);

				// Compruebo que exista la película
				if (p != null) {
					if (vc.isPrestada(codPelicula)) {
						// Pido el carnet al cliente
						System.out.print("Introduzca el número de carnet: ");
						int numCarnet = Integer.valueOf(sc.nextLine());

						Cliente c = vc.buscarCliente(numCarnet);
						if (c != null) {
							if (vc.devolucion(codPelicula, numCarnet)) {
								System.out.println("Devolución realizada con éxito.");
							} else {
								System.err.println("Error al realizar la devolución.");
							}
						} else {
							System.err.println("Aun no eres socio del videoclub.");
						}
					} else {
						System.err.println("La película no estaba prestada");
					}
				} else {
					System.err.println("No disponemos de esa película en el videoclub");
				}

				break;
			case '3':
				System.out.println("LISTADO DE PRÉSTAMOS MOROSOS");

				List<Prestamo> listaMorosos = vc.getPresamosMorosos();
				if (!listaMorosos.isEmpty()) {
					System.out.println("CLIENTE\tPELÍCULA\tFECHA_PRES\tTFECHA_DEV");
					for (Prestamo prestamo : listaMorosos) {
						System.out.print(prestamo.getCliente().getNombre());
						System.out.print("\t" + prestamo.getPelicula().getTitulo());
						System.out.print("\t" + prestamo.getFechaPrestamo());
						System.out.println("\t" + prestamo.getFechaDevolucion());
					}
				} else {
					System.out.println("No hay morosos");
				}

				break;
			case '4':
				System.out.println("LISTADO TOTAL DE PRÉSTAMOS");

				List<Prestamo> listaPrestamos = vc.getPrestamos();
				if (!listaPrestamos.isEmpty()) {
					System.out.println("CLIENTE\tPELÍCULA\tFECHA_PRES\tTFECHA_DEV");
					for (Prestamo prestamo : listaPrestamos) {
						System.out.print(prestamo.getCliente().getNombre());
						System.out.print("\t" + prestamo.getPelicula().getTitulo());
						System.out.print("\t" + prestamo.getFechaPrestamo());
						System.out.println("\t" + prestamo.getFechaDevolucion());
					}
				} else {
					System.out.println("No hay prestamos");
				}

				break;

			case '5':
				System.out.println("CATÁLOGO DE PELÍCULAS");
				vc.mostrarPeliculas();
				break;

			}
			if (opt != '6') {
				System.out.println("pulse una tecla para continuar");
				sc.nextLine();
			}
		} while (opt != '6');
		
		sc.close();

	}
}
