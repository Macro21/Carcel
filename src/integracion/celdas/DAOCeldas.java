/**
 * 
 */
package integracion.celdas;

import java.util.ArrayList;

import negocio.celdas.TransferCelda;

public interface DAOCeldas {

	public int escribir(TransferCelda datos);

	public TransferCelda leer(int idCelda);

	public TransferCelda leerCeldaPorNumeroYPabellon(int numCelda, int idPab,int id_celda);

	public ArrayList<TransferCelda> listar();

	public int updateCelda(TransferCelda datos, int opcion);

	public int contarCeldas(int idPabellon);

	public boolean todasCeldasInactivas(int idPabellon);
	
	public ArrayList<TransferCelda> leerPresosPorCelda(int idCelda);
	
}