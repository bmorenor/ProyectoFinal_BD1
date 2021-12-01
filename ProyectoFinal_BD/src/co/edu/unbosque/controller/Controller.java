package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.file.Pdf;
import co.edu.unbosque.model.Cliente_Telefono;
import co.edu.unbosque.model.Factura;
import co.edu.unbosque.model.Factura_Detalle;
import co.edu.unbosque.model.Historia;
import co.edu.unbosque.model.Mascota;
import co.edu.unbosque.model.Mascota_Color;
import co.edu.unbosque.model.Mascota_Raza;
import co.edu.unbosque.model.Mascota_especie;
import co.edu.unbosque.model.Servicio;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.model.persistence.HistoriaDAO;
import co.edu.unbosque.model.persistence.MascotaDAO;
import co.edu.unbosque.model.persistence.PostgresBD;
import co.edu.unbosque.view.VistaPrincipal;

/**
 * Controller
 * 
 * @author Brayan Moreno
 *
 */
import java.sql.*;

public class Controller implements ActionListener {

	public VistaPrincipal vistaP;
	public PostgresBD bd;
	public Usuario cliente;
	public UsuarioDAO clienteDAO;
	public Mascota mascota;
	public MascotaDAO mascotaDAO;
	public Cliente_Telefono cliente_Telefono;
	public Mascota_Color color;
	public Mascota_Raza raza;
	public Mascota_especie especie;
	public DefaultTableModel dftable;
	public Historia historia;
	public Factura factura;
	public Factura_Detalle factura_Detalle;
	public HistoriaDAO historiaDAO;
	public Servicio servicio;
	public Pdf pdf;
	public static boolean a = true;
	public static String nombreArchivo = "";

	public Controller() throws ParseException {
		vistaP = new VistaPrincipal();
		bd = new PostgresBD();
		clienteDAO = new UsuarioDAO();
		mascotaDAO = new MascotaDAO();
		historiaDAO = new  HistoriaDAO();
		servicio = new Servicio();
		llenarCombos();
		listener(this);

	}

