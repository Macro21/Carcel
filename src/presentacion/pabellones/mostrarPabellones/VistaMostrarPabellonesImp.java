package presentacion.pabellones.mostrarPabellones;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

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

import negocio.pabellones.TransferPabellon;
import negocio.pabellones.TransferPabellonComun;
import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

public class VistaMostrarPabellonesImp extends VistaMostrarPabellones {
	private JPanel panelMostrarPabellon;
	private JPanel panelTabla;
	private DefaultTableModel modelo;
	private JTable tabla;

	private JTextField jTextFieldNumPresos;
	
	public VistaMostrarPabellonesImp() {
		initGUI();
	}
	
	@Override
	public void initGUI() {
		panelMostrarPabellon = new javax.swing.JPanel();
		panelMostrarPabellon.setOpaque(false);

		JButton buscar = new javax.swing.JButton();
		JButton cancelar = new javax.swing.JButton();
		JSeparator jSeparator1 = new javax.swing.JSeparator();
		JLabel jLabelNumPresos = new javax.swing.JLabel();
		jTextFieldNumPresos = new javax.swing.JTextField();

		panelTabla = new javax.swing.JPanel();
		panelTabla.setOpaque(false);
		panelTabla.setPreferredSize(new Dimension(415, 190));
		panelMostrarPabellon.add(panelTabla);

		panelMostrarPabellon.setMaximumSize(new java.awt.Dimension(550, 398));
		panelMostrarPabellon.setPreferredSize(new java.awt.Dimension(550, 398));

		buscar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		buscar.setText("Buscar");
		        buscar.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		            	try{
		            		Controlador.getInstance().accion(EventoNegocio.MOSTRAR_PABELLONES, Integer.parseInt(jTextFieldNumPresos.getText()));
		            		Controlador.getInstance().accion(EventoNegocio.ACTUALIZAR_VISTA_MOSTRAR_PABELLONES, null);
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

		jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
		jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
		jSeparator1.setMinimumSize(new java.awt.Dimension(50, 150));

		jLabelNumPresos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jLabelNumPresos.setText("Número de presos posibles mayor a:");

		jTextFieldNumPresos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		jTextFieldNumPresos.setForeground(new java.awt.Color(102, 102, 102));

		javax.swing.GroupLayout panelMostrarPabellonLayout = new javax.swing.GroupLayout(
				panelMostrarPabellon);
		panelMostrarPabellon.setLayout(panelMostrarPabellonLayout);
		panelMostrarPabellonLayout
				.setHorizontalGroup(panelMostrarPabellonLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelMostrarPabellonLayout
										.createSequentialGroup()
										.addGroup(
												panelMostrarPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																panelMostrarPabellonLayout
																		.createSequentialGroup()
																		.addGap(104,
																				104,
																				104)
																		.addGroup(
																				panelMostrarPabellonLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addGroup(
																								panelMostrarPabellonLayout
																										.createSequentialGroup()
																										.addComponent(
																												buscar)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												cancelar,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												115,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								panelMostrarPabellonLayout
																										.createSequentialGroup()
																										.addComponent(
																												jLabelNumPresos)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jTextFieldNumPresos,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												66,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								panelMostrarPabellonLayout
																										.createSequentialGroup()
																										.addGap(67,
																												67,
																												67))))
														.addGroup(
																panelMostrarPabellonLayout
																		.createSequentialGroup()
																		.addGap(62,
																				62,
																				62)
																		.addComponent(
																				jSeparator1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				409,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																panelMostrarPabellonLayout
																		.createSequentialGroup()
																		.addGap(60,
																				60,
																				60)
																		.addComponent(
																				panelTabla,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(79, Short.MAX_VALUE)));
		panelMostrarPabellonLayout
				.setVerticalGroup(panelMostrarPabellonLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panelMostrarPabellonLayout
										.createSequentialGroup()
										.addGap(26, 26, 26)
										.addGroup(
												panelMostrarPabellonLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextFieldNumPresos,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																33,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabelNumPresos))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												panelMostrarPabellonLayout
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
										.addComponent(
												panelTabla,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(20, Short.MAX_VALUE)));
		generarTabla();
	}

	private void generarTabla() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "ID", "NºPresos/Celda",
				"Nombre pabellón", "Tipo de pabellón" });
		tabla = new JTable(modelo);
		tabla.setEnabled(false);
		//tabla.setSize(new Dimension(100,100));
		JScrollPane scrollTable = new JScrollPane(tabla);
		//scrollTable.setPreferredSize(new Dimension(196, 355));

		tabla.setPreferredScrollableViewportSize(new Dimension(395, 180));
		tabla.setOpaque(false);
		panelTabla.add(scrollTable);
		panelMostrarPabellon.add(panelTabla, BorderLayout.CENTER);

	}

	public void updateTable(ArrayList<TransferPabellon> lista) {
		modelo.setRowCount(lista.size());
		for (int i = 0; i < lista.size(); ++i){
			modelo.setValueAt(lista.get(i).getIdPabellon(), i, 0);
			modelo.setValueAt(((TransferPabellonComun)lista.get(i)).getTamanoCelda(), i, 1);
			modelo.setValueAt(lista.get(i).getNombre(), i, 2);
			modelo.setValueAt(lista.get(i).getTipo(), i, 3);
		}	
	}

	@Override
	public JPanel getPanel() {
		return this.panelMostrarPabellon;
	}

	@Override
	public void update(ArrayList<TransferPabellon> lista) {
		if(lista.size() == 0){
			JOptionPane.showMessageDialog(new JFrame(), "No hay resultados con esos datos.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else{
			this.updateTable(lista);
		}
	}

}
