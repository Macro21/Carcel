package negocio.presos;

import integracion.celdas.DAOCeldas;
import integracion.factoriaDAO.FactoriaDAO;
import integracion.pabellones.DAOPabellones;
import integracion.presos.DAOPresos;
import integracion.transactionManager.Transaction;
import integracion.transactionManager.TransactionManager;

import java.util.ArrayList;

import negocio.celdas.TransferCelda;
import negocio.pabellones.TransferPabellon;
import negocio.pabellones.TransferPabellonComun;
import presentacion.notificaciones.Notificaciones;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Pablo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAPresosImp implements SAPresos {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param datos
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	public Notificaciones alta(TransferPreso datos) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		Notificaciones resultado = Notificaciones.ERROR;
		String DNI = datos.getDNI();
		DAOPresos DAOPresos = FactoriaDAO.getInstance().generarDAOPresos(); //Creo el dao de presos
		TransactionManager transactionManager = TransactionManager.getInstance(); //Creo el transaction Manager
		transactionManager.newTransaction(); //Creo la transaccion;
		Transaction transaction =transactionManager.getTransaction();
		
		transaction.start(); //Inicio la transaccion
		
		TransferPreso preso = DAOPresos.leerPorDNI(DNI); //Busco el preso
		//TransferCelda tc = FactoriaDAO.getInstance().generarDAOCeldas().leer(datos.getIdCelda());
		
		if(preso != null){	//Si el preso existe, comprobar estado
			if(preso.getEstado()){//Si ya esta activo
				resultado = Notificaciones.DOBLE_ALTA;
				transaction.rollback();
			}
			else{//Si el preso no esta activo, le cambiamos el estado
				resultado = Notificaciones.ALTA_EXISTENTE;
				preso.setEstado(true);
				DAOPresos.escribir(preso);
				transaction.commit();
			}
			
		}
		else{//Si el preso no existe
			//comprobar datos, si son incorrectos devolver -3
			int leng = DNI.length();
			if(leng==9 && datos.getNombre().length() > 0 && datos.getApellidos().length() > 0 && datos.getCondena().length() > 0 && datos.getEstado() == true){
				int id = DAOPresos.escribir(datos);
				Notificaciones.ALTA_CORRECTO.setNum(id);
				resultado = Notificaciones.ALTA_CORRECTO;
				transaction.commit();
			}
		}
		
		transactionManager.deleteTransaction(); //Va aqui porque hagas lo que hagas tienes que borrar la transacction despues.
		
		return resultado;
		// end-user-code
	}

	public Notificaciones baja(TransferEstancia tEstancia) {
		// begin-user-code
		Notificaciones resultado = Notificaciones.ERROR;
		DAOPresos daoPresos = FactoriaDAO.getInstance().generarDAOPresos();
		TransactionManager tm = TransactionManager.getInstance();
		tm.newTransaction();
		Transaction transaction = tm.getTransaction();
		transaction.start();
		
		int id_preso = tEstancia.getId_preso();
		
		TransferPreso preso = daoPresos.leer(tEstancia.getId_preso());
		TransferEstancia tEst = daoPresos.leerEstanciaActual(id_preso);
		
		if(preso != null){
			if(preso.getEstado()){//Si esta activo
				if(tEst != null){
					if (fechaCorrecta(tEst.getFecha_inicio(), tEstancia.getFecha_fin())){
						tEst.setFecha_fin(tEstancia.getFecha_fin());
						daoPresos.escribirEstancia(tEst);
					}
					else{
						transaction.rollback();
						tm.deleteTransaction();
						return Notificaciones.FECHA_INCORRECTA;
					}
				}
				preso.setEstado(false);
				int id = daoPresos.escribir(preso);
				Notificaciones.BAJA_CORRECTO.setNum(id);
				resultado = Notificaciones.BAJA_CORRECTO;
				transaction.commit();
			}
			else{//Si ya esta inactivo
				resultado = Notificaciones.DOBLE_BAJA;
				transaction.rollback();
			}
		}
		else{
			resultado = Notificaciones.PRESO_NO_EXISTENTE;
			transaction.rollback();
		}
		tm.deleteTransaction();
		
		return resultado;
		// end-user-code
	}

	public Notificaciones modificar(TransferPreso datos) {
		// begin-user-code

		Notificaciones resultado = Notificaciones.ERROR;
		DAOPresos daoPresos = FactoriaDAO.getInstance().generarDAOPresos();
		TransactionManager tm = TransactionManager.getInstance();
		tm.newTransaction();
		Transaction transaction = tm.getTransaction();
		transaction.start();

		TransferPreso presoAntiguo = daoPresos.leer(datos.getIdPreso());

		if (presoAntiguo != null){
			if (daoPresos.leerPorDNI(datos.getDNI()) == null || daoPresos.leerPorDNI(datos.getDNI()).getIdPreso() == presoAntiguo.getIdPreso()){
				datos.setEstado(presoAntiguo.getEstado());
				datos.setIdCelda(presoAntiguo.getIdCelda());
				
				int id = -1;
				id = daoPresos.escribir(datos);
				if (id != -1){
					Notificaciones.MODIFICAR_CORRECTO.setNum(id);
					resultado = Notificaciones.MODIFICAR_CORRECTO;
					transaction.commit();
				}
				else{
					transaction.rollback();
					resultado = Notificaciones.ERROR;
				}
			}
			else{
				transaction.rollback();
				resultado = Notificaciones.MISMO_DNI;
			}
		}
		else{
			transaction.rollback();
			resultado = Notificaciones.DATOS_ERRONEOS;
		}
		return resultado;
		// end-user-code
	}

	public ArrayList<TransferPreso> listar() {	
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		DAOPresos daoPresos = FactoriaDAO.getInstance().generarDAOPresos();
		ArrayList<TransferPreso> listaPresos = daoPresos.listar();
		
		return listaPresos;
		// end-user-code
	}

	public TransferPreso detalles(int idPreso) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		DAOPresos daoPresos = FactoriaDAO.getInstance().generarDAOPresos();
		TransferPreso preso = daoPresos.leer(idPreso);
		
		return preso;
		// end-user-code
	}

	@Override
	public Notificaciones asignarPresoACelda(TransferPreso tp) {
		Notificaciones resultado = null;
		// TODO Auto-generated method stub
		DAOPresos daoPresos = FactoriaDAO.getInstance().generarDAOPresos();
		DAOCeldas daoCeldas = FactoriaDAO.getInstance().generarDAOCeldas();
		DAOPabellones DAOpabellones = FactoriaDAO.getInstance().generarDAOPabellones();
		
		TransactionManager tm = TransactionManager.getInstance();
		tm.newTransaction();
		Transaction transaction = tm.getTransaction();
		transaction.start();
		
		int idPreso = tp.getIdPreso();
		int idCelda = tp.getIdCelda();
		TransferPreso preso = daoPresos.leer(idPreso);
		TransferCelda celda = daoCeldas.leer(idCelda);
		
		if(preso != null && celda != null && preso.getEstado() && celda.isEstado()){
			
			TransferEstancia tEstancia = new TransferEstancia(idCelda,idPreso,tp.getFechaInicio(idCelda));
			TransferEstancia tEstanciaAnterior = daoPresos.leerEstanciaActual(idPreso);
			
			ArrayList<TransferCelda> nr_presos_actual = daoCeldas.leerPresosPorCelda(idCelda);
			
			TransferPabellon tPabellon =  DAOpabellones.leer(celda.getIdPabellon());
			
			if(((nr_presos_actual.size() == 1 && tPabellon.getTipo().equalsIgnoreCase("aislamiento")) || (tPabellon.getTipo().equalsIgnoreCase("comun") && nr_presos_actual.size() == ((TransferPabellonComun) tPabellon).getTamanoCelda()))){
				if ((tEstanciaAnterior != null && tEstancia.getId_celda() != tEstanciaAnterior.getId_celda() && tEstancia.getId_preso() != tEstanciaAnterior.getId_preso()) || tEstanciaAnterior == null){
					transaction.rollback();
					tm.deleteTransaction();
					return Notificaciones.ASIGNACION_INCORRECTA_CELDA_LLENA;
				}
			}
			
			if(tEstanciaAnterior != null && tEstanciaAnterior.getFecha_fin() == null && 
					fechaCorrecta(tEstanciaAnterior.getFecha_inicio(), tEstancia.getFecha_inicio()) &&
					!tEstanciaAnterior.getFecha_inicio().equalsIgnoreCase(tEstancia.getFecha_inicio())){
					tEstanciaAnterior.setFecha_fin(tEstancia.getFecha_inicio());
					daoPresos.escribirEstancia(tEstanciaAnterior);
					daoPresos.escribirEstancia(tEstancia);
					resultado = Notificaciones.ASIGNACION_CORRECTA;
					transaction.commit();
			}
			else if (tEstanciaAnterior == null){
				daoPresos.escribirEstancia(tEstancia);
				resultado = Notificaciones.ASIGNACION_CORRECTA;
				transaction.commit();
			}
			else{
				transaction.rollback();
				tm.deleteTransaction();
				return Notificaciones.ASIGNACION_INCORRECTA;
			}
		}
		else{
			if(preso == null)
				resultado = Notificaciones.PRESO_NO_EXISTENTE;
			else if (celda == null)
				resultado = Notificaciones.CELDA_INEXISTENTE;
			else if (!preso.getEstado())
				resultado = Notificaciones.PRESO_NO_EXISTENTE;
			else if(!celda.isEstado())
				resultado = Notificaciones.CELDA_INEXISTENTE;
			transaction.rollback();
		}
		
		tm.deleteTransaction();
		
		
		return resultado;
	}

	@Override
	public ArrayList<TransferPreso> leerPresosPorCelda(TransferEstancia tEst) {
		// TODO Apéndice de método generado automáticamente
		DAOPresos daoP = FactoriaDAO.getInstance().generarDAOPresos();	
		
		if (!fechaCorrecta(tEst.getFecha_inicio(), tEst.getFecha_fin())){ return null; }
		
		int id_celda = tEst.getId_celda(); // Id de la celda de la que quiero informacion
		
		String fecha_inicio = tEst.getFecha_inicio();
		String fecha_fin = tEst.getFecha_fin();
		
		//Lista de los presos que han estado en esa celda en esas fechas
		ArrayList<TransferPreso> lista = daoP.leerPresosPorCeldaYfecha(id_celda,fecha_inicio,fecha_fin);

		return lista;
	}
	
	private boolean fechaCorrecta(String fechaAnterior, String fechaPosterior){
		
		 int añoAnterior = Integer.parseInt(fechaAnterior.split("/")[2]), 
			mesAnterior = Integer.parseInt(fechaAnterior.split("/")[1]), 
			diaAnterior = Integer.parseInt(fechaAnterior.split("/")[0]), 
			añoPosterior = Integer.parseInt(fechaPosterior.split("/")[2]), 
			mesPosterior = Integer.parseInt(fechaPosterior.split("/")[1]), 
			diaPosterior = Integer.parseInt(fechaPosterior.split("/")[0]);
		
		if(añoPosterior > añoAnterior){
			return true;
		}
		else if (añoPosterior == añoAnterior){
			if(mesPosterior > mesAnterior){
				return true;
			}
			else if (mesPosterior == mesAnterior){
				if(diaPosterior >= diaAnterior){
					return true;
				}
				else { return false; } 
			}
			else { return false; }
		}
		else{ return false; }
	}
	
}