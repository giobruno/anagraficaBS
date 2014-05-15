<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>

<div class="ContentHome bgA3">	
   
	<form:form name='form' action="registrazione" method='POST' commandName="registrazioneForm">
	
	<div class="div-table">
	
	<div class="div-table-row">
	<div class="div-table-col">
	
	
					
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
 	<div class="div-table-centrata">
 	<p class="visualizzaFormLegend" align="center">Benvenuti sulla pagina di registrazione!</p><br/><br/> 	
 	 <div class="div-table-row">
 	 <p class="erroreForm"><form:errors path="*"/> </p>
 	 
 	 <br/>
 	 
		<fieldset >
		
		<legend>Compila i seguenti campi per registrarti</legend>		
		
		<div class="div-table">	
			<div class="div-table-row">
					    	<div class="div-table-col"><label for="nome"> &nbsp;Nome*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="nome" path="nome" onblur="getUsername()"/></div>
			</div>
			<div class="div-table-row">
							<div class="div-table-col"><label for="cognome"> &nbsp;Cognome*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="cognome" path="cognome" onblur="getUsername()"/></div>			
			</div>
			<div class="div-table-row">
							<div class="div-table-col"><label for="username"> &nbsp;Nome Utente*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="username" path="username"/></div>
			</div>
			<div class="div-table-row">
							<div class="div-table-col"><label for="email"> &nbsp;Indirizzo email*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="email" path="email"  /></div>							
			</div>
			<div class="div-table-row">
							<div class="div-table-col"><label for="password"> &nbsp;Password*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  type="password" maxlength="150" id="password" path="password"/></div>							
			</div>
			<div class="div-table-row">
							<div class="div-table-col"><label for="confermaPassword"> &nbsp;Conferma Password*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  type="password" maxlength="150" id="confermaPassword" path="confermaPassword"/></div>							
			</div></div>
			</fieldset>
			</div>
			<br/>
			<div class="div-table-row">
			<div class="div-table-col">
									<p class="visualizzaForm"> NB: I campi contrassegnati con * sono obbligatori</p>
					</div>
					</div>
					<br/>
			<div class="div-table-row">
						<div class="div-table-col">
									<p class="visualizzaForm">Se hai gia' un account, <a href="login">Accedi!</a></p>
					</div>
					</div>	
			
			
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
						<input type="submit" name="Registrati"  value="Registrati"/>							
						<input type="submit" name="Annulla"  value="Annulla" />
					</div>
				</div>				
				
				
					<br/>					
 </div>
	</form:form>
	
	
	</div>
</body>
