package com.had0uken.be_cool.test;

import javax.xml.crypto.Data;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        LocalDate end = date.plusDays(5);
        LocalDate start = date.minusDays(5);


        while (start.isBefore(end)){
            System.out.println(start);
            start=start.plusDays(1);
        }
    }
}