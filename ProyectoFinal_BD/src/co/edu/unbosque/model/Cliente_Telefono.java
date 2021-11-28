package co.edu.unbosque.model;

public class Cliente_Telefono {
		
	private String num_telefono;
	private String estado;

	
	
	public Cliente_Telefono(String num_telefono, String estado) {
		super();
		this.num_telefono = num_telefono;
		this.estado = estado;
	}


	public String getNum_telefono() {
		return num_telefono;
	}


	public void setNum_telefono(String num_telefono) {
		this.num_telefono = num_telefono;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
