package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class IsWithinTm {

    public static boolean withinFive(String crtTm,String updTm) throws ParseException {
    String crtTime = crtTm;
    Calendar c1 = Calendar.getInstance();
        c1.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(crtTime));
    String updTime = updTm;
    Calendar c2= Calendar.getInstance();
        c2.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(updTime));
    long i = c2.getTimeInMillis()-c1.getTimeInMillis();
    long result = i / (1000 * 60);
        System.out.println("time within "+result);
        if (result<=5){
            return true;
        }else {
            return false;
        }
    }
}
