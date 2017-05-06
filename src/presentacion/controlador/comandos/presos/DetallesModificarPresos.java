package presentacion.controlador.comandos.presos;

import negocio.factoriaSA.FactoriaSA;
import negocio.presos.SAPresos;
import negocio.presos.TransferPreso;
import presentacion.controlador.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.EventoNegocio;

public class DetallesModificarPresos implements Command {

	@Override
	public Contexto execute(Object datos) {
		SAPresos SApresos = FactoriaSA.getInstance().generarSAPresos();
		TransferPreso d = (TransferPreso) datos;
		TransferPreso tDetalles = SApresos.detalles(d.getIdPreso());
		return new Contexto(EventoNegocio.DETALLES_MODIFICAR_PRESOS,tDetalles);
	}

}
