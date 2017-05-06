/**
 * 
 */
package presentacion.celdas.alta;

import javax.swing.JPanel;

import presentacion.notificaciones.Notificaciones;

public abstract class VistaAltaCeldas {

	private static VistaAltaCeldas vistaAltaCeldas;

	public static VistaAltaCeldas getInstance() {
		// begin-user-code
		if (vistaAltaCeldas == null) {
			vistaAltaCeldas = new VistaAltaCeldasImp();
		}
		return vistaAltaCeldas;
		// end-user-code
	}

	public abstract void update(Notificaciones resultado);

	public abstract void initGUI();

	public abstract JPanel getPanel();

}