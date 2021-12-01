package co.edu.unbosque.view;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class PanelMenu_Usuario extends JPanel {
	
	private JButton vacio;
	private JButton verMascota;
	private JButton anadirMascota;
	private JButton eliminarMascota;
	private JButton facturas;
	private JButton historialServicio;
	private JButton solicitudServicio;
	private JButton cerrarSesion;
	private JButton salir;
	


	public PanelMenu_Usuario() {

		setLayout(new GridLayout(8, 1, 10, 10));
		
		vacio = new JButton("VACIO");
		vacio.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		vacio.setVisible(false);


		verMascota = new JButton("Ver mascotas");
		verMascota.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		verMascota.setEnabled(true);

		anadirMascota = new JButton("A�adir mascota");
		anadirMascota.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		anadirMascota.setEnabled(true);
		
		eliminarMascota = new JButton("Eliminar mascota");
		eliminarMascota.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		eliminarMascota.setEnabled(true);
		
		facturas = new JButton("Facturas");
		facturas.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		facturas.setEnabled(true);
		
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
	
		add(anadirMascota);
//		add(eliminarMascota);
//		add(actualizarMascota);
		add(solicitudServicio);
		add(historialServicio);
		add(facturas);
		add(cerrarSesion);
		add(salir);

	}



	public JButton getFacturas() {
		return facturas;
	}



	public void setFacturas(JButton facturas) {
		this.facturas = facturas;
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


	public JButton getAnadirMascota() {
		return anadirMascota;
	}

	public void setAnadirMascota(JButton anadirMascota) {
		this.anadirMascota = anadirMascota;
	}

	public JButton getEliminarMascota() {
		return eliminarMascota;
	}



	public void setEliminarMascota(JButton eliminarMascota) {
		this.eliminarMascota = eliminarMascota;
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
