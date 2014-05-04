<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/custom-functions.tld" prefix="fnc" %>


<div class="Content bgA3">
		
 	<div class="div-table">
		<div class="div-table-row">
		<div class="div-table-col">
						<p class="visualizzaFormLegend">Business Service</p>						
		</div>
	</div>	
	<div class="div-table">
	<div class="div-table-row">
	<div style="text-align: right;"><a href="cancellaBusinessService?codiBusinessService=${businessService.codiBusinessService}" onclick="return conferma('Sei sicuro di voler cancellare il Business Service?')"><button>Elimina il Business Service</button></a>	</div>
	</div>	
	</div>
<!-- <div class="div-table-centrata">	
	<c:if test="${presenzaMessaggio == 'si'}" >	
	<div class="div-table-row">
				<div class="div-table-col">
					<p class="visualizzaForm" style="color:red;">${message}</p>
				</div>
			</div>	
	</c:if>
	
	</div>
	 -->	
	<div class="div-table-row">
		<div class="div-table-col-left">												
		</div>
	</div>
	
	<div class="div-table">

	
	<div class="div-table-row">
	<div class="div-table-col">
					</div>
	</div><div class="div-table-row">
	<div class="div-table-col">
					</div>
	</div><div class="div-table-row">
	<div class="div-table-col">
					</div>
	</div>
	
	 <div class="div-table-row">
 
		<fieldset>
			<legend>Dettaglio Business Service</legend>				
						<div class="div-table">
								<div class="div-table-row">			
									<div class="div-table-col"><p class="visualizzaDesc">Codice</p></div>			 
									<div class="div-table-col"><p class="visualizzaDesc">Nome</p></div>						
									<div class="div-table-col"><p class="visualizzaDesc">Descrizione</p></div>
									<div class="div-table-col"><p class="visualizzaDesc">Responsabile</p></div>
									<div class="div-table-col"><p class="visualizzaDesc">Url</p></div>						
									<div class="div-table-col"><p class="visualizzaDesc">Dipartimento</p></div>
									<div class="div-table-col"><p class="visualizzaDesc">Model applicativo</p></div>
									<div class="div-table-col"><p class="visualizzaDesc">Presenza convenzione</p></div>
														
								</div>
							<div class="div-table-row">
								<div class="div-table-col">
								</div>
							</div>		
							
						<div class="div-table-row">							 
									<div class="div-table-col"><p>${businessService.codiBusinessService}</p></div>
									<div class="div-table-col"><p>${businessService.textNomeBusinessService}</p></div>						
									<div class="div-table-col"><p>${businessService.descBusinessService}</p></div>
									<div class="div-table-col"><p>${businessService.persRespBusinessService}</p></div>
									<div class="div-table-col"><p>${businessService.textUrlBusinessService}</p></div>						
									<div class="div-table-col"><p>${businessService.textSiglaDipartimento}</p></div>
									<div class="div-table-col"><p>${businessService.descModelApplicativo}</p></div>
									<div class="div-table-col"><p>${businessService.flagConvenzione ? 'SI' : 'NO'}</p></div> 
						</div>
						</div> 
		 </fieldset>					
					  </div>
					  <br/>
