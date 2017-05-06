package presentacion.controlador.comandos.presos;

import java.util.ArrayList;

import negocio.factoriaSA.FactoriaSA;
import negocio.presos.SAPresos;
import negocio.presos.TransferPreso;
import presentacion.controlador.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.EventoNegocio;

public class ListarPresos implements Command {

	@Override
	public Contexto execute(Object datos) {
		SAPresos saPresos = FactoriaSA.getInstance().generarSAPresos();
		ArrayList<TransferPreso> preso = saPresos.listar();
		return new Contexto(EventoNegocio.LISTAR_PRESOS,preso);
	}

}
