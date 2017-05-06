/**
 * 
 */
package negocio.celdas;


public class TransferCelda {
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
	private boolean estado;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int idCelda;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int nrCelda;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private boolean television;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private boolean ducha;

	public TransferCelda() {
	}

	public TransferCelda(int idCelda, int numeroCelda,boolean television, boolean ducha) {
		this.idCelda = idCelda;
		this.nrCelda = numeroCelda;
		this.television = television;
		this.ducha = ducha;
	}
	public TransferCelda(int idCelda,int idPabellon, int numeroCelda,boolean television, boolean ducha,boolean estado) {
		this.idPabellon = idPabellon;
		this.nrCelda = numeroCelda;
		this.television = television;
		this.ducha = ducha;
		this.estado = estado;
		this.idCelda=idCelda;
	}
	public TransferCelda(int idCelda,int idPabellon, int numeroCelda,boolean television, boolean ducha) {
		this.idPabellon = idPabellon;
		this.nrCelda = numeroCelda;
		this.television = television;
		this.ducha = ducha;
		this.idCelda=idCelda;
	}

	public TransferCelda(int idCelda){
		this.idCelda = idCelda;
	}
	public TransferCelda(int idPabellon, int numeroCelda) {
		this.nrCelda = numeroCelda;
		this.idPabellon = idPabellon;
	}

	public int getIdCelda() {
		return idCelda;
	}

	public int getNrCelda() {
		return nrCelda;
	}

	public int getIdPabellon() {
		return this.idPabellon;
	}

	public boolean isDucha() {
		return ducha;
	}

	public boolean isEstado() {
		return estado;
	}

	public boolean isTelevision() {
		return television;
	}

	public void setDucha(boolean ducha) {
		this.ducha = ducha;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setIdCelda(int idCelda) {
		this.idCelda = idCelda;
	}

	public void setNrCelda(int nrCelda) {
		this.nrCelda = nrCelda;
	}

	public void setIdPabellon(int idPabellon) {
		this.idPabellon = idPabellon;
	}

	public void setTelevision(boolean television) {
		this.television = television;
	}

}