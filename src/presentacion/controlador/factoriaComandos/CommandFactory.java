/**
 * 
 */
package presentacion.controlador.factoriaComandos;

import presentacion.controlador.Command;
import presentacion.controlador.EventoNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class CommandFactory {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static CommandFactory commandFactory;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static CommandFactory getInstance() {
		// begin-user-code
		if (commandFactory == null) {
			commandFactory = new CommandFactoryImp();
		}
		return commandFactory;
		// end-user-code
	}

	public abstract Command getCommand(EventoNegocio evento);
}