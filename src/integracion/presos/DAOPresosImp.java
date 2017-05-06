package integracion.presos;

import integracion.transactionManager.Transaction;
import integracion.transactionManager.TransactionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import main.Main;
import negocio.presos.TransferEstancia;
import negocio.presos.TransferPreso;
import oracle.jdbc.pool.OracleDataSource;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Pablo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOPresosImp implements DAOPresos {
	

	@Override
	public TransferPreso leer(int idPreso) {
		String leerPreso = "SELECT * FROM PRESOS WHERE ID_PRESO = "
				+ idPreso + " FOR UPDATE";
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
		TransferPreso tp = null;
		try {
			s = stm.executeQuery(leerPreso);
			if (s.next()) {
				tp = new TransferPreso(idPreso, s.getString("DNI"), s.getString("NOMBRE"), 
						s.getString("APELLIDOS"), s.getString("CONDENA"),
						s.getBoolean("ESTADO"));
			}
			if (tr == null)
				cn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return tp;
	}
	
	public int escribir(TransferPreso preso) {
		// TODO Auto-generated method stub
		int resultado =0;
		Statement stm = null;
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();
		
		if (tr != null){ cn = (Connection)tr.getResource(); }
		else{ cn = this.creaConexion(); }
		
		try { stm = cn.createStatement(); }
		catch (SQLException e1) { e1.printStackTrace(); }
		
		try{

			String insertarPreso="";
			
			if(preso.getIdPreso() > 0 && leer(preso.getIdPreso()) != null){
					insertarPreso = "UPDATE PRESOS SET DNI = '" + preso.getDNI() + "',NOMBRE = '" + preso.getNombre() + "'," +
					"APELLIDOS = '" + preso.getApellidos() + "',CONDENA = '" + preso.getCondena() + "'," + 
					"ESTADO = " + (preso.getEstado() ? 1 : 0 ) + " WHERE ID_PRESO = " + preso.getIdPreso();
			}
			else{
				preso.setIdPreso(generarID(stm));
				insertarPreso = "INSERT INTO PRESOS VALUES (" +
					    preso.getIdPreso() + ",'" +
						preso.getDNI() + "','" + 
						preso.getNombre() + "','" + 
						preso.getApellidos() + "','" + 
						preso.getCondena() + "'," +
						(preso.getEstado() ? 1 : 0 ) + ")";
			}

			stm.executeUpdate(insertarPreso);
			
			resultado = preso.getIdPreso();
			if (tr == null)
				cn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public int escribirEstancia(TransferEstancia tEstancia) {
		// TODO Auto-generated method stub
		int resultado =0;
		Statement stm = null;
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();
		
		if (tr != null){
			cn = (Connection)tr.getResource();
		}
		else{
			cn = this.creaConexion();
		}
		try {
			stm = cn.createStatement();
			int idPreso = tEstancia.getId_preso();
			String consulta = "";
			String fechaInicio =tEstancia.getFecha_inicio();
			String fechaFin =tEstancia.getFecha_fin();
		if(fechaFin != null){
			consulta = "update estancia set fecha_fin = to_date( '" + fechaFin + "') where id_preso = " + idPreso +"and id_celda = "+ tEstancia.getId_celda(); 
		}
		else
			consulta = "insert into estancia(id_Celda,id_preso,fecha_inicio) values(" + tEstancia.getId_celda() + "," + idPreso + ", to_date ( '" + fechaInicio+ "'))";		
			
			stm.executeUpdate(consulta);
			resultado = tEstancia.getId_preso();
			if (tr == null)
				cn.close();
		}catch(SQLException e){
			resultado =0;
		}
		
		return resultado;
	}

	private int generarID(Statement stm) {
		ResultSet s;
		int id=-1;
		try {
			s = stm.executeQuery("Select seq_presos_id_presos.nextval from dual");
			if(s.next())
				id = s.getInt("NEXTVAL");
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public ArrayList<TransferPreso> listar() {
		// TODO Auto-generated method stub
		String leerPresos = "SELECT * FROM PRESOS FOR UPDATE";
		ArrayList<TransferPreso> listaPresos = new ArrayList<>();
		Statement stm = null;
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();
		
		if(tr != null){
			cn = (Connection)tr.getResource();
		}
		else{
			cn = this.creaConexion();
		}
		
		try{
			stm = cn.createStatement();
		}catch(SQLException e){}
		
		ResultSet s = null;
		try{
			s = stm.executeQuery(leerPresos);
			while(s.next()){
				listaPresos.add(new TransferPreso(s.getInt("ID_PRESO"),s.getString("DNI"), s.getString("NOMBRE"), 
						s.getString("APELLIDOS"), s.getString("CONDENA"),
						s.getBoolean("ESTADO")));
			}
			if(tr == null)
				cn.close();
		}catch(SQLException e){}
		
		return listaPresos;
	}
	
	private Connection creaConexion(){
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
	public TransferPreso leerPorDNI(String DNI) {
		String leerPreso = "SELECT * FROM PRESOS WHERE DNI = '" + DNI + "'";
		Statement stm = null;
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();
		
		if(tr != null){
			cn = (Connection)tr.getResource();
		}
		else{
			cn = this.creaConexion();
		}
		
		try{
			stm = cn.createStatement();
		} catch(SQLException e1){}
		
		ResultSet s = null;
		TransferPreso tp = null;
		try{
			s = stm.executeQuery(leerPreso);
			if(s.next()){
				tp = new TransferPreso(s.getInt("ID_PRESO"),s.getString("DNI"), s.getString("NOMBRE"), 
						s.getString("APELLIDOS"), s.getString("CONDENA"),
						s.getBoolean("ESTADO"));
			}
			if (tr == null)
				cn.close();
		} catch(SQLException e) {}
		return tp;
	}
	
	public TransferEstancia leerEstanciaActual(int idPreso) {
		// TODO Apéndice de método generado automáticamente
		
		String leerCelda = "Select * from estancia where id_Preso = " + idPreso + "and fecha_fin is null";
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
		TransferEstancia transferEstancia = null;
		try {
			
			s = stm.executeQuery(leerCelda);
			if (s.next()) {
				transferEstancia = new TransferEstancia(s.getInt("id_celda"),s.getInt("id_preso"),convertirDate(s.getDate("fecha_inicio")));
			}
			if(tr == null)
				cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transferEstancia;
	}

	private String convertirDate(Date date){
		String fecha="";
		DateFormat fechaHora = new SimpleDateFormat("dd/MM/yy");
		fecha = fechaHora.format(date);
		
		return fecha;
	}
	
	public ArrayList<TransferPreso> leerPresosPorCeldaYfecha(int id_celda, String fecha_inicio,String fecha_fin) {
		// TODO Apéndice de método generado automáticamente
		Statement stm = null;
		ArrayList<TransferPreso> lista = new ArrayList<TransferPreso>();
		
		String consulta = "select * " +
				"from presos join estancia on presos.id_preso = estancia.id_preso " +
				"where estancia.id_celda = " + id_celda +" and ((fecha_fin between '" + fecha_inicio + "' and '" + fecha_fin+ "') " +
				"or (fecha_inicio between '"+fecha_inicio + "' and '" + fecha_fin+ "') " +
				"or ('" + fecha_inicio + "' between fecha_inicio and fecha_fin) " + 
				"or ('" + fecha_fin + "' between fecha_inicio and fecha_fin)" +
				"or (fecha_fin is null and '" + fecha_inicio + "' >= fecha_inicio))";
		Connection cn = null;
		Transaction tr = TransactionManager.getInstance().getTransaction();

		if (tr != null)
			cn = (Connection) tr.getResource();
		 else 
			cn = this.creaConexion();
		
		ResultSet s = null;
		try {
			stm = cn.createStatement();
			s = stm.executeQuery(consulta);
			while (s.next()) {
				lista.add(new TransferPreso(Integer.parseInt(s.getString("id_preso")), s.getString("DNI"),s.getString("Nombre")));
			}
			if(tr == null)
				cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
}