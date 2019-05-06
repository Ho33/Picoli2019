package control;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import modelo.empresa.DineroEstado;
import modelo.empresa.Factorias;
import modelo.poblacion.Seres;

public class Sede {
	private ArrayList<Factorias> factorias;

	public Sede() {
		super();
		this.factorias = new ArrayList<>();
	}

	public void crearFactoria() {
		this.factorias.add(new Factorias());
	}

	public void eliminarEmpresasEmpty() {
		for (Iterator iterator = factorias.iterator(); iterator.hasNext();) {
			Factorias factoria = (Factorias) iterator.next();
			if (factoria.getPilaTrabajador().isEmpty()) {
				iterator.remove();
			}
		}
	}

	public int produccionTotal() {
		int produccion = 0;
		for (Factorias factoria : factorias) {
			factoria.comprobarProduccion();
		}
		return produccion;
	}

	public void contratarTrabajador(ArrayDeque<Seres> demandantes, Stack<Seres> pilaTrabajador) {
		// if(getDemanda()>factoria.getProduccion()) { /*Hay que obtener el numero
		// concreto de gente a emplear*/
		Seres contratado = demandantes.poll();
		pilaTrabajador.push(contratado);
    
	}
	
	
	public ArrayList<Factorias> eliminarJubilados(ArrayList<Integer> listaJubilados) {
		for (Iterator iterator = factorias.iterator(); iterator.hasNext();) {
			Factorias factoria = (Factorias) iterator.next();
			for (Iterator iterator2 = factoria.getPilaTrabajador().iterator(); iterator2.hasNext();) {
				Seres ser = (Seres) iterator2.next();
				if (listaJubilados.contains(ser.getId())) {
					iterator2.remove();
				}
			}
		}
		return factorias;
	}

	private int numTrabajadores() {
		int contador = 0;
		for (Factorias factoria : factorias) {
			contador = contador + factoria.getPilaTrabajador().size();
		}
		return contador;
	}
	
	public void gestionarCierreFactorias(ArrayDeque<Seres> demandantes) {
		int ocupacionMaxima = 1000;
		for (Iterator iterator = factorias.iterator(); iterator.hasNext();) {
			Factorias empresa = (Factorias) iterator.next();
			int numTrabajadores = empresa.getPilaTrabajador().size();
			float porcentajeOcupado = (numTrabajadores * 100) / ocupacionMaxima;
			if(porcentajeOcupado<=0.3) {
				despedirTrabajadores(demandantes, empresa);
				factorias.remove(empresa);
				}
				
			}
			
			
		}

	private void despedirTrabajadores(ArrayDeque<Seres> demandantes, Factorias empresa) {
		for (int i = 0; i < empresa.getPilaTrabajador().size(); i++) {
			Seres trabajador = empresa.getPilaTrabajador().pop();
			demandantes.offer(trabajador);
		}
	}
	

	public ArrayList<Factorias> getFactorias() {
		return factorias;
	}

	public void setFactorias(ArrayList<Factorias> factorias) {
		this.factorias = factorias;
	}
}