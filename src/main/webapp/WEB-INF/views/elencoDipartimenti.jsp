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
			
			<p class="visualizzaFormLegend">Elenco Dipartimenti</p><br/><br/>
	 <div class="div-table-row">
	 
 	<div class="div-table-centrata">
 	 	
 	 <div class="div-table-row">
 	 	
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
							
							<c:forEach items="${dipartimentiList}" var="item" >
							<div class="div-table-row">						
								<div class="div-table-col">${item.textSiglaDipartimento}</div>	
								<div class="div-table-col">${item.misuPesoDip}</div>	
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
				
						<a href="formModificaPesiDipartimenti"><input type="button" value="Modifica Pesi"/></a>										
						<a href="visualizzaElencoBusinessServices"><input type="button"  value="Homepage" /></a>
					</div>
				</div>						
					</div>
	 
	 
				 <div class="div-table"> 
					<div class="div-table-row">
					
					</div>
					</div>	
					<br/>	
 
	</div>

