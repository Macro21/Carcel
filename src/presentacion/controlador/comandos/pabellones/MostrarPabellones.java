package presentacion.controlador.comandos.pabellones;

import negocio.factoriaSA.FactoriaSA;
import negocio.pabellones.SAPabellones;
import presentacion.controlador.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.EventoNegocio;

public class MostrarPabellones implements Command {

	@Override
	public Contexto execute(Object datos) {
		SAPabellones SApabellones = FactoriaSA.getInstance()
				.generarSAPabellones();
		return new Contexto(EventoNegocio.MOSTRAR_PABELLONES, SApabellones.mostrarPabellones((int) datos));
	}

}
