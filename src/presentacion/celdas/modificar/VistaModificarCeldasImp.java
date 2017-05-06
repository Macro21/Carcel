/**
 * 
 */
package presentacion.celdas.modificar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
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
public class VistaModificarCeldasImp extends VistaModificarCeldas {

	private JPanel panelModificarCelda;
	private JTextField jTextFieldIdCelda;
	private JTextField textCelda;
	private JButton buscar;
	private JButton aceptar;
	private JCheckBox checkDucha;
	private JCheckBox checkTelevision;
	
	public VistaModificarCeldasImp() {
		initGUI();
	}

	public void initGUI() {
		this.panelModificarCelda = new JPanel();
		this.panelModificarCelda.setOpaque(false);

		JLabel jLabelIdCelda = new javax.swing.JLabel();
		jTextFieldIdCelda = new javax.swing.JTextField();
		JSeparator jSeparator1 = new javax.swing.JSeparator();
		JLabel nCelda = new javax.swing.JLabel();
		textCelda = new javax.swing.JTextField();
		JLabel extras = new javax.swing.JLabel();
		checkDucha = new javax.swing.JCheckBox();
		checkTelevision = new javax.swing.JCheckBox();
		buscar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();
		aceptar = new javax.swing.JButton();

		panelModificarCelda.setMaximumSize(new java.awt.Dimension(500, 436));
		panelModificarCelda.setMinimumSize(new java.awt.Dimension(500, 436));
		panelModificarCelda.setPreferredSize(new java.awt.Dimension(500, 436));

		jLabelIdCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jLabelIdCelda.setText("Identificador de la celda a modificar:");

		jTextFieldIdCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jTextFieldIdCelda.setForeground(new java.awt.Color(102, 102, 102));

		jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
		jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
		jSeparator1.setMinimumSize(new java.awt.Dimension(50, 150));
		

		nCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nCelda.setText("Número de celda:");

		textCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textCelda.setForeground(new java.awt.Color(102, 102, 102));
	

		extras.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		extras.setText("Extras:");

		checkDucha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		checkDucha.setText("Ducha");
		checkDucha.setOpaque(false);
	

		checkTelevision.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		checkTelevision.setText("Televisión");
		checkTelevision.setOpaque(false);
		

		buscar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		buscar.setText("Buscar datos");
		        buscar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Apéndice de método generado automáticamente
						TransferCelda datos = null;
						try{
							datos = new TransferCelda(Integer.parseInt(jTextFieldIdCelda.getText()));
							Controlador.getInstance().accion(EventoNegocio.DETALLES_MODIFICAR_CELDAS, datos);	
							Controlador.getInstance().accion( EventoNegocio.ACTUALIZAR_VISTA_MODIFICAR_CELDAS,datos);
						}
						catch(NumberFormatException exception){
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
						EventoNegocio.ACTUALIZAR_VISTA_CELDAS, null);
			}
		});

		aceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		aceptar.setText("Aceptar cambios");
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Apéndice de método generado automáticamente
				TransferCelda datos = null;
				try{
					int idCelda = Integer.parseInt(jTextFieldIdCelda.getText());
					int nrCelda = Integer.parseInt(textCelda.getText());
					boolean tv = checkTelevision.isSelected();
					boolean du = checkDucha.isSelected();
					//boolean est = 
					datos = new TransferCelda (idCelda,nrCelda,tv,du);
					Controlador.getInstance().accion(EventoNegocio.MODIFICAR_CELDAS, datos);
				}
				catch(NumberFormatException exception){
					JOptionPane.showMessageDialog(new JFrame(), "Ha introducido datos sintacticamente incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		javax.swing.GroupLayout panelModificarCeldaLayout = new javax.swing.GroupLayout(panelModificarCelda);
        panelModificarCelda.setLayout(panelModificarCeldaLayout);
        panelModificarCeldaLayout.setHorizontalGroup(
            panelModificarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarCeldaLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(aceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModificarCeldaLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModificarCeldaLayout.createSequentialGroup()
                .addGroup(panelModificarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelModificarCeldaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldIdCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelModificarCeldaLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(panelModificarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelModificarCeldaLayout.createSequentialGroup()
                                .addComponent(nCelda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelModificarCeldaLayout.createSequentialGroup()
                                .addComponent(extras)
                                .addGap(73, 73, 73)
                                .addComponent(checkDucha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkTelevision))))
                    .addGroup(panelModificarCeldaLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77))
            .addGroup(panelModificarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelModificarCeldaLayout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(jLabelIdCelda)
                    .addContainerGap(158, Short.MAX_VALUE)))
        );
        panelModificarCeldaLayout.setVerticalGroup(
            panelModificarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarCeldaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jTextFieldIdCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(panelModificarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(panelModificarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(panelModificarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(extras, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkDucha)
                    .addComponent(checkTelevision))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(panelModificarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelModificarCeldaLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(jLabelIdCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(369, Short.MAX_VALUE)))
        );

	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(TransferCelda tCelda) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		if(tCelda != null){
			this.textCelda.setText(Integer.toString(tCelda.getNrCelda()));
			this.checkDucha.setSelected(tCelda.isDucha());
			this.checkTelevision.setSelected(tCelda.isTelevision());
		}
		else
			JOptionPane.showMessageDialog(new JFrame(), "La celda no existe", "Error", JOptionPane.ERROR_MESSAGE);
		// end-user-code
	}

	@Override
	public JPanel getPanel() {
		return this.panelModificarCelda;
	}

	@Override
	public void update(Notificaciones resultado) {
		// TODO Apéndice de método generado automáticamente
		JOptionPane.showMessageDialog(null, resultado.getNum() <= 0 ? resultado.getMensaje() : resultado.getMensaje() + resultado.getNum() , resultado.getNum() < 0 ? "Error" : "Correcto", resultado.getNum() < 0 ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
	}
}