<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<!-- Homepage wrapper -->
		<div class="PageWrap" id="homepageMop">
		
			<!-- HEADER -->
			<div id="header">
					<div id=headerBox>
						<div id=titleBox><img style="position: absolute;" src="resources/img/tesoro.jpg">
					</div>
				</div>
			</div>
			
			<sec:authorize access="hasRole('ROLE_USER')" >	
			<div id="login" class="fG2">	
				 	<p  class="UserName">${username}&nbsp;</p> 						
						<span class="Logout">						 
						<c:url value="j_spring_security_logout" var="logoutUrl"/>
							<a href="${logoutUrl}" id="logout"><img src="resources/img/bottone_esci.gif"></a> 																
						</span> 						
					</div>
				</sec:authorize>
 		</div>	
				<br/>
				<br/>
					

													<!-- <div id="drop-menu" > -->
													<ul id="menu">
													
														</ul>	
											<!-- 	</div>  -->
	   
			<!-- END HEADER -->
			<div class="footerWrap" align="center">
		<footer class="bgB2">
				<div id="quickMenu">
				
				</div>
			</footer>
	
		</div>
		
		
