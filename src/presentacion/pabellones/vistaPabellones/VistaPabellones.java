package presentacion.pabellones.vistaPabellones;

import java.awt.Component;

import javax.swing.JPanel;

public abstract class VistaPabellones {
	private static VistaPabellones vistaPabellones;

	public static VistaPabellones getInstance() {
		// begin-user-code
		if (vistaPabellones == null)
			vistaPabellones = new VistaPabellonesImp();
		return vistaPabellones;
		// end-user-code
	}

	public abstract void initGUI();

	public abstract JPanel getPanel();

	public abstract void addPanelCentral(Component c);
}
