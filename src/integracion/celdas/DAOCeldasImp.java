/**
 * 
 */
package integracion.celdas;

import integracion.transactionManager.Transaction;
import integracion.transactionManager.TransactionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.Main;
import negocio.celdas.TransferCelda;
import oracle.jdbc.pool.OracleDataSource;

public class DAOCeldasImp implements DAOCeldas {

	@Override
	public int escribir(TransferCelda datos) {
		Statement stm = null;

		Transaction tr = TransactionManager.getInstance().getTransaction();
		Connection cn = null;
		int resultado = 0; //El error que sea

		if (tr != null) {
			cn = (Connection) tr.getResource();
		} 
		else if (tr == null) {
			cn = creaConexion();
		}

		try {

			stm = cn.createStatement();
			//Si me llega un transfer con estado a false es que tengo que activatr una celda
			if (!datos.isEstado()) { //Si la celda ya existe y esta dada de baja
				String activarCelda = "Update Celdas set estado = 1 where ID_CELDA ="
						+ datos.getIdCelda();
				stm.executeUpdate(activarCelda);
			}
			else {//Si la celda no existe y no esta dada de baja, doy una nueva de alta
				int idC = generarID(stm);
					String escribirCelda =
							"Insert into Celdas values ("
							+ idC + ",'" + datos.getIdPabellon()
							+ "'," + datos.getNrCelda() + "," + conversorInt(datos.isTelevision())
							+ "," + conversorInt(datos.isDucha()) + "," + "1)";
				stm.executeUpdate(escribirCelda);
				resultado = idC;
			}
			if(tr == null)
				cn.close();

		} catch (SQLException e1) {
		}
		return resultado;
	}

