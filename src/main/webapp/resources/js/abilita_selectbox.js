function abilita_disabilita(rd){
	
	var bool=(rd.value=='true')?false:true;
			with(document.forms['form']){
				codiArea.disabled=bool;		
				codiArea.value='';
				codiArea.text='--';
		}
	}
