/**
 * 
 */
package integracion.transactionFactory;

import integracion.transactionManager.Transaction;
import integracion.transactionManager.TransactionSQLDeveloper;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionFactoryImp extends TransactionFactory {

	public Transaction generarTransaccion() {
		return new TransactionSQLDeveloper();
	}
}