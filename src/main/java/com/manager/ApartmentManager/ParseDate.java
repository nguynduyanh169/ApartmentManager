/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager.ApartmentManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class ParseDate {

    public String parseDateToString(Date date) {
        String s = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            format.parse(date.toString());
            Calendar cal = format.getCalendar();
            s = handleDateToString((Calendar.DAY_OF_MONTH), (cal.get(Calendar.MONTH) + 1), cal.get(Calendar.YEAR));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return s;
    }
    
    private String handleDateToString(int day, int month, int year) {
        String dayS = Integer.toString(day).length() == 1 ? ("0" + Integer.toString(day)) : Integer.toString(day);
        String monthS = Integer.toString(month).length() == 1 ? ("0" + Integer.toString(month)) : Integer.toString(month);
        String yearS = Integer.toString(year);
        
        return dayS + "/" + monthS + "/" + yearS;
    }
}