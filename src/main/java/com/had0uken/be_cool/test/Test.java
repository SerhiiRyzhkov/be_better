package com.had0uken.be_cool.test;

import com.had0uken.be_cool.enums.Type;

import javax.xml.crypto.Data;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
/*        LocalDate date = LocalDate.now();

        System.out.println(date.getMonth().toString());*/
        Type type = Type.valueOf("YEARLY");
        System.out.println(type);

    }
}