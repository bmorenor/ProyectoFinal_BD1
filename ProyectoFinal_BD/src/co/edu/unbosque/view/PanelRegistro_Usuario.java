package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class PanelRegistro_Usuario extends JPanel {
	private JButton vacio;
	private JButton vacio2;
	private JLabel cuenta;
	private JLabel contrasenia;
	private JButton aceptar;
	private JButton volver;
	private JTextField usuario;
	private JPasswordField password;
	private JButton verContrasena;


	public PanelRegistro_Usuario() {

		setLayout(new GridLayout(5, 2, 40, 40));

		vacio = new JButton("VACIO");
		vacio.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));

		vacio.setVisible(false);
		vacio2 = new JButton("VACIO");
		vacio2.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));

		vacio2.setVisible(false);

		cuenta = new JLabel("Nombre de usuario: ");
		cuenta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		cuenta.setEnabled(true);
		
		usuario = new JTextField();
		usuario.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		usuario.setEnabled(true);
		
		contrasenia = new JLabel("Contrasena: ");
		contrasenia.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		contrasenia.setEnabled(true);
		
		password = new JPasswordField();
		password.setFont((new Font("Comic Sans MS", Font.PLAIN, 20)));


		volver = new JButton("Volver");
		volver.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		volver.setActionCommand("VOLVER_REGISTRO_USUARIO");
		volver.setEnabled(true);
		
		aceptar = new JButton("Aceptar");
		aceptar.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		aceptar.setActionCommand("ACEPTAR_REGISTRO_USUARIO");
		aceptar.setEnabled(true);

		verContrasena = new JButton("Ver/ocultar contrasena");
		verContrasena.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		verContrasena.setActionCommand("VER_CONTRASE�A_REGISTRO_USUARIO");
		

		add(vacio);
		add(vacio2);
		add(cuenta);
		add(usuario);
		add(contrasenia);
		add(password);
		add(verContrasena);
		add(aceptar);
		add(volver);


	}



	public JButton getBorrar() {
		return aceptar;
	}

	public void setBorrar(JButton borrar) {
		aceptar = borrar;
	}



	public JButton getVacio() {
		return vacio;
	}

	public void setVacio(JButton vacio) {
		this.vacio = vacio;
	}


	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}



	public JButton getVacio2() {
		return vacio2;
	}



	public void setVacio2(JButton vacio2) {
		this.vacio2 = vacio2;
	}



	public JLabel getCuenta() {
		return cuenta;
	}



	public void setCuenta(JLabel cuenta) {
		this.cuenta = cuenta;
	}







	public JLabel getContrasenia() {
		return contrasenia;
	}



	public void setContrasenia(JLabel contrasenia) {
		this.contrasenia = contrasenia;
	}



	public JButton getAceptar() {
		return aceptar;
	}



	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}



	public JTextField getUsuario() {
		return usuario;
	}



	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}



	public JPasswordField getPassword() {
		return password;
	}



	public void setPassword(JPasswordField password) {
		this.password = password;
	}


	public JButton getVerContrasena() {
		return verContrasena;
	}

	public void setVerContrasena(JButton verContrasena) {
		this.verContrasena = verContrasena;
	}
}
