/**
 * 
 */
package negocio.pabellones;

import integracion.factoriaDAO.FactoriaDAO;
import integracion.pabellones.DAOPabellones;
import integracion.transactionManager.Transaction;
import integracion.transactionManager.TransactionManager;

import java.util.ArrayList;

import presentacion.notificaciones.Notificaciones;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAPabellonesImp implements SAPabellones {

	public Notificaciones alta(TransferPabellon datos) {
		// begin-user-code

		boolean ok = true;
		Notificaciones resultado = Notificaciones.ERROR;
		DAOPabellones daoPab = FactoriaDAO.getInstance().generarDAOPabellones();
		TransactionManager transactionManager = TransactionManager
				.getInstance();
		transactionManager.newTransaction();
		Transaction transaction = transactionManager.getTransaction();
		transaction.start();

		TransferPabellon pabellon = daoPab.leerPabellonPorNombre(datos
				.getNombre());
				
		if (pabellon == null) {
			if (!datos.getTipo().equalsIgnoreCase("aislamiento") && !datos.getTipo().equalsIgnoreCase("comun")){
				ok = false;
			}
			
			if (!ok) {
				resultado = Notificaciones.DATOS_ERRONEOS;
				transaction.rollback();
			}

			else {
				int id = -1;
				id = daoPab.escribir(datos);
				if (id != -1) { 
					Notificaciones.ALTA_CORRECTO.setNum(id);
					resultado = Notificaciones.ALTA_CORRECTO;
				}
				else {
					resultado = Notificaciones.ERROR;
				}
				transaction.commit();
			}

		} else {
			if (pabellon.getEstado()) {
				resultado = Notificaciones.DOBLE_ALTA;
				transaction.rollback();
			} else {
				pabellon.setEstado(true);
				daoPab.escribir(pabellon);
				resultado = Notificaciones.ALTA_EXISTENTE;
				transaction.commit();
			}
		}

		transactionManager.deleteTransaction();

		return resultado;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param idPabellon
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Notificaciones baja(int idPabellon) {
		// begin-user-code
		Notificaciones resultado = Notificaciones.ERROR;
		DAOPabellones daoPab = FactoriaDAO.getInstance().generarDAOPabellones();
		TransactionManager transactionManager = TransactionManager
				.getInstance();
		transactionManager.newTransaction();
		Transaction transaction = transactionManager.getTransaction();
		transaction.start();

		TransferPabellon pabellon = daoPab.leer(idPabellon);

		if (pabellon == null) {
			resultado = Notificaciones.NO_EXISTE;
			transaction.rollback();
		} 
		else {
			if (pabellon.getEstado()) {
				if(FactoriaDAO.getInstance().generarDAOCeldas().todasCeldasInactivas(pabellon.getIdPabellon())){
					pabellon.setEstado(false);
					int id = -1;
					id = daoPab.escribir(pabellon);
					if (id != -1) { 
						Notificaciones.BAJA_CORRECTO.setNum(id);
						resultado = Notificaciones.BAJA_CORRECTO;
					}
					else {
						resultado = Notificaciones.ERROR;
					}
					transaction.commit();
				}
				else{
					resultado = Notificaciones.CELDAS_ACTIVAS;
					transaction.rollback();
				}
			} else {
				resultado = Notificaciones.DOBLE_BAJA;
				transaction.rollback();
			}
		}

		transactionManager.deleteTransaction();

		return resultado;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param datos
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Notificaciones modificar(TransferPabellon datos) {
		// begin-user-code
		
		boolean ok = true;
		Notificaciones resultado = Notificaciones.ERROR;

		DAOPabellones daoPab = FactoriaDAO.getInstance().generarDAOPabellones();
		TransactionManager transactionManager = TransactionManager
				.getInstance();
		transactionManager.newTransaction();
		Transaction transaction = transactionManager.getTransaction();

		transaction.start();

		TransferPabellon pabellon = daoPab.leer(datos.getIdPabellon());
		if (datos.getNumMaxCeldas() < pabellon.getNumMaxCeldas() || datos.getEstado() != pabellon.getEstado() || 
				(daoPab.leerPabellonPorNombre(datos.getNombre()) != null && !datos.getNombre().equalsIgnoreCase(pabellon.getNombre()))){
			ok = false;
		}
		else if (datos.getTipo().equalsIgnoreCase("comun")){
			if (((TransferPabellonComun) pabellon).getTamanoCelda() < ((TransferPabellonComun) pabellon).getTamanoCelda()){
				ok = false;
			}
		}
		else if (!datos.getTipo().equalsIgnoreCase("aislamiento")){
			ok = false;
		}

		if (!ok) {
			resultado = Notificaciones.DATOS_ERRONEOS;
			transaction.rollback();
		}

		else {
			int id = -1;
			id = daoPab.escribir(datos);
			if (id != -1) { 
				Notificaciones.MODIFICAR_CORRECTO.setNum(id);
				resultado = Notificaciones.MODIFICAR_CORRECTO;
			}
			else {
				resultado = Notificaciones.ERROR;
			}
			transaction.commit();
		}

		return resultado;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param idPabellon
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferPabellon detalles(int idPabellon) {
		// begin-user-code
		DAOPabellones daoPab = FactoriaDAO.getInstance().generarDAOPabellones();

		TransferPabellon pabellon = daoPab.leer(idPabellon);

		return pabellon;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TransferPabellon> listar() {
		// begin-user-code
		DAOPabellones daoPab = FactoriaDAO.getInstance().generarDAOPabellones();

		ArrayList<TransferPabellon> listaPabellones = daoPab.listar();

		return listaPabellones;
		// end-user-code
	}

	@Override
	public ArrayList<TransferPabellon> mostrarPabellones(int num) {
		DAOPabellones daoPab = FactoriaDAO.getInstance().generarDAOPabellones();

		ArrayList<TransferPabellon> listaPabellones = daoPab.listarXPabellones(num);

		return listaPabellones;
	}
}