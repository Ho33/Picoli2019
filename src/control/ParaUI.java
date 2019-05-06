package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.vista.Datos;
import modelo.vista.DatosEstadoGlobal;
import modelo.vista.DatosEstadoLocal;
import modelo.vista.DatosPoblacion;
import vista.Comunicador;
import vista.UI;

public class ParaUI extends UI {

	private Estado estado = new Estado();

	public ParaUI() {
		super();
		estado.pasarPeriodo();
		setDatosEnElInterfazUsuario(estado.getDatosPoblacion(), estado.getDatosEstadoLocal(),
				estado.getDatosEstadoGlobales());
	}

	public void listener() {

		getBtnPasarPeriodo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado.pasarPeriodo();
			}
		});

		getBtnIncrementoDemanda().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		getBtnDecrementoDemanda().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	public void setDatosEnElInterfazUsuario(DatosPoblacion datosPoblacion, DatosEstadoLocal datosEstadoLocal,
			DatosEstadoGlobal datosEstadoGlobal) {
		rellenarComunicador(comunicadorPoblacion, datosPoblacion);
		rellenarComunicador(comunicadorEstadoLocal, datosEstadoLocal);
		rellenarComunicador(comunicadorEstadoGlobal, datosEstadoGlobal);
	}

	public void rellenarComunicador(Comunicador comunicador, Datos datos) {
		comunicador.asignarValores(datos);
	}
}
