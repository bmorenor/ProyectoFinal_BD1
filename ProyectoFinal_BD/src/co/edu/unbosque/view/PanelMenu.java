package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {
	private JButton vacio;
	private JButton cliente;
	private JButton administrador;
	private JButton consultarRegistro;
	private JButton consultarRegistros;
	private JButton salir;
	private JButton actualizar;


	public PanelMenu() {

		setLayout(new GridLayout(4, 1, 40, 40));
		
		vacio = new JButton("VACIO");
		vacio.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		
		vacio.setVisible(false);


		cliente = new JButton("Cliente");
		cliente.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		cliente.setEnabled(true);

		administrador = new JButton("Administrador");
		administrador.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		administrador.setEnabled(true);

		

		salir = new JButton("Salir");
		salir.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));



		add(vacio);
		
		add(cliente);
	
		add(administrador);
	
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


	public JButton getAdministrador() {
		return administrador;
	}


	public void setAdministrador(JButton administrador) {
		this.administrador = administrador;
	}


	public JButton getConsultarRegistro() {
		return consultarRegistro;
	}


	public void setConsultarRegistro(JButton consultarRegistro) {
		this.consultarRegistro = consultarRegistro;
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


	public JButton getActualizar() {
		return actualizar;
	}


	public void setActualizar(JButton actualizar) {
		this.actualizar = actualizar;
	}




	
}
