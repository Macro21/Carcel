package presentacion.controlador.comandos.celdas;

import negocio.celdas.SACeldas;
import negocio.celdas.TransferCelda;
import negocio.factoriaSA.FactoriaSA;
import presentacion.controlador.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.EventoNegocio;

public class DetallesModificar implements Command  {

	@Override
	public Contexto execute(Object datos) {
		SACeldas s = FactoriaSA.getInstance().generarSACeldas();
		TransferCelda tCelda = (TransferCelda) datos;
		TransferCelda tDetalles = s.detalles(tCelda.getIdCelda());
		return new Contexto(EventoNegocio.DETALLES_MODIFICAR_CELDAS,tDetalles);
	}

}
