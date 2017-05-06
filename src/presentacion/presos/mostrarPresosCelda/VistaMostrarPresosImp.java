package presentacion.presos.mostrarPresosCelda;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import negocio.presos.TransferEstancia;
import negocio.presos.TransferPreso;

import org.freixas.jcalendar.JCalendarCombo;

import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

public class VistaMostrarPresosImp extends VistaMostrarPresos {
	private JPanel panelMostrarPresos;
	private JPanel panelTabla;
	private DefaultTableModel modelo;
	private JTable tabla;
	private JTextField textIdCelda;
	private JCalendarCombo calendarioInicio;
	private JCalendarCombo calendarioFin;
	private JButton aceptar;
	private JLabel fechaInicio;
	private JLabel fechaFinal;
	
	public VistaMostrarPresosImp() {
		initGUI();
	}

	@Override
	public void initGUI() {
		panelMostrarPresos = new javax.swing.JPanel();
		panelMostrarPresos.setOpaque(false);
		JLabel idCelda = new javax.swing.JLabel();
		textIdCelda = new javax.swing.JTextField();
		fechaInicio = new javax.swing.JLabel();
		fechaFinal = new javax.swing.JLabel();
		aceptar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();
		JSeparator jSeparator1 = new javax.swing.JSeparator();
		calendarioInicio = new org.freixas.jcalendar.JCalendarCombo();
        calendarioFin = new org.freixas.jcalendar.JCalendarCombo();
      
        
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
        calendarioInicio.setDateFormat(df);
        calendarioInicio.setFont(new java.awt.Font("Tahoma", 0, 16));
        
        calendarioFin.setDateFormat(df);
        calendarioFin.setFont(new java.awt.Font("Tahoma", 0, 16));
        
		panelTabla = new javax.swing.JPanel();
		panelTabla.setOpaque(false);
		panelTabla.setPreferredSize(new Dimension(320, 190));
		panelMostrarPresos.add(panelTabla);

		panelMostrarPresos.setMaximumSize(new java.awt.Dimension(550, 398));
		panelMostrarPresos.setPreferredSize(new java.awt.Dimension(550, 398));

		idCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		idCelda.setText("Identificador de la celda:");

		textIdCelda.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		textIdCelda.setForeground(new java.awt.Color(102, 102, 102));
	
		fechaInicio.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		fechaInicio.setText("Fecha inicio:");

		
		fechaFinal.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		fechaFinal.setText("Fecha final:");

		aceptar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		aceptar.setText("Aceptar");
		
		aceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Apéndice de método generado automáticamente
				try{
					int id_celda = Integer.parseInt(textIdCelda.getText());
					String fechaInicio = (String) calendarioInicio.getSelectedItem();
					String fechaFin = (String) calendarioFin.getSelectedItem();
					TransferEstancia datos = new TransferEstancia(id_celda,fechaInicio,fechaFin);
					
					Controlador.getInstance().accion(EventoNegocio.PRESOS_POR_CELDA,datos);
					Controlador.getInstance().accion(EventoNegocio.ACTUALIZAR_VISTA_MOSTRAR_PRESOS_CELDA, datos);
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

		jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
		jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
		jSeparator1.setMinimumSize(new java.awt.Dimension(50, 150));


		javax.swing.GroupLayout panelMostrarPresosLayout = new javax.swing.GroupLayout(panelMostrarPresos);
        panelMostrarPresos.setLayout(panelMostrarPresosLayout);
        panelMostrarPresosLayout.setHorizontalGroup(
            panelMostrarPresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarPresosLayout.createSequentialGroup()
                .addGroup(panelMostrarPresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMostrarPresosLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMostrarPresosLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(panelMostrarPresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idCelda)
                            .addComponent(fechaFinal)
                            .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaInicio))
                        .addGap(47, 47, 47)
                        .addGroup(panelMostrarPresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelMostrarPresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(textIdCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(calendarioFin, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMostrarPresosLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        panelMostrarPresosLayout.setVerticalGroup(
            panelMostrarPresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMostrarPresosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMostrarPresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIdCelda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMostrarPresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMostrarPresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calendarioFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMostrarPresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
		generarTabla();

	}

	private void generarTabla() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "ID", "DNI", "Nombre preso" });
		tabla = new JTable(modelo);
		tabla.setEnabled(false);
		JScrollPane scrollTable = new JScrollPane(tabla);
		tabla.setPreferredScrollableViewportSize(new Dimension(300, 180));
		tabla.setOpaque(false);
		panelTabla.add(scrollTable);
		panelMostrarPresos.add(panelTabla, BorderLayout.CENTER);

	}
	@Override
	public void update(ArrayList<TransferPreso> lista) {
		if(lista == null){
			modelo.setRowCount(0);
			JOptionPane.showMessageDialog(new JFrame(), "Fechas incorrectas.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else{
			if(lista.size() == 0){
				modelo.setRowCount(0);
				JOptionPane.showMessageDialog(new JFrame(), "No hay resultados con esos datos.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else{
				modelo.setRowCount(lista.size());
				for (int i = 0; i < lista.size(); ++i){
					modelo.setValueAt(lista.get(i).getIdPreso(), i, 0);
					modelo.setValueAt(lista.get(i).getDNI(), i, 1);
					modelo.setValueAt(lista.get(i).getNombre(), i, 2);
				}
			}
		}
	}

	@Override
	public JPanel getPanel() {
		return this.panelMostrarPresos;
	}

}
