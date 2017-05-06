package presentacion.vistaPrincipal;

import java.awt.Component;

import javax.swing.JPanel;

public abstract class VistaPrincipal {
	private static VistaPrincipal vistasPrincipal;

	public static VistaPrincipal getInstance() {
		if (vistasPrincipal == null)
			vistasPrincipal = new VistaPrincipalImp();
		return vistasPrincipal;
	}

	public abstract void initGUI();

	public abstract void addPanelCentral(Component c);

	public abstract JPanel getPanel();
}
