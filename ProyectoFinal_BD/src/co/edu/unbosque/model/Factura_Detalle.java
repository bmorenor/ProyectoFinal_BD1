package co.edu.unbosque.model;

public class Factura_Detalle {
	private int id_factura_detalle;
	private int iva;
	private int id_factura;
	private String servicio;
	private int total;
	private String forma_pago;
	private String fecha;
	private String mascota;
	private String nombreUsuario;
	private int descuento;
	private int id_usuario;
	
	
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public String getForma_pago() {
		return forma_pago;
	}
	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getMascota() {
		return mascota;
	}
	public void setMascota(String mascota) {
		this.mascota = mascota;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Factura_Detalle() {
		
	}
	public Factura_Detalle(int iva,  String servicio) {

		this.iva = iva;
	
		this.servicio = servicio;

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

	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
