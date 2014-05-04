<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <title>AnagraficaBS</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="generator" content="CoffeeCup HTML Editor (www.coffeecup.com)" />
    <meta name="created" content="Fri, 10 May 2013 13:25:28 GMT" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    
	  <link rel="stylesheet" href="resources/css/normalize.css"/>
      <link rel="stylesheet" href="resources/css/fonts.css"/>
      <link rel="stylesheet" href="resources/css/main.css"/>
      
        
  </head>
  <body>
 
<div id="header2">
<div id="imgsx"></div>
<div id="title">Anagrafica dei Servizi di Business</div>
<div id="imgdx"></div>
</div>

			
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
				
		
		<div class="PageWrapBis" id="central">	
			<!-- MAIN PAGE -->
			<div class="Page">
			
				<!-- Homepage left area: ultimi report -->				
				
		<!-- 		<div class="Left">
					<br/>							
						<h3 class="bgAr3"><span class="fG1"></span></h3>
						<h3 class="bgAr3"><span class="fG1"></span></h3>
						<h3 class="bgAr3"><span class="fG1"></span></h3>
						<h3 class="bgAr3"><span class="fG1"></span></h3>
				
					
					
					
				</div>
				<br/>
					 -->
				<!-- End Homepage left area: ultimi report -->
				
				<!-- Homepage central area: in evidenza -->
				<br/>
				
				<div class="ContentHome bgA3">
				
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
			<legend>Errore di sistema</legend>				
						<div class="div-table">
								<div class="div-table-row">							 
									<div class="div-table-col-center"><p class="erroreForm">ERRORE 404!</p> <p class="visualizzaDesc">Riprovare oppure contattare l'assistenza all'indirizzo <a href="mailto:assistenza.utilita@tesoro.it">assistenza.utilita@tesoro.it</a></p></div>																						
								</div>
								<br/>
								<div class="div-table-row">													
									<div class="div-table-col-center"><a href="javascript:history.back()"><p class="visualizzaDesc">Torna alla pagina precedente!</p></a></div>													
								</div>
								<div class="div-table-row">
								<div class="div-table-col">
								</div>
							</div>									
						</div> 
		 </fieldset>		
		 </div></div></div>
					
					
					 


				</div>
			
				
			</div>
			<!-- END MAIN PAGE -->
		</div>
		<!-- End Homepage wrapper -->
		
		<!-- FOOTER -->
		<div class="footerWrap" align="center">
		<footer class="bgB2">
				<div id="quickMenu">
				
				<table width="100%"  style="margin: 0px" cellspacing=0 cellpadding=0>
		<tr height="13px">
			<td align="left" >
				<a href="#"  style="font-size: 10px; font-family: Verdana;color:white;font-weight:bold;"
	onclick="return overlib('<table><tr><td class=label_value_footer align=right nowrap ><b>E-mail:</b></td><td class=label_value>Assistenza.utilita@tesoro.it</td></tr><tr><td align=right class=label_value_footer nowrap><b>Tel.:</b></td><td class=label_value>06 4761 2335</td></tr><tr><td></td><td class=label_value>06 4761 2013</td></tr><tr><td></td><td class=label_value>06 4761 2423</td></tr><tr><td></td><td class=label_value>06 4761 2348</td></tr><tr><td></td><td class=label_value>06 4761 2110</td></tr></table>', TEXTSIZE, '2', TEXTCOLOR, '#373737',  CELLPAD, '10',  STICKY, CAPTION, '&nbsp;:: ASSISTENZA ::', CAPTIONSIZE, '1', CLOSECLICK, CLOSESIZE, '1',SHADOW, WIDTH, 300, HEIGHT, 100, CENTERPOPUP, BGCOLOR, '#444444');"	 onmouseout="return nd();">
	ASSISTENZA
				</a>
			</td>
			<td align="center" width="70%" style="font-size: 11px; font-family: Verdana; color:white;font-weight:bold;">
				Powered By Sogei S.p.A. - 2014
			</td>
			<td align="right" width="15%">
				<a href="#"  style="font-size: 10px; font-family: Verdana;color:white;font-weight:bold;" onclick="return overlib('<table><tr><td align=center><a href=http://www.redhat.it target=_NEW ><img src=/big/images/redhat_icon.png border=0></a></td><td class=label_value nowrap>Sistema Operativo</td></tr><tr><td align=center><a href=http://www.apache.org target=_NEW ><img src=/big/images/apache2_icon.gif border=0></a></td><td class=label_value nowrap>Web Server</td></tr><tr><td align=center><a href=http://www.jboss.org target=_NEW ><img src=/big/images/jboss.jpg border=0></a></td><td class=label_value nowrap>Application Server</td></tr><tr><td align=center><a href=http://www.mysql.com target=_NEW ><img src=/big/images/mysql.gif border=0></a></td><td class=label_value>Database</td></tr><tr><td align=center><a href=http://struts.apache.org/ target=_NEW ><img src=/big/images/struts.jpg border=0></td><td class=label_value nowrap>Framework MVC</td></tr><tr><td align=center><a href=http://www.springframework.org target=_NEW ><img src=/big/images/spring.jpg border=0></a></td><td class=label_value nowrap>Transaction Manager</td></tr><tr><td align=center><a href=http://hibernate.org target=_NEW ><img src=/big/images/hibernate.jpg border=0></a></td><td class=label_value>ORM</td></tr><tr><td align=center><a href=http://www.bosrup.com/web/overlib/ target=_NEW ><img src=/big/images/overlib_icon.png border=0></a></td><td class=label_value nowrap>Tooltip Manager</td></tr><tr><td align=center><a href=http://www.opensymphony.com/osworkflow/ target=_NEW ><img src=/big/images/osworkflow.jpg border=0></a></td><td class=label_value nowrap>OSWorkflow</td></tr></table>', TEXTSIZE, '1', TEXTCOLOR, '#373737',  CELLPAD, '10',  STICKY, CAPTION, '&nbsp;:: CREDITS ::', CAPTIONSIZE, '1', CLOSECLICK, CLOSESIZE, '1',SHADOW, WIDTH, 300, HEIGHT, 200, CENTERPOPUP, BGCOLOR, '#000000');" onmouseout="return nd();"/ >
				CREDITS
				</a>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
				
				
				</div>
			</footer>
	
		</div>
		<!-- END FOOTER -->	
						
		
		
  </body>
</html>