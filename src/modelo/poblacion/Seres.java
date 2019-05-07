package modelo.poblacion;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.text.Utilities;

import control.Estado;
import control.Poblacion;
import utilesglobal.Utilies;

public class Seres {
	private String nombre;
	private int id = 0;
	private int edad;
	private float ahorro;
	private float esperanzaVida;
	private EstadoSer tipoEstado;
	LinkedList<String> nombres = new LinkedList<String>();
	private String[] personas = { "Antonio", "Paco", "Pepe", "Monica", "Laura", "Marta", "Manolo", "Maria", "Pedro",
			"Jesus", "Fran", "Ana", "Raul", "Victoria", "SerRaro", "Alien", "Depredador", "Pitufino", "Rufino",
			"Teresa" };

	public Seres() {
		super();
		this.id = sumarId();
		this.nombre = generarNombreAleatorio(nombres);
		this.edad = generarEdad();
		this.ahorro = 0;
		this.esperanzaVida = Utilies.obtenerAleatorio(90);
		this.tipoEstado = EstadoSer.menor;
	}

	public Seres(int edad, EstadoSer tipoEstado) {
		super();
		this.nombre = generarNombreAleatorio(nombres);
		this.id = sumarId();
		this.edad = edad;
		this.ahorro = 0;
		this.esperanzaVida = Utilies.obtenerAleatorio(this.edad, 90);
		this.tipoEstado = tipoEstado;
	}

	public int sumarId() {
		this.id = this.id++;
		return this.id;
	}

	public String generarNombreAleatorio(LinkedList<String> nombres) {
		anadirNombresAlaLista(nombres);
		int min = 1;
		int max = nombres.size();
		String aleatorio = nombres.get((int) (Math.random() * (max - min) + min));
		return aleatorio;
	}

	public void anadirNombresAlaLista(LinkedList<String> nombres) {
		for (int i = 0; i < personas.length; i++) {
			String nombresRecorridos = personas[i];
			nombres.add(nombresRecorridos);
		}
	}

	public int generarEdad() {
		edad = 0;
		return (int) edad;

	}

	public void setEsperanzaVida(float esperanzaVida) {
		this.esperanzaVida = esperanzaVida;
	}

	public void setNombres(LinkedList<String> nombres) {
		this.nombres = nombres;
	}

	public void setPersonas(String[] personas) {
		this.personas = personas;
	}

	public LinkedList<String> getNombres() {
		return nombres;
	}

	public String[] getPersonas() {
		return personas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getAhorro() {
		return ahorro;
	}

	public void setAhorro(float ahorro) {
		this.ahorro = ahorro;
	}

	public float getEsperanzaVida() {
		return esperanzaVida;
	}

	public EstadoSer getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(EstadoSer tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
