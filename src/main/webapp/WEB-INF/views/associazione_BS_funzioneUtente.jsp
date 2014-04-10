<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="Content bgA3">
	
 
	<form:form name='form' action="inserimentoAssociazioneBSFunzUtente" method='POST' commandName="associazioneBSFunzUtenteForm">
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
 
		<fieldset >
		
		<legend>Compila il seguente form per inserire una nuova Associazione Business Service - Funzione Utente</legend>		
		
		<div class="div-table">		
			
		<div class="div-table-row">
			<div class="div-table-col"><label for="codiBusinessService"> <img src="resources/img/query.png" alt="" title="">&nbsp;Business Service*:</label></div>
			<div class="div-table-col">
								<form:select path="codiBusinessService" id="codiBusinessService" name="codiBusinessService" style="width:180px">
									<form:option value="" label="--" />
									<form:options items="${businessServiceList}" 
										itemValue="codiBusinessService"
										itemLabel="descBusinessService" />										
								</form:select>
							</div>
							<div class="div-table-col"><p class="erroreForm"><form:errors path="codiBusinessService"/> </p></div>	
		</div>
		<div class="div-table-row">
			<div class="div-table-col"><label for="codiArea"> <img src="resources/img/query.png" alt="" title="">&nbsp;Area*:</label></div>
			<div class="div-table-col">
								<form:select path="codiArea" id="codiArea" name="codiArea" style="width:180px">
									<form:option value="" label="--" />
									<form:options items="${codiAreaList}" 
										itemValue="id.codiArea"
										itemLabel="id.descArea" />										
								</form:select>
							</div>
							<div class="div-table-col"><p class="erroreForm"><form:errors path="codiArea"/> </p></div>	
		</div>
		<div class="div-table-row">
			<div class="div-table-col"><label for="codiApplicazione"> <img src="resources/img/query.png" alt="" title="">&nbsp;Applicazione*:</label></div>
			<div class="div-table-col">
								<form:select path="codiApplicazione" id="codiApplicazione" name="codiApplicazione" style="width:180px">
									<form:option value="" label="--" />
									<form:options items="${codiApplicazioneList}" 
										itemValue="id.codiApplicazione"
										itemLabel="id.descApplicazione" />										
								</form:select>
							</div>
							<div class="div-table-col"><p class="erroreForm"><form:errors path="codiApplicazione"/> </p></div>
		</div>
		<div class="div-table-row">
			<div class="div-table-col"><label for=funzioneList> <img src="resources/img/query.png" alt="" title="">&nbsp;Funzione*:</label></div>
			<div class="div-table-col">
								<form:select multiple="multiple" path="funzioneList" id="funzioneList" name="funzioneList" style="width:180px">
									<form:option value="" label="--" />
									<form:options items="${codiFunzioneList}" 
										itemValue="id.codiFunzione"
										itemLabel="id.descFunzione" />										
								</form:select>
							</div>	
							<div class="div-table-col"><p class="erroreForm"><form:errors path="funzioneList"/> </p></div>
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
				
						<input type="submit" name="Invia"  value="Invia" />	
						<input type="reset" name="Cancella" value="Cancella"/>
						<input type="submit" name="Annulla"  value="Annulla" />
					</div>
				</div>
	
				<div class="div-table-row">
							<div class="div-table-col">
							<p class="erroreForm"><form:errors path=""/> </p></div></div>
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
