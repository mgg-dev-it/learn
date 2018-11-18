package mggdevit.learnitext7;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.io.font.TrueTypeFont;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class LearnItext7Font {

	public LearnItext7Font() {
	}

	public void createPDF(String sFileName) {
		System.out.println("Creating " + sFileName);
		try {
			PdfWriter writer = new PdfWriter(sFileName);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);
			
			//PdfFont font = PdfFontFactory.createFont(com.itextpdf.io.font.FontConstants.TIMES_ROMAN);
			PdfFont font = PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.TIMES_ROMAN);
			
			document.add(new Paragraph("Hello World :)"));
			document.add(new Paragraph("aáeéiíoóöőuúüű"));
			document.add(new Paragraph("AÁEÉIÍOÓÖŐUÚÜŰ"));
			document.add(new Paragraph("Times Roman").setFont(font));
			document.add(new Paragraph("aáeéiíoóöőuúüű").setFont(font));
			document.add(new Paragraph("AÁEÉIÍOÓÖŐUÚÜŰ").setFont(font));
			
			PdfFont fontHUTimes = PdfFontFactory.createFont(new TrueTypeFont("mggdevit/learnitext7/fonts/times.ttf"), "ISO-8859-2", true);
			document.add(new Paragraph("Times hungarian: aáeéiíoóöőuúüű AÁEÉIÍOÓÖŐUÚÜŰ").setFont(fontHUTimes));
			
			PdfFont fontHUTimesBold = PdfFontFactory.createFont(new TrueTypeFont("mggdevit/learnitext7/fonts/timesbd.ttf"), "ISO-8859-2", true);
			document.add(new Paragraph("Times hungarian bold: aáeéiíoóöőuúüű AÁEÉIÍOÓÖŐUÚÜŰ").setFont(fontHUTimesBold));
			
			PdfFont fontHUTimesItalic = PdfFontFactory.createFont(new TrueTypeFont("mggdevit/learnitext7/fonts/timesi.ttf"), "ISO-8859-2", true);
			document.add(new Paragraph("Times hungarian italic: aáeéiíoóöőuúüű AÁEÉIÍOÓÖŐUÚÜŰ").setFont(fontHUTimesItalic));
			
			PdfFont fontHUTimesBoldItalic = PdfFontFactory.createFont(new TrueTypeFont("mggdevit/learnitext7/fonts/timesbi.ttf"), "ISO-8859-2", true);
			document.add(new Paragraph("Times hungarian bold italic: aáeéiíoóöőuúüű AÁEÉIÍOÓÖŐUÚÜŰ").setFont(fontHUTimesBoldItalic));
			
//			PdfFont font3 = PdfFontFactory.createFont(new TrueTypeFont("mggdevit/learnitext7/fonts/times.ttf"), "UTF-8", true); //doesn't work ...
//			document.add(new Paragraph("aáeéiíoóöőuúüű").setFont(font3));
//			document.add(new Paragraph("AÁEÉIÍOÓÖŐUÚÜŰ").setFont(font3));
			
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
