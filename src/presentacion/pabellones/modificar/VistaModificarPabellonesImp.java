/**
 * 
 */
package presentacion.pabellones.modificar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
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
public class VistaModificarPabellonesImp extends VistaModificarPabellones {
	private JPanel panelModificarPabellon;
	private JTextField jTextFieldIdPabellon;
	private JTextField textNombrePabellon;
	private JTextField textCeldas;
	private JTextField textPresosCeldaOVigilantes;
	private JLabel tipo;
	private TransferPabellon tp = null;
	private JLabel nPresosCeldaOVigilantes;

	public VistaModificarPabellonesImp() {
		initGUI();
	}
	
	public void initGUI() {
		panelModificarPabellon = new javax.swing.JPanel();
		panelModificarPabellon.setOpaque(false);
		JLabel jLabelIdPabellon = new javax.swing.JLabel();
		jTextFieldIdPabellon = new javax.swing.JTextField();
		JSeparator jSeparator1 = new javax.swing.JSeparator();
		JButton buscar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();
		JButton aceptar = new javax.swing.JButton();
		JLabel nombrePabellon = new javax.swing.JLabel();
		textNombrePabellon = new javax.swing.JTextField();
		JLabel tipoPabellon = new javax.swing.JLabel();
		tipo = new javax.swing.JLabel();
		JLabel nMaxCeldas = new javax.swing.JLabel();
		textCeldas = new javax.swing.JTextField();
		nPresosCeldaOVigilantes = new javax.swing.JLabel();
		textPresosCeldaOVigilantes = new javax.swing.JTextField();

		panelModificarPabellon.setMaximumSize(new java.awt.Dimension(500, 436));
		panelModificarPabellon.setMinimumSize(new java.awt.Dimension(500, 436));
		panelModificarPabellon
				.setPreferredSize(new java.awt.Dimension(500, 436));

		jLabelIdPabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jLabelIdPabellon.setText("Identificador del pabellon a modificar:");

		jTextFieldIdPabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jTextFieldIdPabellon.setForeground(new java.awt.Color(102, 102, 102));

		jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
		jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
		jSeparator1.setMinimumSize(new java.awt.Dimension(50, 150));

		buscar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		buscar.setText("Buscar datos");
		        buscar.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		            	try{
		            		Controlador.getInstance().accion(EventoNegocio.DETALLES_MODIFICAR_PABELLONES, Integer.parseInt(jTextFieldIdPabellon.getText()));		            
		            		Controlador.getInstance().accion(EventoNegocio.ACTUALIZAR_VISTA_MODIFICAR_PABELLONES, null);
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

		aceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		aceptar.setText("Aceptar cambios");
		        aceptar.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		            	try{
		            	if (tp != null){
		            		
		            		if(tp.getTipo().equalsIgnoreCase("aislamiento")){
		            			Controlador.getInstance().accion(
				            			EventoNegocio.MODIFICAR_PABELLONES, 
				            			new TransferPabellonAislamiento(tp.getIdPabellon(), 
							            					 textNombrePabellon.getText(), 
							            					 tp.getEstado(),
							            					 tipo.getText(),
							            					 Integer.parseInt(textCeldas.getText()),
							            					 Integer.parseInt(textPresosCeldaOVigilantes.getText())));	
		            		}
		            		else if(tp.getTipo().equalsIgnoreCase("comun")){
		            			Controlador.getInstance().accion(
				            			EventoNegocio.MODIFICAR_PABELLONES, 
				            			new TransferPabellonComun(tp.getIdPabellon(), 
							            					 textNombrePabellon.getText(), 
							            					 tp.getEstado(),
							            					 tipo.getText(),
							            					 Integer.parseInt(textCeldas.getText()),
							            					 Integer.parseInt(textPresosCeldaOVigilantes.getText())));	
		            		}
		            	}
		            
		            	else
		            		JOptionPane.showMessageDialog(new JFrame(), "Introduce un pabellon.", "Error", JOptionPane.ERROR_MESSAGE);
		            	}
		            	catch(NumberFormatException excep){
							JOptionPane.showMessageDialog(new JFrame(), "Ha introducido datos sintacticamente incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
						}
		            }
		        });

		nombrePabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nombrePabellon.setText("Nombre de pabellón:");

		textNombrePabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textNombrePabellon.setForeground(new java.awt.Color(102, 102, 102));
		//        textNombrePabellon.addActionListener(new java.awt.event.ActionListener() {
		//            public void actionPerformed(java.awt.event.ActionEvent evt) {
		//                textNombrePabellonActionPerformed(evt);
		//            }
		//        });

		tipoPabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		tipoPabellon.setText("Tipo de pabellón:");

		tipo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		tipo.setForeground(new java.awt.Color(102, 102, 102));

		nMaxCeldas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nMaxCeldas.setText("Número máximo de celdas: ");

		textCeldas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textCeldas.setForeground(new java.awt.Color(102, 102, 102));
		//        textCeldas.addActionListener(new java.awt.event.ActionListener() {
		//            public void actionPerformed(java.awt.event.ActionEvent evt) {
		//                textCeldasActionPerformed(evt);
		//            }
		//        });

		nPresosCeldaOVigilantes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nPresosCeldaOVigilantes.setText("Número de presos por celda: ");

