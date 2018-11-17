package mggdevit.learnitext7;

import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.test.annotations.WrapToTest;

/**
 * Learn Itext7 Hello world!
 *
 */
//@WrapToTest
public class HelloWorld {
	public static void main(String[] args) {
		// System.out.println( "Hello World!" );
		new HelloWorld().createPDF(".\\LearnItext7-HelloWorld.pdf");
	}

	private void createPDF(String sFileName) {
		try {
			PdfWriter writer = new PdfWriter(sFileName);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);
			document.add(new Paragraph("Hello World!"));
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
