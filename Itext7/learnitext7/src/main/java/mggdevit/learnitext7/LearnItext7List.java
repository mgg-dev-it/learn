package mggdevit.learnitext7;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.io.font.TrueTypeFont;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.ListNumberingType;

public class LearnItext7List {

	public LearnItext7List() {
	}

	public void createPDF(String sFileName) {
		System.out.println("Creating " + sFileName);
		try {
			PdfWriter writer = new PdfWriter(sFileName);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);

			PdfFont font = PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.TIMES_ROMAN);
			
			document.add(new Paragraph("This is a hungarian font list:").setFont(font));
			
			List list = new List().setSymbolIndent(12).setListSymbol("\u2022").setFont(font);
			list.add(new ListItem("List item 1 aáeéiíoóöőuúüű"));
			list.add(new ListItem("List item 2 aáeéiíoóöőuúüű"));
			list.add(new ListItem("List item 3 aáeéiíoóöőuúüű"));
			list.add(new ListItem("List item 4 aáeéiíoóöőuúüű"));
			list.add(new ListItem("List item 5 aáeéiíoóöőuúüű"));
			document.add(list);

			PdfFont fontHUTimes = PdfFontFactory.createFont(new TrueTypeFont("mggdevit/learnitext7/fonts/times.ttf"),
					"ISO-8859-2", true);

			document.add(new Paragraph("This is a hungarian font list:").setFont(fontHUTimes));
			
			List listHu = new List().setSymbolIndent(12).setListSymbol("\u2022").setFont(fontHUTimes);
			listHu.add(new ListItem("List item 1 aáeéiíoóöőuúüű"));
			listHu.add(new ListItem("List item 2 aáeéiíoóöőuúüű"));
			listHu.add(new ListItem("List item 3 aáeéiíoóöőuúüű"));
			listHu.add(new ListItem("List item 4 aáeéiíoóöőuúüű"));
			listHu.add(new ListItem("List item 5 aáeéiíoóöőuúüű"));
			document.add(listHu);

			document.add(new Paragraph("This is a hungarian font list mixed with original times for the bullet symbol:").setFont(font));

			List listHuMix = new List().setSymbolIndent(12).setListSymbol("\u2022").setFont(font);
			ListItem li1 = new ListItem("List item 1 aáeéiíoóöőuúüű");
			li1.setFont(fontHUTimes);
			listHuMix.add(li1);
			listHuMix.add(new ListItem("List item 2 aáeéiíoóöőuúüű"));
			listHuMix.add(new ListItem("List item 3 aáeéiíoóöőuúüű"));
			listHuMix.add(new ListItem("List item 4 aáeéiíoóöőuúüű"));
			listHuMix.add(new ListItem("List item 5 aáeéiíoóöőuúüű"));
			document.add(listHuMix);
			
			PdfFont fontISO_8859_2 = PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.TIMES_ROMAN, "ISO-8859-2");
			document.add(new Paragraph("Numbered list:").setFont(fontISO_8859_2));
			List list2 = new List().setListSymbol(ListNumberingType.DECIMAL).setFont(fontISO_8859_2);;
			list2.add(new ListItem("List item aáeéiíoóöőuúüű"));
			list2.add(new ListItem("List item aáeéiíoóöőuúüű"));
			list2.add(new ListItem("List item aáeéiíoóöőuúüű"));
			document.add(list2);
			
			
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
