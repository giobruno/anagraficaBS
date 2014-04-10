<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="Content bgA3">
	
 
	<form:form name='form' action="ricercaFunzioniUtente" method='POST' commandName="ricercaFunzioniUtenteForm">
	 <div class="div-table">
	
	<div class="div-table-row">
	<div class="div-table-col">
	
	
					<p class="visualizzaFormLegend">Inserimento Nuova Associazione Business Service - Funzione Utente</p>
	</div>
	</div>
	</div>
		<div class="div-table-centrata">
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
 
		<fieldset>
		
		<legend>Selezionare almeno l'Area di appartenenza per ricercare le Funzioni Utente</legend>		
		
		<div class="div-table">		
			
		<div class="div-table-row">
			<div class="div-table-col"><label for="codiArea"> <img src="resources/img/query.png" alt="" title="">&nbsp;Filtra per Area*:</label></div>
			<div class="div-table-col">
								<form:select  path="codiArea" id="codiArea" name="codiArea" style="width:180px">
									<form:option value="" label="--" />
									<form:options items="${codiAreaList}" 
										itemValue="id.codiArea"
										itemLabel="id.descArea" />	
										<form:hidden path="descArea" value="${id.descArea}"/>										
								</form:select>
							</div>							
		
			<div class="div-table-col"><label for="codiApplicazione"> <img src="resources/img/query.png" alt="" title="">&nbsp;Filtra per Applicazione:</label></div>
			<div class="div-table-col">
								<form:select path="codiApplicazione" id="codiApplicazione" name="codiApplicazione" style="width:180px">
									<form:option value="" label="--" />
									<form:options items="${codiApplicazioneList}" 
										itemValue="id.codiApplicazione"
										itemLabel="id.descApplicazione" />	
										<form:hidden path="descApplicazione" value="${id.descApplicazione}"/>									
								</form:select>
							</div>
							
		</div>		
		</div>
		</fieldset>
		
		</div>
		
		<div class="div-table-row">
			<div class="div-table-col">
					 &nbsp;
							</div>
							</div>
		<div class="div-table-row">
						<div class="div-table-col-center" >
							<input TYPE="submit" name="Indietro" VALUE="Indietro">
							<input type="submit" name="Ricerca"  value="Ricerca" />	
							<input TYPE="submit" name="Annulla" VALUE="Annulla">							
						</div>
		</div>	
		<div class="div-table-row">
							<div class="div-table-col">
							<p class="erroreForm"><form:errors path="codiArea"/> </p></div></div>
						<div class="div-table-row">
							<div class="div-table-col"></div>
						</div>
					</div>
	 
	 
				 <div class="div-table"> 
					<div class="div-table-row">
					<div class="div-table-col">
									<p class="visualizzaForm"> NB: I campi contrassegnati con * sono obbligatori</p>
					</div>
					</div>
					</div>		
		
 
	</form:form>	
	
	</div>
</body>
