package presentacion.presos.mostrarPresosCelda;

import java.util.ArrayList;

import javax.swing.JPanel;

import negocio.presos.TransferPreso;

public abstract class VistaMostrarPresos {
	private static VistaMostrarPresos vistaMostrarPreso;

	public static VistaMostrarPresos getInstance() {
		if (vistaMostrarPreso == null)
			vistaMostrarPreso = new VistaMostrarPresosImp();
		return vistaMostrarPreso;
		// end-user-code
	}

	public abstract void update(ArrayList<TransferPreso> lista);

	public abstract void initGUI();

	public abstract JPanel getPanel();
}
