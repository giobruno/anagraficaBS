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
	
	<div class="div-table-row">
		<div class="div-table-col-left">
						<a href="formBusinessService"><button>Inserisci nuovo Business Service</button></a>						
		</div>
	</div>
	
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
									<div class="div-table-col-center"><p class="visualizzaDesc">Nome Business Service</p></div>						
									<div class="div-table-col-center"><p class="visualizzaDesc" style="align:left;">Modifica</p></div>
									<div class="div-table-col-center"><p class="visualizzaDesc">Cancella</p></div>
														
								</div>
							<div class="div-table-row">
								<div class="div-table-col">
								</div>
							</div>		
							
							<c:forEach items="${businessServiceList}" var="item" >
							<div class="div-table-row">				
								<div class="div-table-col-center"><a href="">${item.textNomeBusinessService}</a></div>								
								<div class="div-table-col-center"><a href="modificaBusinessServiceForm?codiBusinessService=${item.codiBusinessService}"><img src="resources/img/iconeModifica.png"  width="30" height="20" title="Modifica Business Service"></a></div>
								<div class="div-table-col-center"><a href="cancellaBusinessService?codiBusinessService=${item.codiBusinessService}"><img src="resources/img/iconeCancella.png"  width="30" height="20" title="Cancella Business Service"></a></div>
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
					<a href="home"><input TYPE="button" name="Esci" VALUE="Esci"></a>
	</div>	
	</div>
	 </div>     
</div>
		
