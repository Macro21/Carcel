package presentacion.controlador.comandos.presos;

import java.util.ArrayList;

import negocio.factoriaSA.FactoriaSA;
import negocio.presos.SAPresos;
import negocio.presos.TransferEstancia;
import negocio.presos.TransferPreso;
import presentacion.controlador.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.EventoNegocio;


public class PresosPorCelda implements Command {

	@Override
	public Contexto execute(Object datos) {
		// TODO Apéndice de método generado automáticamente
		SAPresos s = FactoriaSA.getInstance().generarSAPresos();
		TransferEstancia tEst = (TransferEstancia) datos;
		ArrayList<TransferPreso> lista = s.leerPresosPorCelda(tEst);
		return new Contexto(EventoNegocio.PRESOS_POR_CELDA,lista);
	}

}
