/**
 * 
 */
package presentacion.controlador;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Contexto {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private EventoNegocio evento;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Object datos;

	public Contexto(EventoNegocio evento, Object datos) {
		this.evento = evento;
		this.datos = datos;
	}

	public EventoNegocio getEvento() {
		return this.evento;
	}

	public Object getDatos() {
		return this.datos;
	}

}