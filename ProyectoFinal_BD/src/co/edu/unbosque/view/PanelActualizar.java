package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.text.MaskFormatter;
import java.awt.Font;
import java.awt.GridLayout;

import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelActualizar extends JPanel {

	private JLabel imeiAnterior;
	private JLabel imei;
	private JLabel numeroCelular;
	private JLabel marca;
	private JLabel modelo;
	private JLabel precio;
	private JLabel color;
	private JComboBox<String> imeiAnteriorC;
	private JTextField imeiT;
	private JTextField numeroCelularT;
	private JTextField marcaT;
	private JTextField modeloT;
	private JTextField precioT;
	private JTextField colorT;
	private JButton aceptar;

	/**
	 * Este metodo inicializa el panel Actualizar
	 * 
	 * @throws ParseException
	 */
	public PanelActualizar() throws ParseException {

		setLayout(new GridLayout(9, 2, 20, 20));

		imeiAnterior = new JLabel("IMEI a actualizar:");
		imeiAnterior.setFont(new Font("Arial", Font.PLAIN, 20));
		imeiAnterior.setForeground(Color.white);
		imeiAnterior.setEnabled(true);

		imeiAnteriorC = new JComboBox<String>();
		imeiAnteriorC.addItem("Seleccione....");
		imeiAnteriorC.setFont(new Font("Arial", Font.PLAIN, 20));
		imeiAnteriorC.setEnabled(true);
		
		
		imei = new JLabel("Nuevo IMEI:");
		imei.setFont(new Font("Arial", Font.PLAIN, 20));
		imei.setForeground(Color.white);
		imei.setEnabled(true);
		
		MaskFormatter mascara1 = new MaskFormatter("###############");
		imeiT = new JFormattedTextField(mascara1);
		imeiT.setFont(new Font("Arial", Font.PLAIN, 20));
		imeiT.setEnabled(true);

		numeroCelular = new JLabel("Número de celular: ");
		numeroCelular.setFont(new Font("Arial", Font.PLAIN, 20));
		numeroCelular.setForeground(Color.white);
		numeroCelular.setEnabled(true);

		MaskFormatter mascara2 = new MaskFormatter("##########");
		numeroCelularT = new JFormattedTextField(mascara2);
		numeroCelularT.setFont(new Font("Arial", Font.PLAIN, 20));
		numeroCelularT.setEnabled(true);

		marca = new JLabel("Marca: ");
		marca.setFont(new Font("Arial", Font.PLAIN, 20));
		marca.setForeground(Color.white);
		marca.setEnabled(true);

		marcaT = new JFormattedTextField();
		marcaT.setFont(new Font("Arial", Font.PLAIN, 20));
		marcaT.setEnabled(true);

		precio = new JLabel("Precio:");
		precio.setFont(new Font("Arial", Font.PLAIN, 20));
		precio.setForeground(Color.white);
		precio.setEnabled(true);

		precioT = new JFormattedTextField();
		precioT.setFont(new Font("Arial", Font.PLAIN, 20));
		precioT.setEnabled(true);

		color = new JLabel("Color: ");
		color.setFont(new Font("Arial", Font.PLAIN, 20));
		color.setForeground(Color.white);
		color.setEnabled(true);

		colorT = new JTextField();
		colorT.setFont(new Font("Arial", Font.PLAIN, 20));

		colorT.setEnabled(true);

		aceptar = new JButton("Actualizar celular");
		aceptar.setFont(new Font("Arial", Font.PLAIN, 20));
		aceptar.setEnabled(true);
		
		modelo = new JLabel("Modelo: ");
		modelo.setFont(new Font("Arial", Font.PLAIN, 20));
		modelo.setForeground(Color.white);
		modelo.setEnabled(true);

		modeloT = new JTextField();
		modeloT.setFont(new Font("Arial", Font.PLAIN, 20));
		modeloT.setEnabled(true);

		add(imeiAnterior);
		add(imeiAnteriorC);
		add(imei);
		add(imeiT);
		add(numeroCelular);
		add(numeroCelularT);
		add(marca);
		add(marcaT);
		add(modelo);
		add(modeloT);
		add(precio);
		add(precioT);
		add(color);
		add(colorT);
		add(aceptar);

	}

	public JLabel getImeiAnterior() {
		return imeiAnterior;
	}

	public void setImeiAnterior(JLabel imeiAnterior) {
		this.imeiAnterior = imeiAnterior;
	}
	

	public JLabel getModelo() {
		return modelo;
	}

	public void setModelo(JLabel modelo) {
		this.modelo = modelo;
	}

	public JTextField getModeloT() {
		return modeloT;
	}

	public void setModeloT(JTextField modeloT) {
		this.modeloT = modeloT;
	}

	public JLabel getImei() {
		return imei;
	}

	public void setImei(JLabel imei) {
		this.imei = imei;
	}

	public JLabel getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(JLabel numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public JLabel getMarca() {
		return marca;
	}

	public void setMarca(JLabel marca) {
		this.marca = marca;
	}

	public JLabel getPrecio() {
		return precio;
	}

	public void setPrecio(JLabel precio) {
		this.precio = precio;
	}

	public JLabel getColor() {
		return color;
	}

	public void setColor(JLabel color) {
		this.color = color;
	}

	public JComboBox<String> getImeiAnteriorC() {
		return imeiAnteriorC;
	}

	public void setImeiAnteriorC(JComboBox<String> imeiAnteriorC) {
		this.imeiAnteriorC = imeiAnteriorC;
	}

	public JTextField getImeiT() {
		return imeiT;
	}

	public void setImeiT(JTextField imeiT) {
		this.imeiT = imeiT;
	}

	public JTextField getNumeroCelularT() {
		return numeroCelularT;
	}

	public void setNumeroCelularT(JTextField numeroCelularT) {
		this.numeroCelularT = numeroCelularT;
	}

	public JTextField getMarcaT() {
		return marcaT;
	}

	public void setMarcaT(JTextField marcaT) {
		this.marcaT = marcaT;
	}

	public JTextField getPrecioT() {
		return precioT;
	}

	public void setPrecioT(JTextField precioT) {
		this.precioT = precioT;
	}

	public JTextField getColorT() {
		return colorT;
	}

	public void setColorT(JTextField colorT) {
		this.colorT = colorT;
	}

	public JButton getAceptar() {
		return aceptar;
	}

	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}
	

}
