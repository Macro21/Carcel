/**
 * 
 */
package presentacion.pabellones.detalles;

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
public class VistaDetallesPabellonesImp extends VistaDetallesPabellones {
	private JPanel panelDetallesPabellon;
	private JTextField jTextFieldIdPabellon;
	private JLabel textNombrePabellon;
	private JLabel textCeldas;
	private JLabel textPresosCeldaOVigilantes;
	private JLabel textTipo;
	private JLabel estado;
	private JLabel nPresosCeldaOVigilantes;

	public VistaDetallesPabellonesImp() {
		initGUI();
	}
	
	public void initGUI() {
		panelDetallesPabellon = new javax.swing.JPanel();
		panelDetallesPabellon.setOpaque(false);
		JLabel jLabelIdPabellon = new javax.swing.JLabel();
		jTextFieldIdPabellon = new javax.swing.JTextField();
		JSeparator jSeparator1 = new javax.swing.JSeparator();
		JButton buscar = new javax.swing.JButton();
		JLabel nombrePabellon = new javax.swing.JLabel();
		textNombrePabellon = new javax.swing.JLabel();
		textTipo = new javax.swing.JLabel();
		JLabel tipoPabellon = new javax.swing.JLabel();
		JLabel nMaxCeldas = new javax.swing.JLabel();
		textCeldas = new javax.swing.JLabel();
		nPresosCeldaOVigilantes = new javax.swing.JLabel();
		textPresosCeldaOVigilantes = new javax.swing.JLabel();
		JButton cancelar = new javax.swing.JButton();
		JLabel est = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();

		panelDetallesPabellon.setMaximumSize(new java.awt.Dimension(550, 436));
		panelDetallesPabellon.setMinimumSize(new java.awt.Dimension(550, 436));
		panelDetallesPabellon
				.setPreferredSize(new java.awt.Dimension(550, 436));

		jLabelIdPabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jLabelIdPabellon.setText("Identificador del pabellon:");

		jTextFieldIdPabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jTextFieldIdPabellon.setForeground(new java.awt.Color(102, 102, 102));

		jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
		jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
		jSeparator1.setMinimumSize(new java.awt.Dimension(50, 150));
		
		est.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
	    est.setText("Estado:");

	    estado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
	    estado.setText("");

		buscar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		buscar.setText("Ver detalles");
		        buscar.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		            	try{
		            		Controlador.getInstance().accion(EventoNegocio.DETALLES_PABELLONES, Integer.parseInt(jTextFieldIdPabellon.getText()));
		            		Controlador.getInstance().accion(EventoNegocio.ACTUALIZAR_VISTA_DETALLES_PABELLONES, null);
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

		tipoPabellon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		tipoPabellon.setText("Tipo de pabellón:");

		textTipo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textTipo.setForeground(new java.awt.Color(102, 102, 102));

		nMaxCeldas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nMaxCeldas.setText("Número máximo de celdas:");

		textCeldas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textCeldas.setForeground(new java.awt.Color(102, 102, 102));

		nPresosCeldaOVigilantes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		nPresosCeldaOVigilantes.setText("Número de presos por celda:");

		textPresosCeldaOVigilantes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textPresosCeldaOVigilantes.setForeground(new java.awt.Color(102, 102, 102));

		cancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		cancelar.setText("Cancelar");
		cancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_PABELLONES, null);
			}
		});

		javax.swing.GroupLayout panelDetallesPabellonLayout = new javax.swing.GroupLayout(panelDetallesPabellon);
        panelDetallesPabellon.setLayout(panelDetallesPabellonLayout);
        panelDetallesPabellonLayout.setHorizontalGroup(
            panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesPabellonLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDetallesPabellonLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDetallesPabellonLayout.createSequentialGroup()
                                .addGroup(panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelDetallesPabellonLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelDetallesPabellonLayout.createSequentialGroup()
                                        .addComponent(jLabelIdPabellon, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldIdPabellon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                            .addGroup(panelDetallesPabellonLayout.createSequentialGroup()
                                .addComponent(buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetallesPabellonLayout.createSequentialGroup()
                                .addGroup(panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelDetallesPabellonLayout.createSequentialGroup()
                                        .addComponent(nPresosCeldaOVigilantes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textPresosCeldaOVigilantes, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelDetallesPabellonLayout.createSequentialGroup()
                                        .addComponent(nMaxCeldas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textCeldas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelDetallesPabellonLayout.createSequentialGroup()
                                        .addComponent(est)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(estado))
                                    .addGroup(panelDetallesPabellonLayout.createSequentialGroup()
                                        .addComponent(tipoPabellon)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelDetallesPabellonLayout.createSequentialGroup()
                                        .addComponent(nombrePabellon)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textNombrePabellon, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(23, 23, 23)))))
                .addGap(81, 81, 81))
        );
        panelDetallesPabellonLayout.setVerticalGroup(
            panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetallesPabellonLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdPabellon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdPabellon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(est, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombrePabellon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNombrePabellon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoPabellon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nMaxCeldas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCeldas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesPabellonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nPresosCeldaOVigilantes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPresosCeldaOVigilantes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
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
			textNombrePabellon.setText(tp.getNombre());
			textCeldas.setText(String.valueOf(tp.getNumMaxCeldas()));
			if(tp.getTipo().equalsIgnoreCase("aislamiento")){
				nPresosCeldaOVigilantes.setText("Numero de vigilantes: ");
				textPresosCeldaOVigilantes.setText(String.valueOf(((TransferPabellonAislamiento)tp).getNumVigilantes()));
			}
			else if (tp.getTipo().equalsIgnoreCase("comun")){
				nPresosCeldaOVigilantes.setText("Numero de presos por celda: ");
				textPresosCeldaOVigilantes.setText(String.valueOf(((TransferPabellonComun)tp).getTamanoCelda()));
			}
			textTipo.setText(tp.getTipo());
			estado.setText((tp.getEstado()) ? "Activo" : "Inactivo");
			estado.setForeground(tp.getEstado() ? new java.awt.Color(076, 145, 065) : new java.awt.Color(255, 0, 0));
		}
		// end-user-code
	}

	@Override
	public JPanel getPanel() {
		return this.panelDetallesPabellon;
	}
}