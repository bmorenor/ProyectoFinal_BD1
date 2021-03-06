package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu_Admin extends JPanel {
	private JButton vacio;
	private JButton cliente;
	private JButton mascota;
	private JButton historialServicios;
	private JButton consultarRegistros;
	private JButton salir;
	private JButton facturas;

	public PanelMenu_Admin() {

		setLayout(new GridLayout(6, 1, 10, 10));

		vacio = new JButton("VACIO");
		vacio.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));

		vacio.setVisible(false);

		cliente = new JButton("Ver clientes");
		cliente.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

		cliente.setEnabled(true);

		mascota = new JButton("Ver mascotas");
		mascota.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		mascota.setEnabled(true);

		historialServicios = new JButton("Ver historial");
		historialServicios.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		historialServicios.setEnabled(true);
		
		facturas = new JButton("Ver facturas");
		facturas.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		facturas.setEnabled(true);

		salir = new JButton("Salir");
		salir.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

		add(vacio);

		add(cliente);

		add(mascota);
		add(historialServicios);
		add(facturas);

		add(salir);

	}

	public JButton getVacio() {
		return vacio;
	}

	public void setVacio(JButton vacio) {
		this.vacio = vacio;
	}

	public JButton getCliente() {
		return cliente;
	}

	public void setCliente(JButton cliente) {
		this.cliente = cliente;
	}

	public JButton getMascota() {
		return mascota;
	}

	public void setMascota(JButton mascota) {
		this.mascota = mascota;
	}

	public JButton getHistorialServicios() {
		return historialServicios;
	}

	public void setHistorialServicios(JButton historialServicios) {
		this.historialServicios = historialServicios;
	}

	public JButton getConsultarRegistros() {
		return consultarRegistros;
	}

	public void setConsultarRegistros(JButton consultarRegistros) {
		this.consultarRegistros = consultarRegistros;
	}

	public JButton getSalir() {
		return salir;
	}

	public void setSalir(JButton salir) {
		this.salir = salir;
	}

	public JButton getFacturas() {
		return facturas;
	}

	public void setFacturas(JButton facturas) {
		this.facturas = facturas;
	}



}
