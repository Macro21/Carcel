package negocio.pabellones;

public class TransferPabellonComun extends TransferPabellon {

	private int tamanoCelda;
	
	public TransferPabellonComun(int idPabellon, String nombre, boolean estado, String tipo, int numMaxCeldas, int tamanoCelda) {
		super(idPabellon, nombre, estado, tipo, numMaxCeldas);
		this.tamanoCelda = tamanoCelda;
	}

	public TransferPabellonComun(String nombre, boolean estado, String tipo, int numMaxCeldas, int tamanoCelda) {
		super(nombre, estado, tipo, numMaxCeldas);
		this.tamanoCelda = tamanoCelda;
	}

	public int getTamanoCelda() {
		return tamanoCelda;
	}
	public void setTamanoCelda(int tamanoCelda) {
		this.tamanoCelda = tamanoCelda;
	}

}
