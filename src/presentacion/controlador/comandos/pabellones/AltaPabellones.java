package presentacion.controlador.comandos.pabellones;

import negocio.factoriaSA.FactoriaSA;
import negocio.pabellones.SAPabellones;
import negocio.pabellones.TransferPabellon;
import presentacion.controlador.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.EventoNegocio;

public class AltaPabellones implements Command {

	@Override
	public Contexto execute(Object datos) {
		SAPabellones SApabellones = FactoriaSA.getInstance()
				.generarSAPabellones();
		return new Contexto(EventoNegocio.ALTA_PABELLONES, SApabellones.alta((TransferPabellon) datos));
	}

}
