package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.Cliente_Telefono;
import co.edu.unbosque.model.persistence.UsuarioDAO;
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
	public Cliente_Telefono cliente_Telefono;
	public DefaultTableModel dftable = (DefaultTableModel) vistaP.getPanelEstandar().getPanelTabla().getTabla().getModel();
	public static boolean a = true;

	public Controller() throws ParseException {
		vistaP = new VistaPrincipal();
		bd = new PostgresBD();
		clienteDAO = new UsuarioDAO();
		

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
		vistaP.getPanelEstandar().getPanelRegistro_Usuario().getVerContraseña().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelRegistro_Usuario().getAceptar().addActionListener(escuchador);
		// REGISTRO USUARIO
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getAceptar().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getVolver().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getVerContraseña().addActionListener(escuchador);
		// Menu ADMIN
		vistaP.getPanelEstandar().getPanelAdmin_Menu().getCuenta().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelAdmin_Menu().getVolver().addActionListener(escuchador);
		// SESION ADMIN
		vistaP.getPanelEstandar().getPanelRegistro_Admin().getAceptar().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelRegistro_Admin().getVolver().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelRegistro_Admin().getVerContraseña().addActionListener(escuchador);
		// Menu de visualizacion ADMIN
		vistaP.getPanelEstandar().getPanelMenu_Admin().getCliente().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Admin().getMascota().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Admin().getHistorialServicios().addActionListener(escuchador);
		vistaP.getPanelEstandar().getPanelMenu_Admin().getSalir().addActionListener(escuchador);

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
				if(!vistaP.getPanelEstandar().getPanelRegistro_Usuario().getUsuario().getText().equals("") &&
						!vistaP.getPanelEstandar().getPanelRegistro_Usuario().getPassword().getPassword().equals(null)) {
					
					String usuario = vistaP.getPanelEstandar().getPanelRegistro_Usuario().getUsuario().getText();
					String constrasenia = new String(vistaP.getPanelEstandar().getPanelRegistro_Usuario().getPassword().getPassword());
					
					if(clienteDAO.verificarUsuarioInicio(constrasenia, usuario)) {
						vistaP.mostrarMensaje("Bienvenido: "+usuario);
						vistaP.getPanelEstandar().getPanelRegistro_Usuario().setVisible(false);
						vistaP.getPanelEstandar().getPanelMenu_Usuario().setVisible(true);
					}else {
						vistaP.mostrarError("Verifique los campos");
					}
					
				}else {
					vistaP.mostrarError("Verifique los campos");
				}
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelRegistro_Usuario().getVerContraseña()) {
			if (a == true) {
				vistaP.getPanelEstandar().getPanelRegistro_Usuario().getPassword().setEchoChar((char) 0);
				a = false;
			} else {
				vistaP.getPanelEstandar().getPanelRegistro_Usuario().getPassword().setEchoChar('•');
				a = true;
			}
		}
		// REGISTRAR CLIENTE
		if (botonPulsado == vistaP.getPanelEstandar().getPanelCliente_NuevoR().getAceptar()) {

			String nombres = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getNombresT().getText();
			String apellidos = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getApellidosT().getText();
			String direccion = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getDireccionT().getText();
			String correo = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getCorreoT().getText();
			String documento = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getDocumentoT().getText();
			String telefono = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getTelefonosT().getText();
			String usuario = vistaP.getPanelEstandar().getPanelCliente_NuevoR().getUsuarioT().getText();
			String contraseña1 = new String(vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContraseña1T().getPassword());
			String contraseña2 = new String(vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContraseña2T().getPassword());
			String estado = "A";
			if(verificarRegistroCliente()==true) {
				if(contraseña1.equals(contraseña2)) {
					cliente = new Usuario(nombres, apellidos, direccion, correo, documento, usuario, contraseña2,estado);
					cliente_Telefono =  new Cliente_Telefono(telefono, estado);
					if(clienteDAO.verificarNumeros(cliente_Telefono)==true) {
						if(clienteDAO.verificarUsuario(cliente)==true) {
							clienteDAO.registrarCliente(cliente, cliente_Telefono);
							vistaP.mostrarMensaje("Registrado con exito");
							vistaP.getPanelEstandar().getPanelCliente_Menu().setVisible(false);
							vistaP.getPanelEstandar().getPanelCliente_NuevoR().setVisible(true);
							borrarCampos();
						
						}else {
							vistaP.mostrarError("El usuario ya esta registrado");
						}
					
					}else {
						vistaP.mostrarError("Algun número ya ha estado registrado anteriormente");
					}
					
				}else {
					vistaP.mostrarError("Las contraseñas no coinciden");
				}
			}else {
				vistaP.mostrarError("Por favor verifique los campos");
			}
			
			

		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelCliente_NuevoR().getVolver()) {

			vistaP.getPanelEstandar().getPanelCliente_Menu().setVisible(true);
			vistaP.getPanelEstandar().getPanelCliente_NuevoR().setVisible(false);
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelCliente_NuevoR().getVerContraseña()) {

			if (a == true) {
				vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContraseña1T().setEchoChar((char) 0);
				vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContraseña2T().setEchoChar((char) 0);
				a = false;
			} else {
				vistaP.getPanelEstandar().getPanelRegistro_Admin().getPassword().setEchoChar('•');
				vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContraseña1T().setEchoChar('•');
				vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContraseña2T().setEchoChar('•');
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
			if(!vistaP.getPanelEstandar().getPanelRegistro_Admin().getUsuario().getText().equals("") &&
					!vistaP.getPanelEstandar().getPanelRegistro_Admin().getPassword().getPassword().equals(null)) {
				
				String usuario = vistaP.getPanelEstandar().getPanelRegistro_Admin().getUsuario().getText();
				String constrasenia = new String(vistaP.getPanelEstandar().getPanelRegistro_Admin().getPassword().getPassword());
				
				if(clienteDAO.verificarAdminInicio(constrasenia, usuario)) {
					vistaP.mostrarMensaje("Bienvenido: "+usuario);
					vistaP.getPanelEstandar().getPanelRegistro_Admin().setVisible(false);
					vistaP.getPanelEstandar().getPanelMenu_Admin().setVisible(true);
				}else {
					vistaP.mostrarError("Verifique los campos");
				}
				
			}else {
				vistaP.mostrarError("Verifique los campos");
			}
		}
		if (botonPulsado == vistaP.getPanelEstandar().getPanelRegistro_Admin().getVolver()) {
			vistaP.getPanelEstandar().getPanelRegistro_Admin().setVisible(false);
			vistaP.getPanelEstandar().getPanelAdmin_Menu().setVisible(true);

		}

		if (botonPulsado == vistaP.getPanelEstandar().getPanelRegistro_Admin().getVerContraseña()) {
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
			
			vistaP.getPanelEstandar().getPanelTabla().getTabla().setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

			}, new String[] { "ID", "Nombres","Apellidos","Direccion","Documento","Correo","Usuario" }));
			vistaP.getPanelEstandar().getPanelTabla().getjScrollPane1().setViewportView(vistaP.getPanelEstandar().getPanelTabla().getTabla());

			ArrayList<Usuario>miUsuario = clienteDAO.listaUsuarios();
			
			for(int i=0; i< miUsuario.size();i++) {
				
				String nombres = miUsuario.get(i).getNombres();
				String apellidos = miUsuario.get(i).getApellidos();
				String direccion = miUsuario.get(i).getDireccion();
				String documento = miUsuario.get(i).getDocumentoIdentidad();
				int id = miUsuario.get(i).getId_usuario();
				String correo = miUsuario.get(i).getCorreo();
				String usuario = miUsuario.get(i).getUsuario();
				Object[] obj = { id, nombres,apellidos,direccion,documento,correo,usuario};
				dftable.addRow(obj);
			}
			
			
			vistaP.getPanelEstandar().getPanelTabla().setVisible(true);
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
				&& !vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContraseña1T().getPassword().equals(null)
				&& !vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContraseña2T().getPassword().equals(null)) {

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
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getTelefonosT().setText("");;
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getUsuarioT().setText("");
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContraseña1T().setText("");
		vistaP.getPanelEstandar().getPanelCliente_NuevoR().getContraseña2T().setText("");
	}

}
