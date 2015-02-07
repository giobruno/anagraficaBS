<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="Content bgA3">	

<form:form name='form' action="modificaPesiDipartimenti" method='GET' commandName="modificaPesiDipartimentiForm">
	
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
			
			<p class="visualizzaFormLegend">Elenco Dipartimenti</p><br/><br/>
	 <div class="div-table-row">
	 
 	<div class="div-table-centrata">
 	 	
 	 <div class="div-table-row">
 	 	<p class="erroreForm"><form:errors path="*"/> </p>
 	 	<br/>
 	 	
		<fieldset >
		
		<legend>Dipartimenti</legend>
		<div class="div-table-centrata">
		 <div class="div-table-row">		
			<div class="div-table-col-center">
		
					<div class="div-table-centrata">
								<div class="div-table-row">									
									<div class="div-table-col"><p class="visualizzaDesc">Dipartimento</p></div>	
									<div class="div-table-col"><p class="visualizzaDesc">Valore Peso</p></div>															
								</div>
							<div class="div-table-row">
								<div class="div-table-col">
								</div>
							</div>		
							
							<c:forEach items="${dipartimentiList}" var="item" varStatus="status">
							<div class="div-table-row">						
								<div class="div-table-col">${item.textSiglaDipartimento}</div>	
								<div class="div-table-col"><form:input style="width:100px" maxlength="6" id="valoriPesiList" path="valoriPesiList" value="${modificaPesiDipartimentiForm.valoriPesiList[status.index]}"/></div>		
							</div>
							</c:forEach>
						</div> 
						</div>
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
				
								<a href="visualizzaElencoBusinessServices"><input TYPE="button" name="Annulla" VALUE="Annulla"></a>
								<input type="submit" name="Salva"  value="Salva" />
					</div>
				</div>						
					</div>
	 
	 
				 <div class="div-table"> 
					<div class="div-table-row">
					
					</div>
					</div>	
					<br/>	
					
			</form:form>
 
	</div>


		
