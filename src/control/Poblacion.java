package control;

import java.util.ArrayDeque;
import java.util.ArrayList;

import modelo.poblacion.EstadoSer;
import modelo.poblacion.Seres;
import utilesglobal.Utilies;

public class Poblacion {

	private ArrayList<Seres> menores;
	private ArrayList<Seres> jubilados;
	private ArrayList<Seres> poblacion;
	private ArrayDeque<Seres> demandantes;

	public Poblacion() {
		int menoresInicial = 30, trabajadoresIncial = 100, jubiladosInicial = 20;
		menores = new ArrayList<>();
		jubilados = new ArrayList<>();
		poblacion = new ArrayList<>();
		demandantes = new ArrayDeque<>();

		for (int i = 0; i < menoresInicial; i++) {
			poblacion.add(new Seres(Utilies.obtenerAleatorio(0, 17), EstadoSer.menor));
		}
		for (int i = 0; i < trabajadoresIncial; i++) {
			poblacion.add(new Seres(Utilies.obtenerAleatorio(18, 65), EstadoSer.trabajador));
		}
		for (int i = 0; i < jubiladosInicial; i++) {
			poblacion.add(new Seres(65, EstadoSer.jubilado));
		}
	}

	public Seres generadorCiudadanos(Seres seres, ArrayList<Seres> menores) {
		Seres ciudadano = new Seres();
		a�adirMenorCreadoAlaLista(ciudadano, menores);

		/* Revisi�n, tambi�n hay que a�adirlo a la lista principal */

		a�adirCiudadanoCreadoAlaLista(ciudadano, poblacion);
		/* Revisi�n: Se a�aden a las dos listas del tir�n */

		return ciudadano;
	}

	private void a�adirMenorCreadoAlaLista(Seres ciudadano, ArrayList<Seres> menores) {
		menores.add(ciudadano);
	}

	private void a�adirCiudadanoCreadoAlaLista(Seres ciudadano, ArrayList<Seres> poblacion) {
		poblacion.add(ciudadano);
	}

	public void envejecer() {
		for (Seres ser : this.poblacion) {
			ser.setEdad(ser.getEdad() + 1);

		}
	}
}
