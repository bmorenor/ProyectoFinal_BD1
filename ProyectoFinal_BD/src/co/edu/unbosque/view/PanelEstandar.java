package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.net.URL;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEstandar extends JPanel {

	private PanelAdmin_Menu panelMenu;
	private Image imagenPrincipal;
	private PanelRegistrar panelRegistrar;
	private PanelEliminar panelEliminar;
	private PanelActualizar panelActualizar;
	private PanelConsulta_Registro panelConsulta_Registro;
	private PanelCliente_Menu panelCliente_Menu;
	private PanelAdmin_Menu panelAdmin_Menu;
	private JLabel vacio;
	private URL imagen;

	/**
	 * Este metodo inicializa el panel estandar <b>pre</b>Inicializar la vista
	 * principal <br>
	 * <b>post</b>Inicializar los paneles que este posee <br>
	 * 
	 * @param vista Se recibe como parametro ya que es donde se va a inicializar
	 *              todos los paneles
	 * @throws ParseException
	 */
	public PanelEstandar(VistaPrincipal vista) throws ParseException {
		
		setLayout(new FlowLayout());
		vacio = new JLabel("");

		panelRegistrar = new PanelRegistrar();
		panelRegistrar.setVisible(false);
		panelRegistrar.setOpaque(false);

		imagen = this.getClass().getResource("/co/edu/unbosque/view/images/perro1.jpg");
		imagenPrincipal = new ImageIcon(imagen).getImage();

		panelMenu = new PanelAdmin_Menu();
		panelMenu.setVisible(false);
		panelMenu.setOpaque(false);

		panelRegistrar = new PanelRegistrar();
		panelRegistrar.setVisible(false);
		panelRegistrar.setOpaque(false);

		panelEliminar = new PanelEliminar();
		panelEliminar.setVisible(false);
		panelEliminar.setOpaque(false);
		
		panelCliente_Menu = new PanelCliente_Menu();
		panelCliente_Menu.setVisible(true);
		panelCliente_Menu.setOpaque(false);

		panelAdmin_Menu = new PanelAdmin_Menu();
		panelCliente_Menu.setVisible(true);
		panelCliente_Menu.setOpaque(false);
		
		panelConsulta_Registro = new PanelConsulta_Registro();
		panelConsulta_Registro.setVisible(false);
		panelConsulta_Registro.setOpaque(false);

		panelActualizar = new PanelActualizar();
		panelActualizar.setVisible(false);
		panelActualizar.setOpaque(false);
		
		add(panelMenu);
		add(panelCliente_Menu);
		add(panelRegistrar);
		add(panelActualizar);
		add(panelConsulta_Registro);
		add(vacio);
		add(panelEliminar);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(imagenPrincipal, 0, 0, getWidth(), getHeight(), this);
	}

	public PanelAdmin_Menu getPanelMenu() {
		return panelMenu;
	}

	public void setPanelMenu(PanelAdmin_Menu panelMenu) {
		this.panelMenu = panelMenu;
	}

	public Image getImagenPrincipal() {
		return imagenPrincipal;
	}

	public void setImagenPrincipal(Image imagenPrincipal) {
		this.imagenPrincipal = imagenPrincipal;
	}

	public PanelRegistrar getPanelRegistrar() {
		return panelRegistrar;
	}

	public void setPanelRegistrar(PanelRegistrar panelRegistrar) {
		this.panelRegistrar = panelRegistrar;
	}
	

	public PanelCliente_Menu getPanelCliente_Menu() {
		return panelCliente_Menu;
	}

	public void setPanelCliente_Menu(PanelCliente_Menu panelCliente_Menu) {
		this.panelCliente_Menu = panelCliente_Menu;
	}

	public PanelAdmin_Menu getPanelAdmin_Menu() {
		return panelAdmin_Menu;
	}

	public void setPanelAdmin_Menu(PanelAdmin_Menu panelAdmin_Menu) {
		this.panelAdmin_Menu = panelAdmin_Menu;
	}

	public PanelEliminar getPanelEliminar() {
		return panelEliminar;
	}

	public void setPanelEliminar(PanelEliminar panelEliminar) {
		this.panelEliminar = panelEliminar;
	}

	public PanelActualizar getPanelActualizar() {
		return panelActualizar;
	}

	public void setPanelActualizar(PanelActualizar panelActualizar) {
		this.panelActualizar = panelActualizar;
	}

	public JLabel getVacio() {
		return vacio;
	}

	public void setVacio(JLabel vacio) {
		this.vacio = vacio;
	}

	public URL getImagen() {
		return imagen;
	}

	public void setImagen(URL imagen) {
		this.imagen = imagen;
	}

	public PanelConsulta_Registro getPanelConsulta_Registro() {
		return panelConsulta_Registro;
	}

	public void setPanelConsulta_Registro(PanelConsulta_Registro panelConsulta_Registro) {
		this.panelConsulta_Registro = panelConsulta_Registro;
	}

}
