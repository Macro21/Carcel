/**
 * 
 */
package integracion.pabellones;

import java.util.ArrayList;

import negocio.pabellones.TransferPabellon;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DAOPabellones {
	
	public int escribir(TransferPabellon datos);

	public TransferPabellon leer(int idPabellon);

	//public TransferPabellon leerPabellonPorNumero(int nrPabellon);

	public ArrayList<TransferPabellon> listar();

	public ArrayList<TransferPabellon> listarXPabellones(int num); 
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param nombrePabellon
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferPabellon leerPabellonPorNombre(String nombrePabellon);

}