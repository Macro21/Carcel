/**
 * 
 */
package integracion.factoriaDAO;

import integracion.celdas.DAOCeldas;
import integracion.celdas.DAOCeldasImp;
import integracion.pabellones.DAOPabellones;
import integracion.pabellones.DAOPabellonesImp;
import integracion.presos.DAOPresos;
import integracion.presos.DAOPresosImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaDAOImp extends FactoriaDAO {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOPabellones generarDAOPabellones() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return new DAOPabellonesImp();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOCeldas generarDAOCeldas() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return new DAOCeldasImp();
		// end-user-code
	}

	@Override
	public DAOPresos generarDAOPresos() {
		return new DAOPresosImp();
	}
}