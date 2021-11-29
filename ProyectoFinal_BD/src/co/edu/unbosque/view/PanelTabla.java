package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PanelTabla extends JPanel {
	

	private JTable tabla;
	private JScrollPane jScrollPane1;
	private JButton excel;
	public PanelTabla() {
		
		
		
		tabla = new JTable();
	
//		jScrollPane1 = new JScrollPane(tabla);
		jScrollPane1 = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		jScrollPane1.setBounds(350, 200, 500, 350);
		tabla.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
//		tabla.setEditable(false);
		  //Caracteristicas Tabla
		tabla.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "tipo_rol 1", "estado 2","estado 2","tipo_rol 1", "estado 2","estado 2" }));
		jScrollPane1.setViewportView(tabla);
		
		
		

			


			
		

			tabla.getTableHeader().setReorderingAllowed(false);
			tabla.getTableHeader().setResizingAllowed(false);

			//tabla.setDefaultRenderer(Object.class, miRender);
			
			excel = new JButton("Exportar excel");
			excel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

			excel.setEnabled(true);
			add(excel);
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


	
	
}
