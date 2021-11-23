package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelEliminar extends JPanel {

	
	private JButton aceptarImei;
	private JButton aceptarCelular;
	private JLabel imei;
	private JComboBox<String> imeiC;
	private JLabel numeroCelular;
	private JComboBox<String> numeroCelularC; 
	private JLabel edicion;


	public PanelEliminar() {

		setLayout(new GridLayout(4, 1, 20, 20));
		
		edicion = new JLabel();

		imeiC = new JComboBox<String>();
		imeiC.addItem("Seleccione....");
		imeiC.setFont(new Font("Arial", Font.PLAIN, 20));
		imeiC.setEnabled(true);

		aceptarImei = new JButton("Eliminar por IMEI");
		aceptarImei.setFont(new Font("Arial", Font.PLAIN, 20));
		aceptarImei.setEnabled(true);

		imei = new JLabel("Eliminar celular : ");
		imei.setFont(new Font("Arial", Font.PLAIN, 20));
		imei.setForeground(Color.white);
		imei.setEnabled(true);
		

		add(imei);
		add(imeiC);
		add(aceptarImei);
		
	}

	public JButton getAceptarImei() {
		return aceptarImei;
	}

	public void setAceptarImei(JButton aceptarImei) {
		this.aceptarImei = aceptarImei;
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

	public void setImei(JLabel imei) {
		this.imei = imei;
	}

	public JComboBox<String> getImeiC() {
		return imeiC;
	}

	public void setImeiC(JComboBox<String> imeiC) {
		this.imeiC = imeiC;
	}

	public JLabel getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(JLabel numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public JComboBox<String> getNumeroCelularC() {
		return numeroCelularC;
	}

	public void setNumeroCelularC(JComboBox<String> numeroCelularC) {
		this.numeroCelularC = numeroCelularC;
	}


}
