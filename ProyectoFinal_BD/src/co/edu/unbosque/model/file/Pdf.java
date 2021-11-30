package co.edu.unbosque.model.file;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.itextpdf.awt.geom.Shape;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf {
	   private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,  Font.BOLD);
	    private static final Font subCategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,  Font.BOLD);
	    private static final Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,  Font.NORMAL, BaseColor.RED);
	    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	    private File archivo ;
	public void utilJTableToPdf(JTable jTable, String title){    
	    try {
	    	
	    	archivo = new File("Files/"+title+".pdf");
	        // We create the document and set the file name.        
	        // Creamos el documento e indicamos el nombre del fichero.
	        Document document = new Document();
	        try {
	            PdfWriter.getInstance(document, new FileOutputStream(archivo));
	        } catch (FileNotFoundException fileNotFoundException) {
	            System.out.println("No such file was found to generate the PDF (No se encontró el fichero para generar el pdf)" + fileNotFoundException);
	        }
	        document.open();
	        // We add metadata to PDF
	        // Añadimos los metadatos del PDF
	        document.addTitle(title);
	        document.addSubject("Información sobre "+title);
	        document.addKeywords("Java, PDF, iText");
	        document.addAuthor("BmorenorR");
	        document.addCreator("BMORENOR");
	         
	        // First page (Primera página)
	        Anchor anchor = new Anchor(title, categoryFont);
	        anchor.setName(title);
	 
	        // Second parameter is the number of the chapter (El segundo parámetro es el número del capítulo).
	        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
	 
	        Paragraph subPara = new Paragraph("", subCategoryFont);
	        Section subCatPart = catPart.addSection(subPara);
//	        subCatPart.add(new Paragraph("This is a simple example (Este es un ejemplo sencillo)+\n"));
	                     
	        // Create the table (Creamos la tabla)
	        PdfPTable table = new PdfPTable(jTable.getColumnCount()); 
	          
	        // Now we fill the rows of the PdfPTable (Ahora llenamos las filas de PdfPTable)
	        PdfPCell columnHeader;
	        // Fill table columns header 
	        // Rellenamos las cabeceras de las columnas de la tabla.                
	        for (int column = 0; column < jTable.getColumnCount(); column++) {                 
	            columnHeader = new PdfPCell(new Phrase(jTable.getColumnName(column)));
	            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(columnHeader);
	        }
	        table.setHeaderRows(1);
	        // Fill table rows (rellenamos las filas de la tabla).                
	        for (int row = 0; row < jTable.getRowCount(); row++) {                
	            for (int column = 0; column < jTable.getColumnCount(); column++) { 
	                table.addCell(jTable.getValueAt(row, column).toString());
	            }
	        } 
	        subCatPart.add(table);
	         
	        document.add(catPart);
	         
	        document.close();
	        JOptionPane.showMessageDialog(null, "Se creo exitosamente",
	                "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
	    } catch (DocumentException documentException) {
	        System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
	        JOptionPane.showMessageDialog(null, "The file not exists (Se ha producido un error al generar un documento): " + documentException,
	                "ERROR", JOptionPane.ERROR_MESSAGE);
	    }     
	              
	}

}
