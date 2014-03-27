<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body onload='document.form.j_username.focus();'>
 
<div class="ContentHome bgA3">

	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
   <fieldset>
	<form name='form' action="<c:url value='/j_spring_security_check' />" method='POST'>
 
		<div class="div-table">	
			<div class="div-table-row">
				<div class="div-table-col">User:</div>
				<div class="div-table-col"><input type='text' name='j_username' id="j_username">
				</div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col">Password:</div>
				<div class="div-table-col"><input type='password' name='j_password' id="j_password">
				</div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col"><input name="login" type="submit" value="submit" />
				</div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col"><input name="reset" type="reset" />
				</div>
			</div>
		</div>
 
	</form>
	</fieldset>
	
	</div>
</body>
