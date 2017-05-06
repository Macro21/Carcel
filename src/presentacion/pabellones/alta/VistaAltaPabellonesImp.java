/**
 * 
 */
package presentacion.pabellones.alta;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.pabellones.TransferPabellon;
import negocio.pabellones.TransferPabellonAislamiento;
import negocio.pabellones.TransferPabellonComun;
import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;
import presentacion.notificaciones.Notificaciones;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaAltaPabellonesImp extends VistaAltaPabellones {
	private JPanel panelAltaPabellon;
	private JTextField textNombrePabellon;
	private JTextField textCeldas;
	private JTextField textMutable;
	private JComboBox<String> jComboBoxTipo;
	private JLabel mutable;
	
	public void initGUI() {
		panelAltaPabellon = new javax.swing.JPanel();
		panelAltaPabellon.setOpaque(false);
		mutable = new javax.swing.JLabel();
		JLabel nombrePabellon = new javax.swing.JLabel();
		textNombrePabellon = new javax.swing.JTextField();
		textCeldas = new javax.swing.JTextField();
		JButton aceptar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();
		JLabel tipoPabellon = new javax.swing.JLabel();
		jComboBoxTipo = new javax.swing.JComboBox<>();
		JLabel nMaxCeldas = new javax.swing.JLabel();
		textMutable = new javax.swing.JTextField();

		panelAltaPabellon.setPreferredSize(new java.awt.Dimension(550, 436));

		mutable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		mutable.setText("Número de vigilantes:");
		

		nombrePabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nombrePabellon.setText("Nombre de pabellón");

		textNombrePabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textNombrePabellon.setForeground(new java.awt.Color(102, 102, 102));
		//        textNombrePabellon.addActionListener(new java.awt.event.ActionListener() {
		//            public void actionPerformed(java.awt.event.ActionEvent evt) {
		//                textNombrePabellonActionPerformed(evt);
		//            }
		//        });

		textCeldas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textCeldas.setForeground(new java.awt.Color(102, 102, 102));
		//        textCeldas.addActionListener(new java.awt.event.ActionListener() {
		//            public void actionPerformed(java.awt.event.ActionEvent evt) {
		//                textCeldasActionPerformed(evt);
		//            }
		//        });

		aceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		aceptar.setText("Aceptar");
		aceptar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try{
				TransferPabellon datos = null;
				String tipoPab = (String) jComboBoxTipo.getSelectedItem();
				if (tipoPab.equalsIgnoreCase("aislamiento")){
					datos = new TransferPabellonAislamiento(textNombrePabellon.getText(),true,"aislamiento", Integer.parseInt(textCeldas.getText()),Integer.parseInt(textMutable.getText()));
				}
				else if (tipoPab.equalsIgnoreCase("comun")){
					datos = new TransferPabellonComun(textNombrePabellon.getText(),true,"comun", Integer.parseInt(textCeldas.getText()),Integer.parseInt(textMutable.getText()));
				}
				Controlador.getInstance().accion(EventoNegocio.ALTA_PABELLONES, datos);
				}
				catch(NumberFormatException excep){
					JOptionPane.showMessageDialog(new JFrame(), "Ha introducido datos sintacticamente incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		cancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		cancelar.setText("Cancelar");
		cancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				initGUI();
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_PABELLONES, null);
			}
		});

		tipoPabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		tipoPabellon.setText("Tipo de Pabellón:");

		jComboBoxTipo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Aislamiento", "Comun" }));
		jComboBoxTipo.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
			}
		});
		jComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(jComboBoxTipo.getItemAt(0)==jComboBoxTipo.getSelectedItem()){
					mutable.setText("Número de vigilantes:");
					VistaAltaPabellones.getInstance().getPanel().updateUI();
				}
				else{
					mutable.setText("Número de presos por celda:");
					VistaAltaPabellones.getInstance().getPanel().updateUI();
				}
			}            
		});

		nMaxCeldas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nMaxCeldas.setText("Número máximo de celdas:");

		textMutable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textMutable.setForeground(new java.awt.Color(102, 102, 102));
		//        textPresosCelda.addActionListener(new java.awt.event.ActionListener() {
		//            public void actionPerformed(java.awt.event.ActionEvent evt) {
		//                textPresosCeldaActionPerformed(evt);
		//            }
		//        });

		javax.swing.GroupLayout panelAltaPabellonLayout = new javax.swing.GroupLayout(
				panelAltaPabellon);
		panelAltaPabellon.setLayout(panelAltaPabellonLayout);
		panelAltaPabellonLayout
				.setHorizontalGroup(panelAltaPabellonLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelAltaPabellonLayout
										.createSequentialGroup()
										.addGap(42, 42, 42)
										.addGroup(
												panelAltaPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																panelAltaPabellonLayout
																		.createSequentialGroup()
																		.addGap(66,
																				66,
																				66)
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
																panelAltaPabellonLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				panelAltaPabellonLayout
																						.createSequentialGroup()
																						.addGroup(
																								panelAltaPabellonLayout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												nombrePabellon)
																										.addComponent(
																												tipoPabellon)
																										.addComponent(
																												nMaxCeldas))
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addGroup(
																								panelAltaPabellonLayout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												textCeldas,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												141,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGroup(
																												panelAltaPabellonLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																false)
																														.addComponent(
																																textNombrePabellon)
																														.addComponent(
																																jComboBoxTipo,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																141,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addComponent(
																												textMutable,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												141,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				panelAltaPabellonLayout
																						.createSequentialGroup()
																						.addComponent(
																								mutable)
																						.addGap(277,
																								277,
																								277))))
										.addGap(85, 85, 85)));
		panelAltaPabellonLayout
				.setVerticalGroup(panelAltaPabellonLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelAltaPabellonLayout
										.createSequentialGroup()
										.addGap(55, 55, 55)
										.addGroup(
												panelAltaPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																nombrePabellon,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textNombrePabellon,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(32, 32, 32)
										.addGroup(
												panelAltaPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																tipoPabellon,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jComboBoxTipo,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																29,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												34, Short.MAX_VALUE)
										.addGroup(
												panelAltaPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																nMaxCeldas,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textCeldas,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(45, 45, 45)
										.addGroup(
												panelAltaPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																mutable,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textMutable,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(60, 60, 60)
										.addGroup(
												panelAltaPabellonLayout
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
										.addGap(64, 64, 64)));

	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(Notificaciones datos) {
		// begin-user-code
		JOptionPane.showMessageDialog(null, datos.getNum() <= 0 ? datos.getMensaje() : datos.getMensaje() + datos.getNum() , datos.getNum() < 0 ? "Error" : "Correcto", datos.getNum() < 0 ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
		// end-user-code
	}

	@Override
	public JPanel getPanel() {
		return this.panelAltaPabellon;
	}
}