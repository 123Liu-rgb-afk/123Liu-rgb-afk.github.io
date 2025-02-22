package com.lrx.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class WebUtils {
    public static String getYearMonthDay() {
        LocalDateTime ldt = LocalDateTime.now();
        int year = ldt.getYear();
        int monthValue = ldt.getMonthValue();
        int dayOfMonth = ldt.getDayOfMonth();

        String yearMonthDay = year + "/" + monthValue + "/" + dayOfMonth;
        return yearMonthDay;
    }


}
