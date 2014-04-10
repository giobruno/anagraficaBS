<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="Content bgA3">
		
 	<div class="div-table">
		<div class="div-table-row">
		<div class="div-table-col">
						<p class="visualizzaFormLegend">Business Services</p>						
		</div>
	</div>	
	<div class="div-table-centrata">	
	<c:if test="${presenzaMessaggio == 'si'}" >	
	<div class="div-table-row">
				<div class="div-table-col">
					<p class="visualizzaForm" style="color:red;">${message}</p>
				</div>
			</div>	
	</c:if>
	
	</div>
	<div class="div-table-row">
		<div class="div-table-col-left">												
		</div>
	</div>
	
	<div class="div-table-centrata">

	
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
									<div class="div-table-col"><p>${businessService.textNomeBusinessService}</p></div>						
									<div class="div-table-col"><p>${businessService.descBusinessService}</p></div>
									<div class="div-table-col"><p>${businessService.persRespBusinessService}</p></div>
									<div class="div-table-col"><p>${businessService.textUrlBusinessService}</p></div>						
									<div class="div-table-col"><p>Dipartimento</p></div>
									<div class="div-table-col"><p>Model applicativo</p></div>
									<div class="div-table-col"><p>${businessService.flagConvenzione ? 'SI' : 'NO'}</p></div>
						</div>
						</div> 
		 </fieldset>					
					  </div>
					  </div>
	<div class="div-table-centrata">				  
	<div class="div-table-row">
 		<div class="div-table-col">
		<fieldset>
			<legend>Funzioni Utente Associate al Business Service</legend>				
						<div class="div-table">
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
										<div class="div-table-col-center"><a href="dettaglioBusinessService">${item.descArea}</a></div>	
										<div class="div-table-col-center"><a href="dettaglioBusinessService">${item.descApplicazione}</a></div>	
										<div class="div-table-col-center"><a href="dettaglioBusinessService">${item.descFunzione}</a></div>								
								<div class="div-table-col-center"><a href="cancellaBusinessService?codiFunzione=${item.id.codiFunzione}&codiArea=${item.id.codiArea}&codiApplicazione=${item.id.codiApplicazione}"><img src="resources/img/iconeCancella2.jpg"  width="30" height="20" title="Cancella Business Service"></a></div>
							</div>
							</c:forEach>
						</div> 
		 </fieldset>	
		 </div>
		 <div class="div-table-col">
		 <fieldset>
			<legend>Processi Associati al Business Service</legend>				
						<div class="div-table">
								<div class="div-table-row">							 
									<div class="div-table-col-center"><p class="visualizzaDesc">Processo</p></div>						
									<div class="div-table-col-center"><p class="visualizzaDesc">Modifica</p></div>
									<div class="div-table-col-center"><p class="visualizzaDesc">Cancella</p></div>
														
								</div>
							<div class="div-table-row">
								<div class="div-table-col">
								</div>
							</div>		
							
							<c:forEach items="${dserviziProcessiList}" var="item" >
							<div class="div-table-row">				
								<div class="div-table-col-center"><a href="dettaglioBusinessService">${item.id.codiProcesso}</a></div>								
								<div class="div-table-col-center"><a href="modificaBusinessServiceForm?codiBusinessService="><img src="resources/img/iconeModifica2.jpg"  width="30" height="20" title="Modifica Business Service"></a></div>
								<div class="div-table-col-center"><a href="cancellaBusinessService?codiBusinessService="><img src="resources/img/iconeCancella2.jpg"  width="30" height="20" title="Cancella Business Service"></a></div>
							</div>
							</c:forEach>
						</div> 
		 </fieldset>					
					  </div>
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
		
