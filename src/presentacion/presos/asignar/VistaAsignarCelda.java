package presentacion.presos.asignar;

import javax.swing.JPanel;

import presentacion.notificaciones.Notificaciones;

public abstract class VistaAsignarCelda {
	private static VistaAsignarCelda vistaAsiganrCelda;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static VistaAsignarCelda getInstance() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		if (vistaAsiganrCelda == null)
			vistaAsiganrCelda = new VistaAsignarCeldaImp();
		return vistaAsiganrCelda;

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void update(Notificaciones resultado);

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void initGUI();

	public abstract JPanel getPanel();
}
