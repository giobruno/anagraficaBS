package com.ddway.anagraficaBS.utility;

import java.awt.Color;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReport extends AbstractPdfView {	
	
	private static Font titoloFont = new Font(Font.TIMES_ROMAN, 18,
		      Font.BOLD, Color.decode("#000088"));
	 private static Font sottoTitoloFont = new Font(Font.TIMES_ROMAN, 15,
		      Font.BOLD, Color.decode("#0000CC"));
	 private static Font baseFont = new Font(Font.TIMES_ROMAN, 12,
		      Font.NORMAL, Color.GRAY);
	 private static Font boldFont = new Font(Font.TIMES_ROMAN, 13,
		      Font.BOLD ,Color.BLACK);
	 private static Font boldFontRed = new Font(Font.TIMES_ROMAN, 12,
		      Font.BOLD ,Color.RED);
	 
	@Override
    protected void buildPdfDocument(Map<String, Object> stringObjectMap, Document document, PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws Exception {
       
		

		}
	}
