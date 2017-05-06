package presentacion.controlador.comandos.actualizarVistas;

import presentacion.controlador.Command;
import presentacion.controlador.Contexto;
import presentacion.controlador.EventoNegocio;

public class VistaModificarPabellon implements Command {

	@Override
	public Contexto execute(Object datos) {
		return new Contexto(
				EventoNegocio.ACTUALIZAR_VISTA_MODIFICAR_PABELLONES, datos);
	}

}
