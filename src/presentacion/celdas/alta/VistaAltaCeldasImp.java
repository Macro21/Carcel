/**
 * 
 */
package presentacion.celdas.alta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.celdas.TransferCelda;
import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;
import presentacion.notificaciones.Notificaciones;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaAltaCeldasImp extends VistaAltaCeldas {
	private JPanel panelAltaCelda;

	public VistaAltaCeldasImp() {
		initGUI();
	}

	private JTextField textPabellon;
	private JTextField textCelda;
	private JCheckBox checkDucha;
	private JCheckBox checkTelevision;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void initGUI() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		panelAltaCelda = new javax.swing.JPanel();
		panelAltaCelda.setOpaque(false);
		JLabel nCelda = new javax.swing.JLabel();
		JLabel nombrePabellon = new javax.swing.JLabel();
		textPabellon = new javax.swing.JTextField();
		textCelda = new javax.swing.JTextField();
		checkDucha = new javax.swing.JCheckBox();
		checkTelevision = new javax.swing.JCheckBox();
		JLabel extras = new javax.swing.JLabel();
		JButton aceptar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();

		panelAltaCelda.setPreferredSize(new java.awt.Dimension(550, 436));

		nCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nCelda.setText("Número de celda:");

		nombrePabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nombrePabellon.setText("Id del pabellón:");

		textPabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textPabellon.setForeground(new java.awt.Color(102, 102, 102));

		textCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textCelda.setForeground(new java.awt.Color(102, 102, 102));

        checkDucha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		checkDucha.setText("Ducha");
		checkDucha.setOpaque(false);

		checkTelevision.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		checkTelevision.setText("Televisión");
		checkTelevision.setOpaque(false);

		extras.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		extras.setText("Extras:");

		aceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		aceptar.setText("Aceptar");

		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TransferCelda datos=null;
				try{
					int idPabellon = Integer.parseInt(textPabellon.getText());
					int nrCelda = Integer.parseInt(textCelda.getText());
					boolean television = checkTelevision.isSelected();
					boolean ducha = checkDucha.isSelected();
					datos = new TransferCelda(0,idPabellon,nrCelda, television, ducha);
					Controlador.getInstance().accion(EventoNegocio.ALTA_CELDAS,datos);
				}
				catch(NumberFormatException excep){
					JOptionPane.showMessageDialog(new JFrame(), "Ha introducido datos sintacticamente incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		cancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		cancelar.setText("Cancelar");
		cancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initGUI();
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_CELDAS, null);
			}
		});

		javax.swing.GroupLayout panelAltaCeldaLayout = new javax.swing.GroupLayout(
				panelAltaCelda);
		panelAltaCelda.setLayout(panelAltaCeldaLayout);
		panelAltaCeldaLayout
				.setHorizontalGroup(panelAltaCeldaLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelAltaCeldaLayout
										.createSequentialGroup()
										.addGap(83, 83, 83)
										.addGroup(
												panelAltaCeldaLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																panelAltaCeldaLayout
																		.createSequentialGroup()
																		.addComponent(
																				nombrePabellon)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				textPabellon,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				141,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																panelAltaCeldaLayout
																		.createSequentialGroup()
																		.addGap(35,
																				35,
																				35)
																		.addComponent(
																				aceptar,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				115,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				cancelar,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				115,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(59,
																				59,
																				59))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																panelAltaCeldaLayout
																		.createSequentialGroup()
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)
																		.addGroup(
																				panelAltaCeldaLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addGroup(
																								panelAltaCeldaLayout
																										.createSequentialGroup()
																										.addComponent(
																												extras,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												92,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGap(95,
																												95,
																												95)
																										.addComponent(
																												checkDucha)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												checkTelevision))
																						.addGroup(
																								panelAltaCeldaLayout
																										.createSequentialGroup()
																										.addComponent(
																												nCelda)
																										.addGap(136,
																												136,
																												136)
																										.addComponent(
																												textCelda,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												141,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))))
										.addGap(75, 75, 75)));
		panelAltaCeldaLayout
				.setVerticalGroup(panelAltaCeldaLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelAltaCeldaLayout
										.createSequentialGroup()
										.addGap(70, 70, 70)
										.addGroup(
												panelAltaCeldaLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																nombrePabellon,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textPabellon,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												58, Short.MAX_VALUE)
										.addGroup(
												panelAltaCeldaLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																nCelda,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textCelda,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(26, 26, 26)
										.addGroup(
												panelAltaCeldaLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																extras,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																71,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																checkDucha)
														.addComponent(
																checkTelevision))
										.addGap(37, 37, 37)
										.addGroup(
												panelAltaCeldaLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																aceptar,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cancelar,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(85, 85, 85)));

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(Notificaciones datos) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		JOptionPane.showMessageDialog(null, datos.getNum() <= 0 ? datos.getMensaje() : datos.getMensaje() + datos.getNum() , datos.getNum() < 0 ? "Error" : "Correcto", datos.getNum() < 0 ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
		// end-user-code
	}

	@Override
	public JPanel getPanel() {
		return this.panelAltaCelda;
	}
}