package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelRegistro_Admin extends JPanel {
	private JButton vacio;
	private JButton vacio2;
	private JLabel cuenta;
	private JLabel contrase�a;
	private JButton aceptar;
	private JButton volver;
	private JTextField usuario;
	private JPasswordField password;
	private JButton verContrase�a;


	public PanelRegistro_Admin() {

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
		
		contrase�a = new JLabel("Contrase�a: ");
		contrase�a.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		contrase�a.setEnabled(true);
		
		password = new JPasswordField();
		password.setFont((new Font("Comic Sans MS", Font.PLAIN, 30)));


		volver = new JButton("Volver");
		volver.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		volver.setActionCommand("VOLVER_REGISTRO_ADMIN");
		volver.setEnabled(true);
		
		aceptar = new JButton("Aceptar");
		aceptar.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		aceptar.setActionCommand("ACEPTAR_REGISTRO_ADMIN");
		aceptar.setEnabled(true);

		verContrase�a = new JButton("Ver contrase�a");
		verContrase�a.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		verContrase�a.setActionCommand("VER_CONTRASE�A_REGISTRO_ADMIN");
		

		add(vacio);
		add(vacio2);
		add(cuenta);
		add(usuario);
		add(contrase�a);
		add(password);
		add(verContrase�a);
		add(aceptar);
		add(volver);


	}



	public JButton getBorrar() {
		return aceptar;
	}

	public void setBorrar(JButton borrar) {
		aceptar = borrar;
	}



	public JButton getSalir() {
		return verContrase�a;
	}

	public void setSalir(JButton salir) {
		this.verContrase�a = salir;
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



	public JLabel getContrase�a() {
		return contrase�a;
	}



	public void setContrase�a(JLabel contrase�a) {
		this.contrase�a = contrase�a;
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



	public JButton getVerContrase�a() {
		return verContrase�a;
	}



	public void setVerContrase�a(JButton verContrase�a) {
		this.verContrase�a = verContrase�a;
	}
	
	

}
