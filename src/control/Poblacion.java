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

	public Poblacion(int menoresInicial, int trabajadoresIncial, int jubiladosInicial) {
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

	private void establecerDestinoCiudadano(ArrayList<Seres> poblacion) {
		for (int i = 0; i < poblacion.size(); i++) {
			int valor = poblacion.get(i).getEdad();
			int respuesta = getRespuesta(valor);
			switch (respuesta) {
			case 0:
				for (int j = 0; j < menores.size(); j++) {
					if (!menores.contains(poblacion.get(i))) {
						poblacion.get(i).setTipoEstado(EstadoSer.menor);
						menores.add(poblacion.get(i));
					}
				}
				break;
			case 1:
				for (int j = 0; j < demandantes.size(); j++) {
					if (!demandantes.contains(poblacion.get(i))) {
						poblacion.get(i).setTipoEstado(EstadoSer.desempleado);
						demandantes.offer(poblacion.get(i));
					}
				}
				break;
			case 2:
				for (int j = 0; j < jubilados.size(); j++) {
					if (!jubilados.contains(poblacion.get(i))) {
						poblacion.get(i).setTipoEstado(EstadoSer.jubilado);
						jubilados.add(poblacion.get(i));
					}
				}
			default:
				break;
			}
		}
	}

	private int getRespuesta(int valor) {
		int respuesta;
		if (valor < 18) {
			respuesta = 0;
		} else {
			if (valor > 65) {
				respuesta = 2;
			} else {
				respuesta = 1;
			}
		}
		return respuesta;
	}

	public void envejecer() {
		for (Seres ser : this.poblacion) {
			ser.setEdad(ser.getEdad() + 1);

		}
	}
}
