package presentacion.controlador.comandos.presos;

import negocio.factoriaSA.FactoriaSA;
import negocio.presos.SAPresos;
import negocio.presos.TransferPreso;
import presentacion.controlador.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.EventoNegocio;

public class DetallesPresos implements Command {

	@Override
	public Contexto execute(Object datos) {
		SAPresos saPresos = FactoriaSA.getInstance().generarSAPresos();
		TransferPreso preso = (TransferPreso)datos;
		Object resultado = saPresos.detalles(preso.getIdPreso());
		return new Contexto(EventoNegocio.DETALLES_PRESOS, resultado);
	}

}
