package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelConsulta_Registro extends JPanel {

	private JLabel celular;
	private JComboBox<String> celularT;
	private JButton aceptarCelular;
	private JLabel imei;
	private JComboBox<String> imeiT;
	private JButton aceptarImei;
	private JLabel edicion;

	public PanelConsulta_Registro() throws ParseException {
		setLayout(new GridLayout(4, 1, 20, 20));

		imei = new JLabel("Buscar por IMEI:");
		imei.setFont(new Font("Arial", Font.PLAIN, 20));
		imei.setForeground(Color.white);
		imei.setEnabled(true);

		imeiT = new JComboBox<String>();
		imeiT.addItem("Seleccione....");
		imeiT.setFont(new Font("Arial", Font.PLAIN, 20));
		imeiT.setEnabled(true);

		celular = new JLabel("Buscar por número de celular: ");
		celular.setFont(new Font("Arial", Font.PLAIN, 20));
		celular.setForeground(Color.white);
		celular.setEnabled(true);

		celularT = new JComboBox<String>();
		celularT.addItem("Seleccione....");
		celularT.setFont(new Font("Arial", Font.PLAIN, 20));
		celularT.setEnabled(true);

		aceptarCelular = new JButton("Consultar por número");
		aceptarCelular.setFont(new Font("Arial", Font.PLAIN, 20));
		aceptarCelular.setEnabled(true);

		aceptarImei = new JButton("Consultar por IMEI");
		aceptarImei.setFont(new Font("Arial", Font.PLAIN, 20));
		aceptarImei.setEnabled(true);

		edicion = new JLabel();
		add(imei);
		add(imeiT);
		add(aceptarImei);
		add(edicion);
		add(celular);
		add(celularT);
		add(aceptarCelular);

	}
	

	public JComboBox<String> getCelularT() {
		return celularT;
	}


	public void setCelularT(JComboBox<String> celularT) {
		this.celularT = celularT;
	}


	public JComboBox<String> getImeiT() {
		return imeiT;
	}


	public void setImeiT(JComboBox<String> imeiT) {
		this.imeiT = imeiT;
	}


	public JLabel getEdicion() {
		return edicion;
	}


	public void setEdicion(JLabel edicion) {
		this.edicion = edicion;
	}


	public void setImei(JLabel imei) {
		this.imei = imei;
	}


	public JLabel getCelular() {
		return celular;
	}

	public void setCelular(JLabel celular) {
		this.celular = celular;
	}

	public JButton getAceptarCelular() {
		return aceptarCelular;
	}

	public void setAceptarCelular(JButton aceptarCelular) {
		this.aceptarCelular = aceptarCelular;
	}

	public JLabel getImei() {
		return imei;
	}

	public JButton getAceptarImei() {
		return aceptarImei;
	}

	public void setAceptarImei(JButton aceptarImei) {
		this.aceptarImei = aceptarImei;
	}

}
