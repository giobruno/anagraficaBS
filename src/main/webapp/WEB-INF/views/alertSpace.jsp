<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="ContentAlertSpace bgA3" style="border: 2px;">
	</br>
	<div class="div-table" >	
		<div class="div-table-row">
			<div class="div-table-col">
				<div class="div-table-centrata">		
					
					<div class="div-table-row">
								<div class="div-table-col"><p class="visualizzaForm">Messaggio: </p></div>
							<c:if test="${presenzaMessaggio == 'si'}" >		
								<div class="div-table-col">
									<p class="visualizzaForm" style="color:red;">${message}</p>
								</div>
								</c:if>
								
							</div>	
				
				</div>
			</div>
		</div>
	</div>
</div>
	 

		
