package presentacion.controlador.comandos.presos;

import negocio.factoriaSA.FactoriaSA;
import negocio.presos.SAPresos;
import negocio.presos.TransferPreso;
import presentacion.controlador.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.EventoNegocio;

public class ModificarPresos implements Command {

	@Override
	public Contexto execute(Object datos) {
		SAPresos saPresos = FactoriaSA.getInstance().generarSAPresos();
		Object resultado = saPresos.modificar((TransferPreso) datos);
		return new Contexto(EventoNegocio.MODIFICAR_PRESOS,resultado);
	}

}
