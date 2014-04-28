function getUsername(){
	var username = document.getElementById('username');
	username.value = document.getElementById('nome').value+'.'+document.getElementById('cognome').value;
	username.value = username.value.toLowerCase();
	return username; 
	}

