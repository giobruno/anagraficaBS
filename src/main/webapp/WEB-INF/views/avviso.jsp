<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
		<!-- End Homepage left area: ultimi report -->
				
				<!-- Homepage central area: in evidenza -->
				<br/>
				
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
	
			<div class="div-table-row">
				<div class="div-table-col"></div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col"></div>
			</div>
	 <div class="div-table-row">
 	<div class="div-table-centrata"> 		
 	 
		<fieldset>
			<legend>Elenco avvisi</legend>				
						<div class="div-table">
							<c:if test="${listaAvvisi != null}">
								<c:forEach items="${listaAvvisi}" var="item" >
									<div class="div-table-row">							 
										<div class="div-table-col"> <p><font color="red"> ${item}</font></div>																						
									</div>
								</c:forEach>
							</c:if>
							<c:if test="${avviso != null}">
								<div class="div-table-row">							 
									<div class="div-table-col-center"> <p><font color="red"> ${avviso}</font></div>																						
								</div>
							</c:if>
							</div>									
						 
		 </fieldset>		
		</div> </div>
		<br/>
		<div class="div-table-row">
			<div class="div-table-col-center" >		
					<a href="visualizzaElencoBusinessServices"><input TYPE="button" name="Home" VALUE="Home"></a>
	</div>
	
	</div>
	<br/>
	<div class="div-table-row">
				<div class="div-table-col"></div>
	</div>
		
		</div></div> 
		<br/>
		<div class="div-table">
			<div class="div-table-row">
				<div class="div-table-col"></div>
	</div>
	</div>
		
		<br/>
				
			
				
		
			<!-- END MAIN PAGE -->

		<!-- End Homepage wrapper -->