package presentacion.presos.asignar;

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

import negocio.presos.TransferPreso;

import org.freixas.jcalendar.JCalendarCombo;

import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;
import presentacion.notificaciones.Notificaciones;

public class VistaAsignarCeldaImp extends VistaAsignarCelda {
	private JPanel panelAsignarCelda;
	private JTextField textCelda;
	private JTextField textPreso;
	private JCalendarCombo calendario;

	public VistaAsignarCeldaImp() {
		initGUI();
	}

	public void initGUI() {
		panelAsignarCelda = new javax.swing.JPanel();
		panelAsignarCelda.setOpaque(false);
		JLabel idCelda = new javax.swing.JLabel();
		JLabel idPreso = new javax.swing.JLabel();
		JLabel jLabelFecha = new javax.swing.JLabel();
		textCelda = new javax.swing.JTextField();
		textPreso = new javax.swing.JTextField();
		JButton aceptar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();
		calendario = new org.freixas.jcalendar.JCalendarCombo();

		panelAsignarCelda.setPreferredSize(new java.awt.Dimension(550, 398));

		idCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		idCelda.setText("Identificador de la celda: ");

		idPreso.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		idPreso.setText("Identificador del preso:");

		textCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textCelda.setForeground(new java.awt.Color(102, 102, 102));

		textPreso.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textPreso.setForeground(new java.awt.Color(102, 102, 102));
	
		jLabelFecha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelFecha.setText("Fecha asignación:");
        
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
        calendario.setDateFormat(df);
        calendario.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        
		aceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		aceptar.setText("Aceptar");
		        aceptar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						TransferPreso preso = null;
						try{
							int idCelda = Integer.parseInt(textCelda.getText());
							int idPreso = Integer.parseInt(textPreso.getText());
							String fecha = (String) calendario.getSelectedItem();
							preso = new TransferPreso(idCelda,idPreso,fecha);
							Controlador.getInstance().accion(EventoNegocio.ASIGNAR_CELDA, preso);
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

		javax.swing.GroupLayout panelAsignarCeldaLayout = new javax.swing.GroupLayout(panelAsignarCelda);
        panelAsignarCelda.setLayout(panelAsignarCeldaLayout);
        panelAsignarCeldaLayout.setHorizontalGroup(
            panelAsignarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsignarCeldaLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(panelAsignarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelAsignarCeldaLayout.createSequentialGroup()
                        .addComponent(jLabelFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAsignarCeldaLayout.createSequentialGroup()
                        .addComponent(idPreso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAsignarCeldaLayout.createSequentialGroup()
                        .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAsignarCeldaLayout.createSequentialGroup()
                        .addComponent(idCelda)
                        .addGap(33, 33, 33)
                        .addComponent(textCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        panelAsignarCeldaLayout.setVerticalGroup(
            panelAsignarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsignarCeldaLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(panelAsignarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panelAsignarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPreso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelAsignarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(panelAsignarCeldaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );
	}

	public void update(Notificaciones notificaciones) {
		JOptionPane.showMessageDialog(null, notificaciones.getNum() <= 0 ? notificaciones.getMensaje() : notificaciones.getMensaje() + notificaciones.getNum() , notificaciones.getNum() < 0 ? "Error" : "Correcto", notificaciones.getNum() < 0 ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE);	
	}

	@Override
	public JPanel getPanel() {
		return this.panelAsignarCelda;
	}
}
