package co.edu.unbosque.model;

public class Mascota_Raza {
	
	private int id_mascota;
	private String tipo_raza;
	
	
	public Mascota_Raza(String tipo_raza) {

		this.tipo_raza = tipo_raza;
	}
	
	public int getId_mascota() {
		return id_mascota;
	}
	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}
	public String getTipo_raza() {
		return tipo_raza;
	}
	public void setTipo_raza(String tipo_raza) {
		this.tipo_raza = tipo_raza;
	}
	
	
}
