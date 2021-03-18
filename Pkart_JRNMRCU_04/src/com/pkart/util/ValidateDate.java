
//	UTILITY CLASS TO VALIDATE DATE

package com.pkart.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidateDate implements IValidatDate {
    private String dateFormat;

    public ValidateDate(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    // This function validates the date
    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}
