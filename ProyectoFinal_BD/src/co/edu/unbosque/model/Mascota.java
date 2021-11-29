package co.edu.unbosque.model;

public class Mascota {
	
	private int id_mascota;
	private int id_cliente;
	private String nombre;
	private String color;
	private String especie;
	private String anno_nacimiento;
	private String raza;
	private String peso;
	private String estado;
	private String sexo;
	
	public Mascota() {
	
	}

	public Mascota(String nombre, String color, String especie, String anno_nacimiento, String raza,
			String peso, String estado, String sexo) {

		this.nombre = nombre;
		this.color = color;
		this.especie = especie;
		this.anno_nacimiento = anno_nacimiento;
		this.raza = raza;
		this.peso = peso;
		this.estado = estado;
		this.sexo = sexo;
	}

	public int getId_mascota() {
		return id_mascota;
	}
	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getAnno_nacimiento() {
		return anno_nacimiento;
	}
	public void setAnno_nacimiento(String anno_nacimiento) {
		this.anno_nacimiento = anno_nacimiento;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	

}
