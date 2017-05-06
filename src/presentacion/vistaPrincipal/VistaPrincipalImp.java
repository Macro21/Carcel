package presentacion.vistaPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

public class VistaPrincipalImp extends VistaPrincipal {

	private JFrame framePpal;
	private JButton presos;
	private JButton celdas;
	private JButton pabellones;
	private JButton empleados;
	private JButton departamento;
	private JButton material;
	private JPanel panelLateral;
	private JPanel panelCentral;
	private JPanel panelConFondo;

	@Override
	public void initGUI() {
		this.framePpal = new JFrame();
		this.framePpal.setTitle("Fox River");
		this.framePpal.setPreferredSize(new Dimension(727, 500));
		this.framePpal.setVisible(true);
		this.framePpal.setLocation(270, 20);
		this.framePpal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.framePpal.setResizable(false);
		panelConFondo();
		this.framePpal.pack();

	}

	private void panelConFondo() {
		panelConFondo = new PanelConFondo("Imagenes/fondo.jpg");
		panelConFondo.setLayout(new BorderLayout());
		this.framePpal.add(panelConFondo);
		panelLateral();
		panelCentral();

	}

	private void panelLateral() {
		panelLateral = new JPanel();

		ImageIcon logo = new ImageIcon("Imagenes/logo.png");
		JLabel logoL = new JLabel(logo);
		logoL.setOpaque(false);

		ImageIcon presosIcon = new ImageIcon("Imagenes/presos1.png");
		presos = new JButton(presosIcon);
		presos.setBackground(Color.white);
		presos.setOpaque(false);
		presos.setBorder(null);

		ImageIcon empleadosIcon = new ImageIcon("Imagenes/empleados1.png");
		empleados = new JButton(empleadosIcon);
		empleados.setBackground(Color.white);
		empleados.setOpaque(false);
		empleados.setBorder(null);

		ImageIcon celdasIcon = new ImageIcon("Imagenes/celdas1.png");
		celdas = new JButton(celdasIcon);
		celdas.setBackground(Color.white);
		celdas.setOpaque(false);
		celdas.setBorder(null);

		ImageIcon materialIcon = new ImageIcon("Imagenes/materiales1.png");
		material = new JButton(materialIcon);
		material.setBackground(Color.white);
		material.setOpaque(false);
		material.setBorder(null);

		ImageIcon pabellonIcon = new ImageIcon("Imagenes/pabellon1.png");
		pabellones = new JButton(pabellonIcon);
		pabellones.setBackground(Color.white);
		pabellones.setOpaque(false);
		pabellones.setBorder(null);

		ImageIcon departamentoIcon = new ImageIcon("Imagenes/departamento1.png");
		departamento = new JButton(departamentoIcon);
		departamento.setBackground(Color.white);
		departamento.setOpaque(false);
		departamento.setBorder(null);

		celdas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_CELDAS, null);
			}
		});
		presos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_PRESOS, null);
			}
		});
		pabellones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_PABELLONES, null);
			}
		});

		panelLateral.add(logoL);
		panelLateral.add(presos);
		panelLateral.add(celdas);
		panelLateral.add(pabellones);
		panelLateral.add(empleados);
		panelLateral.add(departamento);
		panelLateral.add(material);
		panelLateral.setLayout(new GridLayout(7, 1, 0, 5));
		panelLateral.setOpaque(false);
		panelConFondo.add(panelLateral, BorderLayout.WEST);

	}

	private void panelCentral() {
		panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		panelConFondo.add(panelCentral, BorderLayout.CENTER);
	}

	@Override
	public void addPanelCentral(Component c) {
		this.panelCentral.add(c);
		this.panelCentral.updateUI();
	}

	@Override
	public JPanel getPanel() {
		return this.panelCentral;
	}

}
