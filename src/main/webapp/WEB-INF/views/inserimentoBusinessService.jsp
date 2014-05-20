<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="Content bgA3">
	
 
	<form:form name='form' action="inserimentoBusinessService" method='GET' commandName="businessServiceForm">
		 <div class="div-table">
		
			<div class="div-table-row">
				<div class="div-table-col">	
						<p class="visualizzaFormLegend">Inserimento Nuovo Business Service</p>
				</div>
			</div>
			<br/>
		</div>
		
		<div class="div-table-centrata">	
			 <div class="div-table-row">
	 			<p class="erroreForm"><form:errors path="*"/> </p>
	 			
 				<br/>
				<fieldset >
				
				<legend>Compila il seguente form per inserire un nuovo Business Service</legend>		
				
				<div class="div-table">					
					<div class="div-table-row">
						<div class="div-table-col"><label for="textNomeBusinessService"><img src="resources/img/query.png" title="Descrizione breve del Business Service" alt=""> &nbsp;Nome del Business Service*:</label></div>
						<div class="div-table-col"><form:input style="width:297px"  maxlength="50"  id="textNomeBusinessService" path="textNomeBusinessService"/></div>							
					</div>	
					<div class="div-table-row">
						<div class="div-table-col"><label for="descBusinessService"><img src="resources/img/query.png" title="Descrizione estesa del Business Service" alt=""> &nbsp;Descrizione*:</label></div>
						<div class="div-table-col"><form:textarea cols="39" rows="3" path="descBusinessService" id="descBusinessService" onkeyup="maxlength(this,2000)"></form:textarea></div>						
					</div>
					<sec:authorize access="hasRole('ADMIN')" >
					<div class="div-table-row">
							    	<div class="div-table-col"><label for="persRespBusinessService"> &nbsp;Responsabile*:</label></div>
									<div class="div-table-col">
										<form:select path="persRespBusinessService" id="persRespBusinessService" name="persRespBusinessService" style="width:300px">
											<form:option value="" label="--" />
											<form:options items="${utentiList}" 
												itemValue="nomeCognome"
												itemLabel="nomeCognome" />										
										</form:select>
									</div>														
					</div>
					</sec:authorize>
			<!-- 	<div class="div-table-row">
						<div class="div-table-col"><label for="persRespBusinessService"> &nbsp;Responsabile*:</label></div>
						<div class="div-table-col"><form:input style="width:297px"  maxlength="50"  id="persRespBusinessService" path="persRespBusinessService"/></div>				
					</div>
			 -->
					
					<div class="div-table-row">
						<div class="div-table-col"><label for="textUrlBusinessService"><img src="resources/img/query.png" title="Indirizzo da cui si puo' richiamare l'applicazione che realizza il Business Service" alt=""> &nbsp;Url*:</label></div>
						<div class="div-table-col"><form:input style="width:297px"  maxlength="50" value="http://" id="textUrlBusinessService" path="textUrlBusinessService"/></div>				
					</div>		
					<div class="div-table-row">
							    	<div class="div-table-col"><label for="codiDipartimento"> &nbsp;Dipartimento*:</label></div>
									<div class="div-table-col">
										<form:select path="codiDipartimento" id="codiDipartimento" name="codiDipartimento" style="width:300px">
											<form:option value="" label="--" />
											<form:options items="${dipartimentiList}" 
												itemValue="codiDipartimento"
												itemLabel="textSiglaDipartimento" />										
										</form:select>
									</div>														
					</div>	
				<div class="div-table-row">
					<div class="div-table-col"><label for="codiModelApplicativo"> &nbsp;Model Applicativo*:</label></div>
					<div class="div-table-col">
										<form:select path="codiModelApplicativo" id="codiModelApplicativo" name="codiModelApplicativo" style="width:300px">
											<form:option value="" label="--" />
											<form:options items="${modelApplicativiList}" 
												itemValue="codiModelApplicativo"
												itemLabel="descModelApplicativo" />
												<form:hidden  path="descModelApplicativo"  />
										</form:select>
									</div>							
				</div>
				<div class="div-table-row">
						<div class="div-table-col"><label for="flagConvenzione"><img src="resources/img/query.png" title="Indicare se il Business Service deve essere considerato ai fini del calcolo dei parametri della Convenzione MEF-SOGEI" alt=""> &nbsp;Convenzione*:</label></div>
						<div class="div-table-col">			
								<form:radiobutton  path="flagConvenzione" id="flagConvenzione" value="true" /><label for="flagConvenzione">&nbsp;SI</label>
								<form:radiobutton path="flagConvenzione" id="flagConvenzione" value="false" /><label for="flagConvenzione">&nbsp;NO</label>
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
						
						<input type="reset" value="Cancella"/>
						<input type="submit" name="Avanti"  value="Avanti" />							
						<input type="submit" name="Annulla"  value="Annulla" />
					</div>
				</div>
	
				<br/>				
 	</div>
	</form:form>	
	
	</div>
</body>
