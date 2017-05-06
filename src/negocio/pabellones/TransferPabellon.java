/**
 * 
 */
package negocio.pabellones;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransferPabellon {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int idPabellon;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String nombre;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private boolean estado;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String tipo;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int numMaxCeldas;

	public TransferPabellon(){}
	
	public TransferPabellon(int idPabellon, String nombre, boolean estado, String tipo, int numMaxCeldas) {
		this.idPabellon = idPabellon;
		this.nombre = nombre;
		this.estado = estado;
		this.tipo = tipo;
		this.numMaxCeldas = numMaxCeldas;
	}

	public TransferPabellon(String nombre, boolean estado,
			String tipo, int numMaxCeldas) {
		this.nombre = nombre;
		this.estado = estado;
		this.tipo = tipo;
		this.numMaxCeldas = numMaxCeldas;
	}

	public int getIdPabellon() {
		return idPabellon;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumMaxCeldas() {
		return numMaxCeldas;
	}

	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setIdPabellon(int idPabellon) {
		this.idPabellon = idPabellon;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumMaxCeldas(int numMaxCeldas) {
		this.numMaxCeldas = numMaxCeldas;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}