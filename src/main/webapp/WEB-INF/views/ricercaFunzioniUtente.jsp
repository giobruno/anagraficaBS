<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="Content bgA3">
	
 
	<form:form name='form' action="ricercaFunzioniUtente" method='GET' commandName="ricercaFunzioniUtenteForm">
	 <div class="div-table">
	
	<div class="div-table-row">
	<div class="div-table-col">
	
	
					<p class="visualizzaFormLegend">Inserimento Nuova Associazione Business Service - Funzione Utente</p>
	</div>
	</div>
	</div>
		<div class="div-table">
	<div class="div-table-row">
	<div class="div-table-col">
					</div>
	</div>
	
			<div class="div-table-row">
				<div class="div-table-col"></div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col"></div>
			</div>
	 <div class="div-table-row">
 		<p class="erroreForm"><form:errors path="*"/> </p>
 		<br/>
		<fieldset>
		
		<legend>Selezionare almeno l'Area di appartenenza per ricercare le Funzioni Utente</legend>		
		
		<div class="div-table">		
			
		<div class="div-table-row">
			<div class="div-table-col"><label for="codiArea">&nbsp;Filtra per Area*:</label></div>
			<div class="div-table-col">
								<form:select  path="codiArea" id="codiArea" name="codiArea" style="width:180px">
									<form:option value="" label="--" />
									<form:options items="${codiAreaList}" 
										itemValue="scodeArea"
										itemLabel="scodedescrizione" />	
										<form:hidden path="descArea" value="${sdescrizione}"/>										
								</form:select>
							</div>							
		
			<div class="div-table-col"><label for="codiApplicazione">&nbsp;Filtra per Applicazione:</label></div>
			<div class="div-table-col">
								<form:select path="codiApplicazione" id="codiApplicazione" name="codiApplicazione" style="width:180px">
									<form:option value="" label="--" />
									<form:options items="${codiApplicazioneList}" 
										itemValue="scodeApplicazione"
										itemLabel="sdescrizioneBreve" />	
										<form:hidden path="descApplicazione" value="${sdescrizioneBreve}"/>									
								</form:select>
							</div>
							
		</div>		
		</div>
		</fieldset>		
		</div>
		<br/>
		<div class="div-table-row">
					<div class="div-table-col">
									<p class="visualizzaForm"> NB: I campi contrassegnati con * sono obbligatori</p>
					</div>
		</div>
		
		
		<div class="div-table-row">
						<div class="div-table-col-center" >
						<!-- 	<input TYPE="submit" name="Indietro" VALUE="Indietro">    -->
							<input type="submit" name="Ricerca"  value="Ricerca" />	
							<a href="visualizzaElencoBusinessServices"><input TYPE="button" name="Annulla" VALUE="Esci"></a>							
						</div>
		</div>	
		
						<div class="div-table-row">
							<div class="div-table-col"></div>
						</div>
					</div>			
					
					<br/>					
					</form:form>	
				
	 <c:if test="${dServiziFunzioniListAssociate != null}">
	 <div class="div-table">				  
	<div class="div-table-row">
 		<div class="div-table-col">
		<fieldset>
			<legend>Riepilogo Funzioni Utente Associate</legend>	
					<div class="Scroll">						
						<div class="div-table">
								<br/>
								<div class="div-table-row">						
									<div class="div-table-col"><p class="visualizzaDesc">Area</p></div>	
									<div class="div-table-col"><p class="visualizzaDesc">Applicazione</p></div>		 
									<div class="div-table-col"><p class="visualizzaDesc">Funzione Utente</p></div>									
								<!--  	<div class="div-table-col-center"><p class="visualizzaDesc">Cancella</p></div>   	-->		 											
								</div>
							<div class="div-table-row">
								<div class="div-table-col">
								</div>
							</div>		
							
							<c:forEach items="${dServiziFunzioniListAssociate}" var="item" >
							<div class="div-table-row">				
										<div class="div-table-col">${item.descArea}</div>	
										<div class="div-table-col">${item.descApplicazione}</div>	
										<div class="div-table-col">${item.descFunzione}</div>								
							<!-- 	<div class="div-table-col-center"><a href="cancellaAssociazioneFunzioneUtente?codiFunzione=${item.id.codiFunzione}&codiArea=${item.id.codiArea}&codiApplicazione=${item.id.codiApplicazione}&codiBusinessService=${item.id.codiBusinessService}&dataInizioAssociazione=${item.id.dataInizioAssociazione}"><img src="resources/img/iconeCancella2.jpg"  width="30" height="20" title="Cancella Funzione Utente"></a></div>  -->
							</div>
							</c:forEach>
							<br/>		
							
							</div>
					</div>
							
		 </fieldset>	
		 <br/>
		  </div>
		  </div>
		 <div class="div-table-row">
					<div class="div-table-col-center" >							
					<a href="visualizzaElencoBusinessServices"><input TYPE="button" name="Homepage" VALUE="Homepage"></a>							
				</div>
		</div>	 
		 </div>
		<br/>
		 
		 </c:if>
				
					</div>		
</body>
