<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="ContentHome" align="center" onload='document.form.j_username.focus();'>
	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	<form name='form' action="<c:url value='/j_spring_security_check' />" method='POST'>
	<div class="panelGeneric" style="width: 620px; height: 300px;" align="center">
		<img alt="logo Anagrafica BS" src="resources/img/logo1.png" height="60">
		<div id="panelIn">
			<div class="div-table-centrata" style="background:transparent; height: 100%;"> 
				<div class="div-table-row-center"> 
			 		<div class="div-table-col-center">User:</div>
					<div class="div-table-col-center"><input type='text' name='j_username' id="j_username"></div>
				</div>
				<div class="div-table-row-center"> 
					<div class="div-table-col-center">Passowrd:</div>
					<div class="div-table-col-center"><input type='password' name='j_password' id="j_password"></div>
				</div>
				<div class="div-table-row-center" >  
					<div class="div-table-col-center"><input name="login" type="submit" value="Conferma" class="submit" style="width:90px; height:35px"/></div>
					<div class="div-table-col-center"><input name="reset" type="reset" value="Reimposta" class="submit" style="width:90px; height:35px"/></div>
				</div>
			</div>
		</div>
	</div>  
	</form>
</div> 
 
    