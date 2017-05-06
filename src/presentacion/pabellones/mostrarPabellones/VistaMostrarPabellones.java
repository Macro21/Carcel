package presentacion.pabellones.mostrarPabellones;

import java.util.ArrayList;

import javax.swing.JPanel;

import negocio.pabellones.TransferPabellon;

public abstract class VistaMostrarPabellones {
	private static VistaMostrarPabellones vistaMostrarPabellon;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static VistaMostrarPabellones getInstance() {
		// begin-user-code
		if (vistaMostrarPabellon == null)
			vistaMostrarPabellon = new VistaMostrarPabellonesImp();
		return vistaMostrarPabellon;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void initGUI();

	public abstract JPanel getPanel();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void update(ArrayList<TransferPabellon> lista);
}
