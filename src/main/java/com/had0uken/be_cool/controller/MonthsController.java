package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.utilities.DataClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.*;
@EnableTransactionManagement
@Controller
public class MonthsController implements TimeScales{
    @Autowired
    private ModelViewFormatter modelViewFormatter;
    private final Type type = Type.MONTHLY;
    private final Map<LocalDate,String> dates = new LinkedHashMap<>();
    private List<Task> dateTasks=new ArrayList<>();


    @Override
    @RequestMapping(value = {"/month"}, method = RequestMethod.GET)
    public ModelAndView showTypeView(Integer delta, Authentication authentication) {
        shift(delta);
        ModelAndView modelAndView = modelViewFormatter.showTypeView(authentication,dates,type);
        dateTasks= modelViewFormatter.getToDo();
        return modelAndView;
    }

    @Override
    @RequestMapping(value = "setToday_M")
    public ModelAndView setToday(){
        return modelViewFormatter.setTodayMethod(type);
    }

    @Override
    @RequestMapping("/addingNewTask_M")
    public ModelAndView addingNewTask(Authentication authentication){
        return modelViewFormatter.addingNewTask(authentication,type);
    }

    @Override
    @RequestMapping(value = {"/complete_M"}, method = RequestMethod.GET)
    public ModelAndView completeTask(@RequestParam("index") Integer index, Authentication authentication) {
        return modelViewFormatter.complete(dateTasks.get(index), type);
    }

    @Override
    @RequestMapping("/saveTask_M")
    public ModelAndView saveTask(@ModelAttribute("taskAtt") Task task, Authentication authentication){
        return modelViewFormatter.saveTask(task,authentication,type);
    }

    @Override
    @RequestMapping("/addFrequentlyToday_M")
    public ModelAndView addFreqToday(@RequestParam("index") Integer index, Authentication authentication){
        return modelViewFormatter.addFreqToday(index,authentication,type);
    }

    private void shift(int delta){
        dates.clear();
        if(delta>5)DataClass.setDay(DataClass.getDay().plusMonths(delta-5));
        else if(delta<5)DataClass.setDay(DataClass.getDay().minusDays(5-delta));

        LocalDate start = DataClass.getDay().minusMonths(5);
        LocalDate end = DataClass.getDay().plusMonths(6);
        while (start.isBefore(end)){
            dates.put(start,start.getMonth().toString() + " " + start.getYear());
            start=start.plusMonths(1);
        }
    }
}

