package presentacion.vistaPrincipal;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelConFondo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image imagen;
	String nombre;

	public PanelConFondo(String nombre) {
		super();
		this.setSize(200, 200);
		this.nombre = nombre;
	}

	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		this.imagen = new ImageIcon(nombre).getImage();
		repaint();
		g.drawImage(this.imagen, 0, 0, tam.width, tam.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}

}
