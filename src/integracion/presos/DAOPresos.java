package integracion.presos;

import java.util.ArrayList;

import negocio.presos.TransferEstancia;
import negocio.presos.TransferPreso;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Pablo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DAOPresos {

	public TransferPreso leer(int idPreso);
	
	public TransferPreso leerPorDNI(String DNI);

	public int escribir(TransferPreso preso);

	public ArrayList<TransferPreso> listar();
	
	public int escribirEstancia(TransferEstancia tEstancia);
	
	public TransferEstancia leerEstanciaActual(int idPreso);
	
	public ArrayList<TransferPreso> leerPresosPorCeldaYfecha(int id_celda, String fecha_inicio,String fecha_fin);
	
}