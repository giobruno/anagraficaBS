<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="Content bgA3">
	
 
	<form:form name='form' action="selezioneBS" method='GET' commandName="associazioneBSFunzUtenteForm">
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
 		<p class="erroreForm"><form:errors path="*"/> </p>
 		<br/>
		<fieldset>
		
		<legend>Selezionare il Business Service al quale associare le Funzioni Utente</legend>		
		
		<div class="div-table">		
			
		<div class="div-table-row">
			<div class="div-table-col"><label for="codiBusinessService">&nbsp;Seleziona il Business Service:</label></div>
			<div class="div-table-col">
								<form:select  path="codiBusinessService" id="codiBusinessService" name="codiBusinessService" style="width:250px">
									<form:option value="" label="--" />
									<form:options items="${businessServiceList}" 
										itemValue="codiBusinessService"
										itemLabel="textNomeBusinessService" />																					
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
			<div class="div-table-col">
					 &nbsp;
							</div>
							</div>
		<div class="div-table-row">
						<div class="div-table-col-center" >							
							<input type="submit" name="Avanti"  value="Avanti" />	
							<input TYPE="submit" name="Annulla" VALUE="Annulla">							
						</div>
		</div>	
		
						<div class="div-table-row">
							<div class="div-table-col"></div>
						</div>
					</div>
	 
	 
				
					
					<br/>
					<br/>
					<div class="div-table-row">
							<div class="div-table-col">
								
							</div>
					</div>
					
					</form:form>	


				
					</div>		
</body>
