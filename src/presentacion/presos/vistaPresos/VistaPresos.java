package presentacion.presos.vistaPresos;

import java.awt.Component;

import javax.swing.JPanel;

public abstract class VistaPresos {
	private static VistaPresos vistaPresos;

	public static VistaPresos getInstance() {
		// begin-user-code
		if (vistaPresos == null)
			vistaPresos = new VistaPresosImp();
		return vistaPresos;
		// end-user-code
	}

	public abstract void initGUI();

	public abstract JPanel getPanel();

	public abstract void addPanelCentral(Component c);
}
