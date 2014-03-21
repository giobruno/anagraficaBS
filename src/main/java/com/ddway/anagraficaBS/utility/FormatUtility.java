package com.ddway.anagraficaBS.utility;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FormatUtility {
	
	private static final Logger log = LoggerFactory.getLogger(FormatUtility.class);

    public FormatUtility() {
		
	}
	
	public static Date formattaStringaToData(String pattern, String dataStringa) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = format.parse(dataStringa);
		
		return date;
		
	}
	
	public static String formattaDataToString(String pattern, Date data) throws ParseException{
		SimpleDateFormat dataFormat = new SimpleDateFormat(pattern);
		  StringBuilder dataStringa = new StringBuilder( dataFormat.format( data ) );
		
		
		return dataStringa.toString();
		
	}
	
	public static BigDecimal formattaEuroToBigDecimal( String importoStr) throws ParseException{
		
		BigDecimal importo;
		Locale locale = new Locale("it", "IT");
		NumberFormat format = NumberFormat.getInstance(locale);
		Number number = format.parse(importoStr);
		importo = new BigDecimal(number.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		return importo;
		
	}
	
	public Double formattaEuroToDouble( String importoStr) throws ParseException{
		

	    Double importo;
		Locale locale = new Locale("it", "IT");
		NumberFormat format = NumberFormat.getInstance(locale);
		Number number = format.parse(importoStr);
		importo = new Double(number.doubleValue());
		return importo;
		
	}
	
	public String formattaBigDecimalToString(String pattern, BigDecimal value ) {

		if(value == null)
			return "";
		
		java.text.NumberFormat nf =

				java.text.DecimalFormat.getInstance(java.util.Locale.ITALIAN);
                nf.setMinimumFractionDigits(2);
				return nf.format(value);
	      
	   }
	
	public String formattaDoubleToString(String pattern, Double value ) {
		
			java.text.NumberFormat nf =	java.text.DecimalFormat.getInstance(java.util.Locale.ITALIAN);
	        nf.setMinimumFractionDigits(2);
			return nf.format(value);		      
		   }
	}
