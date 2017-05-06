package presentacion.controlador.comandos.presos;

import negocio.factoriaSA.FactoriaSA;
import negocio.presos.SAPresos;
import negocio.presos.TransferEstancia;
import presentacion.controlador.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.EventoNegocio;

public class BajaPresos implements Command {

	@Override
	public Contexto execute(Object datos) {
		SAPresos saPresos = FactoriaSA.getInstance().generarSAPresos();
		TransferEstancia preso = (TransferEstancia)datos;
		Object resultado = saPresos.baja(preso);
		return new Contexto(EventoNegocio.BAJA_PRESOS, resultado);
	}

}
