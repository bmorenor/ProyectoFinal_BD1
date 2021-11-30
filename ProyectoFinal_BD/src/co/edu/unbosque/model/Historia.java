package co.edu.unbosque.model;

public class Historia {

	private int id_historia;
	private int id_mascota;
	private int id_factura_detalle;
	private String descripcion;
	private String servicio;
	private int total;
	private String mascota;
	private String fecha;
	private int valor_total;
	private String estado;
	private int id_usuario;
	
	public Historia() {

	}

	public Historia(int id_mascota, String descripcion) {
		this.id_mascota = id_mascota;

		this.descripcion = descripcion;

	}

	public int getId_historia() {
		return id_historia;
	}

	public void setId_historia(int id_historia) {
		this.id_historia = id_historia;
	}

	public int getId_mascota() {
		return id_mascota;
	}

	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}

	public int getId_factura_detalle() {
		return id_factura_detalle;
	}

	public void setId_factura_detalle(int id_factura_detalle) {
		this.id_factura_detalle = id_factura_detalle;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getValor_total() {
		return valor_total;
	}

	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getMascota() {
		return mascota;
	}

	public void setMascota(String mascota) {
		this.mascota = mascota;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	

}
