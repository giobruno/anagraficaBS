package com.ddway.anagraficaBS.web.report;

import java.awt.Color;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.ddway.anagraficaBS.model.bean.BusinessServiceBean;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi;
import com.ddway.anagraficaBS.utility.CaricaTabellePdf;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReport3 extends AbstractPdfView {
	
	private static final Logger logger = LoggerFactory.getLogger(PdfReport3.class);

	private static Font titoloFont = new Font(Font.TIMES_ROMAN, 14, Font.BOLD, Color.decode("#000088"));
	private static Font sottoTitoloFont = new Font(Font.TIMES_ROMAN, 15, Font.BOLD, Color.decode("#0000CC"));
	private static Font baseFont = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL, Color.GRAY);
	private static Font boldFont = new Font(Font.TIMES_ROMAN, 13, Font.BOLD ,Color.BLACK);
	private static Font boldFontRed = new Font(Font.TIMES_ROMAN, 12, Font.BOLD ,Color.RED);
	 
	@Override
    protected void buildPdfDocument(Map<String, Object> stringObjectMap, Document document, PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Inizio metodo PdfReport3.buildPdfDocument!");
       
		List<DProcessi> processiList = (List<DProcessi>) request.getSession().getAttribute("processiList");	  
		request.getSession().removeAttribute("processiList");

			  
		    try{
		    	String relativeWebPath = "resources/img/logoReport.png";
		    	String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
		    	Image logo = Image.getInstance(absoluteDiskPath);
			    logo.scalePercent(39);
			     
			    Paragraph par = new Paragraph();			    
		        par.add(new Chunk (logo, 0, 0, true));
		        HeaderFooter header = new HeaderFooter(par, false);
		        header.setBorder(0);
		        document.setHeader(header); 
		        document.open();			    
		        
		    	Paragraph titolo = new Paragraph("Elenco Processi", titoloFont);
		    	titolo.setAlignment(Element.ALIGN_CENTER);
		        document.add(titolo);		    	
		       
		        document.add(new Paragraph("   "));
		        document.add(new Paragraph("   "));		       		        
		        
		        CaricaTabellePdf caricaTabellePdf = new CaricaTabellePdf();
		        
		        PdfPTable tabellaReport1 = caricaTabellePdf.caricaTabellaReport3(processiList);
		        document.add(tabellaReport1);		        		       			  
		    }catch(Exception e){
		        e.printStackTrace();
		        logger.info(e.getMessage()+" on method PdfReport3.buildPdfDocument!");
		        throw e;
		    }
		    document.close();
		    }
	}
	

