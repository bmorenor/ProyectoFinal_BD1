package co.edu.unbosque.model;

public class Historia {

	private int id_historia;
	private int id_mascota;
	private int id_factura_detalle;
	private String descripcion;
	private String fecha;
	private int valor_total;
	private String estado;
	
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

}
