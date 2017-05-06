/**
 * 
 */
package negocio.factoriaSA;

import negocio.celdas.SACeldas;
import negocio.celdas.SACeldasImp;
import negocio.pabellones.SAPabellones;
import negocio.pabellones.SAPabellonesImp;
import negocio.presos.SAPresos;
import negocio.presos.SAPresosImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaSAImp extends FactoriaSA {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SACeldas generarSACeldas() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return new SACeldasImp();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAPabellones generarSAPabellones() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return new SAPabellonesImp();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAPresos generarSAPresos() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return new SAPresosImp();
		// end-user-code
	}
}