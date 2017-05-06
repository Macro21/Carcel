package presentacion.celdas.vistaCeldas;

import java.awt.Component;

import javax.swing.JPanel;

public abstract class VistaCeldas {
	private static VistaCeldas vistaCeldas;

	public static VistaCeldas getInstance() {
		// begin-user-code
		if (vistaCeldas == null)
			vistaCeldas = new VistaCeldasImp();
		return vistaCeldas;
		// end-user-code
	}

	public abstract void initGUI();

	public abstract JPanel getPanel();

	public abstract void addPanelCentral(Component c);

}
