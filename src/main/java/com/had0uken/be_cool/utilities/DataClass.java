package com.had0uken.be_cool.utilities;

import com.had0uken.be_cool.enums.Type;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

@Component
public class DataClass {
    private final static String separator= File.separator;
    private final static int RANGE = 5;

    private final static String TERM="2999-12-01";
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public static ModelAndView getModelAndView(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("rangeAtt", DataClass.getRANGE());
        modelAndView.addObject("emailAtt", authentication.getName());
        return modelAndView;
    }

    public static String getUrl(Type type){
        switch (type){
            case DAILY -> {
                return "days";
            }
            case WEEKLY -> {
                return "weeks";
            }
            case MONTHLY -> {
                return "months";
            }
            case YEARLY -> {
                return "years";
            }
        }
        return null;
    }

    public static String getPrefix(Type type){
        switch (type){
            case DAILY -> {
                return "_D";
            }
            case WEEKLY -> {
                return "_W";
            }
            case MONTHLY -> {
                return "_M";
            }
            case YEARLY -> {
                return "_Y";
            }
        }
        return null;
    }

    public static String getDeadLine(Type type){
        switch (type){
            case DAILY -> {
                return DataClass.getDay().toString();
            }
            case WEEKLY -> {
                return DataClass.getDay().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).toString();
            }
            case MONTHLY -> {
                return DataClass.getDay().with(TemporalAdjusters.lastDayOfMonth()).toString();
            }
            case YEARLY -> {
                return DataClass.getDay().with(TemporalAdjusters.lastDayOfYear()).toString();
            }
        }
        return null;
    }

    public static String getScale(Type type){
        switch (type){
            case DAILY -> {return "Day";}
            case WEEKLY -> {return "Week";}
            case MONTHLY -> {return "Month";}
            case YEARLY -> {return "Year";}
        }
        return null;
    }

    public static LocalDate getLocalDate(String date){
        return LocalDate.parse(date, DataClass.getFormatter());
    }

}
