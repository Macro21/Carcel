/**
 * 
 */
package presentacion.celdas.listar;

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

import negocio.celdas.TransferCelda;
import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author andi_
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaListarCeldasImp extends VistaListarCeldas {
	private JPanel panelListarCeldas;
	private JPanel panelTabla;
	private DefaultTableModel modelo;
	private JTable tabla;
	//private Map<Integer,Color> coloresPab;
	private Map<Integer,Color> coloresEstado;
	private ArrayList<TransferCelda> lista;

	public VistaListarCeldasImp() {
		initGUI();
	}

	public void initGUI() {
		
		panelListarCeldas = new JPanel();
		panelListarCeldas.setOpaque(false);
		panelTabla = new JPanel(new BorderLayout());
		coloresEstado = new HashMap<Integer,Color>();
		coloresEstado.put(0, Color.RED);
		coloresEstado.put(1,Color.GREEN);
		JButton cancelar = new javax.swing.JButton();
		cancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
		cancelar.setText("Cancelar");
		cancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				initGUI();
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_CELDAS, null);
			}
		});
		
		javax.swing.GroupLayout panelListarCeldasLayout = new javax.swing.GroupLayout(
				panelListarCeldas);
		panelListarCeldas.setLayout(panelListarCeldasLayout);
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
	//	updateTable();
		panelListarCeldas.add(panelTabla);
		
	}

	private void generarTabla() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "ID", "Número de celda",
				"Id del pabellón" });
		//tabla = new JTable(modelo);
		tabla = new JTable(modelo){
			private static final long serialVersionUID = 1L;
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
				Component comp = super.prepareRenderer(renderer, row, col);
				// the color of row 'row' is taken from the colors table, if
				// 'null' setBackground will use the parent component color.
				comp.setBackground(coloresEstado.get(lista.get(row).isEstado() ? 1 : 0));
				return comp;
			}
		};	
		tabla.setEnabled(false);
		JScrollPane scrollPanel = new JScrollPane(tabla);
		tabla.setPreferredScrollableViewportSize(new Dimension(400, 240));
		tabla.setOpaque(false);
		panelTabla.add(scrollPanel);
		panelListarCeldas.add(panelTabla, BorderLayout.CENTER);

	}
	
	@Override
	public JPanel getPanel() {
		return this.panelListarCeldas;
	}

	/*private void rellenarHash(int idPab){
	//087-166-057
		if(idPab == 1)
			coloresPab.put(idPab, Color.CYAN);
		else if (idPab == 2)
			coloresPab.put(idPab, Color.LIGHT_GRAY);
		else if (idPab == 3)
			coloresPab.put(idPab, Color.ORANGE);
		else if (idPab == 4)
			coloresPab.put(idPab, Color.MAGENTA);
		else if (idPab == 5)
			coloresPab.put(idPab, Color.GRAY);
	}*/
	
	
	@Override
	public void update(ArrayList<TransferCelda> listaCeldas) {
		// TODO Auto-generated method stub
		//coloresPab = new HashMap<>();
		this.lista=listaCeldas;
		modelo.setRowCount(listaCeldas.size());
		for (int i = 0; i < listaCeldas.size(); ++i){
			modelo.setValueAt(listaCeldas.get(i).getIdCelda(), i, 0);
			modelo.setValueAt(listaCeldas.get(i).getNrCelda(), i, 1);
			modelo.setValueAt(listaCeldas.get(i).getIdPabellon(), i, 2);
			//rellenarHash(listaCeldas.get(i).getIdPabellon());
		}
	}
}