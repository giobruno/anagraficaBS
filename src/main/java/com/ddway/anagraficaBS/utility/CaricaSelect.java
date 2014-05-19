package com.ddway.anagraficaBS.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ddway.anagraficaBS.model.bean.CategorieMac;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieInfr;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieMac;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DDipartimenti;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi;
import com.ddway.anagraficaBS.model.db.common.TblArea;
import com.ddway.anagraficaBS.model.db.infap.TblApplicazione;
import com.ddway.anagraficaBS.service.IDataSourceService;


@Service
public class CaricaSelect {
	
	private static final Logger log = LoggerFactory.getLogger(CaricaSelect.class);
	
	@Autowired
	IDataSourceService iDataSourceService;
	
	protected  Object getlistvalues(String query, String objectToFind) throws Exception{
		log.debug("Start CaricaSelect.getlistvalues method");	
		
		List<Object> selectLists = null;
		try{
			selectLists = (List<Object>) iDataSourceService.genericquery(query);
			Iterator<Object> itr = selectLists.iterator();		
		    if(!itr.hasNext()) {
		    	throw new Exception("getlistvalues/Non risultano "+objectToFind+" presenti nel sistema!");
		    	}
		    }catch(Exception e){
		    	log.error(e.getMessage());
		    	throw e;
	}
    return selectLists;
	}	
	
	protected  Object getlistvaluesInfap(String query, String objectToFind) throws Exception{
		log.debug("Start CaricaSelect.getlistvaluesInfap method");	
		
		List<Object> selectLists = null;
		try{
			selectLists = (List<Object>) iDataSourceService.genericqueryInfap(query);
			Iterator<Object> itr = selectLists.iterator();		
		    if(!itr.hasNext()) {
		    	throw new Exception("getlistvalues/Non risultano "+objectToFind+" presenti nel sistema!");
		    	}
		    }catch(Exception e){
		    	log.error(e.getMessage());
		    	throw e;
	}
    return selectLists;
	}
	
	protected  Object getlistvaluesCommon(String query, String objectToFind) throws Exception{
		log.debug("Start CaricaSelect.getlistvaluesCommon method");	
		
		List<Object> selectLists = null;
		try{
			selectLists = (List<Object>) iDataSourceService.genericqueryCommon(query);
			Iterator<Object> itr = selectLists.iterator();		
		    if(!itr.hasNext()) {
		    	throw new Exception("getlistvalues/Non risultano "+objectToFind+" presenti nel sistema!");
		    	}
		    }catch(Exception e){
		    	log.error(e.getMessage());
		    	throw e;
	}
    return selectLists;
	}
	
