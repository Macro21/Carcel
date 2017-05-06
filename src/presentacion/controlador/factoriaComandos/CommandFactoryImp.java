/**
 * 
 */
package presentacion.controlador.factoriaComandos;

import presentacion.controlador.Command;
import presentacion.controlador.EventoNegocio;
import presentacion.controlador.comandos.actualizarVistas.VistaAltaCelda;
import presentacion.controlador.comandos.actualizarVistas.VistaAltaPabellon;
import presentacion.controlador.comandos.actualizarVistas.VistaAltaPreso;
import presentacion.controlador.comandos.actualizarVistas.VistaAsignarCelda;
import presentacion.controlador.comandos.actualizarVistas.VistaBajaCelda;
import presentacion.controlador.comandos.actualizarVistas.VistaBajaPabellon;
import presentacion.controlador.comandos.actualizarVistas.VistaBajaPreso;
import presentacion.controlador.comandos.actualizarVistas.VistaCeldas;
import presentacion.controlador.comandos.actualizarVistas.VistaDetallesCelda;
import presentacion.controlador.comandos.actualizarVistas.VistaDetallesPabellon;
import presentacion.controlador.comandos.actualizarVistas.VistaDetallesPreso;
import presentacion.controlador.comandos.actualizarVistas.VistaListarCeldas;
import presentacion.controlador.comandos.actualizarVistas.VistaListarPabellones;
import presentacion.controlador.comandos.actualizarVistas.VistaListarPresos;
import presentacion.controlador.comandos.actualizarVistas.VistaModificarCelda;
import presentacion.controlador.comandos.actualizarVistas.VistaModificarPabellon;
import presentacion.controlador.comandos.actualizarVistas.VistaModificarPreso;
import presentacion.controlador.comandos.actualizarVistas.VistaMostrarCelda;
import presentacion.controlador.comandos.actualizarVistas.VistaMostrarPabellon;
import presentacion.controlador.comandos.actualizarVistas.VistaMostrarPresosCelda;
import presentacion.controlador.comandos.actualizarVistas.VistaPabellones;
import presentacion.controlador.comandos.actualizarVistas.VistaPresos;
import presentacion.controlador.comandos.actualizarVistas.VistaPrincipal;
import presentacion.controlador.comandos.celdas.AltaCeldas;
import presentacion.controlador.comandos.celdas.BajaCeldas;
import presentacion.controlador.comandos.celdas.DetallesCeldas;
import presentacion.controlador.comandos.celdas.DetallesModificar;
import presentacion.controlador.comandos.celdas.ListarCeldas;
import presentacion.controlador.comandos.celdas.ModificarCeldas;
import presentacion.controlador.comandos.pabellones.AltaPabellones;
import presentacion.controlador.comandos.pabellones.BajaPabellones;
import presentacion.controlador.comandos.pabellones.DetallesModificarPabellones;
import presentacion.controlador.comandos.pabellones.DetallesPabellones;
import presentacion.controlador.comandos.pabellones.ListarPabellones;
import presentacion.controlador.comandos.pabellones.ModificarPabellones;
import presentacion.controlador.comandos.pabellones.MostrarPabellones;
import presentacion.controlador.comandos.presos.AltaPresos;
import presentacion.controlador.comandos.presos.AsignarCelda;
import presentacion.controlador.comandos.presos.BajaPresos;
import presentacion.controlador.comandos.presos.DetallesModificarPresos;
import presentacion.controlador.comandos.presos.DetallesPresos;
import presentacion.controlador.comandos.presos.ListarPresos;
import presentacion.controlador.comandos.presos.ModificarPresos;
import presentacion.controlador.comandos.presos.PresosPorCelda;
/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CommandFactoryImp extends CommandFactory {

	@Override
	public Command getCommand(EventoNegocio evento) {
		Command command = null;
		switch (evento) {
		//CELDAS
		case ACTUALIZAR_VISTA_PRINCIPAL:
			command = new VistaPrincipal();
			break;
		case ACTUALIZAR_VISTA_CELDAS:
			command = new VistaCeldas();
			break;
		case ACTUALIZAR_VISTA_ALTA_CELDAS:
			command = new VistaAltaCelda();
			break;
		case ACTUALIZAR_VISTA_BAJA_CELDAS:
			command = new VistaBajaCelda();
			break;
		case ACTUALIZAR_VISTA_MODIFICAR_CELDAS:
			command = new VistaModificarCelda();
			break;
		case ACTUALIZAR_VISTA_DETALLES_CELDAS:
			command = new VistaDetallesCelda();
			break;
		case ACTUALIZAR_VISTA_LISTAR_CELDAS:
			command = new VistaListarCeldas();
			break;
		case ALTA_CELDAS:
			command = new AltaCeldas();
			break;
		case BAJA_CELDAS:
			command = new BajaCeldas();
			break;
		case MODIFICAR_CELDAS:
			command = new ModificarCeldas();
			break;
		case LISTAR_CELDAS:
			command = new ListarCeldas();
			break;
		case DETALLES_CELDAS:
			command = new DetallesCeldas();
			break;
		case DETALLES_MODIFICAR_CELDAS:
			command = new DetallesModificar();
			break;
		//PABELLONES
		case ACTUALIZAR_VISTA_PABELLONES:
			command = new VistaPabellones();
			break;
		case ACTUALIZAR_VISTA_ALTA_PABELLONES:
			command = new VistaAltaPabellon();
			break;
		case ACTUALIZAR_VISTA_BAJA_PABELLONES:
			command = new VistaBajaPabellon();
			break;
		case ACTUALIZAR_VISTA_DETALLES_PABELLONES:
			command = new VistaDetallesPabellon();
			break;
		case ACTUALIZAR_VISTA_LISTAR_PABELLONES:
			command = new VistaListarPabellones();
			break;
		case ACTUALIZAR_VISTA_MODIFICAR_PABELLONES:
			command = new VistaModificarPabellon();
			break;
		case ACTUALIZAR_VISTA_MOSTRAR_PABELLONES:
			command = new VistaMostrarPabellon();
			break;
		case ALTA_PABELLONES:
			command = new AltaPabellones();
			break;
		case BAJA_PABELLONES:
			command = new BajaPabellones();
			break;
		case MODIFICAR_PABELLONES:
			command = new ModificarPabellones();
			break;
		case LISTAR_PABELLONES:
			command = new ListarPabellones();
			break;
		case DETALLES_PABELLONES:
			command = new DetallesPabellones();
			break;
		case MOSTRAR_PABELLONES:
			command = new MostrarPabellones();
			break;
		case DETALLES_MODIFICAR_PABELLONES:
			command = new DetallesModificarPabellones();
			break;
		//PRESOS
		case ACTUALIZAR_VISTA_PRESOS:
			command = new VistaPresos();
			break;
		case ACTUALIZAR_VISTA_ALTA_PRESOS:
			command = new VistaAltaPreso();
			break;
		case ACTUALIZAR_VISTA_ASIGNAR_CELDA:
			command = new VistaAsignarCelda();
			break;
		case ACTUALIZAR_VISTA_BAJA_PRESOS:
			command = new VistaBajaPreso();
			break;
		case ACTUALIZAR_VISTA_DETALLES_PRESOS:
			command = new VistaDetallesPreso();
			break;
		case ACTUALIZAR_VISTA_LISTAR_PRESOS:
			command = new VistaListarPresos();
			break;
		case ACTUALIZAR_VISTA_MODIFICAR_PRESOS:
			command = new VistaModificarPreso();
			break;
		case ACTUALIZAR_VISTA_MOSTRAR_CELDA:
			command = new VistaMostrarCelda();
			break;
		case ALTA_PRESOS:
			command = new AltaPresos();
		break;
		case BAJA_PRESOS:
			command = new BajaPresos();
		break;
		case MODIFICAR_PRESOS:
			command = new ModificarPresos();
		break;
		case DETALLES_PRESOS:
			command = new DetallesPresos();
		break;
		case LISTAR_PRESOS:
			command = new ListarPresos();
		break;
		case ASIGNAR_CELDA:
			command = new AsignarCelda();
		break;
		case PRESOS_POR_CELDA:
			command = new PresosPorCelda();
		break;
		case DETALLES_MODIFICAR_PRESOS:
			command = new DetallesModificarPresos();
			break;
		case ACTUALIZAR_VISTA_MOSTRAR_PRESOS_CELDA:
			command = new VistaMostrarPresosCelda();
			break;
		}
		return command;
	}
}