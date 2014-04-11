package com.ddway.anagraficaBS.utility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieInfr;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieMac;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DDipartimenti;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi;
import com.ddway.anagraficaBS.model.db.anagraficaBS.VInfap;
import com.ddway.anagraficaBS.service.IDataSourceService;


@Service
public class CaricaSelect {
	
	private static final Logger log = LoggerFactory.getLogger(CaricaSelect.class);
	
	@Autowired
	IDataSourceService iDataSourceService;
	
	protected  Object getlistvalues(String query) throws Exception{
		log.debug("Start CaricaSelect.getlistvalues method");	
		
		List<Object> selectLists = null;
		try{
			selectLists = (List<Object>) iDataSourceService.genericquery(query);
			Iterator<Object> itr = selectLists.iterator();		
		    if(!itr.hasNext()) {
		    	throw new Exception("Valori della select non trovati sulla tabella");
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
			List<DDipartimenti> dipartimentiList = (List<DDipartimenti>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DDipartimenti tab order by tab.textSiglaDipartimento");
			selectLists.put("dipartimentiList", dipartimentiList);	
			List<DModelApplicativi> modelApplicativiList = (List<DModelApplicativi>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DModelApplicativi tab order by tab.descModelApplicativo");	
			selectLists.put("modelApplicativiList", modelApplicativiList);				
		}catch(Exception e){
			log.error(e.getMessage()+" on CaricaSelect.getSelectsInserimentoBusinessService");
			throw e;
		}
		return selectLists;	
	}
	
	
	public  HashMap<String, List> getSelectsInserimentoAssociazioneBSFunzUtente(String sezione) throws Exception{
		log.debug("Start CaricaSelect.getSelectsInserimentoAssociazioneBSFunzUtente method");
		
		HashMap<String, List> selectLists= new HashMap<String, List>();
		try{
			List<DBusinessServices> businessServiceList = (List<DBusinessServices>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices tab order by tab.descBusinessService");
			selectLists.put("businessServiceList", businessServiceList);	
			List<VInfap> codiAreaList = (List<VInfap>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.VInfap tab order by tab.id.descArea");	
			selectLists.put("codiAreaList", codiAreaList);
			List<VInfap> codiApplicazioneList = (List<VInfap>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.VInfap tab order by tab.id.descApplicazione");	
			selectLists.put("codiApplicazioneList", codiApplicazioneList);
			List<VInfap> codiFunzioneList = (List<VInfap>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.VInfap tab order by tab.id.descFunzione");	
			selectLists.put("codiFunzioneList", codiFunzioneList);
		}catch(Exception e){
			log.error(e.getMessage()+" on CaricaSelect.getSelectsInserimentoAssociazioneBSFunzUtente");
			throw e;
		}
		return selectLists;	
	}
	
	
	public  HashMap<String, List> getSelectsInserimentoAssociazioneBSProcesso(String sezione) throws Exception{
		log.debug("Start CaricaSelect.getSelectsInserimentoAssociazioneBSProcesso method");
		
		HashMap<String, List> selectLists= new HashMap<String, List>();
		try{
			List<DBusinessServices> businessServiceList = (List<DBusinessServices>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DBusinessServices tab order by tab.descBusinessService");
			selectLists.put("businessServiceList", businessServiceList);		
			List<DProcessi> codiProcessoList = (List<DProcessi>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DProcessi tab order by tab.descProcesso");
			selectLists.put("codiProcessoList", codiProcessoList);		
			List<DCategorieMac> codiCategoriaMacList = (List<DCategorieMac>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieMac tab order by tab.descCategoriaMac");
			selectLists.put("codiCategoriaMacList", codiCategoriaMacList);		
			List<DCategorieInfr> codiCategoriaInfrList = (List<DCategorieInfr>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.DCategorieInfr tab order by tab.descCategoriaInfr");
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
			List<VInfap> codiAreaList = (List<VInfap>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.VInfap tab order by tab.id.descArea");	
			selectLists.put("codiAreaList", codiAreaList);
//			List<VInfap> codiApplicazioneList = (List<VInfap>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.VInfap tab order by tab.id.descApplicazione");	
//			selectLists.put("codiApplicazioneList", codiApplicazioneList);			
		}catch(Exception e){
			log.error(e.getMessage()+" on CaricaSelect.getSelectsInserimentoAssociazioneBSFunzUtente");
			throw e;
		}
		return selectLists;		
	}
	
	public  List<VInfap> getApplicazioniList() throws Exception{
		log.debug("Start CaricaSelect.getApplicazioniList method");
		
		List<VInfap> codiApplicazioneList = (List<VInfap>) getlistvalues("from com.ddway.anagraficaBS.model.db.anagraficaBS.VInfap tab order by tab.id.descApplicazione");
		return codiApplicazioneList;
	}	
	
}