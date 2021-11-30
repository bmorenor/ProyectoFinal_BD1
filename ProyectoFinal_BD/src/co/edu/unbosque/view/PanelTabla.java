package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PanelTabla extends JPanel {

	private JTable tabla;
	private JScrollPane jScrollPane1;
	private JButton excel;
	private JButton pdf;

	public PanelTabla() {
		setLayout(null);
		tabla = new JTable();

//		jScrollPane1 = new JScrollPane(tabla);
		jScrollPane1 = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane1.setBounds(0, 0, 500,500);
		jScrollPane1.setForeground(Color.white);
//		tabla.setBounds(10, 5, 600, 60);
		
		tabla.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
//		tabla.setEditable(false);
		// Caracteristicas Tabla
		tabla.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "tipo_rol 1", "estado 2", "estado 2", "tipo_rol 1", "estado 2", "estado 2" }));
		jScrollPane1.setViewportView(tabla);

//			tabla.getTableHeader().setReorderingAllowed(false);
//			tabla.getTableHeader().setResizingAllowed(false);

		// tabla.setDefaultRenderer(Object.class, miRender);
		
		 tabla.setRowHeight(70);



		excel = new JButton("Generar Excel");
		excel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		excel.setBounds(0, 520, 170,40);
	
		excel.setEnabled(true);
		
		pdf = new JButton("Generar PDF");
		pdf.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		pdf.setBounds(200, 520, 170,40);


		pdf.setEnabled(true);
		
//		add(excel);
		add(pdf);
		add(jScrollPane1);

	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public JButton getExcel() {
		return excel;
	}

	public void setExcel(JButton excel) {
		this.excel = excel;
	}

	public JButton getPdf() {
		return pdf;
	}

	public void setPdf(JButton pdf) {
		this.pdf = pdf;
	}

}