	private int generarID(Statement stm){
		ResultSet s;
		int id=-1;
		try {
			s = stm.executeQuery("Select seq_celdas_id_celda.nextval from dual");
			if(s.next())
				id = s.getInt("NEXTVAL");
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return id;
	}
	
	@Override
	public TransferCelda leer(int idCelda) {
		// TODO Apéndice de método generado automáticamente
		Statement stm = null;

		String leerCelda = "select * from celdas where id_celda = " + idCelda + " FOR UPDATE";
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();

		if (tr != null) {
			cn = (Connection) tr.getResource();
		} else {
			cn = creaConexion();
		}
		ResultSet s = null;
		TransferCelda transferCelda = null;
		try {
			stm = cn.createStatement();
			s = stm.executeQuery(leerCelda);
			if (s.next()) {
				transferCelda = new TransferCelda(s.getInt("id_celda"),s.getInt("id_pabellon"),s.getInt("num_celda"),conversorBool(s.getInt("television")),conversorBool(s.getInt("ducha")),
						conversorBool(s.getInt("estado")));
			}
			if(tr == null)
				cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transferCelda;
	}
	
	private boolean conversorBool(int dato){
		boolean resultado =false;
		if(dato ==1)
			resultado =true;
		return resultado;
	}
	
	private int conversorInt(boolean dato){
		int resultado = 0;
		if(dato == true)
			resultado=1;
		return resultado;
	}
	
	@Override
	public TransferCelda leerCeldaPorNumeroYPabellon(int numCelda, int numPab, int id_celda) {
		Statement stm = null;

		String leerCeldaPorNumero = "select * from celdas where num_celda = " + numCelda + " and id_pabellon = " + numPab +"and id_celda <>"+id_celda + " FOR UPDATE";
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();

		if (tr != null) {
			cn = (Connection) tr.getResource();
		} else {
			cn = creaConexion();
		}
		ResultSet s = null;
		TransferCelda transferCelda = null;
		try {
			stm = cn.createStatement();
			stm = cn.prepareStatement(leerCeldaPorNumero,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			s = stm.executeQuery(leerCeldaPorNumero);
			if (s.next()) {
				transferCelda = new TransferCelda(s.getInt("id_celda"),s.getInt("id_pabellon"),s.getInt("num_celda"),conversorBool(s.getInt("television")),conversorBool(s.getInt("ducha")),
						conversorBool(s.getInt("estado")));
			}
			if(tr == null)
				cn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return transferCelda;
	}

	private Connection creaConexion() {
		Connection c = null;
		OracleDataSource ds = null;
		try {
			ds = new OracleDataSource();
			ds.setURL(Main.URL);
			c = ds.getConnection(Main.user, Main.password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public ArrayList<TransferCelda> listar() {
		// TODO Apéndice de método generado automáticamente
		Statement stm = null;
		String leerCeldas = "select * from celdas order by id_celda,id_pabellon for update";
		ArrayList<TransferCelda> listaCeldas = new ArrayList<>();
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();

		if (tr != null) {
			cn = (Connection) tr.getResource();
		} else {
			cn = creaConexion();
		}

		ResultSet s = null;
		try {
			stm = cn.createStatement();
			s = stm.executeQuery(leerCeldas);
			while (s.next()) {
				listaCeldas.add(new TransferCelda(
						s.getInt("ID_CELDA"),s.getInt("ID_PABELLON"),
						s.getInt("NUM_CELDA"),conversorBool(s.getInt("TELEVISION")),
						conversorBool(s.getInt("DUCHA")),conversorBool(s.getInt("ESTADO"))
				));
			}
			if(tr == null)
				cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCeldas;
	}
	
	public int updateCelda(TransferCelda tCelda, int opcion){
		Statement stm = null;
		int resultado =0;
		String consulta ="";
		if(opcion == 1)//modificar Celda sin cambiar el estado
			consulta = "update celdas set id_pabellon = '" + tCelda.getIdPabellon()+
				"', num_celda= " + tCelda.getNrCelda() + ", television = " + conversorInt(tCelda.isTelevision()) + ", ducha = "+
				conversorInt(tCelda.isDucha()) + " where id_celda =" + tCelda.getIdCelda();
		else if (opcion ==0){
			consulta = "update celdas set id_pabellon = '" + tCelda.getIdPabellon()+
					"', num_celda= " + tCelda.getNrCelda() + ", television = " + conversorInt(tCelda.isTelevision()) + ", ducha = "+
					conversorInt(tCelda.isDucha()) + ", estado = 0" + " where id_celda =" + tCelda.getIdCelda();
		}
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();
			if (tr != null) {
			cn = (Connection) tr.getResource();
		} else {
			cn = creaConexion();
		}
		
		try {
			stm = cn.createStatement();
			stm.executeUpdate(consulta);
			if(tr == null)
				cn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		resultado = tCelda.getIdCelda();
	
	return resultado;
}

	@Override
	public int contarCeldas(int idPabellon) {
		// TODO Apéndice de método generado automáticamente
		Statement stm = null;

		String consulta = "select count(*) AS NR_CELDAS from celdas where id_pabellon = " +idPabellon;
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();
		int resultado = 0;
		if (tr != null)
			cn = (Connection) tr.getResource();
		
		else 
			cn = creaConexion();
		
		ResultSet s = null;
		try {
			stm = cn.createStatement();
			s = stm.executeQuery(consulta);
			if (s.next()) 
				resultado = s.getInt("NR_CELDAS");
			
			if (tr == null)
				cn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public boolean todasCeldasInactivas(int idPabellon) {
		// TODO Apéndice de método generado automáticamente
		Statement stm = null;
		String consulta = "select count(*) AS NR_CELDAS from celdas where id_pabellon = " + idPabellon + " and estado = 1";
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();
		int resultado = 0;
		if (tr != null) 
			cn = (Connection) tr.getResource();
		else 
			cn = creaConexion();
		
		ResultSet s = null;
		try {
			stm = cn.createStatement();
			s = stm.executeQuery(consulta);
			if (s.next()) {
				resultado = s.getInt("NR_CELDAS");
			}
			if (tr == null)
				cn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado > 0 ? false : true;
	}
	
	public ArrayList<TransferCelda> leerPresosPorCelda(int idCelda){
		Statement stm = null;

		String presosPorCelda = "select * from estancia where id_celda = "+idCelda +"and fecha_fin is null";//Tengo las celdas con presos
		ArrayList<TransferCelda> listaCeldas = new ArrayList<>();
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();

		if (tr != null) {
			cn = (Connection) tr.getResource();
		} else {
			cn = creaConexion();
		}

		ResultSet s = null;
		try {
			stm = cn.createStatement();
			s = stm.executeQuery(presosPorCelda);
			while (s.next()) {
				listaCeldas.add(new TransferCelda(s.getInt("id_celda")));
			}
			if(tr == null)
				cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCeldas;
	}

}