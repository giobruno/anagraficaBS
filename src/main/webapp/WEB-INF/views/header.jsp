<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<!-- Homepage wrapper -->
		<div id="container">
				
			<!-- HEADER -->
			<div id="headerHome">					
					<div class="logoImage">
                  	   <img src="resources/img/tesoro.jpg" alt="Ministero delle Economie e delle Finanze"/>
              		  </div>
					
					<!-- 	<div ><img style="position: absolute;" src="resources/img/tesoro.jpg">  -->
					</div>
				
			</div>
			
		<!-- 	<sec:authorize access="hasRole('ROLE_USER')" >	
			<div id="login" class="fG2">	
				 	<p  class="UserName">${username}&nbsp;</p> 						
						<span class="Logout">						 
						<c:url value="j_spring_security_logout" var="logoutUrl"/>
							<a href="${logoutUrl}" id="logout"><img src="resources/img/bottone_esci.gif"></a> 																
						</span> 						
					</div>
				</sec:authorize>  -->
		
		<!-- <div id="drop-menu" > -->
			<ul id="menu">
				</ul>	
			<!-- 	</div>  -->	
					

													
	   
			<!-- END HEADER -->
			<div class="footerWrap">
		<footer class="bgB2" >	
		<sec:authorize access="hasRole('STANDARD')" >
		<div class="div-table">
			<div class="div-table-row">
				<div class="div-table-col-right">					
					<div style="color:white;font-weight:bold;text-align:right;">Utente loggato: ${utente}</div>
				</div>				 	
				<div class="div-table-col-center">	
				 			<c:url value="j_spring_security_logout" var="logoutUrl"/><a href="${logoutUrl}" id="logout" style="color:white;font-weight:bold;">Esci</a> 
				</div>				
		</div>
	</div>		
	</sec:authorize> 
</footer>
	
</div>
		
		
