package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import co.edu.unbosque.view.VistaPrincipal;

/**
 * Controller
 * 
 * @author Brayan Moreno
 *
 */
import java.sql.*;

public class Controller implements ActionListener {

	VistaPrincipal vistaP;
	public static boolean a = true;

	public Controller() throws ParseException {
		vistaP = new VistaPrincipal();

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
			vistaP.getPanelEstandar().getPanelRegistro_Usuario().setVisible(false);
			vistaP.getPanelEstandar().getPanelCliente_Menu().setVisible(true);
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

	}

	public void salir() {
		System.exit(0);
	}

}