<c:if test="${businessService.flagConvenzione}">			  
	<div class="div-table-row"> 		
		<fieldset>
			<legend>Funzioni Utente Associate al Business Service</legend>				
						<div class="div-table">
								<div class="div-table-row">			
									<div class="div-table-col">						
										<a href="formRicercaFunzioniUtente?codiBusinessService=${businessService.codiBusinessService}" ><button>Associa nuove Funzioni Utente</button></a>
									</div>
								</div>
						</div>
						<div class="div-table">
								<br/>
								<div class="div-table-row">						
									<div class="div-table-col-center"><p class="visualizzaDesc">Area</p></div>	
									<div class="div-table-col-center"><p class="visualizzaDesc">Applicazione</p></div>		 
									<div class="div-table-col-center"><p class="visualizzaDesc">Funzione Utente</p></div>									
									<div class="div-table-col-center"><p class="visualizzaDesc">Cancella</p></div>
														
								</div>
							<div class="div-table-row">
								<div class="div-table-col">
								</div>
							</div>		
							
							<c:forEach items="${dServiziFunzioniList}" var="item" >
							<div class="div-table-row">				
										<div class="div-table-col-center">${item.descArea}</div>	
										<div class="div-table-col-center">${item.descApplicazione}</div>	
										<div class="div-table-col-center">${item.descFunzione}</div>								
								<div class="div-table-col-center"><a href="cancellaAssociazioneFunzioneUtente?codiFunzione=${item.id.codiFunzione}&codiArea=${item.id.codiArea}&codiApplicazione=${item.id.codiApplicazione}&codiBusinessService=${businessService.codiBusinessService}&dataInizioAssociazione=${item.id.dataInizioAssociazione}" onclick="return conferma('Sei sicuro di voler cancellare questa funzione utente?')"><img src="resources/img/iconeCancella2.jpg"  width="30" height="20" title="Cancella Funzione Utente"></a></div>
							</div>
							</c:forEach>
							<br/>	
							</div>
							<div class="div-table">
							<div class="div-table-centrata">								
							</div>					
						</div> 
		 </fieldset>	
		 </div>		
		 <br/>
	</c:if>
		 <div class="div-table-row">			 
			 <fieldset>
				<legend>Processi Associati al Business Service</legend>		
				<div class="div-table">
								<div class="div-table-row">			
									<div class="div-table-col">						
										<a href="formAssociazioneBSProcesso?codiBusinessService=${businessService.codiBusinessService}" ><button>Associa un nuovo Processo</button></a>
									</div>
								</div>
						</div>		
						<br/>
							<div class="div-table">
									<div class="div-table-row">							 
										<div class="div-table-col-center"><p class="visualizzaDesc">&nbsp;</p></div>	
										<div class="div-table-col-center"><p class="visualizzaDesc">Codice</p></div>
										<div class="div-table-col-center"><p class="visualizzaDesc">Processo</p></div>					
										<div class="div-table-col-center"><p class="visualizzaDesc">Modifica</p></div>
										<div class="div-table-col-center"><p class="visualizzaDesc">Cancella</p></div>
															
									</div>
								<div class="div-table-row">
									<div class="div-table-col">
									</div>
								</div>		
								
								<c:forEach items="${associazioneBSProcessoBeanList}" var="item" >
								<div class="div-table-row">				
									<div class="div-table-col-center"><c:if test="${item.dataFineValidita != null}"><label><img src="resources/img/bulb-icon.png" title="Attenzione! Il processo '${item.textSiglaProcesso}' risulta non più valido! " alt="Alert Processo"></label></c:if></div>
									<div class="div-table-col-center">${item.codiProcesso}</div>
									<div class="div-table-col-center">${item.textSiglaProcesso}</div>								
									<div class="div-table-col-center"><a href="modificaAssociazioneBSProcessoForm?codiProcesso=${item.codiProcesso}&codiBusinessService=${businessService.codiBusinessService}&codiCategoriaMac=${item.codiCategoriaMac}&codiCategoriaInfr=${item.codiCategoriaInfr}&dataInizioValidita=${item.dataInizioValidita}"><img src="resources/img/iconeModifica2.jpg"  width="30" height="20" title="Modifica Business Service"></a></div>
									<div class="div-table-col-center"><a href="cancellaAssociazioneBSProcesso?codiProcesso=${item.codiProcesso}&codiBusinessService=${businessService.codiBusinessService}&codiCategoriaMac=${item.codiCategoriaMac}&codiCategoriaInfr=${item.codiCategoriaInfr}&dataInizioValidita=${item.dataInizioValidita}" onclick="return conferma('Sei sicuro di voler cancellare questo processo?')"><img src="resources/img/iconeCancella2.jpg"  width="30" height="20" title="Cancella Business Service"></a></div>
								</div>
								</c:forEach>
							</div> 
			 </fieldset>					
						  
					 
					  </div>
				 	 
	</div>
	
	

	<div class="div-table-row">
	<div class="div-table-col">
	</div></div>
	<br/>
	<div class="div-table-row">
	<div class="div-table-col-center" >							
					<a href="visualizzaElencoBusinessServices"><input TYPE="button" name="Annulla" VALUE="Indietro"></a>
					<a href="reportController?report=6&codiBusinessService=${businessService.codiBusinessService}"><input TYPE="button" name="Stampa" VALUE="Stampa"></a>				
	</div>
	
	</div>
	
	
	</div>
	 
	 
 <div class="div-table"> 
	

	<div class="div-table-row">
	<div class="div-table-col">
					 
	</div>
	</div>
	<div class="div-table-row">
	<div class="div-table-col">
					 
	</div>
	</div>
	<div class="div-table-row">
	<div class="div-table-col">
					 
	</div>
	</div>
	
	<div class="div-table-row">
	<div class="div-table-col-center" >										
	</div>	
	</div>
	
	 </div>     
</div>
		
