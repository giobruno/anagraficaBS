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
			
			<p class="visualizzaFormLegend">Elenco Pesi Business Services</p><br/><br/>
	 <div class="div-table-row">
	 
 	<div class="div-table-centrata">
 	 	
 	 <div class="div-table-row">
 	 	
		<fieldset >
		
		<legend>Pesi Business Services</legend>
		<div class="div-table-centrata">
		 <div class="div-table-row">		
			<div class="div-table-col-center">
		
		<div class="div-table-centrata">
								<div class="div-table-row">									
									<div class="div-table-col"><p class="visualizzaDesc">Business Service</p></div>
									<div class="div-table-col"><p class="visualizzaDesc">Dipartimento BS</p></div>	
									<div class="div-table-col"><p class="visualizzaDesc">Valore Peso BS</p></div>															
								</div>
							<div class="div-table-row">
								<div class="div-table-col">
								</div>
							</div>		
							
							<c:forEach items="${businessServiceBeanList}" var="item" >
							<div class="div-table-row">						
								<div class="div-table-col">${item.textNomeBusinessService}</div>	
								<div class="div-table-col">${item.textSiglaDipartimento}</div>
								<div class="div-table-col">${item.misuPesoBs}</div>	
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
				
						<a href="formModificaPesiBs"><input type="button" value="Modifica Pesi"/></a>										
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

