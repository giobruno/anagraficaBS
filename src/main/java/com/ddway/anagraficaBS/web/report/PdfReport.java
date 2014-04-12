package com.ddway.anagraficaBS.web.report;

import java.awt.Color;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


/**
 * Created with IntelliJ IDEA.
 * User: r.bruno@london.net-a-porter.com
 * Date: 25/11/2013
 * Time: 13:52
 * To change this template use File | Settings | File Templates.
 */

public class PdfReport extends AbstractPdfView {
//	
//	
//	
//	private static Font titoloFont = new Font(Font.TIMES_ROMAN, 18,
//		      Font.BOLD, Color.decode("#000088"));
//	 private static Font sottoTitoloFont = new Font(Font.TIMES_ROMAN, 15,
//		      Font.BOLD, Color.decode("#0000CC"));
//	 private static Font baseFont = new Font(Font.TIMES_ROMAN, 12,
//		      Font.NORMAL, Color.GRAY);
//	 private static Font boldFont = new Font(Font.TIMES_ROMAN, 13,
//		      Font.BOLD ,Color.BLACK);
//	 private static Font boldFontRed = new Font(Font.TIMES_ROMAN, 12,
//		      Font.BOLD ,Color.RED);
//	 
	@Override
    protected void buildPdfDocument(Map<String, Object> stringObjectMap, Document document, PdfWriter pdfWriter, HttpServletRequest request, HttpServletResponse response) throws Exception {
       
//		
////		WrapperFormBigToFormStep wrapperFormBigToFormStep = new WrapperFormBigToFormStep();
////		HashMap<String, Object> progetto = (HashMap<String, Object>) request.getSession().getAttribute("progettoPdf");
////		AnagrafForm anagrafForm =   (AnagrafForm) progetto.get("anagrafForm");
////		FinanzForm finanzForm = (FinanzForm) progetto.get("finanzForm");
////		FisicaForm1 fisicaForm1 = (FisicaForm1) progetto.get("fisicaForm");
////		ProcedForm procedForm = (ProcedForm) progetto.get("procedForm");
//	
//      
//		
//		if (anagrafForm != null ){
//		      Rectangle pageSize = PageSize.LETTER.rotate();
//		      document.setPageSize(pageSize);
//			  
//		    try{
//		    	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("iTextExample.pdf"));
//		        document.open();
//		    StringBuffer pathBuffer = request.getRequestURL();
//		    String path = pathBuffer.toString();
////		    System.out.println(path);
//		    String[] indirizzo = path.split("mop");
//		    Image logoBdap = Image.getInstance("/properties/logoBdapNew.jpg");
//		     
//		    document.add(logoBdap);
//		    document.add(new Paragraph("   "));
//	        document.add(new Paragraph("   "));
//		    	Paragraph titolo = new Paragraph("RIEPILOGO AGGIORNAMENTO DATI", titoloFont);
//		    	titolo.setAlignment(Element.ALIGN_CENTER);
//		        document.add(titolo);
//		    	Paragraph cup = new Paragraph("CUP:  "+anagrafForm.getCodiceUnivocoProgetto(),titoloFont);
//		    	cup.setAlignment(Element.ALIGN_CENTER);
//		        document.add(cup);
//		       
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("Informazioni generali", sottoTitoloFont));
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("   "));
//		        
//		        PdfPTable tableInformazioni = new PdfPTable(4);
//		        tableInformazioni.setWidthPercentage(100f);
//		        tableInformazioni.getDefaultCell().setBorder(Rectangle.NO_BORDER);
//			        PdfPCell c1 = new PdfPCell(new Phrase("Titolo Progetto:",boldFont));
//			        c1.setBorder(Rectangle.NO_BORDER);
//			        
//			      //  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//			        tableInformazioni.addCell(c1);
//		
//			        tableInformazioni.addCell(new Phrase(anagrafForm.getTitoloProgetto(),baseFont));
//			        
//			        c1 = new PdfPCell(new Phrase("Annotazioni:",boldFont));
//			        c1.setBorder(Rectangle.NO_BORDER);
//			     //   c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//			        tableInformazioni.addCell(c1);
//			        
//			        tableInformazioni.addCell(new Phrase(anagrafForm.getAnnotazione(),baseFont));
//		        document.add(tableInformazioni);
//		        
//		        
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("Classificazioni comuni", sottoTitoloFont));
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("   "));
//		        
//		        PdfPTable tableClassificazioni = new PdfPTable(4);
//		        tableClassificazioni.setWidthPercentage(100f);
//		        tableClassificazioni.getDefaultCell().setBorder(Rectangle.NO_BORDER);
//			         c1 = new PdfPCell(new Phrase("Settore:",boldFont));
//			        c1.setBorder(Rectangle.NO_BORDER);
//			        
//			      //  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//			        tableClassificazioni.addCell(c1);
//			        if (anagrafForm.getSettore() != null && !anagrafForm.getSettore().equals(""))
//			        	tableClassificazioni.addCell(new Phrase(anagrafForm.getDescSettore(),baseFont));
//			        else
//			        	tableClassificazioni.addCell(new Phrase("-",baseFont));
//			        
//			        c1 = new PdfPCell(new Phrase("Tipo finanziamento:",boldFont));
//			        c1.setBorder(Rectangle.NO_BORDER);
//			     //   c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//			        tableClassificazioni.addCell(c1);
//			        if (anagrafForm.getTipoFinanziamento() != null && !anagrafForm.getTipoFinanziamento().equals(""))
//			        	tableClassificazioni.addCell(new Phrase(anagrafForm.getDescTipoFinanziamento(),baseFont));
//			        else
//			        	tableClassificazioni.addCell(new Phrase("-",baseFont));
//		        document.add(tableClassificazioni);
//		        
//		        tableClassificazioni = new PdfPTable(6);
//		        tableClassificazioni.setWidthPercentage(100f);
//		        tableClassificazioni.getDefaultCell().setBorder(Rectangle.NO_BORDER);
//			         c1 = new PdfPCell(new Phrase("Generatore entrate:",boldFont));
//			        c1.setBorder(Rectangle.NO_BORDER);
//			        
//			      //  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//			        tableClassificazioni.addCell(c1);
//			        if (anagrafForm.getGeneratoreEntrate() != null && !anagrafForm.getGeneratoreEntrate().equals(""))
//			        	tableClassificazioni.addCell(new Phrase(anagrafForm.getGeneratoreEntrate(),baseFont));
//			        else
//			        	tableClassificazioni.addCell(new Phrase("-",baseFont));
//			        
//			        c1 = new PdfPCell(new Phrase("Tipo intesa:",boldFont));
//			        c1.setBorder(Rectangle.NO_BORDER);
//			     //   c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//			        tableClassificazioni.addCell(c1);
//			        if (anagrafForm.getTipoIntesa() != null && !anagrafForm.getTipoIntesa().equals(""))
//			        	tableClassificazioni.addCell(new Phrase(anagrafForm.getDescTipoIntesa(),baseFont));
//			        else
//			        	tableClassificazioni.addCell(new Phrase("-",baseFont));
//			        
//			        c1 = new PdfPCell(new Phrase("Legge obiettivo:",boldFont));
//			        c1.setBorder(Rectangle.NO_BORDER);
//			     //   c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//			        tableClassificazioni.addCell(c1);
//			        if (anagrafForm.getLeggeObiettivo() != null && !anagrafForm.getLeggeObiettivo().equals(""))
//			        	tableClassificazioni.addCell(new Phrase(anagrafForm.getLeggeObiettivo(),baseFont));
//			        else
//			        	tableClassificazioni.addCell(new Phrase("-",baseFont));
//		        document.add(tableClassificazioni);
//		        
//		        
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("Strumento attuativo", sottoTitoloFont));
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("   "));
//		        
//		        PdfPTable tableStrumento = new PdfPTable(2);
//		        tableStrumento.setWidthPercentage(100f);
//		        tableStrumento.getDefaultCell().setBorder(Rectangle.NO_BORDER);
//			         c1 = new PdfPCell(new Phrase("Strumento attuativo:",boldFont));
//			        c1.setBorder(Rectangle.NO_BORDER);
//			        
//			      //  c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//			        tableStrumento.addCell(c1);
//		
//			        tableStrumento.addCell(new Phrase(anagrafForm.getDescStrumentoAttuativo(),baseFont));
//			       
//		        document.add(tableStrumento);
//		        
//		        
//		       
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("Localizzazione geografica del progetto", sottoTitoloFont));
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("   "));
//		        
//		        
//   CaricaTabellePdf caricaTabellePdf = new CaricaTabellePdf();
//		        
//		        PdfPTable tableLocalizzazioni = caricaTabellePdf.caricaTabellaPdfLocalizzazioni(anagrafForm);
//		        if (tableLocalizzazioni != null)
//		        	document.add(tableLocalizzazioni);
//		        else {
//		        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//		        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//			        document.add(messaggioAssenza);
//		        }	
//		        
//		      
//		        
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("Coordinate di georeferenziazione del progetto", sottoTitoloFont));
//		        document.add(new Paragraph("   "));
//		        document.add(new Paragraph("   "));
//		        
//		        
//		        PdfPTable tableCoordinate = caricaTabellePdf.caricaTabellaPdfGeoreferenziazioni(anagrafForm);
//		        if (tableCoordinate != null)
//		        	document.add(tableCoordinate);
//		        else {
//		        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//		        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//		             document.add(messaggioAssenza);
//		        }	
//		        
//				 document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Soggetti correlati ai progetti", sottoTitoloFont));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        
//			        
//			        
//			        PdfPTable tableSoggetti = caricaTabellePdf.caricaTabellaPdfSoggetti(anagrafForm);
//			        if (tableSoggetti != null)
//			        	document.add(tableSoggetti);
//			        else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//			        
//			        
//			        
//			        // Sezione Finanziaria
//			        
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Finanziamento del progetto", sottoTitoloFont));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        
//			       
//			        PdfPTable tableFinanziamenti = caricaTabellePdf.caricaTabellaPdfFinanziamenti(wrapperFormBigToFormStep.caricaFinanzForm1(finanzForm));
//			        if (tableFinanziamenti != null){
//			        	 document.add(new Paragraph("   "));
//					        document.add(new Paragraph("   "));
//			     
//			        	document.add(tableFinanziamenti);
//			        }  else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//		
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Impegni", sottoTitoloFont));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        
//			     
//			        PdfPTable tableImpegni = caricaTabellePdf.caricaTabellaPdfImpegni(wrapperFormBigToFormStep.caricaFinanzForm2(finanzForm,null));
//			        if (tableImpegni != null)
//			        	document.add(tableImpegni);
//			        else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//		
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Pagamenti", sottoTitoloFont));
//			      
//			        
//			        
//			        PdfPTable tablePagamenti = caricaTabellePdf.caricaTabellaPdfPagamenti(wrapperFormBigToFormStep.caricaFinanzForm2(finanzForm,null));
//			        if (tablePagamenti != null) {
//			        	  document.add(new Paragraph("   "));
//			        	  document.add(new Paragraph("   "));
//			        	document.add(tablePagamenti);
//			        } else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//			    	
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Quadro Economico", sottoTitoloFont));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        
//			      
//			        PdfPTable tableQuadroEconomico = caricaTabellePdf.caricaTabellaPdfQuadroEconomico(wrapperFormBigToFormStep.caricaFinanzForm3(finanzForm,null));
//			        if (tableQuadroEconomico != null)
//			        	document.add(tableQuadroEconomico);
//			        else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//		
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Economie", sottoTitoloFont));
//			      
//			        
//			        
//			        PdfPTable tableEconomie = caricaTabellePdf.caricaTabellaPdfEconomie(wrapperFormBigToFormStep.caricaFinanzForm3(finanzForm,null));
//			        if (tableEconomie != null) {
//			        	  document.add(new Paragraph("   "));
//			        	  document.add(new Paragraph("   "));
//			        	document.add(tableEconomie);
//			        } else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//			        
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Piano dei Costi", sottoTitoloFont));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        
//			      
//			        PdfPTable tablePianoCosti = caricaTabellePdf.caricaTabellaPdfPianoCosti(wrapperFormBigToFormStep.caricaFinanzForm4(finanzForm,null));
//			        if (tablePianoCosti != null)
//			        	document.add(tablePianoCosti);
//			        else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//		
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Ribassi d'asta", sottoTitoloFont));
//			      
//			        
//			        
//			        PdfPTable tableRibassi = caricaTabellePdf.caricaTabellaPdfRibassi(wrapperFormBigToFormStep.caricaFinanzForm4(finanzForm,null));
//			        if (tableRibassi != null) {
//			        	  document.add(new Paragraph("   "));
//			        	  document.add(new Paragraph("   "));
//			        	document.add(tableRibassi);
//			        } else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }
//			   
//			        
//			        // Sezione Fisica
//			        
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Indicatori Core", sottoTitoloFont));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        
//			       
//			        PdfPTable tableCore = caricaTabellePdf.caricaTabellaPdfIndicatoriCore(fisicaForm1);
//			        if (tableCore != null)
//			        	document.add(tableCore);
//			        else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//		
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Indicatori Occupazionali", sottoTitoloFont));
//			      
//			        
//			        
//			        PdfPTable tableOccup = caricaTabellePdf.caricaTabellaPdfIndicatoriOccup(fisicaForm1);
//			        if (tableOccup != null) {
//			        	  document.add(new Paragraph("   "));
//			        	  document.add(new Paragraph("   "));
//			        	document.add(tableOccup);
//			        } else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//			    		   
//			        
//			        // Sezione Procedurale 
//			        
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Anagrafica Procedure di Aggiudicazione (scelta dell'offerente)", sottoTitoloFont));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        
//			       
//			        PdfPTable tableProceduraAgg = caricaTabellePdf.caricaTabellaPdfProceduraAggiudicazione(wrapperFormBigToFormStep.caricaProcedForm1(procedForm));
//			        if (tableProceduraAgg != null)
//			        	document.add(tableProceduraAgg);
//			        else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//		
//			  
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Iter Procedure di Aggiudicazione (scelta dell'offerente)", sottoTitoloFont));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        
//			     
//			        PdfPTable tableIterProceduraAgg = caricaTabellePdf.caricaTabellaPdfIterProceduraAggiudicazione(wrapperFormBigToFormStep.caricaProcedForm1Bis(procedForm));
//			        if (tableIterProceduraAgg != null)
//			        	document.add(tableIterProceduraAgg);
//			        else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//			        
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Iter procedurale del progetto", sottoTitoloFont));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        
//			      
//			        PdfPTable tableIterProg = caricaTabellePdf.caricaTabellaPdfIterProgetto(wrapperFormBigToFormStep.caricaProcedForm2(procedForm));
//			        if (tableIterProg != null)
//			        	document.add(tableIterProg);
//			        else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//			        
//			        
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Revoche/Rinunce", sottoTitoloFont));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        
//			   
//			        PdfPTable tableRevoche= caricaTabellePdf.caricaTabellaPdfRevoche(wrapperFormBigToFormStep.caricaProcedForm3(procedForm,null));
//			        if (tableRevoche != null)
//			        	document.add(tableRevoche);
//			        else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//			        
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Sospensioni", sottoTitoloFont));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        PdfPTable tableSospensioni= caricaTabellePdf.caricaTabellaPdfSospensioni(wrapperFormBigToFormStep.caricaProcedForm3(procedForm,null));
//			        if (tableSospensioni != null)
//			        	document.add(tableSospensioni);
//			        else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//		
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("Stato Avanzamento Lavori", sottoTitoloFont));
//			        document.add(new Paragraph("   "));
//			        document.add(new Paragraph("   "));
//			        
//			     
//			        PdfPTable tableSal = caricaTabellePdf.caricaTabellaPdfStatoAvanzamentoLavori(wrapperFormBigToFormStep.caricaProcedForm4(procedForm));
//			        if (tableSal != null)
//			        	document.add(tableSal);
//			        else {
//			        	Paragraph messaggioAssenza = new Paragraph("_________________________________________________________", sottoTitoloFont);
//			        	messaggioAssenza.setAlignment(Element.ALIGN_CENTER);
//
//			             document.add(messaggioAssenza);
//			        }	
//		  
//		    }catch(Exception e){
//		        e.printStackTrace();
//		    }
//		    document.close();
//		    }
		}
	
}
