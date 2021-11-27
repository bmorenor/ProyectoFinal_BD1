package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelCliente_NuevoR extends JPanel {
	private JButton vacio;
	private JLabel vacio2;
	private JButton aceptar;
	private JButton volver;
	private JTextField nombresT;
	private JLabel nombresL;
	private JTextField apellidosT;
	private JLabel apellidosL;
	private JTextField direccionT;
	private JLabel direccionL;
	private JTextField correoT;
	private JLabel correoL;
	private JTextField documentoT;
	private JLabel documentoL;
	private JTextField telefonosT;
	private JLabel telefonosL;
	private JTextField usuarioT;
	private JLabel usuarioL;
	private JPasswordField contraseña1T;
	private JLabel contraseña1L;
	private JPasswordField contraseña2T;
	private JLabel contraseña2L;
	private JButton verContraseña;
	
	public PanelCliente_NuevoR() {

		setLayout(new GridLayout(12, 2,0,0));

		vacio = new JButton("VACIO");
		vacio.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));

		vacio.setVisible(false);
		vacio2 = new JLabel("Registro Cliente   ");
		vacio2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
//		vacio2.setForeground(Color.black);
		vacio2.setVisible(true);

		nombresL = new JLabel("Nombres: ");
		nombresL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		nombresL.setForeground(Color.white);
		nombresL.setEnabled(true);

		nombresT = new JTextField();
		nombresT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		nombresT.setEnabled(true);

		apellidosL = new JLabel("Apellidos: ");
		apellidosL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		apellidosL.setForeground(Color.black);
		apellidosL.setEnabled(true);

		apellidosT = new JTextField();
		apellidosT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		apellidosT.setEnabled(true);

		direccionL = new JLabel("Dirección: ");
		direccionL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		direccionL.setForeground(Color.white);
		direccionL.setEnabled(true);

		direccionT = new JTextField();
		direccionT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		direccionT.setEnabled(true);

		correoL = new JLabel("Correo: ");
		correoL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		correoL.setForeground(Color.black);
		correoL.setEnabled(true);

		correoT = new JTextField();
		correoT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		correoT.setEnabled(true);

		documentoL = new JLabel("Documento de identidad: ");
		documentoL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		documentoL.setForeground(Color.white);
		documentoL.setEnabled(true);

		documentoT = new JTextField();
		documentoT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		documentoT.setEnabled(true);

		telefonosL = new JLabel("Telefonos: ");
		telefonosL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		telefonosL.setForeground(Color.black);
		telefonosL.setEnabled(true);

		telefonosT = new JTextField();
		telefonosT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		telefonosT.setEnabled(true);
		
		usuarioL = new JLabel("Usuario: ");
		usuarioL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		telefonosL.setForeground(Color.black);
		usuarioL.setEnabled(true);
		
		usuarioT = new JTextField();
		usuarioT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		usuarioT.setEnabled(true);
		
		contraseña1L = new JLabel("Contraseña: ");
		contraseña1L.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		telefonosL.setForeground(Color.black);
		contraseña1L.setEnabled(true);
		
		contraseña1T = new JPasswordField();
		contraseña1T.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		contraseña1T.setEnabled(true);
		
		contraseña2L = new JLabel("Confirme contraseña: ");
		contraseña2L.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		telefonosL.setForeground(Color.black);
		contraseña2L.setEnabled(true);
		
		contraseña2T = new JPasswordField();
		contraseña2T.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		contraseña2T.setEnabled(true);

		verContraseña = new JButton("Ver/ocultar contraseña");
		verContraseña.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
	
		
		volver = new JButton("Volver");
		volver.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		volver.setEnabled(true);

		aceptar = new JButton("Aceptar");
		aceptar.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		aceptar.setEnabled(true);

