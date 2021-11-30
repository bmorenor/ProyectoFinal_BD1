package co.edu.unbosque.model;

public class Factura {
	
	private int id_facura;
	private String fecha;
	private String forma_pago;
	private String estado;
	
	public Factura() {
		
	}
	
	public Factura(String fecha, String forma_pago, String estado) {
	
		this.fecha = fecha;
		this.forma_pago = forma_pago;
		this.estado = estado;
	}
	
	public int getId_facura() {
		return id_facura;
	}
	public void setId_facura(int id_facura) {
		this.id_facura = id_facura;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getForma_pago() {
		return forma_pago;
	}
	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
