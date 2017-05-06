/**
 * 
 */
package presentacion.presos.alta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.presos.TransferPreso;
import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;
import presentacion.notificaciones.Notificaciones;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaAltaPresosImp extends VistaAltaPresos {
	private JPanel panelAltaPreso;
	private JTextField textNombre;
	private JTextField textDni;
	private JTextField textCondena;
	private JTextField textApellidos;

	public VistaAltaPresosImp() {
		initGUI();
	}

	public void initGUI() {
		panelAltaPreso = new javax.swing.JPanel();
		panelAltaPreso.setOpaque(false);
		JLabel condena = new javax.swing.JLabel();
		JLabel nombre = new javax.swing.JLabel();
		textNombre = new javax.swing.JTextField();
		textDni = new javax.swing.JTextField();
		JButton aceptar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();
		JLabel apellidos = new javax.swing.JLabel();
		JLabel dni = new javax.swing.JLabel();
		textCondena = new javax.swing.JTextField();
		textApellidos = new javax.swing.JTextField();

		panelAltaPreso.setMaximumSize(new java.awt.Dimension(550, 398));
		panelAltaPreso.setMinimumSize(new java.awt.Dimension(550, 398));
		panelAltaPreso.setPreferredSize(new java.awt.Dimension(550, 398));

		condena.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		condena.setText("Condena:");

		nombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nombre.setText("Nombre: ");

		textNombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textNombre.setForeground(new java.awt.Color(102, 102, 102));

		textDni.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textDni.setForeground(new java.awt.Color(102, 102, 102));
	
		aceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		aceptar.setText("Aceptar");
		aceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Apéndice de método generado automáticamente
				try{
					String nombreStr = textNombre.getText();
					String apellidosStr = textApellidos.getText();
					String dniStr = textDni.getText();
					String condenaStr = textCondena.getText();
					TransferPreso preso = new TransferPreso(dniStr, nombreStr, apellidosStr, condenaStr, true);
					Controlador.getInstance().accion(EventoNegocio.ALTA_PRESOS, preso);
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
						EventoNegocio.ACTUALIZAR_VISTA_PRESOS, null);
			}
		});

		apellidos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		apellidos.setText("Apellidos:");

		dni.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		dni.setText("DNI:");

		textCondena.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textCondena.setForeground(new java.awt.Color(102, 102, 102));
		//        textPresosCelda.addActionListener(new java.awt.event.ActionListener() {
		//            public void actionPerformed(java.awt.event.ActionEvent evt) {
		//                textPresosCeldaActionPerformed(evt);
		//            }
		//        });

		textApellidos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textApellidos.setForeground(new java.awt.Color(102, 102, 102));
		//        textApellidos.addActionListener(new java.awt.event.ActionListener() {
		//            public void actionPerformed(java.awt.event.ActionEvent evt) {
		//                textApellidosActionPerformed(evt);
		//            }
		//        });

		javax.swing.GroupLayout panelAltaPresoLayout = new javax.swing.GroupLayout(
				panelAltaPreso);
		panelAltaPreso.setLayout(panelAltaPresoLayout);
		panelAltaPresoLayout
				.setHorizontalGroup(panelAltaPresoLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								panelAltaPresoLayout
										.createSequentialGroup()
										.addContainerGap(120, Short.MAX_VALUE)
										.addGroup(
												panelAltaPresoLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																panelAltaPresoLayout
																		.createSequentialGroup()
																		.addGroup(
																				panelAltaPresoLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								aceptar,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								115,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								condena))
																		.addGap(56,
																				56,
																				56)
																		.addGroup(
																				panelAltaPresoLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								textNombre,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								141,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textApellidos,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								141,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textDni,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								141,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textCondena,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								141,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								cancelar,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								115,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addComponent(nombre)
														.addComponent(apellidos)
														.addComponent(
																dni))
										.addGap(118, 118, 118)));
		panelAltaPresoLayout
				.setVerticalGroup(panelAltaPresoLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelAltaPresoLayout
										.createSequentialGroup()
										.addGap(25, 25, 25)
										.addGroup(
												panelAltaPresoLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																nombre,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textNombre,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(32, 32, 32)
										.addGroup(
												panelAltaPresoLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																apellidos,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textApellidos,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												35, Short.MAX_VALUE)
										.addGroup(
												panelAltaPresoLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																dni,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textDni,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(37, 37, 37)
										.addGroup(
												panelAltaPresoLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																condena,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textCondena,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(52, 52, 52)
										.addGroup(
												panelAltaPresoLayout
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
										.addGap(80, 80, 80)));

	}

	
	@Override
	public JPanel getPanel() {
		return this.panelAltaPreso;
	}


	@Override
	public void update(Notificaciones notificaciones) {
		JOptionPane.showMessageDialog(null, notificaciones.getNum() <= 0 ? notificaciones.getMensaje() : notificaciones.getMensaje() + notificaciones.getNum() , notificaciones.getNum() < 0 ? "Error" : "Correcto", notificaciones.getNum() < 0 ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
		
	}
}