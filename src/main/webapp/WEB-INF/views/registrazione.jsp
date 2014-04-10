<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body onload='document.form.nome.focus();'>

<div class="ContentHome bgA3">	
   
	<form:form name='form' action="registrazione" method='POST' commandName="registrazioneForm">
	
	<div class="div-table">
	
	<div class="div-table-row">
	<div class="div-table-col">
	
	
					<p class="visualizzaFormLegend">Registrazione	</p>
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
		
		<legend>Compila i seguenti campi per registrarti</legend>		
		
		<div class="div-table">	
			<div class="div-table-row">
					    	<div class="div-table-col"><label for="nome"> <img src="resources/img/query.png" alt="" title="">&nbsp;Nome*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="nome" path="nome"/></div>
			</div>
			<div class="div-table-row">
							<div class="div-table-col"><label for="cognome"> <img src="resources/img/query.png" alt="" title="">&nbsp;Cognome*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="cognome" path="cognome"/>
			</div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col"><label for="user"> <img src="resources/img/query.png" alt="" title="">&nbsp;Nome Utente*:</label></div>
				<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="user" path="user"/>
				</div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col"><label for="email"> <img src="resources/img/query.png" alt="" title="">&nbsp;Indirizzo email*:</label></div>
				<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="email" path="email"/>
				</div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col"><label for="password"> <img src="resources/img/query.png" alt="" title="">&nbsp;Password*:</label></div>
				<div class="div-table-col"><form:input style="width:200px"  type="password" maxlength="150" id="password" path="password"/>
				</div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col"><label for="confermaPassword"> <img src="resources/img/query.png" alt="" title="">&nbsp;Conferma Password*:</label></div>
				<div class="div-table-col"><form:input style="width:200px"  type="password" maxlength="150" id="confermaPassword" path="confermaPassword"/>
				</div>
			</div></div>
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
							<p class="erroreForm"><form:errors path="*"/> </p></div></div>
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