//		add(vacio);
		add(vacio2);
		add(vacio);
		add(nombresL);
		add(nombresT);
		add(apellidosL);
		add(apellidosT);
		add(direccionL);
		add(direccionT);
		add(correoL);
		add(correoT);
		add(documentoL);
		add(documentoT);
		add(telefonosL);
		add(telefonosT);
		add(usuarioL);
		add(usuarioT);
		add(contraseña1L);
		add(contraseña1T);
		add(contraseña2L);
		add(contraseña2T);
		add(aceptar);
		add(verContraseña);
		add(volver);

	}
	

	public JPasswordField getContraseña1T() {
		return contraseña1T;
	}


	public void setContraseña1T(JPasswordField contraseña1t) {
		contraseña1T = contraseña1t;
	}


	public JLabel getContraseña1L() {
		return contraseña1L;
	}


	public void setContraseña1L(JLabel contraseña1l) {
		contraseña1L = contraseña1l;
	}


	public JPasswordField getContraseña2T() {
		return contraseña2T;
	}


	public void setContraseña2T(JPasswordField contraseña2t) {
		contraseña2T = contraseña2t;
	}


	public JLabel getContraseña2L() {
		return contraseña2L;
	}


	public void setContraseña2L(JLabel contraseña2l) {
		contraseña2L = contraseña2l;
	}


	public JButton getVerContraseña() {
		return verContraseña;
	}


	public void setVerContraseña(JButton verContraseña) {
		this.verContraseña = verContraseña;
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



	public JButton getAceptar() {
		return aceptar;
	}

	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}

	public JTextField getNombresT() {
		return nombresT;
	}

	public void setNombresT(JTextField nombresT) {
		this.nombresT = nombresT;
	}

	public JLabel getNombresL() {
		return nombresL;
	}

	public void setNombresL(JLabel nombresL) {
		this.nombresL = nombresL;
	}

	public JTextField getApellidosT() {
		return apellidosT;
	}

	public void setApellidosT(JTextField apellidosT) {
		this.apellidosT = apellidosT;
	}

	public JLabel getApellidosL() {
		return apellidosL;
	}

	public void setApellidosL(JLabel apellidosL) {
		this.apellidosL = apellidosL;
	}

	public JTextField getDireccionT() {
		return direccionT;
	}

	public void setDireccionT(JTextField direccionT) {
		this.direccionT = direccionT;
	}

	public JLabel getDireccionL() {
		return direccionL;
	}

	public void setDireccionL(JLabel direccionL) {
		this.direccionL = direccionL;
	}

	public JTextField getCorreoT() {
		return correoT;
	}

	public void setCorreoT(JTextField correoT) {
		this.correoT = correoT;
	}

	public JLabel getCorreoL() {
		return correoL;
	}

	public void setCorreoL(JLabel correoL) {
		this.correoL = correoL;
	}

	public JTextField getDocumentoT() {
		return documentoT;
	}

	public void setDocumentoT(JTextField documentoT) {
		this.documentoT = documentoT;
	}

	public JLabel getDocumentoL() {
		return documentoL;
	}

	public void setDocumentoL(JLabel documentoL) {
		this.documentoL = documentoL;
	}

	public JTextField getTelefonosT() {
		return telefonosT;
	}

	public void setTelefonosT(JTextField telefonosT) {
		this.telefonosT = telefonosT;
	}

	public JLabel getTelefonosL() {
		return telefonosL;
	}

	public void setTelefonosL(JLabel telefonosL) {
		this.telefonosL = telefonosL;
	}

	public JLabel getVacio2() {
		return vacio2;
	}

	public void setVacio2(JLabel vacio2) {
		this.vacio2 = vacio2;
	}

	public JTextField getUsuarioT() {
		return usuarioT;
	}

	public void setUsuarioT(JTextField usuarioT) {
		this.usuarioT = usuarioT;
	}

	public JLabel getUsuarioL() {
		return usuarioL;
	}

	public void setUsuarioL(JLabel usuarioL) {
		this.usuarioL = usuarioL;
	}

	public JTextField getContrseña1T() {
		return contraseña1T;
	}



	public JLabel getContrseña1L() {
		return contraseña1L;
	}

	public void setContrseña1L(JLabel contrseña1l) {
		contraseña1L = contrseña1l;
	}

	public JTextField getContrseña2T() {
		return contraseña2T;
	}



	public JLabel getContrseña2L() {
		return contraseña2L;
	}

	public void setContrseña2L(JLabel contrseña2l) {
		contraseña2L = contrseña2l;
	}



}
