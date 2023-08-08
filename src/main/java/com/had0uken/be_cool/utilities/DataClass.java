package com.had0uken.be_cool.utilities;

import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDate;
@Component
public class DataClass {
    private final static String separator= File.separator;
    private final static int RANGE = 5;

    private final static String TERM="2999-12-01";
    private static LocalDate day;
    public DataClass() {
        day=LocalDate.now();
    }

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

    public static String getTERM() {
        return TERM;
    }

}