	private void listener(ActionListener escuchador) {
		// Menu Principal
		vistaP.getPanelEstandar().getPanelMenu().getCliente().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu().getAdministrador().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu().getSalir().addActionListener(escuchador);
		// Menu Cliente
		vistaP.getPanelEstandar().getPanelCliente_Menu().getCuenta().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelCliente_Menu().getRegistrar().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelCliente_Menu().getVolver().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelCliente_Menu().getSalir().addActionListener(escuchador);
		// SESION USUARIO
		vistaP.getPanelEstandar().getPanelRegistro_Usuario().getVolver().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelRegistro_Usuario().getVerContrasena().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelRegistro_Usuario().getAceptar().addActionListener(escuchador);
		// REGISTRO USUARIO
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getAceptar().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getVolver().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getVerContrasena().addActionListener(escuchador);
		// SESION USUARIO-MASCOTAS
		vistaP.getPanelEstandar().getPanelMenu_Usuario().getCerrarSesion().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Usuario().getSalir().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Usuario().getVerMascota().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Usuario().getHistorialServicio().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Usuario().getAnadirMascota().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Usuario().getSolicitudServicio().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Usuario().getFacturas().addActionListener(escuchador);
		// PDF
		vistaP.getPanelEstandar().getPanelTabla().getPdf().addActionListener(escuchador);
		// Usuario -mascota
		vistaP.getPanelEstandar().getPanelRegistro_Mascota().getAceptar().addActionListener(escuchador);
		// Usuario -servicio
		vistaP.getPanelEstandar().getPanelRegistro_Servicio().getAceptar().addActionListener(escuchador);
		// Menu ADMIN
		vistaP.getPanelEstandar().getPanelAdmin_Menu().getCuenta().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelAdmin_Menu().getVolver().addActionListener(escuchador);
		// SESION ADMIN
		vistaP.getPanelEstandar().getPanelRegistro_Admin().getAceptar().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelRegistro_Admin().getVolver().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelRegistro_Admin().getVerContrasena().addActionListener(escuchador);
		// Menu de visualizacion ADMIN
		vistaP.getPanelEstandar().getPanelMenu_Admin().getCliente().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Admin().getMascota().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Admin().getHistorialServicios().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Admin().getSalir().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Admin().getFacturas().addActionListener(escuchador);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object botonPulsado = e.getSource();
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Salir")) {

			salir();
		}
		// CLIENTE
		if (botonPulsado == vistaP.getPanelEstandar().getPanelMenu().getCliente()) {
			vistaP.getPanelEstandar().getPanelCliente_Menu().setVisible(true);
			vistaP.getPanelEstandar().getPanelMenu().setVisible(false);
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelCliente_Menu().getCuenta()) {
			vistaP.getPanelEstandar().getPanelRegistro_Usuario().setVisible(true);
			vistaP.getPanelEstandar().getPanelCliente_Menu().setVisible(false);
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelCliente_Menu().getVolver()) {
			vistaP.getPanelEstandar().getPanelCliente_Menu().setVisible(false);
			vistaP.getPanelEstandar().getPanelMenu().setVisible(true);
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelCliente_Menu().getRegistrar()) {
			vistaP.getPanelEstandar().getPanelMenu().setVisible(false);
			vistaP.getPanelEstandar().getPanelCliente_Menu().setVisible(false);
			vistaP.getPanelEstandar().getPanelCliente_NuevoR().setVisible(true);
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelCliente_Menu().getSalir()) {
			salir();
		}
		// SESION USUARIO
		if (botonPulsado == vistaP.getPanelEstandar().getPanelRegistro_Usuario().getVolver()) {
			vistaP.getPanelEstandar().getPanelRegistro_Usuario().setVisible(false);
			vistaP.getPanelEstandar().getPanelCliente_Menu().setVisible(true);
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelRegistro_Usuario().getAceptar()) {
			if (!vistaP.getPanelEstandar().getPanelRegistro_Usuario().getUsuario().getText().equals("")
					&& !vistaP.getPanelEstandar().getPanelRegistro_Usuario().getPassword().getPassword().equals(null)) {

				String usuario = vistaP.getPanelEstandar().getPanelRegistro_Usuario().getUsuario().getText();
				String constrasenia = new String(
						vistaP.getPanelEstandar().getPanelRegistro_Usuario().getPassword().getPassword());

				if (clienteDAO.verificarUsuarioInicio(constrasenia, usuario)) {
					vistaP.mostrarMensaje("Bienvenido: " + usuario);
					vistaP.getPanelEstandar().getPanelRegistro_Usuario().setVisible(false);
					vistaP.getPanelEstandar().getPanelMenu_Usuario().setVisible(true);
				} else {
					vistaP.mostrarError("Verifique los campos");
				}

			} else {
				vistaP.mostrarError("Verifique los campos");
			}
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelRegistro_Usuario().getVerContrasena()) {
			if (a == true) {
				vistaP.getPanelEstandar().getPanelRegistro_Usuario().getPassword().setEchoChar((char) 0);
				a = false;
			} else {
				vistaP.getPanelEstandar().getPanelRegistro_Usuario().getPassword().setEchoChar('•');
				a = true;
			}
		}
		// PANEL USUARIO _ MASCOTAS; SERVICIOS
		if (botonPulsado == vistaP.getPanelEstandar().getPanelMenu_Usuario().getCerrarSesion()) {

			vistaP.mostrarMensaje("Hasta Pronto");
			vistaP.getPanelEstandar().getPanelMenu_Usuario().setVisible(false);
			vistaP.getPanelEstandar().getPanelTabla().setVisible(false);
			vistaP.getPanelEstandar().getPanelCliente_Menu().setVisible(true);

		}

