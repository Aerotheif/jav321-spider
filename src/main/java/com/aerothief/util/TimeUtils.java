package com.aerothief.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeUtils {
    public static SimpleDateFormat formatA=new SimpleDateFormat("yyyy-MM-dd");

    /**
     *
     * @param dateStr yyyy-MM-dd
     * @return
     */
    public static Timestamp stringToTimestamp(String dateStr){
        dateStr=dateStr+" 00:00:00";
        return Timestamp.valueOf(dateStr);
    }
}
