<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>

<div class="Content bgA3">	
   
	<form:form name='form' action="modificaPassword" method='GET' commandName="modificaPasswordForm">
	
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
			<p class="visualizzaFormLegend">Gestione Account</p><br/><br/> 	
	 <div class="div-table-row">
 	<div class="div-table-centrata"> 	
 	 <div class="div-table-row">
 	  <p class="erroreForm"><form:errors path="*"/> </p>
 	 <br/>
		<fieldset >
		
		<legend>Modifica Password</legend>		
		
		<div class="div-table">							
			<div class="div-table-row">
						<div class="div-table-col"><label for="attualePassword"> <img src="resources/img/query.png" alt="" title="">&nbsp;Password Attuale*:</label></div>
						<div class="div-table-col"><form:input style="width:200px"  type="password" maxlength="150" id="attualePassword" path="attualePassword"/></div>						
			</div>	
			<div class="div-table-row">
						<div class="div-table-col"><label for="password"> <img src="resources/img/query.png" alt="" title="">&nbsp;Nuova Password*:</label></div>
						<div class="div-table-col"><form:input style="width:200px"  type="password" maxlength="150" id="password" path="password"/></div>						
			</div>
			<div class="div-table-row">
						<div class="div-table-col"><label for="confermaPassword"> <img src="resources/img/query.png" alt="" title="">&nbsp;Conferma Nuova Password*:</label></div>
						<div class="div-table-col"><form:input style="width:200px"  type="password" maxlength="150" id="confermaPassword" path="confermaPassword"/></div>						
			</div></div>			
			</fieldset>
			</div>
			<form:hidden path="userId"/>
			<form:hidden path="nome"/>
			<form:hidden path="cognome"/>
			<form:hidden path="username"/>
			<form:hidden path="email"/>
			<form:hidden path="oldPassword"/>
			<br/>
			<div class="div-table-row">
			<div class="div-table-col">
									<p class="visualizzaForm"> NB: I campi contrassegnati con * sono obbligatori</p>
					</div>
					</div>
					<br/>
						
			</div>
			</div>			
	
					<div class="div-table-row">
						<div class="div-table-col-center" >
				
						<input type="reset" name="Cancella" value="Cancella"/>
						<input type="submit" name="Modifica"  value="Modifica" onclick="return conferma('Sei sicuro di voler modificare la password del tuo account?')"/>					
						<input type="submit" name="Annulla"  value="Annulla" />
					</div>
				</div>		
					
					</div>
	 
	 			<br/>
				 <div class="div-table"> 
					<div class="div-table-row">
					
					</div>
					</div>		
 
	</form:form>
	
	
	</div>
</body>
