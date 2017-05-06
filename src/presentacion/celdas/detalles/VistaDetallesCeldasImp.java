/**
 * 
 */
package presentacion.celdas.detalles;

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

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaDetallesCeldasImp extends VistaDetallesCeldas {

	private JPanel panelDetallesCelda;
	private JTextField jTextFieldIdCelda;
	private JLabel textPabellon;
	private JLabel textCelda;
	private JButton buscar;
	private JCheckBox checkDucha;
	private JCheckBox checkTelevision;
	private JLabel estado;
	
	public VistaDetallesCeldasImp() {
		initGUI();
	}

	public void initGUI() {
		this.panelDetallesCelda = new JPanel();
		this.panelDetallesCelda.setOpaque(false);

		JLabel jLabelIdCelda = new javax.swing.JLabel();
		jTextFieldIdCelda = new javax.swing.JTextField();
		JSeparator jSeparator1 = new javax.swing.JSeparator();
		JLabel nPabellon = new javax.swing.JLabel();
		textPabellon = new javax.swing.JLabel();
		JLabel nCelda = new javax.swing.JLabel();
		textCelda = new javax.swing.JLabel();
		JLabel extras = new javax.swing.JLabel();
		
		checkDucha = new javax.swing.JCheckBox();
		checkDucha.setEnabled(false);
		checkTelevision = new javax.swing.JCheckBox();
		JLabel est = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
		buscar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();

		panelDetallesCelda.setMaximumSize(new java.awt.Dimension(500, 436));
		panelDetallesCelda.setMinimumSize(new java.awt.Dimension(500, 436));

		jLabelIdCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jLabelIdCelda.setText("Identificador de la celda:");

		jTextFieldIdCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jTextFieldIdCelda.setForeground(new java.awt.Color(102, 102, 102));

		jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
		jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
		jSeparator1.setMinimumSize(new java.awt.Dimension(50, 150));
		
		est.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
	    est.setText("Estado:");
	        
	    estado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
	    estado.setText("");

		nPabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nPabellon.setText("Id del pabellón:");
		textPabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

		nCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nCelda.setText("Número de celda:");

		textCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		
		extras.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		extras.setText("Extras:");

		checkDucha.setEnabled(false);
		checkDucha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		checkDucha.setText("Ducha");
		checkDucha.setOpaque(false);
	
		checkTelevision.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		checkTelevision.setText("Televisión");
		checkTelevision.setOpaque(false);
		checkTelevision.setEnabled(false);

		
		
		buscar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		buscar.setText("Ver detalles");
		       buscar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Apéndice de método generado automáticamente
					
					try{
						int idCelda = Integer.parseInt(jTextFieldIdCelda.getText());
						TransferCelda datos = new TransferCelda(idCelda);
						Controlador.getInstance().accion(EventoNegocio.DETALLES_CELDAS, datos);
						Controlador.getInstance().accion(EventoNegocio.ACTUALIZAR_VISTA_DETALLES_CELDAS, datos);
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
						EventoNegocio.ACTUALIZAR_VISTA_CELDAS, null);
			}
		});

		javax.swing.GroupLayout panelDetallesCeldaLayout = new javax.swing.GroupLayout(panelDetallesCelda);
        panelDetallesCelda.setLayout(panelDetallesCeldaLayout);
        panelDetallesCeldaLayout.setHorizontalGroup(
            panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesCeldaLayout.createSequentialGroup()
                .addGroup(panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetallesCeldaLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDetallesCeldaLayout.createSequentialGroup()
                                .addGroup(panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nCelda)
                                    .addComponent(nPabellon)
                                    .addComponent(extras)
                                    .addComponent(est))
                                .addGap(24, 24, 24)
                                .addGroup(panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(estado, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textCelda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textPabellon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkDucha)
                                    .addComponent(checkTelevision)))
                            .addGroup(panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelDetallesCeldaLayout.createSequentialGroup()
                                    .addComponent(buscar)
                                    .addGap(65, 65, 65)
                                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelDetallesCeldaLayout.createSequentialGroup()
                                    .addComponent(jLabelIdCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldIdCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelDetallesCeldaLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        panelDetallesCeldaLayout.setVerticalGroup(
            panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesCeldaLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(est, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nPabellon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPabellon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelDetallesCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetallesCeldaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(checkDucha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkTelevision))
                    .addGroup(panelDetallesCeldaLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(extras, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
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
			this.checkDucha.setSelected(tCelda.isDucha());
			this.checkTelevision.setSelected(tCelda.isTelevision());
			this.textCelda.setText(Integer.toString(tCelda.getNrCelda()));
			this.textPabellon.setText(Integer.toString(tCelda.getIdPabellon()));
			boolean estado = tCelda.isEstado();
			if(estado)
				this.estado.setForeground(new java.awt.Color(076, 145, 065));
			else
				this.estado.setForeground(new java.awt.Color(255, 0, 0));
			this.estado.setText(estado ? "Activo": "Inactivo");
		}
		else
			JOptionPane.showMessageDialog(new JFrame(), "La celda no existe", "Error", JOptionPane.ERROR_MESSAGE);
			
	}

	@Override
	public JPanel getPanel() {
		return this.panelDetallesCelda;
	}
}