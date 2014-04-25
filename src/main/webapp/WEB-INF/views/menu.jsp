<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

			
				<!-- Homepage left area: ultimi report -->				
				<div class="Left">
						<br/>		
						<sec:authorize access="hasRole('ADMIN')" >
							<h3 class="bgAr3"><span class="fG1"><a href="visualizzaElencoUtenti" class="fB2" style="color:white;">Gestione Utenti</a></span></h3>
						</sec:authorize>
						<h3 class="bgAr3"><span class="fG1"><a href="visualizzaAccount" class="fB2" style="color:white;">Gestione Account</a></span></h3>	
						<h3 class="bgAr3"><span class="fG1"><a href="visualizzaElencoBusinessServices" class="fB2" style="color:white;">Visualizza Business Service</a></span></h3>
						<h3 class="bgAr3"><span class="fG1"><a href="visualizzaElencoProcessi" class="fB2" style="color:white;">Visualizza Processi</a></span></h3>
						<h3 class="bgAr3"><span class="fG1"><a href="formAssociazioneBSProcesso" class="fB2" style="color:white;">Associa Processo</a></span></h3>												
						<h3 class="bgAr3"><span class="fG1"><a href="elencoReport" class="fB2" style="color:white;">Visualizza Report</a></span></h3>	
			<!-- 			
						<h3 class="bgAr3"><span class="fG1"><a href="#" class="fB2" style="color:white;">Visualizza Business Services</a></span></h3>
						<h3 class="bgAr3"><span class="fG1"><a href="#" class="fB2" style="color:white;">Visualizza Processi</a></span></h3>
						<h3 class="bgAr3"><span class="fG1"><a href="#" class="fB2" style="color:white;">Visualizza Associazioni BS-P</a></span></h3>
						<h3 class="bgAr3"><span class="fG1"><a href="#" class="fB2" style="color:white;">Visualizza Associazioni BS-FU</a></span></h3>				
			 -->
				</div>
						
				<!-- End Homepage left area: ultimi report -->