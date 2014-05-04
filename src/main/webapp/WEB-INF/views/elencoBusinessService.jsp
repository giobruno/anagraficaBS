<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="Content bgA3">
		
 	<div class="div-table">
		<div class="div-table-row">
		<div class="div-table-col">
						<p class="visualizzaFormLegend">Elenco Business Services</p>						
		</div>
	</div>	
	<div class="div-table">
	<div class="div-table-row">
	<div style="text-align: right;"><a href="formBusinessService" ><button>Inserisci nuovo Business Service</button></a>	</div>	
	</div>
	<!--   <c:if test="${presenzaMessaggio == 'si'}" >	
	<div class="div-table-row">
				<div class="div-table-col">
					<p class="visualizzaForm" style="color:red;">${message}</p>
				</div>
			</div>	
	</c:if>
	-->
	</div>
	<div class="div-table-row">
		<div class="div-table-col-left">												
		</div>
	</div>
	
	<div class="div-table">

	
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
									<div class="div-table-col-center"><p class="visualizzaDesc">Codice</p></div>			 
									<div class="div-table-col-center"><p class="visualizzaDesc">Nome</p></div>												
									<div class="div-table-col-center"><p class="visualizzaDesc">Responsabile</p></div>												
									<div class="div-table-col-center"><p class="visualizzaDesc">Dipartimento</p></div>
									<div class="div-table-col-center"><p class="visualizzaDesc">Model applicativo</p></div>
									<div class="div-table-col-center"><p class="visualizzaDesc">Presenza convenzione</p></div>						
									<div class="div-table-col-center"><p class="visualizzaDesc">Modifica</p></div>	
									<div class="div-table-col-center"><p class="visualizzaDesc">Dettaglio</p></div>													
								</div>
							<div class="div-table-row">
								<div class="div-table-col">
								</div>
							</div>		
							
							<c:forEach items="${businessServiceBeanList}" var="item" >
							<div class="div-table-row">				
									<div class="div-table-col-center"><p>${item.codiBusinessService}</p></div>
									<div class="div-table-col-center"><p>${item.textNomeBusinessService}</p></div>										
									<div class="div-table-col-center"><p>${item.persRespBusinessService}</p></div>															
									<div class="div-table-col-center"><p>${item.textSiglaDipartimento}</p></div>
									<div class="div-table-col-center"><p>${item.descModelApplicativo}</p></div>
									<div class="div-table-col-center"><p>${item.flagConvenzione ? 'SI' : 'NO'}</p></div> 													
								<div class="div-table-col-center"><a href="modificaBusinessServiceForm?codiBusinessService=${item.codiBusinessService}"><img src="resources/img/iconeModifica2.jpg"  width="30" height="20" title="Modifica Business Service"></a></div>
								<div class="div-table-col-center"><a href="dettaglioBusinessService?codiBusinessService=${item.codiBusinessService}"><img src="resources/img/dettaglio.jpg"  width="30" height="20" title="Visualizza Dettaglio"></a></div>							
							</div>
							</c:forEach>
						</div> 
		 </fieldset>					
					  </div>
					  
						 <br/>
						<div class="div-table-row">
								<div class="div-table-col-center" >							
											<a href="reportController?report=2"><input TYPE="button" name="Stampa" VALUE="Stampa"></a>				
								</div>	
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
	</div>	
	</div>
	
	 </div>     
</div>
		
