<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body onload='document.form.nome.focus();'>

<div class="ContentHome bgA3">
	
   <fieldset>
	<form name='form' action="registrazione" method='POST'>
 
		<div class="div-table">	
			<div class="div-table-row">
				<div class="div-table-col">Nome: </div>
				<div class="div-table-col"><input type='text' name='nome' id="nome">
				</div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col">Cognome:</div>
				<div class="div-table-col"><input type='text' name='cognome' id="cognome">
				</div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col">User: </div>
				<div class="div-table-col"><input type='text' name='user' id="user">
				</div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col">Email:</div>
				<div class="div-table-col"><input type='email' name='email' id="email">
				</div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col">Password:</div>
				<div class="div-table-col"><input type='password' name='password' id="password">
				</div>
			</div>
			<div class="div-table-row">
				<div class="div-table-col">Conferma Password:</div>
				<div class="div-table-col"><input type='password' name='confermapassword' id="confermapassword">
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
