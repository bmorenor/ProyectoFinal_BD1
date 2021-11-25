package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAdmin_Menu extends JPanel {
	private JButton vacio;
	private JButton cuenta;
	private JButton registrar;
	private JButton volver;
//	private JButton salir;

	public PanelAdmin_Menu() {

		setLayout(new GridLayout(3, 1, 40, 40));

		vacio = new JButton("VACIO");
		vacio.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));

		vacio.setVisible(false);

		cuenta = new JButton("Iniciar Sesión");
		cuenta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

		cuenta.setEnabled(true);


		volver = new JButton("Volver");
		volver.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		volver.setEnabled(true);

//		salir = new JButton("Salir");
//		salir.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

		add(vacio);

		add(cuenta);

		add(volver);

//		add(salir);

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

	public JButton getRegistrar() {
		return registrar;
	}

	public void setRegistrar(JButton registrar) {
		this.registrar = registrar;
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

//	public JButton getSalir() {
//		return salir;
//	}
//
//	public void setSalir(JButton salir) {
//		this.salir = salir;
//	}


	

}
