/**
 * 
 */
package presentacion.presos.detalles;

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

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaDetallesPresosImp extends VistaDetallesPresos {

	private JPanel panelDetallesPreso;
	private JTextField jTextFieldIdPreso;
	private JLabel textNombre;
	private JLabel textApellidos;
	private JLabel textDni;
	private JLabel textCondena;
	private JLabel estado;

	public VistaDetallesPresosImp() {
		initGUI();
	}

	public void initGUI() {
		panelDetallesPreso = new javax.swing.JPanel();
		panelDetallesPreso.setOpaque(false);
		JLabel jLabelIdPreso = new javax.swing.JLabel();
		jTextFieldIdPreso = new javax.swing.JTextField();
		JSeparator jSeparator1 = new javax.swing.JSeparator();
		JButton buscar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();
		JLabel nombre = new javax.swing.JLabel();
		textNombre = new javax.swing.JLabel();
		JLabel apellidos = new javax.swing.JLabel();
		textApellidos = new javax.swing.JLabel();
		JLabel dni = new javax.swing.JLabel();
		textDni = new javax.swing.JLabel();
		JLabel condena = new javax.swing.JLabel();
		textCondena = new javax.swing.JLabel();
		JLabel est = new javax.swing.JLabel();
		estado = new javax.swing.JLabel();

		panelDetallesPreso.setMaximumSize(new java.awt.Dimension(550, 398));
		panelDetallesPreso.setMinimumSize(new java.awt.Dimension(550, 398));
		panelDetallesPreso.setPreferredSize(new java.awt.Dimension(550, 398));

		jLabelIdPreso.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jLabelIdPreso.setText("Identificador del preso:");

		jTextFieldIdPreso.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jTextFieldIdPreso.setForeground(new java.awt.Color(102, 102, 102));

		jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
		jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
		jSeparator1.setMinimumSize(new java.awt.Dimension(50, 150));

		buscar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		buscar.setText("Ver detalles");
		buscar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					int id = Integer.parseInt(jTextFieldIdPreso.getText());
					TransferPreso preso = new TransferPreso(id);
					Controlador.getInstance().accion(EventoNegocio.DETALLES_PRESOS, preso);
					Controlador.getInstance().accion(EventoNegocio.ACTUALIZAR_VISTA_DETALLES_PRESOS, preso);
				}
				catch(NumberFormatException ex){
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
		
		est.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
	    est.setText("Estado:");
	    estado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    	estado.setForeground(new java.awt.Color(0, 255, 51));
    	estado.setText("");
	     /* ----Aquí decido si está activo o inactivo
	     if(TransferPreso.getEstado() == true){
	    	 estado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
	    	 estado.setForeground(new java.awt.Color(0, 255, 51));
	    	 estado.setText("Activo");
	     }
	     else if(){
	    	 estado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
	    	 estado.setForeground(new java.awt.Color(255, 0, 0));
	    	 estado.setText("Inactivo");
	     }
	     */
		nombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nombre.setText("Nombre: ");

		textNombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textNombre.setForeground(new java.awt.Color(102, 102, 102));
		textNombre.setEnabled(false);
		//        textNombre.addActionListener(new java.awt.event.ActionListener() {
		//            public void actionPerformed(java.awt.event.ActionEvent evt) {
		//                textNombreActionPerformed(evt);
		//            }
		//        });

		apellidos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		apellidos.setText("Apellidos:");

		textApellidos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textApellidos.setForeground(new java.awt.Color(102, 102, 102));
		textApellidos.setEnabled(false);
		//        textApellidos.addActionListener(new java.awt.event.ActionListener() {
		//            public void actionPerformed(java.awt.event.ActionEvent evt) {
		//                textApellidosActionPerformed(evt);
		//            }
		//        });

		dni.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		dni.setText("DNI:");

		textDni.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textDni.setForeground(new java.awt.Color(102, 102, 102));
		textDni.setEnabled(false);
		//        textCeldas.addActionListener(new java.awt.event.ActionListener() {
		//            public void actionPerformed(java.awt.event.ActionEvent evt) {
		//                textCeldasActionPerformed(evt);
		//            }
		//        });

		condena.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		condena.setText("Condena:");

		textCondena.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textCondena.setForeground(new java.awt.Color(102, 102, 102));
		textCondena.setEnabled(false);
		//        textPresosCelda.addActionListener(new java.awt.event.ActionListener() {
		//            public void actionPerformed(java.awt.event.ActionEvent evt) {
		//                textPresosCeldaActionPerformed(evt);
		//            }
		//        });

		javax.swing.GroupLayout panelDetallesPresoLayout = new javax.swing.GroupLayout(panelDetallesPreso);
        panelDetallesPreso.setLayout(panelDetallesPresoLayout);
        panelDetallesPresoLayout.setHorizontalGroup(
            panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesPresoLayout.createSequentialGroup()
                .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetallesPresoLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDetallesPresoLayout.createSequentialGroup()
                                .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelDetallesPresoLayout.createSequentialGroup()
                                            .addComponent(est)
                                            .addGap(15, 15, 15))
                                        .addComponent(apellidos))
                                    .addComponent(condena)
                                    .addComponent(nombre)
                                    .addComponent(dni))
                                .addGap(72, 72, 72)
                                .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(estado)
                                    .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textDni, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCondena, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelDetallesPresoLayout.createSequentialGroup()
                                    .addComponent(buscar)
                                    .addGap(65, 65, 65)
                                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelDetallesPresoLayout.createSequentialGroup()
                                    .addComponent(jLabelIdPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldIdPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelDetallesPresoLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        panelDetallesPresoLayout.setVerticalGroup(
            panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesPresoLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(est, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDni, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(condena, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCondena, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
	}

	

	@Override
	public JPanel getPanel() {
		return this.panelDetallesPreso;
	}

	@Override
	public void update(TransferPreso transferPreso) {
		if(transferPreso != null){
			estado.setText((transferPreso.getEstado()) ? "Activo" : "Inactivo");
			estado.setForeground(transferPreso.getEstado() ? new java.awt.Color(076, 145, 065) : new java.awt.Color(255, 0, 0));			this.textNombre.setText(transferPreso.getNombre());
			this.textApellidos.setText(transferPreso.getApellidos());
			this.textDni.setText(transferPreso.getDNI());
			this.textCondena.setText(transferPreso.getCondena());
		}
		else
			JOptionPane.showMessageDialog(new JFrame(), "El preso no existe", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
}