		if (botonPulsado == vistaP.getPanelEstandar().getPanelMenu_Usuario().getSolicitudServicio()) {

			vistaP.getPanelEstandar().getPanelTabla().setVisible(false);
			vistaP.getPanelEstandar().getPanelRegistro_Mascota().setVisible(false);
			vistaP.getPanelEstandar().getPanelRegistro_Servicio().setVisible(true);
			llenarCombos();

		}
		// SERVICIO GUARDADO
		if (botonPulsado == vistaP.getPanelEstandar().getPanelRegistro_Servicio().getAceptar()) {

			SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-YYYY");
			String fecha1 = dformat.format(vistaP.getPanelEstandar().getPanelRegistro_Servicio().getFechaD().getDate());
			if (verificarSolicitudServicio() && !fecha1.equals("")) {
				String dia = fecha1.split("-")[0];
				String mes = fecha1.split("-")[1];
				String anno = fecha1.split("-")[2];

				String fecha = anno + "-" + mes + "-" + dia;
				String servicio = (String) vistaP.getPanelEstandar().getPanelRegistro_Servicio().getServicioC()
						.getSelectedItem();

				String formaPago = vistaP.getPanelEstandar().getPanelRegistro_Servicio().getForma_pagoT().getText();
				String descripcion = vistaP.getPanelEstandar().getPanelRegistro_Servicio().getDescripcionT().getText();
				String mascota = (String) vistaP.getPanelEstandar().getPanelRegistro_Servicio().getMascotaC()
						.getSelectedItem();
				
				int id_mascota=mascotaDAO.buscarMascota(UsuarioDAO.id, mascota);
				int iva = 19;
				
				historia = new Historia(id_mascota, descripcion);
				factura = new Factura(fecha, formaPago);
				factura_Detalle = new Factura_Detalle(iva, servicio);
				
				historiaDAO.registrarDatosHistoria(historia, factura, factura_Detalle);
				vistaP.mostrarMensaje("Factura generada correctamente");
				llenarCombos();
				borrarCampos();
			}else {
				vistaP.mostrarError("Por favor llenar correctamente");
			}

		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelMenu_Usuario().getAnadirMascota()) {
			vistaP.getPanelEstandar().getPanelRegistro_Mascota().setVisible(true);
			vistaP.getPanelEstandar().getPanelTabla().setVisible(false);
			vistaP.getPanelEstandar().getPanelRegistro_Servicio().setVisible(false);

		}
		// Aï¿½ADIR MASCOTA
		if (botonPulsado == vistaP.getPanelEstandar().getPanelRegistro_Mascota().getAceptar()) {
			if (verificarRegistroMascota()) {
				String nombre = vistaP.getPanelEstandar().getPanelRegistro_Mascota().getNombreT().getText().toUpperCase();
				String anno_nacimiento = vistaP.getPanelEstandar().getPanelRegistro_Mascota().getAnno_NacimientoT()
						.getText();
				String peso = vistaP.getPanelEstandar().getPanelRegistro_Mascota().getPesoT().getText();
				String color1 = vistaP.getPanelEstandar().getPanelRegistro_Mascota().getColorT().getText().toUpperCase();
				String sexo = (String) vistaP.getPanelEstandar().getPanelRegistro_Mascota().getSexo().getSelectedItem();
				String raza1 = vistaP.getPanelEstandar().getPanelRegistro_Mascota().getRazaT().getText().toUpperCase();
				String especie1 = vistaP.getPanelEstandar().getPanelRegistro_Mascota().getEspecieT().getText().toUpperCase();
				String estado = "A";

				mascota = new Mascota(nombre, color1, especie1, anno_nacimiento, raza1, peso, estado, sexo);
				raza = new Mascota_Raza(raza1);
				color = new Mascota_Color(color1);
				especie = new Mascota_especie(especie1);

				mascotaDAO.registrarDatosM(color, especie, raza);
				if (mascotaDAO.registrarMascota(mascota) == false) {
					vistaP.mostrarMensaje("Se registro exitosamente");
					borrarCampos();
					llenarCombos();
				} else {
					vistaP.mostrarError("Hay un fallo");
				}

			} else {
				vistaP.mostrarError("Por favor ingrese todos los campos");
			}
			vistaP.getPanelEstandar().getPanelRegistro_Mascota().setVisible(true);

		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelMenu_Usuario().getVerMascota()) {
			vistaP.getPanelEstandar().getPanelTabla().setVisible(true);
			vistaP.getPanelEstandar().getPanelRegistro_Mascota().setVisible(false);
			vistaP.getPanelEstandar().getPanelRegistro_Servicio().setVisible(false);
			vistaP.getPanelEstandar().getPanelTabla().getTabla()
					.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

					}, new String[] { "ID", "Nombre", "Peso", "Color", "Raza", "Especie", "Aï¿½o Nacimiento",
							"Id_cliente" }));
			vistaP.getPanelEstandar().getPanelTabla().getjScrollPane1()
					.setViewportView(vistaP.getPanelEstandar().getPanelTabla().getTabla());

			ArrayList<Mascota> miMascota = mascotaDAO.listaMascotasUsuario();
			int id_usuario = 0;
			for (int i = 0; i < miMascota.size(); i++) {
				dftable = (DefaultTableModel) vistaP.getPanelEstandar().getPanelTabla().getTabla().getModel();
				String nombre = miMascota.get(i).getNombre();
				String peso = miMascota.get(i).getPeso();
				String color = miMascota.get(i).getColor();
				String raza = miMascota.get(i).getRaza();
				int id = miMascota.get(i).getId_mascota();
				String especie = miMascota.get(i).getEspecie();
				int usuario = miMascota.get(i).getId_cliente();
				String anno_naciemiento = miMascota.get(i).getAnno_nacimiento();
				Object[] obj = { id, nombre, peso, color, raza, especie, anno_naciemiento, usuario };
				dftable.addRow(obj);
				id_usuario = usuario;
			}
			nombreArchivo = "MascotaCliente " + id_usuario + "";

		}
		if(botonPulsado == vistaP.getPanelEstandar().getPanelMenu_Usuario().getHistorialServicio()) {
			vistaP.getPanelEstandar().getPanelTabla().setVisible(true);
			vistaP.getPanelEstandar().getPanelRegistro_Mascota().setVisible(false);
			vistaP.getPanelEstandar().getPanelRegistro_Servicio().setVisible(false);

			vistaP.getPanelEstandar().getPanelTabla().getTabla()
					.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

					}, new String[] { "ID_historia","Fecha", "Mascota", "Servicio", "Total", "Descripcion"}));
			vistaP.getPanelEstandar().getPanelTabla().getjScrollPane1()
					.setViewportView(vistaP.getPanelEstandar().getPanelTabla().getTabla());

			ArrayList<Historia> miHistoria = historiaDAO.listaHistoriaUsuario(UsuarioDAO.id);

			for (int i = 0; i < miHistoria.size(); i++) {
				dftable = (DefaultTableModel) vistaP.getPanelEstandar().getPanelTabla().getTabla().getModel();
				int id_historia = miHistoria.get(i).getId_historia();
				String fecha = miHistoria.get(i).getFecha();
				String mascota = miHistoria.get(i).getMascota();
				String servicio = miHistoria.get(i).getServicio();
				int total = miHistoria.get(i).getTotal();
				String descripcion = miHistoria.get(i).getDescripcion();
	
				Object[] obj = { id_historia, fecha, mascota, servicio, total, descripcion};
				dftable.addRow(obj);
			}
			nombreArchivo = "Historial_Usuario_"+UsuarioDAO.id;
		}
		if(botonPulsado == vistaP.getPanelEstandar().getPanelMenu_Usuario().getFacturas()) {
			vistaP.getPanelEstandar().getPanelTabla().setVisible(true);
			vistaP.getPanelEstandar().getPanelRegistro_Mascota().setVisible(false);
			vistaP.getPanelEstandar().getPanelRegistro_Servicio().setVisible(false);

			vistaP.getPanelEstandar().getPanelTabla().getTabla()
					.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

					}, new String[] { "ID_factura","Fecha", "Mascota", "Servicio", "Descuento","Iva%","Tarifa", "Total"}));
			vistaP.getPanelEstandar().getPanelTabla().getjScrollPane1()
					.setViewportView(vistaP.getPanelEstandar().getPanelTabla().getTabla());

			ArrayList<Factura_Detalle> miFactura = historiaDAO.listaFacturaUsuario(UsuarioDAO.id);
			int id_factura=0;
			for (int i = 0; i < miFactura.size(); i++) {
				dftable = (DefaultTableModel) vistaP.getPanelEstandar().getPanelTabla().getTabla().getModel();
				id_factura = miFactura.get(i).getId_factura();
				String fecha = miFactura.get(i).getFecha();
				String mascota = miFactura.get(i).getMascota();
				String servicio = miFactura.get(i).getServicio();
				int iva =  miFactura.get(i).getIva();
				int total = miFactura.get(i).getTotal();
				int descuento = miFactura.get(i).getDescuento();
				int tarifa = miFactura.get(i).getTarifa();
	
				Object[] obj = { id_factura, fecha, mascota, servicio, descuento, iva,tarifa,total};
				dftable.addRow(obj);
			}
			nombreArchivo = "Factura_"+id_factura+"Usuario_"+UsuarioDAO.id;
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelMenu_Usuario().getSalir()) {

			vistaP.mostrarMensaje("Hasta Pronto");
			salir();

		}
		// REGISTRAR CLIENTE
		if (botonPulsado == vistaP.getPanelEstandar().getPanelCliente_NuevoR().getAceptar()) {

			String nombres = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getNombresT().getText().toUpperCase();
			String apellidos = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getApellidosT().getText().toUpperCase();
			String direccion = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getDireccionT().getText().toUpperCase();
			String correo = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getCorreoT().getText();
			String documento = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getDocumentoT().getText();
			String telefono = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getTelefonosT().getText();
			String usuario = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getUsuarioT().getText();
			String contrasena1 = new String(
					vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContrasena1T().getPassword());
			String contrasena2 = new String(
					vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContrasena2T().getPassword());
			String estado = "A";
			if (verificarRegistroCliente() == true) {
				if (contrasena1.equals(contrasena2)) {
					cliente = new Usuario(nombres, apellidos, direccion, correo, documento, usuario, contrasena2,
							estado);
					cliente_Telefono = new Cliente_Telefono(telefono, estado);
					if (clienteDAO.verificarNumeros(cliente_Telefono) == true) {
						if (clienteDAO.verificarUsuario(cliente) == true) {
							clienteDAO.registrarCliente(cliente, cliente_Telefono);
							vistaP.mostrarMensaje("Registrado con exito");
							vistaP.getPanelEstandar().getPanelCliente_Menu().setVisible(true);
							vistaP.getPanelEstandar().getPanelCliente_NuevoR().setVisible(false);

							borrarCampos();

						} else {
							vistaP.mostrarError("El usuario ya esta registrado");
						}

					} else {
						vistaP.mostrarError("Algun nï¿½mero ya ha estado registrado anteriormente");
					}

				} else {
					vistaP.mostrarError("Las contraseï¿½as no coinciden");
				}
			} else {
				vistaP.mostrarError("Por favor verifique los campos");
			}

		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelCliente_NuevoR().getVolver()) {

			vistaP.getPanelEstandar().getPanelCliente_Menu().setVisible(true);
			vistaP.getPanelEstandar().getPanelCliente_NuevoR().setVisible(false);
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelCliente_NuevoR().getVerContrasena()) {

			if (a == true) {
				vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContrasena1T().setEchoChar((char) 0);
				vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContrasena2T().setEchoChar((char) 0);
				a = false;
			} else {
				vistaP.getPanelEstandar().getPanelRegistro_Admin().getPassword().setEchoChar('•');
				vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContrasena1T().setEchoChar('•');
				vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContrasena2T().setEchoChar('•');
				a = true;
			}

		}
		// ADMIN
		if (botonPulsado == vistaP.getPanelEstandar().getPanelMenu().getAdministrador()) {
			vistaP.getPanelEstandar().getPanelMenu().setVisible(false);
			vistaP.getPanelEstandar().getPanelAdmin_Menu().setVisible(true);

		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelAdmin_Menu().getCuenta()) {
			vistaP.getPanelEstandar().getPanelAdmin_Menu().setVisible(false);
			vistaP.getPanelEstandar().getPanelRegistro_Admin().setVisible(true);

		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelAdmin_Menu().getVolver()) {

			vistaP.getPanelEstandar().getPanelAdmin_Menu().setVisible(false);
			vistaP.getPanelEstandar().getPanelMenu().setVisible(true);

		}
		// SESION ADMIN
		if (botonPulsado == vistaP.getPanelEstandar().getPanelRegistro_Admin().getAceptar()) {
			if (!vistaP.getPanelEstandar().getPanelRegistro_Admin().getUsuario().getText().equals("")
					&& !vistaP.getPanelEstandar().getPanelRegistro_Admin().getPassword().getPassword().equals(null)) {

				String usuario = vistaP.getPanelEstandar().getPanelRegistro_Admin().getUsuario().getText();
				String constrasenia = new String(
						vistaP.getPanelEstandar().getPanelRegistro_Admin().getPassword().getPassword());

				if (clienteDAO.verificarAdminInicio(constrasenia, usuario)) {
					vistaP.mostrarMensaje("Bienvenido: " + usuario);
					vistaP.getPanelEstandar().getPanelMenu_Admin().setVisible(true);
					vistaP.getPanelEstandar().getPanelRegistro_Admin().setVisible(false);

				} else {
					vistaP.mostrarError("Verifique los campos");
				}

			} else {
				vistaP.mostrarError("Verifique los campos");
			}
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelRegistro_Admin().getVolver()) {
			vistaP.getPanelEstandar().getPanelRegistro_Admin().setVisible(false);
			vistaP.getPanelEstandar().getPanelAdmin_Menu().setVisible(true);

		}

		if (botonPulsado == vistaP.getPanelEstandar().getPanelRegistro_Admin().getVerContrasena()) {
			if (a == true) {
				vistaP.getPanelEstandar().getPanelRegistro_Admin().getPassword().setEchoChar((char) 0);
				a = false;
			} else {
				vistaP.getPanelEstandar().getPanelRegistro_Admin().getPassword().setEchoChar('•');
				a = true;
			}

		}
		// SESION ADMIN VISUALIZACION
		if (botonPulsado == vistaP.getPanelEstandar().getPanelMenu_Admin().getCliente()) {

			vistaP.getPanelEstandar().getPanelTabla().setVisible(true);

			vistaP.getPanelEstandar().getPanelTabla().getTabla()
					.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

					}, new String[] { "ID", "Nombres", "Apellidos", "Direccion", "Documento", "Correo", "Usuario" }));
			vistaP.getPanelEstandar().getPanelTabla().getjScrollPane1()
					.setViewportView(vistaP.getPanelEstandar().getPanelTabla().getTabla());

			ArrayList<Usuario> miUsuario = clienteDAO.listaUsuarios();

			for (int i = 0; i < miUsuario.size(); i++) {
				dftable = (DefaultTableModel) vistaP.getPanelEstandar().getPanelTabla().getTabla().getModel();
				String nombres = miUsuario.get(i).getNombres();
				String apellidos = miUsuario.get(i).getApellidos();
				String direccion = miUsuario.get(i).getDireccion();
				String documento = miUsuario.get(i).getDocumentoIdentidad();
				int id = miUsuario.get(i).getId_usuario();
				String correo = miUsuario.get(i).getCorreo();
				String usuario = miUsuario.get(i).getUsuario();
				Object[] obj = { id, nombres, apellidos, direccion, documento, correo, usuario };
				dftable.addRow(obj);
			}
			nombreArchivo = "TodosLosClientes";
		}
		if(botonPulsado == vistaP.getPanelEstandar().getPanelMenu_Admin().getHistorialServicios()) {
			vistaP.getPanelEstandar().getPanelTabla().setVisible(true);

			vistaP.getPanelEstandar().getPanelTabla().getTabla()
					.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

					}, new String[] { "ID_historia","Fecha", "Mascota", "Servicio", "Total", "Descripcion", "id_usuario"}));
			vistaP.getPanelEstandar().getPanelTabla().getjScrollPane1()
					.setViewportView(vistaP.getPanelEstandar().getPanelTabla().getTabla());

			ArrayList<Historia> miHistoria = historiaDAO.listaHistoria();

			for (int i = 0; i < miHistoria.size(); i++) {
				dftable = (DefaultTableModel) vistaP.getPanelEstandar().getPanelTabla().getTabla().getModel();
				int id_historia = miHistoria.get(i).getId_historia();
				String fecha = miHistoria.get(i).getFecha();
				String mascota = miHistoria.get(i).getMascota();
				String servicio = miHistoria.get(i).getServicio();
				int total = miHistoria.get(i).getTotal();
				int id_usuario = miHistoria.get(i).getId_usuario();
				String descripcion = miHistoria.get(i).getDescripcion();
	
				Object[] obj = { id_historia, fecha, mascota, servicio, total, descripcion,id_usuario};
				dftable.addRow(obj);
			}
			nombreArchivo = "Historial_Usuarios";
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelMenu_Admin().getMascota()) {
			vistaP.getPanelEstandar().getPanelTabla().setVisible(true);

			vistaP.getPanelEstandar().getPanelTabla().getTabla()
					.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

					}, new String[] { "ID", "Nombre", "Peso", "Color", "Raza", "Especie", "Aï¿½o Nacimiento",
							"Id_cliente" }));
			vistaP.getPanelEstandar().getPanelTabla().getjScrollPane1()
					.setViewportView(vistaP.getPanelEstandar().getPanelTabla().getTabla());

			ArrayList<Mascota> miMascota = mascotaDAO.listaMascotas();

			for (int i = 0; i < miMascota.size(); i++) {
				dftable = (DefaultTableModel) vistaP.getPanelEstandar().getPanelTabla().getTabla().getModel();
				String nombre = miMascota.get(i).getNombre();
				String peso = miMascota.get(i).getPeso();
				String color = miMascota.get(i).getColor();
				String raza = miMascota.get(i).getRaza();
				int id = miMascota.get(i).getId_mascota();
				String especie = miMascota.get(i).getEspecie();
				int usuario = miMascota.get(i).getId_cliente();
				String anno_naciemiento = miMascota.get(i).getAnno_nacimiento();
				Object[] obj = { id, nombre, peso, color, raza, especie, anno_naciemiento, usuario };
				dftable.addRow(obj);
			}
			nombreArchivo = "TodasLasMascotas";
		}if(botonPulsado == vistaP.getPanelEstandar().getPanelMenu_Admin().getFacturas()) {
			vistaP.getPanelEstandar().getPanelTabla().setVisible(true);
			vistaP.getPanelEstandar().getPanelRegistro_Mascota().setVisible(false);
			vistaP.getPanelEstandar().getPanelRegistro_Servicio().setVisible(false);

			vistaP.getPanelEstandar().getPanelTabla().getTabla()
					.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

					}, new String[] { "ID_factura","ID_usuario","Fecha", "Mascota", "Servicio", "Descuento","Iva%","Tarifa", "Total"}));
			vistaP.getPanelEstandar().getPanelTabla().getjScrollPane1()
					.setViewportView(vistaP.getPanelEstandar().getPanelTabla().getTabla());

			ArrayList<Factura_Detalle> miFactura = historiaDAO.listaFactura();
			int id_factura=0;
			for (int i = 0; i < miFactura.size(); i++) {
				dftable = (DefaultTableModel) vistaP.getPanelEstandar().getPanelTabla().getTabla().getModel();
				id_factura = miFactura.get(i).getId_factura();
				String fecha = miFactura.get(i).getFecha();
				String mascota = miFactura.get(i).getMascota();
				String servicio = miFactura.get(i).getServicio();
				int iva =  miFactura.get(i).getIva();
				int total = miFactura.get(i).getTotal();
				int descuento = miFactura.get(i).getDescuento();
				int tarifa = miFactura.get(i).getTarifa();
				int id_usuario = miFactura.get(i).getId_usuario();
	
				Object[] obj = { id_factura,id_usuario, fecha, mascota, servicio, descuento, iva,tarifa,total};
				dftable.addRow(obj);
			}
			nombreArchivo = "Factura_Usuarios";
		}

		// PDF

		if (botonPulsado == vistaP.getPanelEstandar().getPanelTabla().getPdf()) {
			vistaP.getPanelEstandar().getPanelTabla().setVisible(true);

			pdf = new Pdf();
			pdf.utilJTableToPdf(vistaP.getPanelEstandar().getPanelTabla().getTabla(), nombreArchivo);

		}

	}

	public void salir() {
		System.exit(0);
	}

	public boolean verificarRegistroCliente() {
		boolean registro = true;

		if (!vistaP.getPanelEstandar().getPanelCliente_NuevoR().getNombresT().getText().equals("")
				&& !vistaP.getPanelEstandar().getPanelCliente_NuevoR().getApellidosT().getText().equals("")
				&& !vistaP.getPanelEstandar().getPanelCliente_NuevoR().getDireccionT().getText().equals("")
				&& !vistaP.getPanelEstandar().getPanelCliente_NuevoR().getCorreoT().getText().equals("")
				&& !vistaP.getPanelEstandar().getPanelCliente_NuevoR().getDocumentoT().getText().equals("")
				&& !vistaP.getPanelEstandar().getPanelCliente_NuevoR().getTelefonosT().getText().equals("")
				&& !vistaP.getPanelEstandar().getPanelCliente_NuevoR().getUsuarioT().getText().equals("")
				&& !vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContrasena1T().getPassword().equals(null)
				&& !vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContrasena2T().getPassword().equals(null)) {

			registro = true;
		} else {

			registro = false;
		}
		return registro;

	}

	public boolean verificarRegistroMascota() {
		boolean registro = true;

		if (!vistaP.getPanelEstandar().getPanelRegistro_Mascota().getNombreT().getText().equals("")
				&& !vistaP.getPanelEstandar().getPanelRegistro_Mascota().getAnno_NacimientoL().getText().equals("")
				&& !vistaP.getPanelEstandar().getPanelRegistro_Mascota().getPesoT().getText().equals("")
				&& !vistaP.getPanelEstandar().getPanelRegistro_Mascota().getColorT().getText().equals("")
				&& !Objects.equals(vistaP.getPanelEstandar().getPanelRegistro_Mascota().getSexo().getSelectedItem(),
						"Seleccione...")
				&& !vistaP.getPanelEstandar().getPanelRegistro_Mascota().getRazaT().getText().equals("")
				&& !vistaP.getPanelEstandar().getPanelRegistro_Mascota().getEspecieT().getText().equals("")) {

			registro = true;
		} else {

			registro = false;
		}
		return registro;

	}

	public boolean verificarSolicitudServicio() {
		boolean registro = true;

		if (!Objects.equals(vistaP.getPanelEstandar().getPanelRegistro_Servicio().getServicioC().getSelectedItem(),
				"Seleccione...")
				&& !Objects.equals(
						vistaP.getPanelEstandar().getPanelRegistro_Servicio().getMascotaC().getSelectedItem(),
						"Seleccione...")
				&& !vistaP.getPanelEstandar().getPanelRegistro_Servicio().getForma_pagoT().getText().equals("")
				&& !vistaP.getPanelEstandar().getPanelRegistro_Servicio().getDescripcionT().getText().equals("")) {

			registro = true;
		} else {

			registro = false;
		}
		return registro;

	}

	public void borrarCampos() {
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getNombresT().setText("");
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getApellidosT().setText("");
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getDireccionT().setText("");
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getCorreoT().setText("");
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getDocumentoT().setText("");
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getTelefonosT().setText("");
		;
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getUsuarioT().setText("");
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContrasena1T().setText("");
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContrasena2T().setText("");

		vistaP.getPanelEstandar().getPanelRegistro_Mascota().getNombreT().setText("");
		vistaP.getPanelEstandar().getPanelRegistro_Mascota().getColorT().setText("");
		vistaP.getPanelEstandar().getPanelRegistro_Mascota().getRazaT().setText("");
		vistaP.getPanelEstandar().getPanelRegistro_Mascota().getEspecieT().setText("");
		vistaP.getPanelEstandar().getPanelRegistro_Mascota().getPesoT().setText("");
		vistaP.getPanelEstandar().getPanelRegistro_Mascota().getAnno_NacimientoT().setText("");

		vistaP.getPanelEstandar().getPanelRegistro_Servicio().getDescripcionT().setText("");
		vistaP.getPanelEstandar().getPanelRegistro_Servicio().getFechaD().setToolTipText("");
		vistaP.getPanelEstandar().getPanelRegistro_Servicio().getForma_pagoT().setText("");

	}

	public void llenarCombos() {
		vistaP.getPanelEstandar().getPanelRegistro_Servicio().getMascotaC().removeAllItems();
		vistaP.getPanelEstandar().getPanelRegistro_Servicio().getServicioC().removeAllItems();

		//
		vistaP.getPanelEstandar().getPanelRegistro_Servicio().getMascotaC().addItem("Seleccione...");
		vistaP.getPanelEstandar().getPanelRegistro_Servicio().getServicioC().addItem("Seleccione...");
		
		
		ArrayList<Mascota> miMascota = mascotaDAO.listaMascotasUsuario(UsuarioDAO.id);

		for (int i = 0; i < miMascota.size(); i++) {
			vistaP.getPanelEstandar().getPanelRegistro_Servicio().getMascotaC()
					.addItem(miMascota.get(i).getNombre());


		}
		ArrayList<Servicio> miServicio = historiaDAO.listaServicio();

		for (int i = 0; i < miServicio.size(); i++) {
			vistaP.getPanelEstandar().getPanelRegistro_Servicio().getServicioC()
					.addItem(miServicio.get(i).getNombre_servicio());


		}
	}

}
