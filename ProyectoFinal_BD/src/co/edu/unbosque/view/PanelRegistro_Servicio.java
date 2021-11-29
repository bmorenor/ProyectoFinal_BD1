package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelRegistro_Servicio extends JPanel {
	private JButton vacio;
	private JLabel vacio2;
	private JButton aceptar;
	private JButton volver;
	private JTextField nombreT;
	private JLabel nombreL;
	private JTextField pesoT;
	private JLabel pesoL;
	private JTextField anno_NacimientoT;
	private JLabel anno_NacimientoL;
	private JTextField sexoT;
	private JLabel sexoL;
	private JTextField colorT;
	private JLabel colorL;
	private JTextField razaT;
	private JLabel razaL;
	private JTextField especieT;
	private JLabel especieL;
	private JComboBox<String> sexo;

	
	public PanelRegistro_Servicio() {

		setLayout(new GridLayout(10, 2,0,0));

		vacio = new JButton("VACIO");
		vacio.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		
		sexo = new JComboBox<String>();
		sexo.addItem("Seleccione....");
		sexo.addItem("F");
		sexo.addItem("M");
		sexo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		sexo.setEnabled(true);

		vacio.setVisible(false);
		vacio2 = new JLabel("Registro Mascota   ");
		vacio2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
//		vacio2.setForeground(Color.black);
		vacio2.setVisible(true);

		nombreL = new JLabel("Nombre: ");
		nombreL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		nombresL.setForeground(Color.white);
		nombreL.setEnabled(true);

		nombreT = new JTextField();
		nombreT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		nombreT.setEnabled(true);

		pesoL = new JLabel("Peso: ");
		pesoL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		apellidosL.setForeground(Color.black);
		pesoL.setEnabled(true);

		pesoT = new JTextField();
		pesoT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		pesoT.setEnabled(true);

		anno_NacimientoL = new JLabel("Año Nacimiento: ");
		anno_NacimientoL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		direccionL.setForeground(Color.white);
		anno_NacimientoL.setEnabled(true);

		anno_NacimientoT = new JTextField();
		anno_NacimientoT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		anno_NacimientoT.setEnabled(true);

		sexoL = new JLabel("Sexo: ");
		sexoL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		correoL.setForeground(Color.black);
		sexoL.setEnabled(true);

		sexoT = new JTextField();
		sexoT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		sexoT.setEnabled(true);

		colorL = new JLabel("Color: ");
		colorL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		documentoL.setForeground(Color.white);
		colorL.setEnabled(true);

		colorT = new JTextField();
		colorT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		colorT.setEnabled(true);

		razaL = new JLabel("Raza: ");
		razaL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		telefonosL.setForeground(Color.black);
		razaL.setEnabled(true);

		razaT = new JTextField();
		razaT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		razaT.setEnabled(true);
		
		especieL = new JLabel("Especie: ");
		especieL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		telefonosL.setForeground(Color.black);
		especieL.setEnabled(true);
		
		especieT = new JTextField();
		especieT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		especieT.setEnabled(true);
		
	
		
		volver = new JButton("Volver");
		volver.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		volver.setEnabled(true);

		aceptar = new JButton("Aceptar");
		aceptar.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		aceptar.setEnabled(true);

//		add(vacio);
		add(vacio2);
		add(vacio);
		add(nombreL);
		add(nombreT);
		add(pesoL);
		add(pesoT);
		add(anno_NacimientoL);
		add(anno_NacimientoT);
		add(sexoL);
		add(sexo);
		add(colorL);
		add(colorT);
		add(razaL);
		add(razaT);
		add(especieL);
		add(especieT);
	
		add(aceptar);


	}


	public JComboBox<String> getSexo() {
		return sexo;
	}


	public void setSexo(JComboBox<String> sexo) {
		this.sexo = sexo;
	}


	public JButton getVacio() {
		return vacio;
	}


	public void setVacio(JButton vacio) {
		this.vacio = vacio;
	}


	public JLabel getVacio2() {
		return vacio2;
	}


	public void setVacio2(JLabel vacio2) {
		this.vacio2 = vacio2;
	}


	public JButton getAceptar() {
		return aceptar;
	}


	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}


	public JButton getVolver() {
		return volver;
	}


	public void setVolver(JButton volver) {
		this.volver = volver;
	}


	public JTextField getNombreT() {
		return nombreT;
	}


	public void setNombreT(JTextField nombreT) {
		this.nombreT = nombreT;
	}


	public JLabel getNombreL() {
		return nombreL;
	}


	public void setNombreL(JLabel nombreL) {
		this.nombreL = nombreL;
	}


	public JTextField getPesoT() {
		return pesoT;
	}


	public void setPesoT(JTextField pesoT) {
		this.pesoT = pesoT;
	}


	public JLabel getPesoL() {
		return pesoL;
	}


	public void setPesoL(JLabel pesoL) {
		this.pesoL = pesoL;
	}


	public JTextField getAnno_NacimientoT() {
		return anno_NacimientoT;
	}


	public void setAnno_NacimientoT(JTextField anno_NacimientoT) {
		this.anno_NacimientoT = anno_NacimientoT;
	}


	public JLabel getAnno_NacimientoL() {
		return anno_NacimientoL;
	}


	public void setAnno_NacimientoL(JLabel anno_NacimientoL) {
		this.anno_NacimientoL = anno_NacimientoL;
	}


	public JTextField getSexoT() {
		return sexoT;
	}


	public void setSexoT(JTextField sexoT) {
		this.sexoT = sexoT;
	}


	public JLabel getSexoL() {
		return sexoL;
	}


	public void setSexoL(JLabel sexoL) {
		this.sexoL = sexoL;
	}


	public JTextField getColorT() {
		return colorT;
	}


	public void setColorT(JTextField colorT) {
		this.colorT = colorT;
	}


	public JLabel getColorL() {
		return colorL;
	}


	public void setColorL(JLabel colorL) {
		this.colorL = colorL;
	}


	public JTextField getRazaT() {
		return razaT;
	}


	public void setRazaT(JTextField razaT) {
		this.razaT = razaT;
	}


	public JLabel getRazaL() {
		return razaL;
	}


	public void setRazaL(JLabel razaL) {
		this.razaL = razaL;
	}


	public JTextField getEspecieT() {
		return especieT;
	}


	public void setEspecieT(JTextField especieT) {
		this.especieT = especieT;
	}


	public JLabel getEspecieL() {
		return especieL;
	}


	public void setEspecieL(JLabel especieL) {
		this.especieL = especieL;
	}
	

	



}
