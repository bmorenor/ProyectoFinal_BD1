package co.edu.unbosque.view;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu_Usuario extends JPanel {
	
	private JButton vacio;
	private JButton verMascota;
	private JButton añadirMascota;
	private JButton eliminarMascota;
	private JButton actualizarMascota;
	private JButton historialServicio;
	private JButton solicitudServicio;
	private JButton cerrarSesion;
	private JButton salir;
	


	public PanelMenu_Usuario() {

		setLayout(new GridLayout(7, 1, 10, 10));
		
		vacio = new JButton("VACIO");
		vacio.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		vacio.setVisible(false);


		verMascota = new JButton("Ver mascotas");
		verMascota.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		verMascota.setEnabled(true);

		añadirMascota = new JButton("Añadir mascota");
		añadirMascota.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		añadirMascota.setEnabled(true);
		
		eliminarMascota = new JButton("Eliminar mascota");
		eliminarMascota.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		eliminarMascota.setEnabled(true);
		
		actualizarMascota = new JButton("Actualizar mascota");
		actualizarMascota.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		actualizarMascota.setEnabled(true);
		
		historialServicio = new JButton("Historial Servicios");
		historialServicio.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		historialServicio.setEnabled(true);
		
		solicitudServicio = new JButton("Solicitud de servicio");
		solicitudServicio.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		solicitudServicio.setEnabled(true);

		

		cerrarSesion = new JButton("Cerrar Sesion");
		cerrarSesion.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		salir = new JButton("Salir");
		salir.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));



		add(vacio);
		
		add(verMascota);
	
		add(añadirMascota);
//		add(eliminarMascota);
//		add(actualizarMascota);
		add(historialServicio);
		add(solicitudServicio);
		add(cerrarSesion);
		add(salir);

	}



	public JButton getVacio() {
		return vacio;
	}



	public void setVacio(JButton vacio) {
		this.vacio = vacio;
	}



	public JButton getVerMascota() {
		return verMascota;
	}



	public void setVerMascota(JButton verMascota) {
		this.verMascota = verMascota;
	}



	public JButton getAñadirMascota() {
		return añadirMascota;
	}



	public void setAñadirMascota(JButton añadirMascota) {
		this.añadirMascota = añadirMascota;
	}



	public JButton getEliminarMascota() {
		return eliminarMascota;
	}



	public void setEliminarMascota(JButton eliminarMascota) {
		this.eliminarMascota = eliminarMascota;
	}



	public JButton getActualizarMascota() {
		return actualizarMascota;
	}



	public void setActualizarMascota(JButton actualizarMascota) {
		this.actualizarMascota = actualizarMascota;
	}



	public JButton getHistorialServicio() {
		return historialServicio;
	}



	public void setHistorialServicio(JButton historialServicio) {
		this.historialServicio = historialServicio;
	}



	public JButton getSolicitudServicio() {
		return solicitudServicio;
	}



	public void setSolicitudServicio(JButton solicitudServicio) {
		this.solicitudServicio = solicitudServicio;
	}



	public JButton getCerrarSesion() {
		return cerrarSesion;
	}



	public void setCerrarSesion(JButton cerrarSesion) {
		this.cerrarSesion = cerrarSesion;
	}



	public JButton getSalir() {
		return salir;
	}



	public void setSalir(JButton salir) {
		this.salir = salir;
	}




	
}
