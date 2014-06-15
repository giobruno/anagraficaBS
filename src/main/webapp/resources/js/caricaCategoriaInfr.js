$(document).ready(function(){
 $('#codiProcesso').change(function() {
  $.ajax({
		     type: "GET",
		      url: "caricaCategoriaInfr",		
		      data: "codiProcesso="+document.getElementById("codiProcesso").value,
		      dataType: "xml",
		      success: function(xml) {
		       var select=document.getElementById("codiCategoriaInfr");
		       if ( select ){
		       while ( select.length > 1  )
		       {
		         select.remove(1);
		         }
		    }		    
		       $(xml).find('elemento').each(function(){
		       
		     var value = $(this).find('codice').text();
		     var text = $(this).find('descrizione').text();   
		     var select = document.getElementById("codiCategoriaInfr");    
		     var option = document.createElement('option');
		    
		                option.text = text;
		                option.value = value;
		               
		                try
		                {		                 
		                  select.add(option, null); 
		                }
		                catch(ex)
		                {
		                
		                  select.add(option); 
		                }
		     });
		  
		  }
		 });
		  });	
 
  });
