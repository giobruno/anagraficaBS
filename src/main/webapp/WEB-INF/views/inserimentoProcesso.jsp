<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="Content bgA3">
	
 
	<form:form name='form' action="inserimentoProcesso" method='POST' commandName="processoForm">
	 <div class="div-table">
	
	<div class="div-table-row">
	<div class="div-table-col">
	
	
					<p class="visualizzaFormLegend">Inserimento Nuovo Processo</p>
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
		<fieldset >
		
		<legend>Compila il seguente form per inserire un nuovo Processo</legend>		
		
		<div class="div-table">			
				
			<div class="div-table-row">
				<div class="div-table-col"><label for="textSiglaProcesso"> &nbsp;Sigla del Processo*:</label></div>
				<div class="div-table-col"><form:input style="width:297px"  maxlength="50"  id="textSiglaProcesso" path="textSiglaProcesso"/></div>				
			</div>	
			<div class="div-table-row">
				<div class="div-table-col"><label for="descProcesso"> &nbsp;Descrizione*:</label></div>
				<div class="div-table-col"><form:textarea cols="40" rows="3" path="descProcesso" id="descProcesso" onkeyup="maxlength(this,2000)"></form:textarea></div>				
			</div>	
			<div class="div-table-row">
						<div class="div-table-col"><label for="flagCatMac"> &nbsp;Categoria Mac*:</label></div>
						<div class="div-table-col">			
								<form:radiobutton  path="flagCatMac" id="flagCatMac" value="true" /><label for="flagCatMac">&nbsp;SI</label>
								<form:radiobutton path="flagCatMac" id="flagCatMac" value="false" /><label for="flagCatMac">&nbsp;NO</label>
						</div>					
			</div>
			<div class="div-table-row">
						<div class="div-table-col"><label for="flagCatInfr"> &nbsp;Categoria Infr*:</label></div>
						<div class="div-table-col">			
								<form:radiobutton  path="flagCatInfr" id="flagCatInfr" value="true" /><label for="flagCatInfr">&nbsp;SI</label>
								<form:radiobutton path="flagCatInfr" id="flagCatInfr" value="false" /><label for="flagCatInfr">&nbsp;NO</label>
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
				
						<input type="reset" name="Cancella" value="Cancella"/>
						<input type="submit" name="Salva"  value="Salva" />							
						<input type="submit" name="Annulla"  value="Annulla" />
					</div>
				</div>
	
				<div class="div-table-row">
							<div class="div-table-col">
							</div></div>
						<div class="div-table-row">
							<div class="div-table-col"></div>
						</div>
					</div>
	  				<br/>
	</form:form>	
	
	</div>
</body>
