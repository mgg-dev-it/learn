package mggdevit.learnitext7;

import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class HelloWorld {

	public HelloWorld() {
	}

	public void createPDF(String sFileName) {
		System.out.println("Creating " + sFileName);
		try {
			PdfWriter writer = new PdfWriter(sFileName);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);
			document.add(new Paragraph("Hello World :)"));
			document.add(new Paragraph("aáeéiíoóöőuúüű"));
			document.add(new Paragraph("AÁEÉIÍOÓÖŐUÚÜŰ"));
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
