/**
 * 
 */
package integracion.transactionManager;

import java.sql.Connection;
import java.sql.SQLException;

import main.Main;
import oracle.jdbc.pool.OracleDataSource;

public class TransactionSQLDeveloper implements Transaction {

	private Connection connection;

	public TransactionSQLDeveloper() {
		this.connection = OracleDataSourceConnection();
	}

	private Connection OracleDataSourceConnection() {
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

	public Object getResource() {
		return this.connection;
	}

	public void start() {
		try {
			this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void commit() {
		try {
			this.connection.commit();
		} catch (SQLException e) {
			System.out
					.println("Error al hacer commit, clase transactionsqldeveloper!!!!!");
		}
	}

	public void rollback() {
		try {
			this.connection.rollback();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}

}