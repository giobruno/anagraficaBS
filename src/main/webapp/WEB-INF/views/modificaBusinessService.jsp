<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="Content bgA3">
	
 
	<form:form name='form' action="modificaBusinessService" method='GET' commandName="businessServiceForm">
	
		 <div class="div-table">		
				<div class="div-table-row">
						<div class="div-table-col">
							<p class="visualizzaFormLegend">Modifica Business Service</p>
						</div>
				</div>
		</div>
		<br/>
		<div class="div-table-centrata">						
				 <div class="div-table-row">
			 		<p class="erroreForm"><form:errors path="*"/> </p>
			 		<br/>
					<fieldset >
					
					<legend>Effettua le modifiche richieste e premi sul tasto 'Modifica' per salvare!</legend>		
					
					<div class="div-table">					
						<div class="div-table-row">
							<div class="div-table-col"><label for="textNomeBusinessService"> <img src="resources/img/query.png" alt="" title="">&nbsp;Nome del Business Service*:</label></div>
							<div class="div-table-col"><form:input style="width:297px"  maxlength="50"  id="textNomeBusinessService" path="textNomeBusinessService"/></div>										
						</div>	
						<div class="div-table-row">
							<div class="div-table-col"><label for="descBusinessService"> <img src="resources/img/query.png" alt="" title="">&nbsp;Descrizione*:</label></div>
							<div class="div-table-col"><form:textarea cols="40" rows="3" path="descBusinessService" id="descBusinessService" onkeyup="maxlength(this,2000)"></form:textarea></div>										
						</div>
						<div class="div-table-row">
							<div class="div-table-col"><label for="persRespBusinessService"> <img src="resources/img/query.png" alt="" title="">&nbsp;Responsabile*:</label></div>
							<div class="div-table-col"><form:input style="width:297px"  maxlength="50"  id="persRespBusinessService" path="persRespBusinessService"/></div>							
						</div>
						<div class="div-table-row">
							<div class="div-table-col"><label for="textUrlBusinessService"> <img src="resources/img/query.png" alt="" title="">&nbsp;Url*:</label></div>
							<div class="div-table-col"><form:input style="width:297px"  maxlength="50"  id="textUrlBusinessService" path="textUrlBusinessService"/></div>							
						</div>		
						<div class="div-table-row">
								    	<div class="div-table-col"><label for="codiDipartimento"> <img src="resources/img/query.png" alt="" title="">&nbsp;Dipartimento*:</label></div>
										<div class="div-table-col">
											<form:select path="codiDipartimento" id="codiDipartimento" name="codiDipartimento" style="width:180px">
												<form:option value="" label="--" />
												<form:options items="${dipartimentiList}" 
													itemValue="codiDipartimento"
													itemLabel="textSiglaDipartimento" />										
											</form:select>
										</div>																	
						</div>	
					<div class="div-table-row">
						<div class="div-table-col"><label for="codiModelApplicativo"> <img src="resources/img/query.png" alt="" title="">&nbsp;Model Applicativo*:</label></div>
						<div class="div-table-col">
											<form:select path="codiModelApplicativo" id="codiModelApplicativo" name="codiModelApplicativo" style="width:180px">
												<form:option value="" label="--" />
												<form:options items="${modelApplicativiList}" 
													itemValue="codiModelApplicativo"
													itemLabel="descModelApplicativo" />
													<form:hidden  path="descModelApplicativo"  />
											</form:select>
										</div>										
					</div>
					<div class="div-table-row">
							<div class="div-table-col"><label for="flagConvenzione"> <img src="resources/img/query.png" alt="" title="">&nbsp;Presenza convenzione*:</label></div>
							<div class="div-table-col">			
									<form:radiobutton  path="flagConvenzione" id="flagConvenzione" value="true" disabled="true"/><label for="flagConvenzione">&nbsp;SI</label>
									<form:radiobutton path="flagConvenzione" id="flagConvenzione" value="false" disabled="true"/><label for="flagConvenzione">&nbsp;NO</label>
							</div>					
						</div>
							<form:hidden path="codiBusinessServiceOld" />
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
									
									<input type="submit" name="Modifica"  value="Modifica" onclick="return conferma('Sei sicuro di voler modificare il Business Service?')"/>							
									<input type="submit" name="Annulla"  value="Annulla" />
								</div>
							</div>		
							<br/>
				</div>	
				
 
	</form:form>	
	
	</div>
</body>
