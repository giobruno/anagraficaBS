function getUser(){
	var user = document.getElementById('user');
	user.value = document.getElementById('nome').value+'.'+document.getElementById('cognome').value;
	user.value = user.value.toLowerCase();
	return user; 
	}

