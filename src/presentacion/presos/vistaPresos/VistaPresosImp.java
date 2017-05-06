package presentacion.presos.vistaPresos;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

public class VistaPresosImp extends VistaPresos {
	private JButton AltaPreso;
	private JButton BajaPreso;
	private JButton ListarPresos;
	private JButton ModificarPreso;
	private JButton DetallesPreso;
	private JButton AsignarCelda;
	private JButton MostrarPresosCelda;
	private JPanel panelPresos;
	private JPanel panelSuperior;
	private JPanel panelCentral;

	public void initGUI() {
		panelSuperior();
		panelCentral();
		this.panelPresos = new JPanel();
		this.panelPresos.setOpaque(false);
		panelPresos.setLayout(new BoxLayout(panelPresos, BoxLayout.Y_AXIS));
		this.panelPresos.add(this.panelSuperior);
		this.panelPresos.add(this.panelCentral);
	}

	private void panelSuperior() {
		this.panelSuperior = new JPanel();
		//this.panelSuperior.setBackground(Color.black);
		this.panelSuperior.setOpaque(false);
		this.panelSuperior.setPreferredSize(new Dimension(550, 67));
		// Los demas paneles dimension: (550, 398)

		AltaPreso = new JButton("Alta preso");
		BajaPreso = new JButton("Baja preso");
		ModificarPreso = new JButton("Modificar preso");
		DetallesPreso = new JButton("Ver detalles preso");
		ListarPresos = new JButton("Listar presos");
		AsignarCelda = new JButton("Asignar celda");
		MostrarPresosCelda = new JButton("Mostrar presos por celda");

		panelSuperior.add(AltaPreso);
		panelSuperior.add(BajaPreso);
		panelSuperior.add(ModificarPreso);
		panelSuperior.add(DetallesPreso);
		panelSuperior.add(ListarPresos);
		panelSuperior.add(AsignarCelda);
		panelSuperior.add(MostrarPresosCelda);

		AltaPreso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_ALTA_PRESOS, null);
			}
		});
		BajaPreso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_BAJA_PRESOS, null);
			}
		});
		ModificarPreso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_MODIFICAR_PRESOS, null);
			}
		});
		DetallesPreso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Controlador.getInstance().accion(EventoNegocio.DETALLES_PRESOS, null);
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_DETALLES_PRESOS, null);
			}
		});
		ListarPresos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(EventoNegocio.LISTAR_PRESOS, null);
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_LISTAR_PRESOS, null);
		
			}
		});
		AsignarCelda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_ASIGNAR_CELDA, null);
			}
		});
		MostrarPresosCelda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_MOSTRAR_CELDA, null);
			}
		});

	}

	public void panelCentral() {
		this.panelCentral = new JPanel();
		panelCentral.setOpaque(false);
	}

	@Override
	public JPanel getPanel() {
		return this.panelPresos;
	}

	@Override
	public void addPanelCentral(Component c) {
		this.panelCentral.add(c);
		this.panelCentral.updateUI();

	}
}
