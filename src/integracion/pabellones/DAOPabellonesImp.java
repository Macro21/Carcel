/**
 * 
 */
package integracion.pabellones;

import integracion.transactionManager.Transaction;
import integracion.transactionManager.TransactionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.Main;
import negocio.pabellones.TransferPabellon;
import negocio.pabellones.TransferPabellonAislamiento;
import negocio.pabellones.TransferPabellonComun;
import oracle.jdbc.pool.OracleDataSource;

public class DAOPabellonesImp implements DAOPabellones {

	@Override
	public int escribir(TransferPabellon datos) {
		Statement stm = null;
		Connection cn = null;
		int id = -1;
		Transaction tr = TransactionManager.getInstance().getTransaction();

		if (tr != null) { cn = (Connection) tr.getResource(); } 
		else { cn = this.creaConexion(); }

		try { stm = cn.createStatement(); } 
		catch (SQLException e1) { e1.printStackTrace(); }
		
		try {
			String insertarPabellon = "";
			
			if (datos.getIdPabellon() > 0 && leer(datos.getIdPabellon()) != null) {	
				id = datos.getIdPabellon();
				insertarPabellon += "UPDATE PABELLONES SET " + "NOMBRE = '"
									+ datos.getNombre() + "'," + "ESTADO = "
									+ (datos.getEstado() ? 1 : 0) + "," 
									+ (datos.getTipo().equalsIgnoreCase("aislamiento") ? "NUM_VIGILANTES = " +  ((TransferPabellonAislamiento) datos).getNumVigilantes(): "TAMANO_CELDA = " + ((TransferPabellonComun) datos).getTamanoCelda()) 
									+ "," + "TIPO = '"
									+ datos.getTipo() + "'," + "NUM_MAX_CELDAS = "
									+ datos.getNumMaxCeldas()
									+ " WHERE ID_PABELLON = " + datos.getIdPabellon();
			}
			else {
				ResultSet rs = stm.executeQuery("Select seq_pabellones_id_pabellones.nextval from dual");
				if(rs.next()){
					id = rs.getInt("NEXTVAL");
				}
				insertarPabellon += "INSERT INTO PABELLONES " + "(ID_PABELLON, NOMBRE, ESTADO," + (datos.getTipo().equalsIgnoreCase("aislamiento") ? "NUM_VIGILANTES," : "TAMANO_CELDA,") + "TIPO, NUM_MAX_CELDAS)"
				+ " VALUES ("
									+ id + ",'"
									+ datos.getNombre() + "'," 
									+ (datos.getEstado() ? 1 : 0) + "," 
									+ (datos.getTipo().equalsIgnoreCase("aislamiento") ? ((TransferPabellonAislamiento) datos).getNumVigilantes(): ((TransferPabellonComun) datos).getTamanoCelda()) + ",'" 
									+ datos.getTipo() + "'," 
									+ datos.getNumMaxCeldas() + ")";
			}
			stm.executeUpdate(insertarPabellon);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (tr == null){ 
			try { cn.close(); } 
			catch (Exception e) {} 
		}
		return id;
	}

	@Override
	public TransferPabellon leer(int idPabellon) {
		String leerPabellon = "SELECT * FROM PABELLONES WHERE ID_PABELLON = "
				+ idPabellon + " FOR UPDATE";
		Statement stm = null;
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();

		if (tr != null) {
			cn = (Connection) tr.getResource();
		} else {
			cn = this.creaConexion();
		}

		try {
			stm = cn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ResultSet s = null;
		TransferPabellon tp = null;
		try {
			s = stm.executeQuery(leerPabellon);
			if (s.next()) {
				if (s.getString("TIPO").equalsIgnoreCase("aislamiento")){
					tp = new TransferPabellonAislamiento(s.getInt("ID_PABELLON"),
							s.getString("NOMBRE"), s.getBoolean("ESTADO"),
							s.getString("TIPO"), s.getInt("NUM_MAX_CELDAS"),
							s.getInt("NUM_VIGILANTES"));
				}
				else if (s.getString("TIPO").equalsIgnoreCase("comun")){
					tp = new TransferPabellonComun(s.getInt("ID_PABELLON"),
							s.getString("NOMBRE"), s.getBoolean("ESTADO"),
							s.getString("TIPO"), s.getInt("NUM_MAX_CELDAS"), 
							s.getInt("TAMANO_CELDA"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (tr == null){ 
			try { cn.close(); } 
			catch (Exception e) {} 
		}
		return tp;
	}

	public TransferPabellon leerPabellonPorNombre(String nombrePabellon) {
		// begin-user-code
		String leerPabellon = "select * from pabellones where nombre = '" +nombrePabellon +"' for update";
		Statement stm = null;
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();
		if (tr != null) {
			cn = (Connection) tr.getResource();
		} else {
			cn = this.creaConexion();
		}

		try {
			stm = cn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ResultSet s = null;
		TransferPabellon tp = null;
		try {
			s = stm.executeQuery(leerPabellon);
			if (s.next()) {
				if (s.getString("TIPO").equalsIgnoreCase("aislamiento")){
					tp = new TransferPabellonAislamiento(s.getInt("ID_PABELLON"),
							s.getString("NOMBRE"), s.getBoolean("ESTADO"),
							s.getString("TIPO"), s.getInt("NUM_MAX_CELDAS"),
							s.getInt("NUM_VIGILANTES"));
				}
				else if (s.getString("TIPO").equalsIgnoreCase("comun")){
					tp = new TransferPabellonComun(s.getInt("ID_PABELLON"),
							s.getString("NOMBRE"), s.getBoolean("ESTADO"),
							s.getString("TIPO"), s.getInt("NUM_MAX_CELDAS"), 
							s.getInt("TAMANO_CELDA"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (tr == null){ 
			try { cn.close(); } 
			catch (Exception e) {} 
		}
		return tp;
		// end-user-code
	}

	@Override
	public ArrayList<TransferPabellon> listar() {
		String leerPabellones = "SELECT * FROM PABELLONES ORDER BY ID_PABELLON FOR UPDATE";
		ArrayList<TransferPabellon> listaPab = new ArrayList<>();
		Statement stm = null;
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();

		if (tr != null) {
			cn = (Connection) tr.getResource();
		} else {
			cn = this.creaConexion();
		}

		try {
			stm = cn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ResultSet s = null;
		try {
			s = stm.executeQuery(leerPabellones);
			while (s.next()) {
				if (s.getString("TIPO").equalsIgnoreCase("aislamiento")){
					listaPab.add(new TransferPabellonAislamiento(s.getInt("ID_PABELLON"),
							s.getString("NOMBRE"), s.getBoolean("ESTADO"),
							s.getString("TIPO"), s.getInt("NUM_MAX_CELDAS"),
							s.getInt("NUM_VIGILANTES")));
				}
				else if (s.getString("TIPO").equalsIgnoreCase("comun")){
					listaPab.add(new TransferPabellonComun(s.getInt("ID_PABELLON"),
							s.getString("NOMBRE"), s.getBoolean("ESTADO"),
							s.getString("TIPO"), s.getInt("NUM_MAX_CELDAS"), 
							s.getInt("TAMANO_CELDA")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (tr == null){ 
			try { cn.close(); } 
			catch (Exception e) {} 
		}
		return listaPab;
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
	public ArrayList<TransferPabellon> listarXPabellones(int num) {
		String leerPabellones = "SELECT * FROM PABELLONES " + "WHERE TAMANO_CELDA > " + num + " ORDER BY ID_PABELLON FOR UPDATE";
		ArrayList<TransferPabellon> listaPab = new ArrayList<>();
		Statement stm = null;
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();

		if (tr != null) {
			cn = (Connection) tr.getResource();
		} else {
			cn = this.creaConexion();
		}

		try {
			stm = cn.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ResultSet s = null;
		try {
			s = stm.executeQuery(leerPabellones);
			while (s.next()) {
				if (s.getString("TIPO").equalsIgnoreCase("comun")){
					listaPab.add(new TransferPabellonComun(s.getInt("ID_PABELLON"),
							s.getString("NOMBRE"), s.getBoolean("ESTADO"),
							s.getString("TIPO"), s.getInt("NUM_MAX_CELDAS"), 
							s.getInt("TAMANO_CELDA")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (tr == null){ 
			try { cn.close(); } 
			catch (Exception e) {} 
		}
		return listaPab;
	}

}