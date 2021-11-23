package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VistaPrincipal extends JFrame{
	
	private PanelEstandar panelEstandar;

	public VistaPrincipal () throws ParseException {
		
		
		    panelEstandar = new PanelEstandar(this);
		
		 	setVisible(true);
	        setSize(1000, 700);
	        setLocationRelativeTo(null);
	        setTitle("Veterinaria");
	        setResizable(false);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        getContentPane().setLayout(new BorderLayout(10,10));
	        
	        add(panelEstandar);
	     
	}

	public void setPanelEstandar(PanelEstandar panelEstandar) {
		this.panelEstandar = panelEstandar;
	}
	/**
	 * Este metodo permite mostrar un mensaje de alerta de error cuando ocurra en el programa
	 * <b>pre</b> inicializar vista principal<br>
	 * <b>post</b> Se devuelve un mensaje de alerta <br>
	 * @param mensaje Este es un string donde se almcena el error ocurrido
	 */
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

	/**
	 * Este metodo permite mostrar un mensaje informativo en el programa
	 * <b>pre</b> inicializar vista principal<br>
	 * <b>post</b> Se devuelve un mensaje  <br>
	 * @param mensaje Este es un string donde se almcena el mensaje que se quiere mostrar al usuario
	 */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
	
	/**
	 * Devuelve panelEstandar
	 * 
	 * @return panelEstandar
	 */
	public PanelEstandar getPanelEstandar() {
		return panelEstandar;
	}

	/**
	 * Modifica panelEstandar
	 * 
	 * @param panelEstandar
	 */
}
