/**
 * 
 */
package negocio.presos;

import java.util.HashMap;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransferPreso {
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
	private String apellidos;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String DNI;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String condena;
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
	private boolean estado;
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private int idPreso;
	
	
	private class FechasCelda{
		
		private String fechaInicio;
		private String fechaFin;
		private int idCelda;		
		
		public int getIdCelda() {
			return idCelda;
		}
		public String getFechaInicio() {
			return fechaInicio;
		}
		public void setFechaInicio(String fechaInicio) {
			this.fechaInicio = fechaInicio;
		}
		public String getFechaFin() {
			return fechaFin;
		}
		/*public void setFechaFin(String fechaFin) {
			this.fechaFin = fechaFin;
		}*/
	}
	
	
	private HashMap<Integer,FechasCelda> estancia;
	
	public TransferPreso(int id_preso) {
		this.idPreso =id_preso;
	}

	public TransferPreso(String dni, String nombre, String apellidos,String condena, boolean estado) {
		this.DNI = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.condena = condena;
		this.estado = estado;
	}
	public TransferPreso(int id_preso, String dni, String nombre) {
		this.idPreso = id_preso;
		this.DNI = dni;
		this.nombre = nombre;
	}
	public TransferPreso(int idPreso,String dni, String nombre, String apellidos,String condena, boolean estado) {
		this.idPreso = idPreso;
		this.DNI = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.condena = condena;
		this.estado = estado;
	}
	
	public TransferPreso(int idPreso, String dni, String nombre, String apellidos,String condena, int idCelda, boolean estado) {
		this.idPreso = idPreso;
		this.DNI = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.condena = condena;
		this.idCelda = idCelda;
		this.estado = estado;
	}
	
	public TransferPreso(int idCelda, int idPreso, String fechaInicio) {
		this.idCelda = idCelda;
		this.idPreso = idPreso;
		this.estancia = new HashMap<Integer,FechasCelda>();
		FechasCelda t = new FechasCelda();
		t.setFechaInicio(fechaInicio);
		this.addFechasCelda(t, idCelda);
	}

	public void addFechasCelda(FechasCelda fc, int id){
		this.estancia.put(id, fc);
	}
	
	public String getFechaInicio(int id){
		return this.estancia.get(id).getFechaInicio();
	}
	
	public String getFechaFin(int id){
		return this.estancia.get(id).getFechaFin();
	}
	
	public int getIdCelda(int id){
		return this.estancia.get(id).getIdCelda();
	}
	
	public String getApellidos() {
		return apellidos;
	}

	public String getCondena() {
		return condena;
	}

	public String getDNI() {
		return DNI;
	}

	public int getIdCelda() {
		return idCelda;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getIdPreso(){
		return idPreso;
	}

	public boolean getEstado() {
		return this.estado;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setCondena(String condena) {
		this.condena = condena;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setIdCelda(int idCelda) {
		this.idCelda = idCelda;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setIdPreso(int idPreso) {
		this.idPreso = idPreso;
	}
	public HashMap<Integer, FechasCelda> getEstancia() {
		return estancia;
	}
	
}