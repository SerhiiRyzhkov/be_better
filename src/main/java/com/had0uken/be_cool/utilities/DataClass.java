package com.had0uken.be_cool.utilities;

import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDate;
@Component
public class DataClass {
    private static String separator= File.separator;
    private static LocalDate day;

    public DataClass() {
        day=LocalDate.now();
    }

    private static int RANGE = 5;

    public static String getSeparator() {
        return separator;
    }

    public static LocalDate getDay() {
        return day;
    }

    public static void setDay(LocalDate day) {
        DataClass.day = day;
    }

    public static int getRANGE() {
        return RANGE;
    }

}
