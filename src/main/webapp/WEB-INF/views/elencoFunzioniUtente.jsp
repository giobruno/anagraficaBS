<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="Content bgA3">
		
 <form:form name="form" method="POST" action="inserisciFunzioniUtente" commandName="elencoFunzioniForm">
	<div class="div-table">
		<div class="div-table-row">
		<div class="div-table-col">
						<p class="visualizzaFormLegend">Elenco Funzioni Utente da associare</p>						
		</div>
	</div>
	
			<div class="div-table-row">
				<div class="div-table-col"></div>
	</div>
				<div class="div-table-row">
				<div class="div-table-col"></div>
	</div>
	<div class="div-table-centrata">

	
	<div class="div-table-row">
	<div class="div-table-col">
					</div>
	</div><div class="div-table-row">
	<div class="div-table-col">
					</div>
	</div><div class="div-table-row">
	<div class="div-table-col">
					</div>
	</div>
	
	 <div class="div-table-row">
 
		<fieldset>
			<legend>Selezionare le funzioni da associare</legend>				
							<table  width="100%"  border="0">
							<tr>
							<th><p class="visualizzaDesc">Area</p></th>
							<th><p class="visualizzaDesc">Applicazione</p></th>							
							<th><p class="visualizzaDesc">Funzione Utente</p></th>
							<th><p class="visualizzaDesc">Seleziona</p></th>														

							<tr><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th></tr>
							<c:forEach items="${funzioniList}" var="item" >
							<tr>
							<th>${item.descArea}</th>
							<th>${item.descApplicazione}</th>
							<th>${item.descFunzione}</th>
							<th>	
								<form:checkbox path="funzioniDaInserire" id="funzioniDaInserire"  value="${item.codiArea}/${item.descArea}/${item.codiApplicazione}/${item.descApplicazione}/${item.codiFunzione}/${item.descFunzione}"/>
								<label for="funzioniDaInserire"></label>
							</th>																					
							</c:forEach> 					
					  </table>
		 </fieldset>		 	 
	</div>
	
	
	</div>
	 
	 
 <div class="div-table"> 
	

	<div class="div-table-row">
	<div class="div-table-col">
					 
	</div>
	</div>
	<div class="div-table-row">
	<div class="div-table-col">
					 
	</div>
	</div>
	<div class="div-table-row">
	<div class="div-table-col">
					 
	</div>
	</div>
	
	<div class="div-table-row">
	<div class="div-table-col-center" >
	
					<input TYPE="submit" name="Indietro" VALUE="Indietro">	
		 <c:if test="${fn:length(funzioniList) gt 1}" > 
					<input type=button value="Seleziona tutti" onClick="this.value=check(this.form.funzioniDaInserire)"> 
		</c:if>		
					
					<input TYPE="submit" name="Associa" VALUE="Associa" >
					<input TYPE="submit" name="Annulla" VALUE="Annulla">
	</div>
	
	</div>
	</div>
	<br/>
	
	<div class="div-table-row">
				<div class="div-table-col">
					<p class="erroreForm"><form:errors path="*"/> </p>
				</div>
		</div>
			<div class="div-table-row">
				<div class="div-table-col"></div>
	</div>

	 </div>
	 
    </form:form>		
     
</div>
		
