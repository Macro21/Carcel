/**
 * 
 */
package negocio.celdas;

import integracion.celdas.DAOCeldas;
import integracion.factoriaDAO.FactoriaDAO;
import integracion.pabellones.DAOPabellones;
import integracion.transactionManager.Transaction;
import integracion.transactionManager.TransactionManager;

import java.util.ArrayList;

import negocio.pabellones.TransferPabellon;
import presentacion.notificaciones.Notificaciones;

public class SACeldasImp implements SACeldas {

	public Notificaciones alta(TransferCelda datos) {
		
		Notificaciones resultado = Notificaciones.ERROR;

		DAOCeldas DAOceldas = FactoriaDAO.getInstance().generarDAOCeldas(); //Creo el dao de celdas
		DAOPabellones DAOpabellones = FactoriaDAO.getInstance()
				.generarDAOPabellones(); //Creo el dao pabellones

		TransactionManager transactionManager = TransactionManager
				.getInstance(); //Creo el transaction Manager

		transactionManager.newTransaction(); //Creo la transaccion;

		Transaction transaction = transactionManager.getTransaction();

		transaction.start(); //Inicio la transaccion

		int idPabellon = datos.getIdPabellon();

		TransferPabellon pabellon = DAOpabellones.leer(idPabellon);
		
		if (pabellon != null){
			
			int contadorCeldas = DAOceldas.contarCeldas(idPabellon);
			int numCelda = datos.getNrCelda();
			TransferCelda celda = DAOceldas.leerCeldaPorNumeroYPabellon(numCelda, idPabellon,0);

			if (pabellon.getNumMaxCeldas() > contadorCeldas || celda != null) {
				if (celda == null) { 
					datos.setEstado(true);
					int id = 0;
					id = DAOceldas.escribir(datos);
					if (id != 0) { 
						Notificaciones.ALTA_CORRECTO.setNum(id);
						resultado = Notificaciones.ALTA_CORRECTO;
					}
					else {
						resultado = Notificaciones.ERROR;
					}
					transaction.commit();
				} 
				else if (!celda.isEstado()) {
					DAOceldas.escribir(celda);
					resultado = Notificaciones.ALTA_EXISTENTE;
					transaction.commit();
				}
				else if (celda.isEstado()) {
					transaction.rollback();
					resultado = Notificaciones.DOBLE_ALTA;
				}
			}
			else if(pabellon.getNumMaxCeldas()<= contadorCeldas){
				resultado = Notificaciones.PABELLON_LLENO;
			}
		} else {
			transaction.rollback();
			resultado = Notificaciones.PABELLON_NO_EXISTE;
		}
		transactionManager.deleteTransaction();

		return resultado;
		// end-user-code
	}

	public Notificaciones baja(int idCelda) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		Notificaciones resultado = Notificaciones.ERROR;

		DAOCeldas DAOceldas = FactoriaDAO.getInstance().generarDAOCeldas(); //Creo el dao de celdas
		TransactionManager transactionManager = TransactionManager.getInstance(); //Creo el transaction Manager

		transactionManager.newTransaction(); //Creo la transaccion;

		Transaction transaction = transactionManager.getTransaction();

		transaction.start(); //Inicio la transaccion

		ArrayList<TransferCelda> listaCeldasConPresos = DAOceldas.leerPresosPorCelda(idCelda);
		
		TransferCelda tCelda = DAOceldas.leer(idCelda);
		
		if(tCelda != null && tCelda.isEstado() && listaCeldasConPresos.size() == 0){//Si la celda existe y no tiene presos
			int id = DAOceldas.updateCelda(tCelda,0);
			if(id !=0){
				Notificaciones.BAJA_CORRECTO.setNum(id);
				resultado = Notificaciones.BAJA_CORRECTO;
				transaction.commit();
			}
			else{
				resultado = Notificaciones.DOBLE_BAJA;
				transaction.rollback();
			}
		}
		else{
			if(tCelda == null)
				resultado = Notificaciones.NO_EXISTE;
			else if (!tCelda.isEstado())
				resultado = Notificaciones.DOBLE_BAJA;
			else
				resultado = Notificaciones.CELDA_CON_PRESOS;
			transaction.rollback();
		}
		transactionManager.deleteTransaction();
		return resultado;
		// end-user-code
	}

	public Notificaciones modificar(TransferCelda datos) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		Notificaciones resultado=Notificaciones.ERROR;
		DAOCeldas DAOceldas = FactoriaDAO.getInstance().generarDAOCeldas(); //Creo el dao de celdas
		DAOPabellones DAOpabellones = FactoriaDAO.getInstance()
				.generarDAOPabellones(); //Creo el dao pabellones

		TransactionManager transactionManager = TransactionManager
				.getInstance(); //Creo el transaction Manager

		transactionManager.newTransaction(); //Creo la transaccion;

		Transaction transaction = transactionManager.getTransaction();

		transaction.start(); //Inicio la transaccion

		TransferCelda celda = DAOceldas.leer(datos.getIdCelda());
		if(celda != null){
			int idPabellon = celda.getIdPabellon();
			TransferPabellon pabellon = DAOpabellones.leer(idPabellon);
			
			if(pabellon != null){//Compruebo otra vez que el pabellon exista
				TransferCelda tCelda = DAOceldas.leerCeldaPorNumeroYPabellon(datos.getNrCelda(), idPabellon,datos.getIdCelda());
				datos.setIdPabellon(idPabellon);
				if(tCelda == null){ //Si quiero modificar una celda, y ponerle el numero de una que ya existe, no me tiene que dejar
					int id =0;
					id = DAOceldas.updateCelda(datos,1);
					if(id != 0){
						Notificaciones.MODIFICAR_CORRECTO.setNum(id);
						resultado = Notificaciones.MODIFICAR_CORRECTO;
						transaction.commit();
					}
				}
				else{
					transaction.rollback();
					resultado = Notificaciones.NR_CELDA_EXISTENTE;			}
			}
		}
		else{
			resultado = Notificaciones.DATOS_ERRONEOS;
		}
		
		transactionManager.deleteTransaction();
		return resultado;
		// end-user-code
	}

	public ArrayList<TransferCelda> listar() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		DAOCeldas DAOceldas = FactoriaDAO.getInstance().generarDAOCeldas();
		ArrayList<TransferCelda> listaCeldas = DAOceldas.listar();
		return listaCeldas;
		// end-user-code
	}

	public TransferCelda detalles(int idCelda) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		DAOCeldas DAOceldas = FactoriaDAO.getInstance().generarDAOCeldas();
		TransferCelda tCelda = DAOceldas.leer(idCelda);
		return tCelda;
		// end-user-code
	}
}