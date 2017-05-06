/**
 * 
 */
package presentacion.pabellones.baja;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;
import presentacion.notificaciones.Notificaciones;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaBajaPabellonesImp extends VistaBajaPabellones {
	private JPanel panelBajaPabellon;
	private JTextField jTextFieldIdPabellon;

	public void initGUI() {
		panelBajaPabellon = new javax.swing.JPanel();
		panelBajaPabellon.setOpaque(false);
		JLabel jLabelIdPabellon = new javax.swing.JLabel();
		jTextFieldIdPabellon = new javax.swing.JTextField();
		JButton aceptar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();

		panelBajaPabellon.setMaximumSize(new java.awt.Dimension(550, 436));
		panelBajaPabellon.setPreferredSize(new java.awt.Dimension(550, 436));

		jLabelIdPabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jLabelIdPabellon.setText("Identificador de pabellon:");

		aceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		aceptar.setText("Aceptar");
		        aceptar.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		            	try{
		            		Controlador.getInstance().accion(EventoNegocio.BAJA_PABELLONES, 
		            			Integer.parseInt(jTextFieldIdPabellon.getText()));
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
		cancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		cancelar.setText("Cancelar");

		javax.swing.GroupLayout panelBajaPabellonLayout = new javax.swing.GroupLayout(
				panelBajaPabellon);
		panelBajaPabellon.setLayout(panelBajaPabellonLayout);
		panelBajaPabellonLayout
				.setHorizontalGroup(panelBajaPabellonLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelBajaPabellonLayout
										.createSequentialGroup()
										.addGap(77, 77, 77)
										.addGroup(
												panelBajaPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																aceptar,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																96,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabelIdPabellon))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												26, Short.MAX_VALUE)
										.addGroup(
												panelBajaPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jTextFieldIdPabellon,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																91,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cancelar,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																96,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(119, 119, 119)));
		panelBajaPabellonLayout
				.setVerticalGroup(panelBajaPabellonLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelBajaPabellonLayout
										.createSequentialGroup()
										.addContainerGap(122, Short.MAX_VALUE)
										.addGroup(
												panelBajaPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelIdPabellon,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																51,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextFieldIdPabellon,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(78, 78, 78)
										.addGroup(
												panelBajaPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																aceptar,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																41,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cancelar,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																41,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(144, 144, 144)));
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
		return this.panelBajaPabellon;
	}
}