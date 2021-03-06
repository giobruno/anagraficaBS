<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
 <head>
    <title>AnagraficaBS - Anagrafica Business Services versione 1</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
    <meta name="generator" content="CoffeeCup HTML Editor (www.coffeecup.com)" />
    <meta name="created" content="Fri, 10 May 2013 13:25:28 GMT" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta http-equiv="cache-control" content="no-cache"/>
    
	  <link rel="stylesheet" href="resources/css/normalize.css"/>
      <link rel="stylesheet" href="resources/css/fonts.css"/>
      <link rel="stylesheet" href="resources/css/main.css"/>     
      <script src="resources/js/jquery-1.9.1.min.js"></script>
      <script src="resources/js/maxlength.js"></script>
      <script src="resources/js/abilita_selectbox.js"></script>
      <script src="resources/js/caricaApplicazioni.js"></script>
      <script src="resources/js/check_tutti.js"></script>
      <script src="resources/js/mostraMessaggio.js"></script> 
      <script src="resources/js/confermaSubmit.js"></script>       
      <script src="resources/js/compilaCampoUser.js"></script>  
      <script src="resources/js/popup.js"></script>
      <script src="resources/js/caricaCategoriaInfr.js"></script>
      <script src="resources/js/caricaCategoriaMac.js"></script>    
  </head>
<body >

<div style="height:100%;">
<tiles:insertAttribute name="header" />

<div class="PageWrapBis" id="central">	
<div class="Page">
<tiles:insertAttribute name="menu" />
<br/>
<tiles:insertAttribute name="alertSpace" />
<br/>
<tiles:insertAttribute name="body" />				
</div>
</div>

<tiles:insertAttribute name="footer" />
</div>
</body>

</html>