		textPresosCeldaOVigilantes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textPresosCeldaOVigilantes.setForeground(new java.awt.Color(102, 102, 102));
		//        textPresosCelda.addActionListener(new java.awt.event.ActionListener() {
		//            public void actionPerformed(java.awt.event.ActionEvent evt) {
		//                textPresosCeldaActionPerformed(evt);
		//            }
		//        });

		javax.swing.GroupLayout paneModificarPabellonLayout = new javax.swing.GroupLayout(
				panelModificarPabellon);
		panelModificarPabellon.setLayout(paneModificarPabellonLayout);
		panelModificarPabellon.setLayout(paneModificarPabellonLayout);
		paneModificarPabellonLayout
				.setHorizontalGroup(paneModificarPabellonLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								paneModificarPabellonLayout
										.createSequentialGroup()
										.addGroup(
												paneModificarPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																paneModificarPabellonLayout
																		.createSequentialGroup()
																		.addGap(30,
																				30,
																				30)
																		.addComponent(
																				jSeparator1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				415,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																paneModificarPabellonLayout
																		.createSequentialGroup()
																		.addGap(49,
																				49,
																				49)
																		.addGroup(
																				paneModificarPabellonLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addGroup(
																								paneModificarPabellonLayout
																										.createSequentialGroup()
																										.addComponent(
																												jLabelIdPabellon)
																										.addGap(31,
																												31,
																												31)
																										.addComponent(
																												jTextFieldIdPabellon,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												66,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								paneModificarPabellonLayout
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
																												javax.swing.GroupLayout.PREFERRED_SIZE))))
														.addGroup(
																paneModificarPabellonLayout
																		.createSequentialGroup()
																		.addGap(162,
																				162,
																				162)
																		.addComponent(
																				aceptar))
														.addGroup(
																paneModificarPabellonLayout
																		.createSequentialGroup()
																		.addGap(51,
																				51,
																				51)
																		.addGroup(
																				paneModificarPabellonLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								paneModificarPabellonLayout
																										.createSequentialGroup()
																										.addGroup(
																												paneModificarPabellonLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																tipoPabellon)
																														.addComponent(
																																nombrePabellon)
																														.addComponent(
																																nMaxCeldas))
																										.addGap(11,
																												11,
																												11))
																						.addComponent(
																								nPresosCeldaOVigilantes))
																		.addGroup(
																				paneModificarPabellonLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								paneModificarPabellonLayout
																										.createSequentialGroup()
																										.addGap(17,
																												17,
																												17)
																										.addGroup(
																												paneModificarPabellonLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																tipo,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																141,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																textNombrePabellon,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																141,
																																javax.swing.GroupLayout.PREFERRED_SIZE)))
																						.addGroup(
																								paneModificarPabellonLayout
																										.createSequentialGroup()
																										.addGap(18,
																												18,
																												18)
																										.addGroup(
																												paneModificarPabellonLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																textCeldas,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																141,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																textPresosCeldaOVigilantes,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																141,
																																javax.swing.GroupLayout.PREFERRED_SIZE))))))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		paneModificarPabellonLayout
				.setVerticalGroup(paneModificarPabellonLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								paneModificarPabellonLayout
										.createSequentialGroup()
										.addGap(29, 29, 29)
										.addGroup(
												paneModificarPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelIdPabellon,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextFieldIdPabellon,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												paneModificarPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																buscar,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cancelar,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												11,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												paneModificarPabellonLayout
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
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												27, Short.MAX_VALUE)
										.addGroup(
												paneModificarPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																tipoPabellon,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																tipo,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																29,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												paneModificarPabellonLayout
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
										.addGap(27, 27, 27)
										.addGroup(
												paneModificarPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																nPresosCeldaOVigilantes,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textPresosCeldaOVigilantes,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																28,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(35, 35, 35)
										.addComponent(
												aceptar,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(59, 59, 59)));
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(TransferPabellon tp) {
		// begin-user-code
		if(tp == null){
			Notificaciones datos = Notificaciones.NO_EXISTE;
			JOptionPane.showMessageDialog(null, datos.getNum() <= 0 ? datos.getMensaje() : datos.getMensaje() + datos.getNum() , datos.getNum() < 0 ? "Error" : "Correcto", datos.getNum() < 0 ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			this.tp = tp;
			textNombrePabellon.setText(tp.getNombre());
			textCeldas.setText(String.valueOf(tp.getNumMaxCeldas()));
			
			if(tp.getTipo().equalsIgnoreCase("aislamiento")){
				nPresosCeldaOVigilantes.setText("Número de vigilantes:           ");
				textPresosCeldaOVigilantes.setText(String.valueOf(((TransferPabellonAislamiento)tp).getNumVigilantes()));
			}
			else if (tp.getTipo().equalsIgnoreCase("comun")){
				nPresosCeldaOVigilantes.setText("Numero de presos por celda: ");
				textPresosCeldaOVigilantes.setText(String.valueOf(((TransferPabellonComun)tp).getTamanoCelda()));
			}
			tipo.setText(tp.getTipo());
		}
		// end-user-code
	}

	@Override
	public void update(Notificaciones datos) {
		JOptionPane.showMessageDialog(null, datos.getNum() <= 0 ? datos.getMensaje() : datos.getMensaje() + datos.getNum() , datos.getNum() < 0 ? "Error" : "Correcto", datos.getNum() < 0 ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public JPanel getPanel() {
		return this.panelModificarPabellon;
	}
}