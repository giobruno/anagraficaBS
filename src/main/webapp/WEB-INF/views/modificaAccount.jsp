<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>

<div class="Content bgA3">	
   
	<form:form name='form' action="modificaAccount" method='GET' commandName="accountForm">
	
	<div class="div-table">
	
	<div class="div-table-row">
	<div class="div-table-col">
	
	
					
	</div>
	</div>
	</div>
		<div class="div-table-centrata">
	
			
			<p class="visualizzaFormLegend">Gestione Account</p><br/><br/> 	
	 <div class="div-table-row">
 	<div class="div-table-centrata">
 	
 	 <div class="div-table-row">
 		 <p class="erroreForm"><form:errors path="*"/> </p>
 		<br/>
		<fieldset >
		
		<legend>Informazioni utente</legend>		
		
		<div class="div-table">	
			<div class="div-table-row">
					    	<div class="div-table-col"><label for="nome"> <img src="resources/img/query.png" alt="" title="">&nbsp;Nome*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="nome" path="nome" onblur="getUsername()"/></div>
						<!-- 	<div class="div-table-col"><p class="erroreForm"><form:errors path="nome"/> </p></div>   -->
			</div>
			<div class="div-table-row">
							<div class="div-table-col"><label for="cognome"> <img src="resources/img/query.png" alt="" title="">&nbsp;Cognome*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="cognome" path="cognome" onblur="getUsername()"/></div>
						<!-- 	<div class="div-table-col"><p class="erroreForm"><form:errors path="cognome"/> </p></div>  -->
			
			</div>
			<div class="div-table-row">
							<div class="div-table-col"><label for="username"> <img src="resources/img/query.png" alt="" title="">&nbsp;Nome Utente*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="username" path="username" /></div>
						<!-- 	<div class="div-table-col"><p class="erroreForm"><form:errors path="username"/> </p></div>  -->
			</div>
			<div class="div-table-row">
							<div class="div-table-col"><label for="email"> <img src="resources/img/query.png" alt="" title="">&nbsp;Indirizzo email*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="email" path="email"  /></div>
						<!-- 	<div class="div-table-col"><p class="erroreForm"><form:errors path="email"/> </p></div>   -->
			</div>
				
			</div>
			<form:hidden path="userId"/>
			<form:hidden path="password"/>
			
			</fieldset>
			</div>
			<br/>
			<div class="div-table-row">
			<div class="div-table-col">
									<p class="visualizzaForm"> NB: I campi contrassegnati con * sono obbligatori</p>
					</div>
					</div>
					</div></div>
					<br/>	
	
	
					<div class="div-table-row">
						<div class="div-table-col-center" >
				
						<input type="reset" name="Cancella" value="Cancella"/>
						<input type="submit" name="Modifica"  value="Modifica Account" onclick="return conferma('Sei sicuro di voler modificare i dati del tuo account?')"/>							
						<input type="submit" name="Annulla"  value="Annulla" />
					</div>
				</div>				
				</div>
				<br/>
 
	</form:form>
	
	
	</div>
</body>
