/**
 * 
 */
package integracion.transactionManager;

import integracion.transactionFactory.TransactionFactory;

import java.util.concurrent.ConcurrentHashMap;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionManagerImp extends TransactionManager {

	@SuppressWarnings({ "rawtypes", "unused" })
	private ConcurrentHashMap concurrentHashMap;

	private Transaction transaction;

	public void newTransaction() {
		this.transaction = TransactionFactory.getInstance()
				.generarTransaccion();

	}

	public void deleteTransaction() {
		this.transaction = null;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}
}