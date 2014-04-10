var checkflag = "false";

function check(field) {
	
	if (checkflag == "false") {
		for ( var i = 0; i < field.length; i++) {
			field[i].checked = true;}
		checkflag = "true";
		return "Deseleziona tutti"; 
		}
	else {
		for (var ii = 0; ii < field.length; ii++) {
			field[ii].checked = false; }
		checkflag = "false";
		return "Seleziona tutti"; 
		}
	}

