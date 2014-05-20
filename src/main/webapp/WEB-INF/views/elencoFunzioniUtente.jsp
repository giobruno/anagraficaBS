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
							<div class="div-table">
								<div class="div-table-row">
									<div class="div-table-col"><p class="visualizzaDesc">Area</p></div>
									<div class="div-table-col"><p class="visualizzaDesc">Applicazione</p></div>							
									<div class="div-table-col"><p class="visualizzaDesc">Funzione Utente</p></div>
									<div class="div-table-col-center"><p class="visualizzaDesc">Seleziona</p></div>
								</div>													

								<div class="div-table-row">
									<div class="div-table-col">
									</div>
								</div>
								
								<c:forEach items="${funzioniList}" var="item" >
									<div class="div-table-row">
										<div class="div-table-col">${item.descArea}</div>
										<div class="div-table-col">${item.descApplicazione}</div>
										<div class="div-table-col">${item.descFunzione}</div>
										<div class="div-table-col-center">	
											<form:checkbox path="funzioniDaInserire" id="funzioniDaInserire"  value="${item.codiArea}/${item.descArea}/${item.codiApplicazione}/${item.descApplicazione}/${item.codiFunzione}/${item.descFunzione}"/>
											<label for="funzioniDaInserire"></label>
										</div>	
									</div>														
								</c:forEach> 					
						 	 </div>
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
					<a href="visualizzaElencoBusinessServices"><input TYPE="button" name="Annulla" VALUE="Annulla"></a>
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
		
