/**
 * 
 */
package presentacion.celdas.modificar;

import javax.swing.JPanel;

import negocio.celdas.TransferCelda;
import presentacion.notificaciones.Notificaciones;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class VistaModificarCeldas {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static VistaModificarCeldas vistaModificarCeldas;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static VistaModificarCeldas getInstance() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		if (vistaModificarCeldas == null) {
			vistaModificarCeldas = new VistaModificarCeldasImp();
		}
		return vistaModificarCeldas;

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
	public abstract void update(TransferCelda tCelda);
	
	public abstract void update (Notificaciones resultado);

	public abstract JPanel getPanel();
}