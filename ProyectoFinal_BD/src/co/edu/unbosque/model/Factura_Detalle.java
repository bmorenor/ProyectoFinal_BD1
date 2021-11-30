package co.edu.unbosque.model;

public class Factura_Detalle {
	private int id_factura_detalle;
	private int iva;
	private int id_factura;
	private int id_servicio;
	private int total;
	
	
	
	public Factura_Detalle() {
		
	}
	public Factura_Detalle(int iva, int id_factura, int id_servicio, int total) {

		this.iva = iva;
		this.id_factura = id_factura;
		this.id_servicio = id_servicio;
		this.total = total;
	}
	
	
	public int getId_factura_detalle() {
		return id_factura_detalle;
	}
	public void setId_factura_detalle(int id_factura_detalle) {
		this.id_factura_detalle = id_factura_detalle;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getId_factura() {
		return id_factura;
	}
	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
