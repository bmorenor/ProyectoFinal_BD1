package co.edu.unbosque.model;

public class Usuario {
	
	private String nombres;
	private String apellidos;
	private String direccion;
	private String correo;
	private String documentoIdentidad;
	private String usuario;
	private String contrasenia;
	private String estado;
	private int id_usuario;
	
	public Usuario() {

	}
	public Usuario(String nombres, String apellidos, String direccion, String correo, String documentoIdentidad,
			String usuario, String contrasenia, String estado) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.correo = correo;
		this.documentoIdentidad = documentoIdentidad;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
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




	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
	
	
}
