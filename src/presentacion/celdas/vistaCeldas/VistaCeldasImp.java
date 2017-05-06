package presentacion.celdas.vistaCeldas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

public class VistaCeldasImp extends VistaCeldas {

	private JButton AltaCelda;
	private JButton BajaCelda;
	private JButton ListarCeldas;
	private JButton ModificarCelda;
	private JButton DetallesCelda;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JPanel panelSuperior;
	private JPanel panelCentral;
	private JPanel panelCeldas;

	public void initGUI() {
		panelSuperior();
		panelCentral();
		this.panelCeldas = new JPanel();
		this.panelCeldas.setOpaque(false);
		panelCeldas.setLayout(new BoxLayout(panelCeldas, BoxLayout.Y_AXIS));
		this.panelCeldas.add(this.panelSuperior);
		this.panelCeldas.add(this.panelCentral);
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaCeldasImp() {
		// begin-user-code
		// TODO Apéndice de constructor generado automáticamente
		// end-user-code
	}

	private void panelSuperior() {
		this.panelSuperior = new JPanel();
		panelSuperior.setOpaque(false);

		AltaCelda = new JButton("Alta");
		BajaCelda = new JButton("Baja");
		ModificarCelda = new JButton("Modificar");
		DetallesCelda = new JButton("Ver detalles");
		ListarCeldas = new JButton("Listar celdas");

		panelSuperior.add(AltaCelda);
		panelSuperior.add(BajaCelda);
		panelSuperior.add(ModificarCelda);
		panelSuperior.add(DetallesCelda);
		panelSuperior.add(ListarCeldas);

		AltaCelda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_ALTA_CELDAS, null);
			}
		});
		BajaCelda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_BAJA_CELDAS, null);
			}
		});
		ModificarCelda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_MODIFICAR_CELDAS, null);
			}
		});
		DetallesCelda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_DETALLES_CELDAS, null);
			}
		});
		ListarCeldas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(EventoNegocio.LISTAR_CELDAS, null);
				Controlador.getInstance().accion(EventoNegocio.ACTUALIZAR_VISTA_LISTAR_CELDAS, null);
				
			}
		});
	}

	private void panelCentral() {
		this.panelCentral = new JPanel();
		panelCentral.setOpaque(false);
	}

	@Override
	public JPanel getPanel() {
		return this.panelCeldas;
	}

	@Override
	public void addPanelCentral(Component c) {
		this.panelCentral.add(c);
		this.panelCentral.updateUI();

	}
	
}
