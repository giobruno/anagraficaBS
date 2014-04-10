<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="Content bgA3">

<c:if test="${presenzaMessaggio == 'si'}" >
	<div class="div-table-row">
				<div class="div-table-col">
					<p class="visualizzaForm">${messaggio}</p>
				</div>
			</div>
	
	</c:if>

<fieldset>
<div class="div-table-centrata">

	
	<div class="div-table-row">
		<div class="div-table-col">
		
		<h3>Message : ${message}</h3>	
	<h3>Username : ${username}</h3>	
	<c:url value="/j_spring_security_logout" var="logoutUrl"/>
	<a href="${logoutUrl}" > Logout</a>
		</div>
		
		</div>
	</div>
</fieldset>
					
					
					 </div>