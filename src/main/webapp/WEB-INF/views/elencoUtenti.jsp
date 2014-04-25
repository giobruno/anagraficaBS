<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="Content bgA3">
		
 	<div class="div-table">
		<div class="div-table-row">
		<div class="div-table-col">
						<p class="visualizzaFormLegend">Elenco Utenti</p>						
		</div>
	</div>	
	
	
<!-- 	<div class="div-table-centrata">		
		<c:if test="${presenzaMessaggio == 'si'}" >	
		<div class="div-table-row">
					<div class="div-table-col">
						<p class="visualizzaForm" style="color:red;">${message}</p>
					</div>
				</div>	
	</c:if>
	</div>
	 -->
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
			<legend>Business Services</legend>				
						<div class="div-table">
								<div class="div-table-row">							 
									<div class="div-table-col-center"><p class="visualizzaDesc">Nome</p></div>	
									<div class="div-table-col-center"><p class="visualizzaDesc">Cognome</p></div>					
									<div class="div-table-col-center"><p class="visualizzaDesc">Abilita</p></div>
									<div class="div-table-col-center"><p class="visualizzaDesc">Invia Password</p></div>
							<!-- 		<div class="div-table-col-center"><p class="visualizzaDesc">Cancella</p></div>    -->
														
								</div>
							<div class="div-table-row">
								<div class="div-table-col">
								</div>
							</div>		
							
							<c:forEach items="${utentiList}" var="item" >
							<div class="div-table-row">				
								<div class="div-table-col-center">${item.nome}</div>	
								<div class="div-table-col-center">${item.cognome}</div>							
								
								<c:if test="${item.enabled}">
									<div class="div-table-col-center"><a href="disabilitaUtente?userId=${item.userId}">
									<img src="resources/img/abilitato.jpg"  width="30" height="20" title="Utente Abilitato"></a></div>
								</c:if>
								<c:if test="${!item.enabled}">
									<div class="div-table-col-center"><a href="abilitaUtente?userId=${item.userId}">
									<img src="resources/img/nonAbilitato.jpg"  width="30" height="20" title="Abilita Utente"></a></div>
								</c:if>
								<div class="div-table-col-center"><a href="#"><img src="resources/img/inviaPassword.jpg"  width="30" height="20" title="Invia Password"></a></div>
					<!-- 			<div class="div-table-col-center"><a href="cancellaUtente?userId=${item.userId}"><img src="resources/img/iconeCancella2.jpg"  width="30" height="20" title="Cancella Utente"></a></div>     -->
							</div>
							</c:forEach>
						</div> 
		 </fieldset>					
					  </div>
				 	 
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
					<a href="visualizzaElencoBusinessServices"><input TYPE="button" name="Annulla" VALUE="Annulla"></a>
	</div>		
	</div>
	</br>
	
	 </div>     
</div>

		
