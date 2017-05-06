/**
 * 
 */
package presentacion.controlador.comandos.celdas;

import java.util.ArrayList;

import negocio.celdas.SACeldas;
import negocio.celdas.TransferCelda;
import negocio.factoriaSA.FactoriaSA;
import presentacion.controlador.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.EventoNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ListarCeldas implements Command {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param datos
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		SACeldas s = FactoriaSA.getInstance().generarSACeldas();
		ArrayList<TransferCelda> listaCeldas = s.listar();
		return new Contexto(EventoNegocio.LISTAR_CELDAS, listaCeldas);

		// end-user-code
	}
}