package com.ddway.anagraficaBS.utility;

import java.awt.Color;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddway.anagraficaBS.model.bean.AssociazioneBSProcessoBean;
import com.ddway.anagraficaBS.model.bean.BusinessServiceBean;
import com.ddway.anagraficaBS.model.bean.ModelApplicativoPiuBSAssoicatiBean;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziFunzioni;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziModel;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DServiziProcessi;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

@Service
public class CaricaTabellePdf {

	 private static Font titoloFont = new Font(Font.TIMES_ROMAN, 18,Font.BOLD, Color.decode("#000088"));
	 private static Font sottoTitoloFont = new Font(Font.TIMES_ROMAN, 15,Font.BOLD, Color.decode("#0000CC"));
	 private static Font baseFont = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL, Color.GRAY);
	 private static Font boldFont = new Font(Font.TIMES_ROMAN, 13, Font.BOLD ,Color.BLACK);
	
	private static final Logger log = LoggerFactory.getLogger(CaricaTabellePdf.class);

	public CaricaTabellePdf(){}	
	
	@Autowired
	GestioneDataBase gestioneDataBase;
	
	public PdfPTable caricaTabellaReport1 (List<BusinessServiceBean> businessServicesList) throws Exception{
		log.info("Inizio metodo CaricaTabellePdf.caricaTabellaReport1!");
		
			BusinessServiceBean businessService;
			PdfPTable table = null;
			
			try{
			 	if (businessServicesList !=null && !businessServicesList.isEmpty()) {
					 table = (new PdfPTable(2));
					 table.setWidthPercentage(100f);
					 table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
					 
				     PdfPCell c1 = new PdfPCell(new Phrase("Nome Business Service",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			        
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				        
				     c1 = new PdfPCell(new Phrase("Model Applicativo Associato",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1); c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
					 for(int i=0;i<businessServicesList.size();i++){
						 businessService = businessServicesList.get(i);
						 table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
						 table.addCell(new Phrase(businessService.getTextNomeBusinessService(),baseFont));
						 table.addCell(new Phrase(businessService.getDescModelApplicativo(),baseFont));
						 }
			 	}
			}catch(Exception e){
				log.error(e.getMessage()+" on method CaricaTabellePdf.caricaTabellaReport1!");
				throw e;
			}			
		 	return table;
		 	}
	
	public PdfPTable caricaTabellaReport2 (List<BusinessServiceBean> businessServicesList) throws Exception{
		log.info("Inizio metodo CaricaTabellePdf.caricaTabellaReport2!");
		
			BusinessServiceBean businessService;
			PdfPTable table = null;
			
			try{
			 	if (businessServicesList !=null && !businessServicesList.isEmpty()) {
					 table = (new PdfPTable(6));
					 table.setWidthPercentage(100f);
					 table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
					 
				     PdfPCell c1 = new PdfPCell(new Phrase("Codice",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			        
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				        
				     c1 = new PdfPCell(new Phrase("Nome",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("Responsabile",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				    
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("Dipartimento",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				    
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("Model Applicativo",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("Convenzione",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     
					 for(int i=0;i<businessServicesList.size();i++){
						 businessService = businessServicesList.get(i);						 
						 table.addCell(new Phrase(businessService.getCodiBusinessService(),baseFont));
						 table.addCell(new Phrase(businessService.getTextNomeBusinessService(),baseFont));
						 table.addCell(new Phrase(businessService.getPersRespBusinessService(),baseFont));
						 table.addCell(new Phrase(businessService.getTextSiglaDipartimento(),baseFont));
						 table.addCell(new Phrase(businessService.getDescModelApplicativo(),baseFont));
						 table.addCell(new Phrase(businessService.getFlagConvenzione() ? "Si" : "No",baseFont));						 
						 }
			 	}
			}catch(Exception e){
				log.error(e.getMessage()+" on method CaricaTabellePdf.caricaTabellaReport2!");
				throw e;
			}			
		 	return table;
		 	}
	
	public PdfPTable caricaTabellaBusinessService (BusinessServiceBean businessServiceBean) throws Exception{
		log.info("Inizio metodo CaricaTabellePdf.caricaTabellaBusinessService!");
		
			BusinessServiceBean businessService;
			PdfPTable table = null;
			
			try{
			 	if (businessServiceBean != null) {
					 table = (new PdfPTable(6));
					 table.setWidthPercentage(100f);
					 table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
					 
				     PdfPCell c1 = new PdfPCell(new Phrase("Codice",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			        
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				        
				     c1 = new PdfPCell(new Phrase("Nome",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("Responsabile",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				    
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("Dipartimento",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				    
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("Model Applicativo",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("Convenzione",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);				     
				     table.addCell(c1);			     
											 
					table.addCell(new Phrase(businessServiceBean.getCodiBusinessService(),baseFont));
					table.addCell(new Phrase(businessServiceBean.getTextNomeBusinessService(),baseFont));
					table.addCell(new Phrase(businessServiceBean.getPersRespBusinessService(),baseFont));
					table.addCell(new Phrase(businessServiceBean.getTextSiglaDipartimento(),baseFont));
					table.addCell(new Phrase(businessServiceBean.getDescModelApplicativo(),baseFont));
					table.addCell(new Phrase(businessServiceBean.getFlagConvenzione() ? "Si" : "No",baseFont));								 
			 	}
			}catch(Exception e){
				log.error(e.getMessage()+" on method CaricaTabellePdf.caricaTabellaBusinessService!");
				throw e;
			}			
		 	return table;
		 	}
	
	public PdfPTable caricaTabellaReport3 (List<DProcessi> processiList) throws Exception{
		log.info("Inizio metodo CaricaTabellePdf.caricaTabellaReport3!");
		
			DProcessi processo;
			PdfPTable table = null;
			
			try{
			 	if (processiList !=null && !processiList.isEmpty()) {
					 table = (new PdfPTable(3));
					 table.setWidthPercentage(100f);
					 table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
					 
				     PdfPCell c1 = new PdfPCell(new Phrase("Codice",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);		
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				        
				     c1 = new PdfPCell(new Phrase("Sigla",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("Descrizione",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);	
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);	
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1); 
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);		
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
					 for(int i=0;i<processiList.size();i++){
						 processo = processiList.get(i);			
						 table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
						 table.addCell(new Phrase(processo.getCodiProcesso().toString(),baseFont));
						 table.addCell(new Phrase(processo.getTextSiglaProcesso(),baseFont));
						 table.addCell(new Phrase(processo.getDescProcesso(),baseFont));
						 }
			 	}
			}catch(Exception e){
				log.error(e.getMessage()+" on method CaricaTabellePdf.caricaTabellaReport3!");
				throw e;
			}			
		 	return table;
		 	}
	
	public PdfPTable caricaTabellaProcessi (List<AssociazioneBSProcessoBean> processiList) throws Exception{
		log.info("Inizio metodo CaricaTabellePdf.caricaTabellaProcessi!");
		
		AssociazioneBSProcessoBean associazioneBSProcessoBean;
			PdfPTable table = null;
			
			try{
			 	if (processiList !=null && !processiList.isEmpty()) {
					 table = (new PdfPTable(4));
					 table.setWidthPercentage(100f);
					 table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
					 
				     PdfPCell c1 = new PdfPCell(new Phrase("Processo",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);		
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("Descrizione",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				        
				     c1 = new PdfPCell(new Phrase("Categoria Mac",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("Categoria Infr",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);	
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);	
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1); 
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);		
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
					 for(int i=0;i<processiList.size();i++){
						 associazioneBSProcessoBean = processiList.get(i);			
						 table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);						 
						 table.addCell(new Phrase(associazioneBSProcessoBean.getTextSiglaProcesso(),baseFont));
						 table.addCell(new Phrase(associazioneBSProcessoBean.getDescProcesso(),baseFont));
						 table.addCell(new Phrase(associazioneBSProcessoBean.getDescCategoriaMac()+"",baseFont));
						 table.addCell(new Phrase(associazioneBSProcessoBean.getDescCategoriaInfr(),baseFont));
						 }
			 	}
			}catch(Exception e){
				log.error(e.getMessage()+" on method CaricaTabellePdf.caricaTabellaProcessi!");
				throw e;
			}			
		 	return table;
		 	}
	
	public PdfPTable caricaTabellaFunzioniUtente (List<DServiziFunzioni> funzioniList) throws Exception{
		log.info("Inizio metodo CaricaTabellePdf.caricaTabellaFunzioniUtente!");
		
		DServiziFunzioni dServiziFunzioni;
			PdfPTable table = null;
			
			try{
			 	if (funzioniList !=null && !funzioniList.isEmpty()) {
					 table = (new PdfPTable(3));
					 table.setWidthPercentage(100f);
					 table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
					 
				     PdfPCell c1 = new PdfPCell(new Phrase("Area",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);		
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				        
				     c1 = new PdfPCell(new Phrase("Applicazione",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("Funzione",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);	
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);	
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1); 
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);		
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
					 for(int i=0;i<funzioniList.size();i++){
						 dServiziFunzioni = funzioniList.get(i);			
						 table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
						 table.addCell(new Phrase(dServiziFunzioni.getId().getCodiArea()+" - "+ dServiziFunzioni.getDescArea().toString(),baseFont));
						 table.addCell(new Phrase(dServiziFunzioni.getId().getCodiApplicazione()+" - "+dServiziFunzioni.getDescApplicazione(),baseFont));
						 table.addCell(new Phrase(dServiziFunzioni.getDescFunzione(),baseFont));
						 }
			 	}
			}catch(Exception e){
				log.error(e.getMessage()+" on method CaricaTabellePdf.caricaTabellaFunzioniUtente!");
				throw e;
			}			
		 	return table;
		 	}
	
	public PdfPTable caricaTabellaReport4 (List<DModelApplicativi> modelApplicativiList) throws Exception{
		log.info("Inizio metodo CaricaTabellePdf.caricaTabellaReport4!");
		
			DModelApplicativi modelApplicativo;
			PdfPTable table = null;
			float[] columnWidths = new float[] {15f, 100f};            
			
			try{
			 	if (modelApplicativiList !=null && !modelApplicativiList.isEmpty()) {
					 table = (new PdfPTable(2));
					 table.setWidthPercentage(100f);
					 table.setWidths(columnWidths);
					 table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
					 
					 PdfPCell c1 = new PdfPCell(new Phrase("Codice",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);				     
				     table.addCell(c1);	
				     
				     c1 = new PdfPCell(new Phrase("Descrizione",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);			
				     table.addCell(c1);					    
				     
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);	
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);				     
				     
					 for(int i=0;i<modelApplicativiList.size();i++){
						 modelApplicativo = modelApplicativiList.get(i);			
						 table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
						 table.addCell(new Phrase(modelApplicativo.getCodiModelApplicativo().toString(),baseFont));							 
						 table.addCell(new Phrase(modelApplicativo.getDescModelApplicativo().toString(),baseFont));							
						 }
			 	}
			}catch(Exception e){
				log.error(e.getMessage()+" on method CaricaTabellePdf.caricaTabellaReport4!");
				throw e;
			}			
		 	return table;
		 	}
	
	@Transactional
	public PdfPTable caricaTabellaReport5 (List<ModelApplicativoPiuBSAssoicatiBean> modelApplicativiList) throws Exception{
		log.info("Inizio metodo CaricaTabellePdf.caricaTabellaReport5!");
		
		List<DServiziModel> dServiziModelList; 
		ModelApplicativoPiuBSAssoicatiBean modelApplicativo;
		PdfPTable table = null;
		String businessServiceListString = "";
		BusinessServiceBean businessServiceBean;
			
			try{
			 	if (modelApplicativiList !=null && !modelApplicativiList.isEmpty()) {
					 table = (new PdfPTable(2));
					 table.setWidthPercentage(100f);
					 table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
					 
				     PdfPCell c1 = new PdfPCell(new Phrase("Model Applicativo",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			        
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				        
				     c1 = new PdfPCell(new Phrase("Business Services",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
				     c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1); c1 = new PdfPCell(new Phrase("",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				     
					 for(int i=0;i<modelApplicativiList.size();i++){
						 modelApplicativo = modelApplicativiList.get(i);
						 if(modelApplicativo.getBusinessServiceBeanList() != null && !modelApplicativo.getBusinessServiceBeanList().isEmpty()){
						 businessServiceListString = "";
						 table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
						 table.addCell(new Phrase(modelApplicativo.getModelApplicativo().getDescModelApplicativo(),baseFont));
						 for (int j = 0; j < modelApplicativo.getBusinessServiceBeanList().size(); j++) {
							 businessServiceBean = modelApplicativo.getBusinessServiceBeanList().get(j);
							 businessServiceListString = businessServiceListString+businessServiceBean.getTextNomeBusinessService()+"\n";
						}
						 businessServiceListString = businessServiceListString+"\n\n";
						 table.addCell(new Phrase(businessServiceListString,baseFont));							 
						 }
			 	}
			 	}
			}catch(Exception e){
				log.error(e.getMessage()+" on method CaricaTabellePdf.caricaTabellaReport5!");
				throw e;
			}			
		 	return table;
		 	}
	
	public PdfPTable caricaTabellaReport6 (List<BusinessServiceBean> businessServicesList) throws Exception{
		log.info("Inizio metodo CaricaTabellePdf.caricaTabellaReport6!");
		
			BusinessServiceBean businessService;
			PdfPTable table = null;
			
			try{
			 	if (businessServicesList !=null && !businessServicesList.isEmpty()) {
					 table = (new PdfPTable(2));
					 table.setWidthPercentage(100f);
					 table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
					 
				     PdfPCell c1 = new PdfPCell(new Phrase("Nome Business Service",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);			        
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);
				        
				     c1 = new PdfPCell(new Phrase("Model Applicativo Associato",boldFont));
				     c1.setBorder(Rectangle.NO_BORDER);
				     c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				     table.addCell(c1);	
				     
					 for(int i=0;i<businessServicesList.size();i++){
						 businessService = businessServicesList.get(i);
						 table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
						 table.addCell(new Phrase(businessService.getTextNomeBusinessService(),baseFont));
						 table.addCell(new Phrase(businessService.getDescModelApplicativo(),baseFont));
						 }
			 	}
			}catch(Exception e){
				log.error(e.getMessage()+" on method CaricaTabellePdf.caricaTabellaReport6!");
				throw e;
			}			
		 	return table;
		 	}
}