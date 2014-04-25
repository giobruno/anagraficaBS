<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body onload='document.form.nome.focus();'>

<div class="ContentHome bgA3">		
   
	<form name='form' action="<c:url value='/j_spring_security_check' />" method='POST'>
	
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
 	<div class="div-table-centrata">
 	<p class="visualizzaFormLegend" align="center">Benvenuti sulla pagina di login!</p><br/><br/> 	
 	 
		<fieldset >
		
		<legend>Compila i seguenti campi per effettuare il login!</legend>		
		
		<div class="div-table">	
			<div class="div-table-row">
					    	<div class="div-table-col-center"><label for="j_username"> <img src="resources/img/query.png" alt="" title="">&nbsp;Username*:</label></div>
							<div class="div-table-col-center"><input style="width:200px"  maxlength="150" id="j_username" name="j_username"/></div>							
			</div>
			</br>
			<div class="div-table-row">
							<div class="div-table-col-center"><label for="j_password"> <img src="resources/img/query.png" alt="" title="">&nbsp;Password*:</label></div>
							<div class="div-table-col-center"><input style="width:200px"  maxlength="150" type="password" id="j_password" name="j_password"/>
							
			</div>
			</div>	
			
			</div>
			</fieldset>
			
			</br>
			<div class="div-table-row">
			<div class="div-table-col">
									<p class="visualizzaForm"> NB: I campi contrassegnati con * sono obbligatori</p>
					</div>
					</div>
					</br>
					<div class="div-table-row">
						<div class="div-table-col">
									<p class="visualizzaForm">Se non hai ancora un account, <a href="formRegistrazione">Registrati!</a></p>
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
							<input type="submit" name="Accedi"  value="Accedi"/>
							
							
							
							<a href="home" ><input type="button" value="Annulla"></a>	
						</div>						
						
					</div>
					</br>				
					<div class="div-table-row">
					<c:if test="${presenzaMessaggio == 'si'}" >
							<div class="div-table-row">
								<div class="div-table-col">
										<p class="visualizzaForm" style="color:red;">${messaggio}</p>
								</div>
							</div>
	
					</c:if>
					<c:if test="${not empty error}">
						<div class="div-table-row">
								<div class="div-table-col">
									<div class="visualizzaForm" style="color:red;">Utente non trovato! Verifica l'esattezza di username e pasword e assicurati che il tuo account sia abilitato!</div>
								</div>
						</div>
				</c:if>
					
				</div>
	
				</div>
			</div>
			</div>
							
		
	
							
						<div class="div-table-row">
							<div class="div-table-col"></div>
						</div>
					</div>
	 
	 
				 <div class="div-table"> 
					<div class="div-table-row">
					
					</div>
					</div>		
 
	</form>
	
	
	</div>
</body>

