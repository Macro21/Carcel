package presentacion.dispatcher;

import java.util.ArrayList;

import negocio.celdas.TransferCelda;
import negocio.pabellones.TransferPabellon;
import negocio.presos.TransferPreso;
import presentacion.celdas.alta.VistaAltaCeldas;
import presentacion.celdas.baja.VistaBajaCeldas;
import presentacion.celdas.detalles.VistaDetallesCeldas;
import presentacion.celdas.listar.VistaListarCeldas;
import presentacion.celdas.modificar.VistaModificarCeldas;
import presentacion.celdas.vistaCeldas.VistaCeldas;
import presentacion.controlador.Contexto;
import presentacion.notificaciones.Notificaciones;
import presentacion.pabellones.alta.VistaAltaPabellones;
import presentacion.pabellones.baja.VistaBajaPabellones;
import presentacion.pabellones.detalles.VistaDetallesPabellones;
import presentacion.pabellones.listar.VistaListarPabellones;
import presentacion.pabellones.modificar.VistaModificarPabellones;
import presentacion.pabellones.mostrarPabellones.VistaMostrarPabellones;
import presentacion.pabellones.vistaPabellones.VistaPabellones;
import presentacion.presos.alta.VistaAltaPresos;
import presentacion.presos.asignar.VistaAsignarCelda;
import presentacion.presos.baja.VistaBajaPresos;
import presentacion.presos.detalles.VistaDetallesPresos;
import presentacion.presos.listar.VistaListarPresos;
import presentacion.presos.modificar.VistaModificarPresos;
import presentacion.presos.mostrarPresosCelda.VistaMostrarPresos;
import presentacion.presos.vistaPresos.VistaPresos;
import presentacion.vistaPrincipal.VistaPrincipal;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DispatcherImp extends Dispatcher {

	@SuppressWarnings("unchecked")
	@Override
	public void actualizarVista(Contexto contexto) {

		if (VistaPrincipal.getInstance().getPanel() != null){
			VistaPrincipal.getInstance().getPanel().removeAll();
		}
		switch (contexto.getEvento()) {
		case ACTUALIZAR_VISTA_PRINCIPAL:
			VistaPrincipal.getInstance().initGUI();
			break;
		//CELDAS
		case ACTUALIZAR_VISTA_CELDAS:
			VistaCeldas.getInstance().initGUI();
			VistaPrincipal.getInstance().addPanelCentral(VistaCeldas.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_ALTA_CELDAS:
			VistaCeldas.getInstance().initGUI();
			VistaCeldas.getInstance().addPanelCentral(VistaAltaCeldas.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaCeldas.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_BAJA_CELDAS:
			VistaCeldas.getInstance().initGUI();
			VistaCeldas.getInstance().addPanelCentral(VistaBajaCeldas.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaCeldas.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_MODIFICAR_CELDAS:
			VistaCeldas.getInstance().initGUI();
			VistaCeldas.getInstance().addPanelCentral(VistaModificarCeldas.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaCeldas.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_DETALLES_CELDAS:
			VistaCeldas.getInstance().initGUI();
			VistaCeldas.getInstance().addPanelCentral(VistaDetallesCeldas.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaCeldas.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_LISTAR_CELDAS:
			VistaCeldas.getInstance().initGUI();
			VistaCeldas.getInstance().addPanelCentral(VistaListarCeldas.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaCeldas.getInstance().getPanel());
			break;
		case ALTA_CELDAS:
			VistaAltaCeldas.getInstance().update((Notificaciones) contexto.getDatos());
			break;
		case BAJA_CELDAS:
			VistaBajaCeldas.getInstance().update((Notificaciones) contexto.getDatos());
			break;
		case LISTAR_CELDAS:
			VistaListarCeldas.getInstance().update((ArrayList<TransferCelda>) contexto.getDatos());	
			break;
		case DETALLES_CELDAS:
			VistaDetallesCeldas.getInstance().update((TransferCelda) contexto.getDatos());
			break;
		case MODIFICAR_CELDAS:
			VistaModificarCeldas.getInstance().update((Notificaciones)contexto.getDatos());
			break;
		case DETALLES_MODIFICAR_CELDAS:
			VistaModificarCeldas.getInstance().update((TransferCelda) contexto.getDatos());
			break;
		//PRESOS
		case ACTUALIZAR_VISTA_PRESOS:
			VistaPresos.getInstance().initGUI();
			VistaPrincipal.getInstance().addPanelCentral(VistaPresos.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_ALTA_PRESOS:
			VistaPresos.getInstance().initGUI();
			VistaPresos.getInstance().addPanelCentral(VistaAltaPresos.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPresos.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_BAJA_PRESOS:
			VistaPresos.getInstance().initGUI();
			VistaPresos.getInstance().addPanelCentral(VistaBajaPresos.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPresos.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_DETALLES_PRESOS:
			VistaPresos.getInstance().initGUI();
			VistaPresos.getInstance().addPanelCentral(VistaDetallesPresos.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPresos.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_ASIGNAR_CELDA:
			VistaPresos.getInstance().initGUI();
			VistaPresos.getInstance().addPanelCentral(VistaAsignarCelda.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPresos.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_LISTAR_PRESOS:
			VistaPresos.getInstance().initGUI();
			VistaPresos.getInstance().addPanelCentral(VistaListarPresos.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPresos.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_MODIFICAR_PRESOS:
			VistaPresos.getInstance().initGUI();
			VistaPresos.getInstance().addPanelCentral(VistaModificarPresos.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPresos.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_MOSTRAR_PRESOS_CELDA:
			VistaPresos.getInstance().initGUI();
			VistaPresos.getInstance().addPanelCentral(VistaMostrarPresos.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPresos.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_MOSTRAR_CELDA:
			VistaPresos.getInstance().initGUI();
			VistaPresos.getInstance().addPanelCentral(VistaMostrarPresos.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPresos.getInstance().getPanel());
			break;
		case ALTA_PRESOS:
			VistaAltaPresos.getInstance().update((Notificaciones) contexto.getDatos());
			break;
		case BAJA_PRESOS:
			VistaBajaPresos.getInstance().update((Notificaciones) contexto.getDatos());
			break;
		case LISTAR_PRESOS:
			VistaListarPresos.getInstance().update((ArrayList<TransferPreso>) contexto.getDatos());	
			break;
		case DETALLES_PRESOS:
			VistaDetallesPresos.getInstance().update((TransferPreso) contexto.getDatos());
			break;
		case MODIFICAR_PRESOS:
			VistaModificarPresos.getInstance().update((Notificaciones)contexto.getDatos());
			break;
		case ASIGNAR_CELDA:
			VistaAsignarCelda.getInstance().update((Notificaciones)contexto.getDatos());
			break;
		case DETALLES_MODIFICAR_PRESOS:
			VistaModificarPresos.getInstance().update((TransferPreso) contexto.getDatos());
			break;
		//PABELLONES
		case ACTUALIZAR_VISTA_PABELLONES:
			VistaPabellones.getInstance().initGUI();
			VistaPrincipal.getInstance().addPanelCentral(VistaPabellones.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_ALTA_PABELLONES:
			VistaPabellones.getInstance().initGUI();
			VistaAltaPabellones.getInstance().initGUI();
			VistaPabellones.getInstance().addPanelCentral(VistaAltaPabellones.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPabellones.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_BAJA_PABELLONES:
			VistaPabellones.getInstance().initGUI();
			VistaBajaPabellones.getInstance().initGUI();
			VistaPabellones.getInstance().addPanelCentral(VistaBajaPabellones.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPabellones.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_DETALLES_PABELLONES:
			VistaPabellones.getInstance().initGUI();
			VistaPabellones.getInstance().addPanelCentral(VistaDetallesPabellones.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPabellones.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_LISTAR_PABELLONES:
			VistaPabellones.getInstance().initGUI();
			VistaListarPabellones.getInstance().initGUI();
			VistaPabellones.getInstance().addPanelCentral(VistaListarPabellones.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPabellones.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_MODIFICAR_PABELLONES:
			VistaPabellones.getInstance().initGUI();
			VistaPabellones.getInstance().addPanelCentral(VistaModificarPabellones.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPabellones.getInstance().getPanel());
			break;
		case ACTUALIZAR_VISTA_MOSTRAR_PABELLONES:
			VistaPabellones.getInstance().initGUI();
			VistaPabellones.getInstance().addPanelCentral(VistaMostrarPabellones.getInstance().getPanel());
			VistaPrincipal.getInstance().addPanelCentral(VistaPabellones.getInstance().getPanel());
			break;
		case ALTA_PABELLONES:
			VistaAltaPabellones.getInstance().update((Notificaciones) contexto.getDatos());
			break;
		case BAJA_PABELLONES:
			VistaBajaPabellones.getInstance().update((Notificaciones) contexto.getDatos());
			break;
		case MODIFICAR_PABELLONES:
			VistaModificarPabellones.getInstance().update((Notificaciones) contexto.getDatos());
			break;
		case DETALLES_PABELLONES:
			VistaDetallesPabellones.getInstance().update((TransferPabellon)contexto.getDatos());
			break;
		case LISTAR_PABELLONES:
			VistaListarPabellones.getInstance().update((ArrayList<TransferPabellon>) contexto.getDatos());
			break;
		case MOSTRAR_PABELLONES:
			VistaMostrarPabellones.getInstance().update((ArrayList<TransferPabellon>) contexto.getDatos());
			break;
		case DETALLES_MODIFICAR_PABELLONES:
			VistaModificarPabellones.getInstance().update((TransferPabellon) contexto.getDatos());
			break;
		case PRESOS_POR_CELDA:
			VistaMostrarPresos.getInstance().update((ArrayList<TransferPreso>)contexto.getDatos());
			break;
		
		}

	}
}