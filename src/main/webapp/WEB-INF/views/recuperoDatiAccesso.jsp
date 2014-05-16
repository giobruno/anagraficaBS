<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>

<div class="Content bgA3">	
   
	<form:form name='form' action="richiestaDatiAccesso" method='GET' commandName="emailForm">
	
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
 	 <div class="div-table-row">
 	 <p class="erroreForm"><form:errors path="*"/> </p>
 	 
 	 <br/>
 	 
		<fieldset >
		
		<legend>Inserisci l'indirizzo email utilizzato per la registrazione!</legend>		
		
		<div class="div-table">				
			<div class="div-table-row">
							<div class="div-table-col"><label for="email"> &nbsp;Indirizzo email*:</label></div>
							<div class="div-table-col"><form:input style="width:200px"  maxlength="150" id="email" path="email"  /></div>							
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
					<br/>			
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
						<input type="submit" name="Registrati"  value="Invia"/>							
						<input type="submit" name="Annulla"  value="Annulla" />
					</div>
				</div>				
				
				
					<br/>					
 </div>
	</form:form>
	
	
	</div>
</body>