	@Cacheable(value="selectLists",key="#sezione")
	public  HashMap<String, List> getSelectsInserimentoBusinessService(String sezione) throws Exception{
		log.debug("Start CaricaSelect.getSelectsInserimentoBusinessService method");
		
		HashMap<String, List> selectLists= new HashMap<String, List>();
		try{		
			List<DDipartimenti> dipartimentiList = (List<DDipartimenti>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DDipartimenti tab order by tab.textSiglaDipartimento","Dipartimenti");
			selectLists.put("dipartimentiList", dipartimentiList);	
			List<DModelApplicativi> modelApplicativiList = (List<DModelApplicativi>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi tab order by tab.descModelApplicativo","Model Applicativi");	
			selectLists.put("modelApplicativiList", modelApplicativiList);				
		}catch(Exception e){
			log.error(e.getMessage()+" on CaricaSelect.getSelectsInserimentoBusinessService");
			throw e;
		}
		return selectLists;	
	}
	
	
//	public  HashMap<String, List> getSelectsInserimentoAssociazioneBSFunzUtente(String sezione) throws Exception{
//		log.debug("Start CaricaSelect.getSelectsInserimentoAssociazioneBSFunzUtente method");
//		
//		HashMap<String, List> selectLists= new HashMap<String, List>();
//		try{
//			List<DBusinessServices> businessServiceList = (List<DBusinessServices>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices tab order by tab.descBusinessService");
//			selectLists.put("businessServiceList", businessServiceList);	
//			List<TblArea> codiAreaList = (List<TblArea>) getlistvalues("from com.ddway.anagraficaBS.model.db.common.TblArea tab order by tab.sdescrizione");	
//			selectLists.put("codiAreaList", codiAreaList);
//			List<TblApplicazione> codiApplicazioneList = (List<TblApplicazione>) getlistvalues("from com.ddway.anagraficaBS.model.db.infap.TblApplicazione tab order by tab.sdescrizioneBreve");	
//			selectLists.put("codiApplicazioneList", codiApplicazioneList);			
//		}catch(Exception e){
//			log.error(e.getMessage()+" on CaricaSelect.getSelectsInserimentoAssociazioneBSFunzUtente");
//			throw e;
//		}
//		return selectLists;	
//	}
	
	
	public  HashMap<String, List> getSelectsInserimentoAssociazioneBSProcesso(String sezione) throws Exception{
		log.debug("Start CaricaSelect.getSelectsInserimentoAssociazioneBSProcesso method");
		
		HashMap<String, List> selectLists= new HashMap<String, List>();
		List<CategorieMac> categorieMaclist = new ArrayList<CategorieMac>();
		CategorieMac categorieMac;
		DCategorieMac dCategorieMac;
		Iterator<DCategorieMac> itr;
		
		try{
//			List<DBusinessServices> businessServiceList = (List<DBusinessServices>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices tab where tab.dataFineValidita is null order by tab.descBusinessService","Business Services");
//			selectLists.put("businessServiceList", businessServiceList);		
			List<DProcessi> codiProcessoList = (List<DProcessi>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi tab where tab.dataFineValidita is null order by tab.descProcesso", "Processi" );
			selectLists.put("codiProcessoList", codiProcessoList);		
			List<DCategorieMac> codiCategoriaMacList = (List<DCategorieMac>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieMac tab order by tab.descCategoriaMac","Categoria Mac");
			itr = codiCategoriaMacList.iterator();
			while(itr.hasNext()){
				dCategorieMac = itr.next();
				categorieMac = new CategorieMac();
				categorieMac.setCodiCategoriaMac(dCategorieMac.getCodiCategoriaMac());
				categorieMac.setDescCategoriaMac(dCategorieMac.getDescCategoriaMac());
				categorieMac.setFlagMacLavSol(dCategorieMac.getFlagMacLavSol());
				categorieMac.setCodiDescCategoriaMac(dCategorieMac.getCodiCategoriaMac()+" - "+dCategorieMac.getDescCategoriaMac());
				categorieMaclist.add(categorieMac);
			}
			selectLists.put("codiCategoriaMacList", categorieMaclist);		
			List<DCategorieInfr> codiCategoriaInfrList = (List<DCategorieInfr>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieInfr tab order by tab.descCategoriaInfr","Categoria Infr");
			selectLists.put("codiCategoriaInfrList", codiCategoriaInfrList);
		}catch(Exception e){
			log.error(e.getMessage()+" on CaricaSelect.getSelectsInserimentoAssociazioneBSProcesso");
			throw e;
		}
		return selectLists;	
	}
	
	@Cacheable(value="selectLists",key="#sezione")
	public  HashMap<String, List> getSelectsRicercaFunzioniUtenteForm(String sezione) throws Exception{
		log.debug("Start CaricaSelect.getSelectsRicercaFunzioniUtenteForm method");
		
		HashMap<String, List> selectLists= new HashMap<String, List>();
		try{				
			List<TblArea> codiAreaList = (List<TblArea>) getlistvaluesCommon("from com.ddway.anagraficaBS.model.db.common.TblArea tab order by tab.sdescrizione", "Aree");	
			selectLists.put("codiAreaList", codiAreaList);			
		}catch(Exception e){
			log.error(e.getMessage()+" on CaricaSelect.getSelectsInserimentoAssociazioneBSFunzUtente");
			throw e;
		}
		return selectLists;		
	}
	
	public  List<TblApplicazione> getApplicazioniList(String codiArea) throws Exception{
		log.debug("Start CaricaSelect.getApplicazioniList method");
		
		List<TblApplicazione> codiApplicazioneList = (List<TblApplicazione>) getlistvaluesInfap("from com.ddway.anagraficaBS.model.db.infap.TblApplicazione tab where tab.scodeArea = '"+codiArea+"' order by tab.sdescrizioneBreve", "Applicazioni");
		return codiApplicazioneList;
	}	
	
}