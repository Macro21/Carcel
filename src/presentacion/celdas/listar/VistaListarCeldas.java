/**
 * 
 */
package presentacion.celdas.listar;

import java.util.ArrayList;

import javax.swing.JPanel;

import negocio.celdas.TransferCelda;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class VistaListarCeldas {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static VistaListarCeldas vistaListarCeldas;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static VistaListarCeldas getInstance() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		if (vistaListarCeldas == null) {
			vistaListarCeldas = new VistaListarCeldasImp();
		}
		return vistaListarCeldas;

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void initGUI();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void update(ArrayList<TransferCelda> listaCeldas);

	public abstract JPanel getPanel();
}