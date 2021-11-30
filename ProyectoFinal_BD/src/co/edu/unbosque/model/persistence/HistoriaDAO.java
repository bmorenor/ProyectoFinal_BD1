package co.edu.unbosque.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import co.edu.unbosque.model.Factura;
import co.edu.unbosque.model.Factura_Detalle;
import co.edu.unbosque.model.Historia;
import co.edu.unbosque.model.Mascota;
import co.edu.unbosque.model.Mascota_Color;
import co.edu.unbosque.model.Mascota_Raza;
import co.edu.unbosque.model.Mascota_especie;
import co.edu.unbosque.model.Servicio;

public class HistoriaDAO {
	private Servicio servicio;
	private Factura factura;
	private Factura_Detalle factura_Detalle;
	private Historia historia;
	private PostgresBD bd;
	private Statement statement;
	
	public HistoriaDAO() {
		bd = new PostgresBD();
	
	}
	public boolean registrarDatosHistoria( Historia historia, Factura factura, Factura_Detalle factura_Detalle) {
		boolean registrar = false;
		

		try {
			
		
				bd.connectDatabase();
				statement = bd.getConnection().createStatement();
				statement.executeUpdate(
						"INSERT INTO factura (fecha,forma_pago,estado)"
								+ " VALUES" + "('"+ factura.getFecha()+ "', '"+factura.getForma_pago()+"',"+"'A')");
				statement.close();
				bd.cierraConexion();
			
			
		
			int id_factura = ultimoRegistroFactura();
			int id_servicio = buscarServicio(factura_Detalle.getServicio());
			
			int totalPago=totalPago(factura_Detalle.getIva(), tarifa(id_servicio), dezscuento(id_servicio));
			
		
				bd.connectDatabase();
				statement = bd.getConnection().createStatement();
				statement.executeUpdate(
						"INSERT INTO factura_detalle (iva,id_factura,id_servicio,total)"
								+ " VALUES" + "("+ factura_Detalle.getIva()+ ","+id_factura+","+id_servicio+","+totalPago+","+"'A')");
				statement.close();
				bd.cierraConexion();
			int id_factura_detalle = ultimoRegistroFacturaDetalle();
			
				bd.connectDatabase();
				statement = bd.getConnection().createStatement();
				statement.executeUpdate(
						"INSERT INTO historia (id_mascota,id_factura_detalle,descripcion,estado)"
								+ " VALUES" + "("+ historia.getId_mascota()+ ","+id_factura_detalle+",'"+historia.getDescripcion()+"',"+"'A')");
				statement.close();
				bd.cierraConexion();
			
		

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registrar;

	}
	public int ultimoRegistroFactura() {
		int ultimoR = 0;
		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement(
					"select id_factura from factura\r\n" + "		order by id_factura desc\r\n" + "		limit 1");

			ResultSet res = consulta.executeQuery();

			if (res.next()) {
				ultimoR = res.getInt("id_factura");
			}

			res.close();
			consulta.close();

		} catch (Exception e) {
			e.getStackTrace();

		}

		return ultimoR;
	}
	public int ultimoRegistroFacturaDetalle() {
		int ultimoR = 0;
		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement(
					"select id_factura_detalle from factura_detalle\r\n" + "		order by id_factura desc\r\n" + "		limit 1");

			ResultSet res = consulta.executeQuery();

			if (res.next()) {
				ultimoR = res.getInt("id_factura_detalle");
			}

			res.close();
			consulta.close();

		} catch (Exception e) {
			e.getStackTrace();

		}

		return ultimoR;
	}
	public int dezscuento(int id_servicio) {
		int ultimoR = 0;
		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement(
					"select descuento from servicio where id_servicio = "+id_servicio);

			ResultSet res = consulta.executeQuery();

			if (res.next()) {
				ultimoR = res.getInt("descuento");
			}

			res.close();
			consulta.close();

		} catch (Exception e) {
			e.getStackTrace();

		}

		return ultimoR;
	}
	public int tarifa(int id_servicio) {
		int ultimoR = 0;
		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement(
					"select tarifa_servicio from servicio where id_servicio = "+id_servicio);

			ResultSet res = consulta.executeQuery();

			if (res.next()) {
				ultimoR = res.getInt("tarifa_servicio");
			}

			res.close();
			consulta.close();

		} catch (Exception e) {
			e.getStackTrace();

		}

		return ultimoR;
	}
	public int buscarServicio(String servicio) {
		int ultimoR = 0;
		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement(
					"select id_servicio from servicio where nombre_servicio= '"+servicio+"'");

			ResultSet res = consulta.executeQuery();

			if (res.next()) {
				ultimoR = res.getInt("id_servicio");
			}

			res.close();
			consulta.close();

		} catch (Exception e) {
			e.getStackTrace();

		}

		return ultimoR;
	}
	public int totalPago(int iva, int tarifaS, int descuento) {
		int ultimoR = 0;
		
		iva = iva/100;
		
		int totalIva = (iva*tarifaS)+tarifaS; 
		
		ultimoR = totalIva-descuento;


		return ultimoR;
	}
	public ArrayList<Servicio> listaServicio(){
		bd.connectDatabase();
		ArrayList<Servicio>miServicio = new ArrayList<Servicio>();
		int color=0;
		int raza=0;
		int especie=0;
		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement(
					"select * from servicio");

			ResultSet res = consulta.executeQuery();
			
	

			while (res.next()) {
				Servicio servicio =  new Servicio();
				servicio.setNombre_servicio(res.getString("nombre_servicio"));
	
	
				miServicio.add(servicio);
			
			}

			res.close();
			consulta.close();
			bd.cierraConexion();

		} catch (Exception e) {
			e.getStackTrace();

		}
		return miServicio;
	}
}
