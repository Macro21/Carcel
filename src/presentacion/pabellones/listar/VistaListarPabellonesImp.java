/**
 * 
 */
package presentacion.pabellones.listar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import negocio.pabellones.TransferPabellon;
import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

public class VistaListarPabellonesImp extends VistaListarPabellones {
	private JPanel panelListarPabellones;
	private JPanel panelTabla;
	private DefaultTableModel modelo;
	private JTable tabla;
	private Map<Integer,Color> coloresEstado;
	private ArrayList<TransferPabellon> lista;

	public void initGUI() {
		coloresEstado = new HashMap<>();
		coloresEstado.put(0, new java.awt.Color(255, 0, 0));
		coloresEstado.put(1, new java.awt.Color(076, 145, 065));
		panelListarPabellones = new JPanel();
		panelListarPabellones.setOpaque(false);
		panelTabla = new JPanel(new BorderLayout());
		JButton cancelar = new javax.swing.JButton();
		cancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		cancelar.setText("Cancelar");
		cancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				initGUI();
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_PABELLONES, null);
			}
		});
		javax.swing.GroupLayout panelListarCeldasLayout = new javax.swing.GroupLayout(
				panelListarPabellones);
		panelListarPabellones.setLayout(panelListarCeldasLayout);
		panelListarCeldasLayout.setHorizontalGroup(panelListarCeldasLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						panelListarCeldasLayout
								.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(cancelar,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										115,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(192, 192, 192))
				.addGroup(
						panelListarCeldasLayout
								.createSequentialGroup()
								.addGap(47, 47, 47)
								.addComponent(panelTabla,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(47, Short.MAX_VALUE)));
		panelListarCeldasLayout
				.setVerticalGroup(panelListarCeldasLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								panelListarCeldasLayout
										.createSequentialGroup()
										.addGap(56, 56, 56)
										.addComponent(
												panelTabla,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												33, Short.MAX_VALUE)
										.addComponent(
												cancelar,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(69, 69, 69)));
		generarTabla();
		Controlador.getInstance().accion(EventoNegocio.LISTAR_PABELLONES, null);
	}

	private void generarTabla() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "ID", "Nombre de pabellón",
				"Tipo de pabellón" });
		tabla = new JTable(modelo){
			private static final long serialVersionUID = 1L;
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
				Component comp = super.prepareRenderer(renderer, row, col);
				// the color of row 'row' is taken from the colors table, if
				// 'null' setBackground will use the parent component color.
				/*int var=0;
				if((lista.get(row).getEstado()))
					var=1;*/
				comp.setBackground(coloresEstado.get(lista.get(row).getEstado() ? 1 : 0));
				return comp;
			}
		};	
		tabla.setEnabled(false);
		JScrollPane scrollPanel = new JScrollPane(tabla);
		tabla.setPreferredScrollableViewportSize(new Dimension(400, 240));
		tabla.setOpaque(false);
		panelTabla.add(scrollPanel);
		panelListarPabellones.add(panelTabla, BorderLayout.CENTER);
	}
	
	public void updateTable(ArrayList<TransferPabellon> lista) {
		this.lista=lista;
		modelo.setRowCount(lista.size());
		for (int i = 0; i < lista.size(); ++i){
			modelo.setValueAt(lista.get(i).getIdPabellon(), i, 0);
			modelo.setValueAt(lista.get(i).getNombre(), i, 1);
			modelo.setValueAt(lista.get(i).getTipo(), i, 2);			
		}
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(ArrayList<TransferPabellon> lista) {
		// begin-user-code
		this.updateTable(lista);
		// end-user-code
	}

	@Override
	public JPanel getPanel() {
		return this.panelListarPabellones;
	}
}