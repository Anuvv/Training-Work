
//	UTILITY CLASS FOR DATE

package com.pkart.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static Date date;
	
	// This function get validated date
	public static Date getDate(String strDate) throws ParseException {

			IValidatDate validator = new ValidateDate("dd/MM/yyyy");
			if(validator.isValid(strDate))
			{
				date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
				return date;
			}
			else
				return null;
	}
}
