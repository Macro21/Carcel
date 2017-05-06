/**
 * 
 */
package presentacion.controlador.comandos.celdas;

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
public class DetallesCeldas implements Command {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param datos
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Contexto execute(Object datos) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		SACeldas s = FactoriaSA.getInstance().generarSACeldas();
		TransferCelda tCelda = (TransferCelda) datos;
		TransferCelda tDetalles = s.detalles(tCelda.getIdCelda());
		return new Contexto(EventoNegocio.DETALLES_CELDAS,tDetalles);
		// end-user-code
	}
}