package modelo.empresa;

import java.util.Stack;

import modelo.poblacion.EstadoSer;
import modelo.poblacion.Seres;

public class Factorias {

	private int produccionEmpleado = 1000;
	private Stack<Seres> pilaTrabajador;

	public Factorias() {
		super();
		this.pilaTrabajador = new Stack<Seres>();
	}

//hola
	public int comprobarProduccion() {
		int produccion = pilaTrabajador.size() * this.produccionEmpleado;
		return produccion;
	}

	public int numeroTrabajadores() {
		int empleados;
		empleados = 1000 - this.pilaTrabajador.size();
		return empleados;

	}
	

	public void pagarTrabajador(DineroEstado dinero) {
		float pagar = (float) (EstadoSer.trabajador.getSueldo());
		float impuesto = EstadoSer.trabajador.getNivelVida() / 2;
		float nv = EstadoSer.trabajador.getNivelVida();
		float cobroLimpioCadaTrabajador = pagar - impuesto - nv;
		for (int i = 0; i < this.pilaTrabajador.size(); i++) {
			float suma = this.pilaTrabajador.get(i).getAhorro() + cobroLimpioCadaTrabajador;
			pilaTrabajador.get(i).setAhorro(suma);
			dinero.setDineroTotal(dinero.getDineroTotal() - (nv + cobroLimpioCadaTrabajador));
		}
	}

	public int getProduccion() {
		return produccionEmpleado;
	}

	public Stack<Seres> getPilaTrabajador() {
		return pilaTrabajador;
	}

	public void setPilaTrabajador(Stack<Seres> pilaTrabajador) {
		this.pilaTrabajador = pilaTrabajador;
	}

	public void setContratarTrabajador(Seres ser) {
		this.pilaTrabajador.add(ser);
		
	}

}
