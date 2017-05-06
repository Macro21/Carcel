package presentacion.controlador.comandos.presos;

import negocio.factoriaSA.FactoriaSA;
import negocio.presos.SAPresos;
import negocio.presos.TransferPreso;
import presentacion.controlador.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.EventoNegocio;

public class AsignarCelda implements Command {

	@Override
	public Contexto execute(Object datos) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		SAPresos s = FactoriaSA.getInstance().generarSAPresos();
		Contexto contexto = new Contexto(EventoNegocio.ASIGNAR_CELDA, s.asignarPresoACelda((TransferPreso) datos));
		return contexto;
	}

}
