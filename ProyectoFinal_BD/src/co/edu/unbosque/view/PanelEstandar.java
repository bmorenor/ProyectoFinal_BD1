package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.net.URL;
import java.text.ParseException;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelEstandar extends JPanel {

	private PanelMenu panelMenu;
	private Image imagenPrincipal;
	private PanelActualizar panelActualizar;
	private PanelCliente_Menu panelCliente_Menu;
	private PanelAdmin_Menu panelAdmin_Menu;
	private PanelRegistro_Usuario panelRegistro_Usuario;
	private PanelRegistro_Admin panelRegistro_Admin;
	private PanelMenu_Usuario panelMenu_Usuario;
	private PanelCliente_NuevoR panelCliente_NuevoR;
	private PanelMenu_Admin panelMenu_Admin;
	private PanelTabla panelTabla;
	private PanelRegistro_Mascota panelRegistro_Mascota;
	private PanelRegistro_Servicio panelRegistro_Servicio;
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

		panelTabla = new PanelTabla();
		panelTabla.setPreferredSize(new Dimension(500, 800));
		panelTabla.setVisible(false);
		panelTabla.setOpaque(false);

		panelRegistro_Mascota = new PanelRegistro_Mascota();
		panelRegistro_Mascota.setVisible(false);
		panelRegistro_Mascota.setOpaque(true);
		panelRegistro_Mascota.setBackground(Color.white);

		panelRegistro_Servicio = new PanelRegistro_Servicio();
		panelRegistro_Servicio.setVisible(false);
		panelRegistro_Servicio.setOpaque(true);
		panelRegistro_Servicio.setBackground(Color.white);



		imagen = this.getClass().getResource("/co/edu/unbosque/view/images/perro1.jpg");
		imagenPrincipal = new ImageIcon(imagen).getImage();

		panelMenu = new PanelMenu();
		panelMenu.setVisible(true);
		panelMenu.setOpaque(false);


		panelRegistro_Usuario = new PanelRegistro_Usuario();
		panelRegistro_Usuario.setVisible(false);
		panelRegistro_Usuario.setOpaque(false);

		panelRegistro_Admin = new PanelRegistro_Admin();
		panelRegistro_Admin.setVisible(false);
		panelRegistro_Admin.setOpaque(false);

		panelMenu_Usuario = new PanelMenu_Usuario();
		panelMenu_Usuario.setVisible(false);
		panelMenu_Usuario.setOpaque(false);

		panelCliente_Menu = new PanelCliente_Menu();
		panelCliente_Menu.setVisible(false);
		panelCliente_Menu.setOpaque(false);

		panelAdmin_Menu = new PanelAdmin_Menu();
		panelAdmin_Menu.setVisible(false);
		panelAdmin_Menu.setOpaque(false);

		panelActualizar = new PanelActualizar();
		panelActualizar.setVisible(false);
		panelActualizar.setOpaque(false);

		panelMenu_Admin = new PanelMenu_Admin();
		panelMenu_Admin.setVisible(false);
		panelMenu_Admin.setOpaque(false);

		panelCliente_NuevoR = new PanelCliente_NuevoR();
		panelCliente_NuevoR.setVisible(false);
		panelCliente_NuevoR.setOpaque(true);
		panelCliente_NuevoR.setBackground(Color.white);

		add(panelMenu);
		add(panelTabla);
		add(panelCliente_NuevoR);
		add(panelCliente_Menu);

		add(panelRegistro_Usuario);
		add(panelMenu_Usuario);
		add(panelRegistro_Admin);
		add(panelActualizar);

		add(panelAdmin_Menu);
		add(panelMenu_Admin);
		add(panelRegistro_Mascota);
		add(panelRegistro_Servicio);

	}

	public PanelRegistro_Servicio getPanelRegistro_Servicio() {
		return panelRegistro_Servicio;
	}

	public void setPanelRegistro_Servicio(PanelRegistro_Servicio panelRegistro_Servicio) {
		this.panelRegistro_Servicio = panelRegistro_Servicio;
	}

	public PanelRegistro_Mascota getPanelRegistro_Mascota() {
		return panelRegistro_Mascota;
	}

	public void setPanelRegistro_Mascota(PanelRegistro_Mascota panelRegistro_Mascota) {
		this.panelRegistro_Mascota = panelRegistro_Mascota;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(imagenPrincipal, 0, 0, getWidth(), getHeight(), this);
	}

	public Image getImagenPrincipal() {
		return imagenPrincipal;
	}

	public URL getImagen() {
		return imagen;
	}

	public void setImagen(URL imagen) {
		this.imagen = imagen;
	}

	public PanelMenu getPanelMenu() {
		return panelMenu;
	}

	public void setPanelMenu(PanelMenu panelMenu) {
		this.panelMenu = panelMenu;
	}



	public PanelActualizar getPanelActualizar() {
		return panelActualizar;
	}

	public void setPanelActualizar(PanelActualizar panelActualizar) {
		this.panelActualizar = panelActualizar;
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

	public PanelRegistro_Usuario getPanelRegistro_Usuario() {
		return panelRegistro_Usuario;
	}

	public void setPanelRegistro_Usuario(PanelRegistro_Usuario panelRegistro_Usuario) {
		this.panelRegistro_Usuario = panelRegistro_Usuario;
	}

	public PanelRegistro_Admin getPanelRegistro_Admin() {
		return panelRegistro_Admin;
	}

	public void setPanelRegistro_Admin(PanelRegistro_Admin panelRegistro_Admin) {
		this.panelRegistro_Admin = panelRegistro_Admin;
	}

	public PanelMenu_Usuario getPanelMenu_Usuario() {
		return panelMenu_Usuario;
	}

	public void setPanelMenu_Usuario(PanelMenu_Usuario panelMenu_Usuario) {
		this.panelMenu_Usuario = panelMenu_Usuario;
	}

	public JLabel getVacio() {
		return vacio;
	}

	public void setVacio(JLabel vacio) {
		this.vacio = vacio;
	}

	public void setImagenPrincipal(Image imagenPrincipal) {
		this.imagenPrincipal = imagenPrincipal;
	}

	public PanelCliente_NuevoR getPanelCliente_NuevoR() {
		return panelCliente_NuevoR;
	}

	public void setPanelCliente_NuevoR(PanelCliente_NuevoR panelCliente_NuevoR) {
		this.panelCliente_NuevoR = panelCliente_NuevoR;
	}

	public PanelMenu_Admin getPanelMenu_Admin() {
		return panelMenu_Admin;
	}

	public void setPanelMenu_Admin(PanelMenu_Admin panelMenu_Admin) {
		this.panelMenu_Admin = panelMenu_Admin;
	}

	public PanelTabla getPanelTabla() {
		return panelTabla;
	}

	public void setPanelTabla(PanelTabla panelTabla) {
		this.panelTabla = panelTabla;
	}

}
