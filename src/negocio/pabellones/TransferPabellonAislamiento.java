package negocio.pabellones;

public class TransferPabellonAislamiento extends TransferPabellon {

	private int numVigilantes;
	
	public TransferPabellonAislamiento(int idPabellon, String nombre, boolean estado, String tipo, int numMaxCeldas, int nVigilantes) {
		super(idPabellon, nombre, estado, tipo, numMaxCeldas);
		this.numVigilantes = nVigilantes;
	}

	public TransferPabellonAislamiento(String nombre, boolean estado, String tipo, int numMaxCeldas, int nVigilantes) {
		super(nombre, estado, tipo, numMaxCeldas);
		this.numVigilantes = nVigilantes;
	}

	public int getNumVigilantes() {
		return numVigilantes;
	}
	public void setNumVigilantes(int numVigilantes) {
		this.numVigilantes = numVigilantes;
	}

}
