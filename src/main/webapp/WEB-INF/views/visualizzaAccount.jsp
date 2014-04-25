<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>

<div class="Content bgA3">	
   
	<form:form name='form' action="modificaAccount" method='GET' commandName="registrazioneForm">
	
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
 	<p class="visualizzaFormLegend">Gestione Account</p><br/><br/> 	
 	 <div class="div-table-row">
		<fieldset >
		
		<legend>Informazioni utente</legend>		
		
		<div class="div-table">	
			<div class="div-table-row">
					    	<div class="div-table-col"><label for="nome"> <img src="resources/img/query.png" alt="" title="">&nbsp;Nome*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="nome" path="nome" onblur="getUser()"/></div>
							<div class="div-table-col"><p class="erroreForm"><form:errors path="nome"/> </p></div>
			</div>
			<div class="div-table-row">
							<div class="div-table-col"><label for="cognome"> <img src="resources/img/query.png" alt="" title="">&nbsp;Cognome*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="cognome" path="cognome" onblur="getUser()"/></div>
							<div class="div-table-col"><p class="erroreForm"><form:errors path="cognome"/> </p></div>
			
			</div>
			<div class="div-table-row">
				<div class="div-table-col"><label for="user"> <img src="resources/img/query.png" alt="" title="">&nbsp;Nome Utente*:</label></div>
				<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="user" path="user" readonly="true"/></div>
				<div class="div-table-col"><p class="erroreForm"><form:errors path="user"/> </p></div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col"><label for="email"> <img src="resources/img/query.png" alt="" title="">&nbsp;Indirizzo email*:</label></div>
				<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="email" path="email"  /></div>
				<div class="div-table-col"><p class="erroreForm"><form:errors path="email"/> </p></div>
			</div>
			</br>
			
			<div class="div-table-row">			
				<div class="div-table-col-center">
					<p class="visualizzaForm" align="right">Modifica Password:</p>
				</div>
			</div>
			</br>	
			<div class="div-table-row">
				<div class="div-table-col"><label for="oldPassword"> <img src="resources/img/query.png" alt="" title="">&nbsp;Password Attuale*:</label></div>
				<div class="div-table-col"><form:input style="width:200px"  type="password" maxlength="150" id="oldPassword" path="oldPassword"/></div>
				<div class="div-table-col"><p class="erroreForm"><form:errors path="oldPassword"/> </p></div>
			</div>	
			<div class="div-table-row">
				<div class="div-table-col"><label for="password"> <img src="resources/img/query.png" alt="" title="">&nbsp;Nuova Password*:</label></div>
				<div class="div-table-col"><form:input style="width:200px"  type="password" maxlength="150" id="password" path="password"/></div>
				<div class="div-table-col"><p class="erroreForm"><form:errors path="password"/> </p></div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col"><label for="confermaPassword"> <img src="resources/img/query.png" alt="" title="">&nbsp;Conferma Nuova Password*:</label></div>
				<div class="div-table-col"><form:input style="width:200px"  type="password" maxlength="150" id="confermaPassword" path="confermaPassword"/></div>
				<div class="div-table-col"><p class="erroreForm"><form:errors path="confermaPassword"/> </p></div>
			</div></div>
			<form:hidden path="userId"/>
			</fieldset>
			</div>
			</br>
			<div class="div-table-row">
			<div class="div-table-col">
									<p class="visualizzaForm"> NB: I campi contrassegnati con * sono obbligatori</p>
					</div>
					</div>
					</br>
						
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
						<input type="submit" name="Modifica"  value="Modifica Account" onclick="return conferma('Sei sicuro di voler modificare i dati del tuo account?')"/>							
						<input type="submit" name="Annulla"  value="Annulla" />
					</div>
				</div>
				
				<c:if test="${presenzaMessaggio == 'si'}" >
							<div class="div-table-row">
								<div class="div-table-col">
										<p class="visualizzaForm" style="color:red;">${messaggio}</p>
								</div>
							</div>
	
					</c:if>
				
				<div class="div-table-row">
							<div class="div-table-col">
							<p class="erroreForm"><form:errors path=""/> </p></div>
						</div>
						<div class="div-table-row">
							<div class="div-table-col"></div>
						</div>
					</div>
	 
	 
				 <div class="div-table"> 
					<div class="div-table-row">
					
					</div>
					</div>		
 
	</form:form>
	
	
	</div>
</body>
