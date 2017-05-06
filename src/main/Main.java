package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.pool.OracleDataSource;
import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

public class Main {

	public final static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public final static String user = "ANONYMOUS";
	public final static String password = "pepe";
	public final static String ficheroCreaTablas = "creaTablas.sql";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		creaTablas();		
		Controlador.getInstance().accion(EventoNegocio.ACTUALIZAR_VISTA_PRINCIPAL, null);

	}
	
	private static void creaTablas(){
		try {
			File crearTablas = new File("creaTablas.sql");
			OracleDataSource ds = new OracleDataSource();
			ds.setURL(Main.URL);
			Connection c = ds.getConnection(Main.user, Main.password);
			Statement stm = c.createStatement();
			
			String linea="";
			String instruccion="";
			Scanner scan = new Scanner(crearTablas);
			while(scan.hasNext()){
				linea = scan.nextLine();
				if(!linea.equals(";"))
					instruccion += linea;
				else{
					try{ 
						stm.executeUpdate(instruccion); }
					catch(Exception e){ }
					instruccion="";
				}
			}
			scan.close();
			c.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}
		catch(SQLException e1){
		}
	}
}
