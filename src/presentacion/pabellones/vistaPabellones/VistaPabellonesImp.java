package presentacion.pabellones.vistaPabellones;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

public class VistaPabellonesImp extends VistaPabellones {
	private JButton AltaPabellon;
	private JButton BajaPabellon;
	private JButton ListarPabellones;
	private JButton ModificarPabellones;
	private JButton DetallesPabellon;
	private JButton PabellonesXCeldas;

	private JPanel panelPabellon;
	private JPanel panelSuperior;
	private JPanel panelCentral;

	public void initGUI() {
		panelSuperior();
		panelCentral();
		this.panelPabellon = new JPanel();
		this.panelPabellon.setOpaque(false);
		panelPabellon.setLayout(new BoxLayout(panelPabellon, BoxLayout.Y_AXIS));
		this.panelPabellon.add(this.panelSuperior);
		this.panelPabellon.add(this.panelCentral);
	}

	private void panelSuperior() {
		this.panelSuperior = new JPanel();
		panelSuperior.setOpaque(false);
		this.panelSuperior.setPreferredSize(new Dimension(550, 67));

		AltaPabellon = new JButton("Alta pabellon");
		BajaPabellon = new JButton("Baja pabellon");
		ModificarPabellones = new JButton("Modificar pabellon");
		DetallesPabellon = new JButton("Ver detalles pabellon");
		ListarPabellones = new JButton("Listar pabellones");
		PabellonesXCeldas = new JButton("Pabellones con tamaño de celda > x");

		panelSuperior.add(AltaPabellon);
		panelSuperior.add(BajaPabellon);
		panelSuperior.add(ModificarPabellones);
		panelSuperior.add(DetallesPabellon);
		panelSuperior.add(ListarPabellones);
		panelSuperior.add(PabellonesXCeldas);

		AltaPabellon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_ALTA_PABELLONES, null);
			}
		});
		BajaPabellon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_BAJA_PABELLONES, null);
			}
		});
		ModificarPabellones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_MODIFICAR_PABELLONES,
						null);
			}
		});
		DetallesPabellon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_DETALLES_PABELLONES,
						null);
			}
		});
		ListarPabellones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_LISTAR_PABELLONES, null);
			}
		});
		PabellonesXCeldas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_MOSTRAR_PABELLONES, null);
			}
		});

	}

	public void panelCentral() {
		this.panelCentral = new JPanel();
		panelCentral.setOpaque(false);
	}

	@Override
	public JPanel getPanel() {
		return this.panelPabellon;
	}

	@Override
	public void addPanelCentral(Component c) {
		this.panelCentral.add(c);
		this.panelCentral.updateUI();

	}
}
