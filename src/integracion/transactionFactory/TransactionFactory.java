/**
 * 
 */
package integracion.transactionFactory;

import integracion.transactionManager.Transaction;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class TransactionFactory {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static TransactionFactory transactionFactory;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static TransactionFactory getInstance() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		if (transactionFactory == null)
			transactionFactory = new TransactionFactoryImp();
		return transactionFactory;

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract Transaction generarTransaccion();
}