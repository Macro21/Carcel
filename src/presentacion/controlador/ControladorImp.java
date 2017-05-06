/**
 * 
 */
package presentacion.controlador;

import presentacion.controlador.factoriaComandos.CommandFactory;
import presentacion.dispatcher.Dispatcher;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControladorImp extends Controlador {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param evento
	 * @param datos
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void accion(EventoNegocio evento, Object datos) {
		// begin-user-code
		Dispatcher dispatcher = Dispatcher.getInstance();
		CommandFactory comandFactory = CommandFactory.getInstance();
		Command command = comandFactory.getCommand(evento);
		Contexto contexto = command.execute(datos);
		dispatcher.actualizarVista(contexto);

		// end-user-code
	}
}