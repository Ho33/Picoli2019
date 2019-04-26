package control;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import modelo.poblacion.Seres;


public class Poblacion {
	
	private ArrayList<Seres> menores;
	private ArrayList<Seres> jubilados;
	private ArrayList<Seres> poblacion;
	
	
	public Poblacion() {
		menores = new ArrayList<>();
		jubilados = new ArrayList<>();
		poblacion = new ArrayList<>();
	}
		
	public Seres generadorCiudadanos(Seres seres,ArrayList<Seres> menores) {
		Seres ciudadano = new Seres();
		a�adirMenorCreadoAlaLista(ciudadano, menores);
		/*Revisi�n, tambi�n hay que a�adirlo a la lista principal*/
		return ciudadano;
	}

	private void a�adirMenorCreadoAlaLista(Seres ciudadano,ArrayList<Seres> menores) {
		menores.add(ciudadano);
	}
}
