/**
 * 
 */
package presentacion.presos.baja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.presos.TransferEstancia;

import org.freixas.jcalendar.JCalendarCombo;

import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;
import presentacion.notificaciones.Notificaciones;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaBajaPresosImp extends VistaBajaPresos {

	private JPanel panelBajaPreso;
	private JTextField jTextFieldIdPreso;
	private JCalendarCombo calendario;

	public VistaBajaPresosImp() {
		initGUI();
	}

	public void initGUI() {
		panelBajaPreso = new javax.swing.JPanel();
		panelBajaPreso.setOpaque(false);
        JLabel jLabelIdPreso = new javax.swing.JLabel();
        jTextFieldIdPreso = new javax.swing.JTextField();
        JButton aceptar = new javax.swing.JButton();
        JButton cancelar = new javax.swing.JButton();
        calendario = new org.freixas.jcalendar.JCalendarCombo();
        JLabel jLabelFecha = new javax.swing.JLabel();

        panelBajaPreso.setPreferredSize(new java.awt.Dimension(550, 398));

        jLabelIdPreso.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelIdPreso.setText("Identificador de preso:");

        aceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TransferEstancia tEstancia = null;
				try{
					int idPreso = Integer.parseInt(jTextFieldIdPreso.getText());
					String fecha = (String) calendario.getSelectedItem();
					tEstancia = new TransferEstancia(idPreso,fecha);
					Controlador.getInstance().accion(EventoNegocio.BAJA_PRESOS, tEstancia);
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
        
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
        calendario.setDateFormat(df);
        calendario.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabelFecha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelFecha.setText("Escoger fecha:");

        javax.swing.GroupLayout panelBajaPresoLayout = new javax.swing.GroupLayout(panelBajaPreso);
        panelBajaPreso.setLayout(panelBajaPresoLayout);
        panelBajaPresoLayout.setHorizontalGroup(
            panelBajaPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBajaPresoLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(panelBajaPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBajaPresoLayout.createSequentialGroup()
                        .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBajaPresoLayout.createSequentialGroup()
                        .addComponent(jLabelFecha)
                        .addGap(81, 81, 81)
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBajaPresoLayout.createSequentialGroup()
                        .addComponent(jLabelIdPreso)
                        .addGap(89, 89, 89)
                        .addComponent(jTextFieldIdPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        panelBajaPresoLayout.setVerticalGroup(
            panelBajaPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBajaPresoLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(panelBajaPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBajaPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panelBajaPresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
		/*
		panelBajaPreso = new javax.swing.JPanel();
		panelBajaPreso.setOpaque(false);
		JLabel jLabelIdPreso = new javax.swing.JLabel();
		jTextFieldIdPreso = new javax.swing.JTextField();
		JButton aceptar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();

		panelBajaPreso.setMaximumSize(new java.awt.Dimension(550, 398));
		panelBajaPreso.setMinimumSize(new java.awt.Dimension(550, 398));
		panelBajaPreso.setPreferredSize(new java.awt.Dimension(550, 398));

		jLabelIdPreso.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jLabelIdPreso.setText("Identificador de preso:");

		aceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		aceptar.setText("Aceptar");
		aceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int idPreso = Integer.parseInt(jTextFieldIdPreso.getText());
				TransferPreso preso = new TransferPreso(idPreso, null, null, null, null, 0, false);
				Controlador.getInstance().accion(EventoNegocio.BAJA_PRESOS, preso);
				
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

		javax.swing.GroupLayout panelBajaPresoLayout = new javax.swing.GroupLayout(
				panelBajaPreso);
		panelBajaPreso.setLayout(panelBajaPresoLayout);
		panelBajaPresoLayout
				.setHorizontalGroup(panelBajaPresoLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelBajaPresoLayout
										.createSequentialGroup()
										.addContainerGap(103, Short.MAX_VALUE)
										.addGroup(
												panelBajaPresoLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabelIdPreso)
														.addComponent(
																aceptar,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																96,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(71, 71, 71)
										.addGroup(
												panelBajaPresoLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jTextFieldIdPreso,
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
		panelBajaPresoLayout
				.setVerticalGroup(panelBajaPresoLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelBajaPresoLayout
										.createSequentialGroup()
										.addContainerGap(122, Short.MAX_VALUE)
										.addGroup(
												panelBajaPresoLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabelIdPreso,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																51,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextFieldIdPreso,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																30,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(78, 78, 78)
										.addGroup(
												panelBajaPresoLayout
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
	*/
	}

	

	@Override
	public JPanel getPanel() {
		return this.panelBajaPreso;
	}


	@Override
	public void update(Notificaciones notificaciones) {
		JOptionPane.showMessageDialog(null, notificaciones.getNum() <= 0 ? notificaciones.getMensaje() : notificaciones.getMensaje() + notificaciones.getNum() , notificaciones.getNum() < 0 ? "Error" : "Correcto", notificaciones.getNum() < 0 ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
		
	}
}