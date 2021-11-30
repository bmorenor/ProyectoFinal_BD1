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

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

public class PanelRegistro_Servicio extends JPanel {
	private JButton vacio;
	private JLabel vacio2;
	private JButton aceptar;
	private JButton volver;
	private JDateChooser fechaD;
	private JLabel fechaL;
	private JTextField forma_pagoT;
	private JLabel forma_pagoL;
	private JTextField descripcionT;
	private JLabel descripcionL;

	private JLabel mascotaL;
	private JLabel servicioL;
	private JComboBox<String> servicioC;
	private JComboBox<String> mascotaC;

	public PanelRegistro_Servicio() {

		setLayout(new GridLayout(7, 2, 0, 0));

		vacio = new JButton("VACIO");
		vacio.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));

		servicioC = new JComboBox<String>();
		servicioC.addItem("Seleccione....");
		servicioC.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		servicioC.setEnabled(true);

		mascotaC = new JComboBox<String>();
		mascotaC.addItem("Seleccione....");
		mascotaC.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		mascotaC.setEnabled(true);

		vacio.setVisible(false);
		vacio2 = new JLabel("Solicitud servicio   ");
		vacio2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
//		vacio2.setForeground(Color.black);
		vacio2.setVisible(true);

		fechaL = new JLabel("Fecha: ");
		fechaL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		nombresL.setForeground(Color.white);
		fechaL.setEnabled(true);

		fechaD = new JDateChooser();
		fechaD.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		fechaD.setEnabled(true);

		forma_pagoL = new JLabel("Forma de pago: ");
		forma_pagoL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		apellidosL.setForeground(Color.black);
		forma_pagoL.setEnabled(true);

		forma_pagoT = new JTextField();
		forma_pagoT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		forma_pagoT.setEnabled(true);

		servicioL = new JLabel("Servicio: ");
		servicioL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		direccionL.setForeground(Color.white);
		servicioL.setEnabled(true);

		descripcionT = new JTextField();
		descripcionT.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		descripcionT.setEnabled(true);

		descripcionL = new JLabel("Descripcion: ");
		descripcionL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		direccionL.setForeground(Color.white);
		descripcionL.setEnabled(true);

		mascotaL = new JLabel("Mascota: ");
		mascotaL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//		direccionL.setForeground(Color.white);
		mascotaL.setEnabled(true);

		volver = new JButton("Volver");
		volver.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		volver.setEnabled(true);

		aceptar = new JButton("Aceptar");
		aceptar.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		aceptar.setEnabled(true);

//		add(vacio);
		add(vacio2);
		add(vacio);
		add(fechaL);
		add(fechaD);
		add(mascotaL);
		add(mascotaC);
		add(servicioL);
		add(servicioC);
		add(forma_pagoL);
		add(forma_pagoT);
		add(descripcionL);
		add(descripcionT);

		add(aceptar);

	}
	
	

	public JLabel getMascotaL() {
		return mascotaL;
	}



	public void setMascotaL(JLabel mascotaL) {
		this.mascotaL = mascotaL;
	}



	public JComboBox<String> getMascotaC() {
		return mascotaC;
	}



	public void setMascotaC(JComboBox<String> mascotaC) {
		this.mascotaC = mascotaC;
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

	public JDateChooser getFechaD() {
		return fechaD;
	}

	public void setFechaD(JDateChooser fechaD) {
		this.fechaD = fechaD;
	}

	public JLabel getFechaL() {
		return fechaL;
	}

	public void setFechaL(JLabel fechaL) {
		this.fechaL = fechaL;
	}

	public JTextField getForma_pagoT() {
		return forma_pagoT;
	}

	public void setForma_pagoT(JTextField forma_pagoT) {
		this.forma_pagoT = forma_pagoT;
	}

	public JLabel getForma_pagoL() {
		return forma_pagoL;
	}

	public void setForma_pagoL(JLabel forma_pagoL) {
		this.forma_pagoL = forma_pagoL;
	}

	public JTextField getDescripcionT() {
		return descripcionT;
	}

	public void setDescripcionT(JTextField descripcionT) {
		this.descripcionT = descripcionT;
	}

	public JLabel getDescripcionL() {
		return descripcionL;
	}

	public void setDescripcionL(JLabel descripcionL) {
		this.descripcionL = descripcionL;
	}

	public JLabel getServicioL() {
		return servicioL;
	}

	public void setServicioL(JLabel servicioL) {
		this.servicioL = servicioL;
	}

	public JComboBox<String> getServicioC() {
		return servicioC;
	}

	public void setServicioC(JComboBox<String> servicioC) {
		this.servicioC = servicioC;
	}

}
