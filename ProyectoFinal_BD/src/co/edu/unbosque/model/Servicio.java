package co.edu.unbosque.model;

public class Servicio {
	private int id_servicio;
	private String nombre_servicio;
	private int tarifa_serivio;
	private int descuento;
	private String estado;
	
	public Servicio() {
		
	}
	
	public Servicio(String nombre_servicio, int tarifa_serivio, int descuento, String estado) {
	
		this.nombre_servicio = nombre_servicio;
		this.tarifa_serivio = tarifa_serivio;
		this.descuento = descuento;
		this.estado = estado;
	}

	public int getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getNombre_servicio() {
		return nombre_servicio;
	}

	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}

	public int getTarifa_serivio() {
		return tarifa_serivio;
	}

	public void setTarifa_serivio(int tarifa_serivio) {
		this.tarifa_serivio = tarifa_serivio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

}
