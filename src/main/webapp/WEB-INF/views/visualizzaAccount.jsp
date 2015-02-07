<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div class="Content bgA3">	
	
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
			
			<p class="visualizzaFormLegend">Gestione Account</p><br/><br/>
	 <div class="div-table-row">
	 
 	<div class="div-table-centrata">
 	 	
 	 <div class="div-table-row">
		<fieldset >
		
		<legend>Informazioni utente</legend>		
		
		<div class="div-table">	
			<div class="div-table-row">
					    	<div class="div-table-col"> <p class="visualizzaDesc">Nome:</p></div>
							<div class="div-table-col"><p>${user.nome}</p></div>
							
			</div>
			<div class="div-table-row">
							<div class="div-table-col"> <p class="visualizzaDesc">Cognome:</p></div>
							<div class="div-table-col"><p>${user.cognome}</p></div>
							
			
			</div>
			<div class="div-table-row">
				<div class="div-table-col"> <p class="visualizzaDesc">Nome Utente:</p></div>
							<div class="div-table-col"><p>${user.username}</p></div>
				
			</div>
			<div class="div-table-row">
				<div class="div-table-col"> <p class="visualizzaDesc">Email:</p></div>
							<div class="div-table-col"><p>${user.email}</p></div>
				
			</div>			
			</div>			
			</fieldset>
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
				
						<a href="modificaPasswordForm"><input type="button" value="Modifica Password"/></a>
						<a href="modificaAccountForm"> <input type="button" value="Modifica dati Account"/></a>					
						<a href="visualizzaElencoBusinessServices"><input type="button"  value="Homepage" /></a>
					</div>
				</div>						
					</div>
	 
	 
				 <div class="div-table"> 
					<div class="div-table-row">
					
					</div>
					</div>		
 
	</div>

