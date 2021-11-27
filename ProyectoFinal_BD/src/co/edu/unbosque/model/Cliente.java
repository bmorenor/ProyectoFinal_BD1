package co.edu.unbosque.model;

public class Cliente {
	
	private String nombres;
	private String apellidos;
	private String direccion;
	private String correo;
	private String documentoIdentidad;
	private String usuario;
	private String contrase�a;
	private String estado;
	
	
	public Cliente(String nombres, String apellidos, String direccion, String correo, String documentoIdentidad,
			String usuario, String contrase�a, String estado) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.correo = correo;
		this.documentoIdentidad = documentoIdentidad;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.estado = estado;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}


	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
