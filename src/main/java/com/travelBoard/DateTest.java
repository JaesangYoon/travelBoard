package com.travelBoard;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        // 오늘 날짜 계산
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);

        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("day = " + day);

        // 형식화. yyyy-MM-dd
        Date today = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String reg_date = sdf.format(today);

        System.out.println(reg_date); // 형식화 된 현재 날짜
    }
}
