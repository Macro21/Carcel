/**
 * 
 */
package presentacion.celdas.baja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
public class VistaBajaCeldasImp extends VistaBajaCeldas {
	private JPanel panelBajaCeldas;
	private JTextField jTextFieldIdCelda;
	private JButton aceptar;
	
	public VistaBajaCeldasImp() {
		initGUI();
	}

	public void initGUI() {
		panelBajaCeldas = new JPanel();
		panelBajaCeldas.setOpaque(false);
		JLabel jLabelIdCelda = new javax.swing.JLabel();
		jTextFieldIdCelda = new javax.swing.JTextField();
		aceptar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();

		panelBajaCeldas.setMaximumSize(new java.awt.Dimension(550, 436));
		panelBajaCeldas.setPreferredSize(new java.awt.Dimension(500, 436));

		jLabelIdCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jLabelIdCelda.setText("Identificador de celda:");

		aceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		aceptar.setText("Aceptar");
		
		aceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Apéndice de método generado automáticamente
				TransferCelda datos = null;
				try{
					datos = new TransferCelda(Integer.parseInt(jTextFieldIdCelda.getText()));
					Controlador.getInstance().accion(EventoNegocio.BAJA_CELDAS, datos);
				}
				catch(NumberFormatException exception){
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

		javax.swing.GroupLayout panelBajaCeldasLayout = new javax.swing.GroupLayout(
				panelBajaCeldas);
		panelBajaCeldas.setLayout(panelBajaCeldasLayout);
		panelBajaCeldasLayout
				.setHorizontalGroup(panelBajaCeldasLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelBajaCeldasLayout
										.createSequentialGroup()
										.addGap(77, 77, 77)
										.addGroup(
												panelBajaCeldasLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																aceptar,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																96,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabelIdCelda,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																175,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												33, Short.MAX_VALUE)
										.addGroup(
												panelBajaCeldasLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jTextFieldIdCelda,
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
		panelBajaCeldasLayout
				.setVerticalGroup(panelBajaCeldasLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelBajaCeldasLayout
										.createSequentialGroup()
										.addContainerGap(122, Short.MAX_VALUE)
										.addGroup(
												panelBajaCeldasLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelIdCelda,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																51,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextFieldIdCelda,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(78, 78, 78)
										.addGroup(
												panelBajaCeldasLayout
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
	public void update(Notificaciones resultado) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		JOptionPane.showMessageDialog(null, resultado.getNum() <= 0 ? resultado.getMensaje() : resultado.getMensaje() + resultado.getNum() , resultado.getNum() < 0 ? "Error" : "Correcto", resultado.getNum() < 0 ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
		// end-user-code
	}

	@Override
	public JPanel getPanel() {
		return this.panelBajaCeldas;
	}
}