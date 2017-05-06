/**
 * 
 */
package presentacion.presos.modificar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
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
public class VistaModificarPresosImp extends VistaModificarPresos {

	private JPanel panelModificarPreso;
	private JTextField jTextFieldIdPreso;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDni;
	private JTextField textCondena;
	private JButton aceptar;
	private JButton buscar;
	
	public VistaModificarPresosImp() {
		initGUI();
	}

	public void initGUI() {
		panelModificarPreso = new javax.swing.JPanel();
		panelModificarPreso.setOpaque(false);
		JLabel jLabelIdPreso = new javax.swing.JLabel();
		jTextFieldIdPreso = new javax.swing.JTextField();
		JSeparator jSeparator1 = new javax.swing.JSeparator();
		buscar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();
		aceptar = new javax.swing.JButton();
		JLabel nombre = new javax.swing.JLabel();
		textNombre = new javax.swing.JTextField();
		JLabel apellidos = new javax.swing.JLabel();
		textApellidos = new javax.swing.JTextField();
		JLabel nMaxCeldas = new javax.swing.JLabel();
		textDni = new javax.swing.JTextField();
		JLabel condena = new javax.swing.JLabel();
		textCondena = new javax.swing.JTextField();

		panelModificarPreso.setMaximumSize(new java.awt.Dimension(550, 398));
		panelModificarPreso.setMinimumSize(new java.awt.Dimension(550, 398));
		panelModificarPreso.setPreferredSize(new java.awt.Dimension(550, 398));

		jLabelIdPreso.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jLabelIdPreso.setText("Identificador del preso a modificar:");

		jTextFieldIdPreso.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jTextFieldIdPreso.setForeground(new java.awt.Color(102, 102, 102));

		jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
		jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
		jSeparator1.setMinimumSize(new java.awt.Dimension(50, 150));

		buscar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		buscar.setText("Buscar datos");
		buscar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Apéndice de método generado automáticamente
				TransferPreso datos = null;
				try{
					datos = new TransferPreso(Integer.parseInt(jTextFieldIdPreso.getText()));
					Controlador.getInstance().accion(EventoNegocio.DETALLES_MODIFICAR_PRESOS, datos);
					Controlador.getInstance().accion(EventoNegocio.ACTUALIZAR_VISTA_MODIFICAR_PRESOS,datos);
				}
				catch(NumberFormatException except){
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

		aceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		aceptar.setText("Aceptar cambios");
		aceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Apéndice de método generado automáticamente
				try{
					String nombre = textNombre.getText();
					String apellidos = textApellidos.getText();
					int id = Integer.parseInt(jTextFieldIdPreso.getText());
					String dni = textDni.getText();
					String condena = textCondena.getText();
					TransferPreso preso = new TransferPreso(id, dni, nombre, apellidos, condena, true);
					Controlador.getInstance().accion(EventoNegocio.MODIFICAR_PRESOS, preso);
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Ha introducido datos sintacticamente incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});

		nombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nombre.setText("Nombre: ");

		textNombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textNombre.setForeground(new java.awt.Color(102, 102, 102));

		apellidos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		apellidos.setText("Apellidos:");

		textApellidos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textApellidos.setForeground(new java.awt.Color(102, 102, 102));
	
		nMaxCeldas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nMaxCeldas.setText("DNI:");

		textDni.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textDni.setForeground(new java.awt.Color(102, 102, 102));
		
		condena.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		condena.setText("Condena:");

		textCondena.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textCondena.setForeground(new java.awt.Color(102, 102, 102));
	

		javax.swing.GroupLayout panelModificarPresoLayout = new javax.swing.GroupLayout(
				panelModificarPreso);
		panelModificarPreso.setLayout(panelModificarPresoLayout);
		panelModificarPresoLayout
				.setHorizontalGroup(panelModificarPresoLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelModificarPresoLayout
										.createSequentialGroup()
										.addGroup(
												panelModificarPresoLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																panelModificarPresoLayout
																		.createSequentialGroup()
																		.addGap(59,
																				59,
																				59)
																		.addComponent(
																				jSeparator1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				415,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																panelModificarPresoLayout
																		.createSequentialGroup()
																		.addGap(100,
																				100,
																				100)
																		.addGroup(
																				panelModificarPresoLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addGroup(
																								panelModificarPresoLayout
																										.createSequentialGroup()
																										.addComponent(
																												buscar,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												135,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												cancelar,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												115,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								panelModificarPresoLayout
																										.createSequentialGroup()
																										.addComponent(
																												jLabelIdPreso)
																										.addGap(18,
																												18,
																												18)
																										.addComponent(
																												jTextFieldIdPreso,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												66,
																												javax.swing.GroupLayout.PREFERRED_SIZE))))
														.addGroup(
																panelModificarPresoLayout
																		.createSequentialGroup()
																		.addGap(100,
																				100,
																				100)
																		.addGroup(
																				panelModificarPresoLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								nMaxCeldas)
																						.addGroup(
																								panelModificarPresoLayout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																										.addComponent(
																												apellidos)
																										.addComponent(
																												nombre))
																						.addComponent(
																								condena))
																		.addGap(115,
																				115,
																				115)
																		.addGroup(
																				panelModificarPresoLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								textCondena,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								141,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textApellidos,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								141,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textNombre,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								141,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textDni,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								141,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																panelModificarPresoLayout
																		.createSequentialGroup()
																		.addGap(187,
																				187,
																				187)
																		.addComponent(
																				aceptar)))
										.addContainerGap(76, Short.MAX_VALUE)));
		panelModificarPresoLayout
				.setVerticalGroup(panelModificarPresoLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelModificarPresoLayout
										.createSequentialGroup()
										.addGap(29, 29, 29)
										.addGroup(
												panelModificarPresoLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelIdPreso,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextFieldIdPreso,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												panelModificarPresoLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																cancelar,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																buscar,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(20, 20, 20)
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												11,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(4, 4, 4)
										.addGroup(
												panelModificarPresoLayout
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
										.addGap(16, 16, 16)
										.addGroup(
												panelModificarPresoLayout
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
												23, Short.MAX_VALUE)
										.addGroup(
												panelModificarPresoLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																nMaxCeldas,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textDni,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												panelModificarPresoLayout
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
										.addGap(26, 26, 26)
										.addComponent(
												aceptar,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(39, 39, 39)));
	}

	

	@Override
	public JPanel getPanel() {
		return this.panelModificarPreso;
	}


	@Override
	public void update(Notificaciones notificaciones) {
		JOptionPane.showMessageDialog(null, notificaciones.getNum() <= 0 ? notificaciones.getMensaje() : notificaciones.getMensaje() + notificaciones.getNum() , notificaciones.getNum() < 0 ? "Error" : "Correcto", notificaciones.getNum() < 0 ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
		
	}

	@Override
	public void update(TransferPreso tp) {
		// TODO Apéndice de método generado automáticamente
		if(tp == null){
			Notificaciones datos = Notificaciones.NO_EXISTE;
			JOptionPane.showMessageDialog(null, datos.getNum() <= 0 ? datos.getMensaje() : datos.getMensaje() + datos.getNum() , datos.getNum() < 0 ? "Error" : "Correcto", datos.getNum() < 0 ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			this.textNombre.setText(tp.getNombre());
			this.textApellidos.setText(tp.getApellidos());
			this.textDni.setText(tp.getDNI());
			this.textCondena.setText(tp.getCondena());
		}
		
	}
}