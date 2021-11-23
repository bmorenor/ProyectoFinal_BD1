package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCliente_Menu extends JPanel {
	private JButton vacio;
	private JButton cuenta;
	private JButton registrar;
	private JButton volver;
	private JButton salir;

	public PanelCliente_Menu() {

		setLayout(new GridLayout(5, 1, 40, 40));

		vacio = new JButton("VACIO");
		vacio.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));

		vacio.setVisible(false);

		cuenta = new JButton("Iniciar Sesión");
		cuenta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

		cuenta.setEnabled(true);

		registrar = new JButton("Registrarse");
		registrar.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		registrar.setEnabled(true);

		volver = new JButton("Volver");
		volver.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		volver.setEnabled(true);

		salir = new JButton("Salir");
		salir.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

		add(vacio);

		add(cuenta);

		add(registrar);

		add(volver);

		add(salir);

	}

	public JButton getRegistrar() {
		return cuenta;
	}

	public void setRegistrar(JButton registrar) {
		cuenta = registrar;
	}

	public JButton getBorrar() {
		return registrar;
	}

	public void setBorrar(JButton borrar) {
		registrar = borrar;
	}



	public JButton getSalir() {
		return salir;
	}

	public void setSalir(JButton salir) {
		this.salir = salir;
	}


	public JButton getVacio() {
		return vacio;
	}

	public void setVacio(JButton vacio) {
		this.vacio = vacio;
	}

	public JButton getCuenta() {
		return cuenta;
	}

	public void setCuenta(JButton cuenta) {
		this.cuenta = cuenta;
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}
	

}
