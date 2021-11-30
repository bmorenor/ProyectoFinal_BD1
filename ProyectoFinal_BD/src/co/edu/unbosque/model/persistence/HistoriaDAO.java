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

	public boolean registrarDatosHistoria(Historia historia, Factura factura, Factura_Detalle factura_Detalle) {
		boolean registrar = false;

		try {

			bd.connectDatabase();
			statement = bd.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO factura (fecha,forma_pago,estado)" + " VALUES" + "('"
					+ factura.getFecha() + "', '" + factura.getForma_pago() + "'," + "'A')");
			statement.close();
			bd.cierraConexion();

			int id_factura = ultimoRegistroFactura();
			System.out.println(id_factura);
			int id_servicio = buscarServicio(factura_Detalle.getServicio());

			int totalPago = totalPago(factura_Detalle.getIva(), tarifa(id_servicio), dezscuento(id_servicio));
			System.out.println(totalPago+" "+tarifa(id_servicio)+" "+dezscuento(id_servicio)+" "+factura_Detalle.getIva());

			bd.connectDatabase();
			statement = bd.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO factura_detalle (iva,id_factura,id_servicio,total)" + " VALUES" + "("
					+ factura_Detalle.getIva() + "," + id_factura + "," + id_servicio + "," + totalPago + "" + ")");
			statement.close();
			bd.cierraConexion();
			int id_factura_detalle = ultimoRegistroFacturaDetalle();

			bd.connectDatabase();
			statement = bd.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO historia (id_mascota,id_factura_detalle,descripcion,estado)"
					+ " VALUES" + "(" + historia.getId_mascota() + "," + id_factura_detalle + ",'"
					+ historia.getDescripcion() + "'," + "'A')");
			statement.close();
			bd.cierraConexion();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registrar;

	}

	public int ultimoRegistroFactura() {
		bd.connectDatabase();
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
		bd.connectDatabase();
		int ultimoR = 0;
		try {
			PreparedStatement consulta = bd.getConnection()
					.prepareStatement("select id_factura_detalle from factura_detalle\r\n"
							+ "		order by id_factura desc\r\n" + "		limit 1");

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
		bd.connectDatabase();
		int ultimoR = 0;
		try {
			PreparedStatement consulta = bd.getConnection()
					.prepareStatement("select descuento from servicio where id_servicio = " + id_servicio);

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
		bd.connectDatabase();
		int ultimoR = 0;
		try {
			PreparedStatement consulta = bd.getConnection()
					.prepareStatement("select tarifa_servicio from servicio where id_servicio = " + id_servicio);

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
		bd.connectDatabase();
		int ultimoR = 0;
		try {
			PreparedStatement consulta = bd.getConnection()
					.prepareStatement("select id_servicio from servicio where nombre_servicio= '" + servicio + "'");

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
		float ivaD = (float) 0.0;

		ivaD =(float)  iva / 100;

		float totalIva = (ivaD * tarifaS);

		ultimoR = (int) (tarifaS+totalIva)-descuento ;
		System.out.println(totalIva);

		return ultimoR;
	}

	public ArrayList<Servicio> listaServicio() {
		bd.connectDatabase();
		ArrayList<Servicio> miServicio = new ArrayList<Servicio>();
		int color = 0;
		int raza = 0;
		int especie = 0;
		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement("select * from servicio");

			ResultSet res = consulta.executeQuery();

			while (res.next()) {
				Servicio servicio = new Servicio();
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

	public ArrayList<Historia> listaHistoriaUsuario(int id_usuario) {
		bd.connectDatabase();
		ArrayList<Historia> miHistoria = new ArrayList<Historia>();

		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement(
					"select a.id_historia, b.nombre,c.nombre_servicio,d.total,a.descripcion,e.fecha from historia a, mascota b, servicio c, factura_detalle d, factura e\r\n"
							+ "where b.id_usuario = " + id_usuario + "\r\n" + "and d.id_factura = e.id_factura \r\n"
							+ "and a.id_factura_detalle = d.id_factura_detalle \r\n"
							+ "and a.id_mascota = b.id_mascota \r\n" + "and d.id_servicio = c.id_servicio");

			ResultSet res = consulta.executeQuery();

			while (res.next()) {
				Historia historia = new Historia();
				historia.setId_historia(res.getInt("id_historia"));
				historia.setMascota(res.getString("nombre"));
				historia.setServicio(res.getString("nombre_servicio"));

				historia.setTotal(res.getInt("total"));

				historia.setDescripcion(res.getString("descripcion"));
				historia.setFecha(res.getString("fecha"));

				miHistoria.add(historia);

			}

			res.close();
			consulta.close();
			bd.cierraConexion();

		} catch (Exception e) {
			e.getStackTrace();

		}
		return miHistoria;
	}
	public ArrayList<Historia> listaHistoria() {
		bd.connectDatabase();
		ArrayList<Historia> miHistoria = new ArrayList<Historia>();

		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement(
					"select a.id_historia, b.nombre,c.nombre_servicio,d.total,a.descripcion,e.fecha,b.id_usuario from historia a, mascota b, servicio c, factura_detalle d, factura e\r\n"
					+ "where d.id_factura = e.id_factura \r\n"
					+ "and a.id_factura_detalle = d.id_factura_detalle \r\n"
					+ "and a.id_mascota = b.id_mascota \r\n"
					+ "and d.id_servicio = c.id_servicio");

			ResultSet res = consulta.executeQuery();

			while (res.next()) {
				Historia historia = new Historia();
				
				historia.setId_historia(res.getInt("id_historia"));
				historia.setMascota(res.getString("nombre"));
				historia.setServicio(res.getString("nombre_servicio"));

				historia.setTotal(res.getInt("total"));

				historia.setDescripcion(res.getString("descripcion"));
				historia.setFecha(res.getString("fecha"));
				historia.setId_usuario(res.getInt("id_usuario"));

				miHistoria.add(historia);

			}

			res.close();
			consulta.close();
			bd.cierraConexion();

		} catch (Exception e) {
			e.getStackTrace();

		}
		return miHistoria;
	}
	
	public ArrayList<Factura_Detalle> listaFactura() {
		bd.connectDatabase();
		ArrayList<Factura_Detalle> miFactura_Detalle = new ArrayList<Factura_Detalle>();

		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement(
					"select e.id_factura , b.nombre , d.iva , e.fecha ,c.nombre_servicio,c.descuento, c.tarifa_servicio ,d.total ,b.id_usuario from historia a, mascota b, servicio c, factura_detalle d, factura e\r\n"
					+ "where d.id_factura = e.id_factura \r\n"
					+ "and a.id_factura_detalle = d.id_factura_detalle \r\n"
					+ "and a.id_mascota = b.id_mascota \r\n"
					+ "and d.id_servicio = c.id_servicio");

			ResultSet res = consulta.executeQuery();

			while (res.next()) {
				Factura_Detalle factura = new Factura_Detalle();
				factura.setId_factura(res.getInt("id_factura"));
				factura.setMascota(res.getString("nombre"));
				factura.setIva(res.getInt("iva"));
				factura.setFecha(res.getString("fecha"));
				factura.setTarifa(res.getInt("tarifa_servicio"));
				factura.setServicio(res.getString("nombre_servicio"));
				factura.setDescuento(res.getInt("descuento"));
				factura.setTotal(res.getInt("total"));
				factura.setId_usuario(res.getInt("id_usuario"));
				

				miFactura_Detalle.add(factura);

			}

			res.close();
			consulta.close();
			bd.cierraConexion();

		} catch (Exception e) {
			e.getStackTrace();

		}
		return miFactura_Detalle;
	}
	public ArrayList<Factura_Detalle> listaFacturaUsuario(int id_usuario) {
		bd.connectDatabase();
		ArrayList<Factura_Detalle> miFactura_Detalle = new ArrayList<Factura_Detalle>();

		try {
			PreparedStatement consulta = bd.getConnection().prepareStatement(
					"select e.id_factura , b.nombre , d.iva , e.fecha ,c.nombre_servicio,c.descuento, c.tarifa_servicio ,d.total  from historia a, mascota b, servicio c, factura_detalle d, factura e\r\n"
					+ "where b.id_usuario = "+id_usuario+"\r\n"
					+ "and d.id_factura = e.id_factura \r\n"
					+ "and a.id_factura_detalle = d.id_factura_detalle \r\n"
					+ "and a.id_mascota = b.id_mascota \r\n"
					+ "and d.id_servicio = c.id_servicio");

			ResultSet res = consulta.executeQuery();

			while (res.next()) {
				Factura_Detalle factura = new Factura_Detalle();
				factura.setId_factura(res.getInt("id_factura"));
				factura.setMascota(res.getString("nombre"));
				factura.setIva(res.getInt("iva"));
				factura.setFecha(res.getString("fecha"));
				factura.setTarifa(res.getInt("tarifa_servicio"));
				factura.setServicio(res.getString("nombre_servicio"));
				factura.setDescuento(res.getInt("descuento"));
				factura.setTotal(res.getInt("total"));

				

				miFactura_Detalle.add(factura);

			}

			res.close();
			consulta.close();
			bd.cierraConexion();

		} catch (Exception e) {
			e.getStackTrace();

		}
		return miFactura_Detalle;
	}
}
