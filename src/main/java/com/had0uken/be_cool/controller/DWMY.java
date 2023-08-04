package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.service.TaskService;
import com.had0uken.be_cool.service.UserService;
import com.had0uken.be_cool.utilities.DataClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
public class DWMY {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;



    public ModelAndView tes(Authentication authentication, List<Task> dayTasks, List<Task>regular, Map<LocalDate,String> dates){
        ModelAndView modelAndView = new ModelAndView();

        dayTasks = taskService.getTasksByUserAndDate(userService.get(authentication.getName()), DataClass.getDay().toString());
        regular = taskService.getTasksByUserAndTypeAndFrequency(userService.get(authentication.getName()), Type.DAILY, Frequency.FREQUENT);



        modelAndView.addObject("regularAtt",regular);
        modelAndView.addObject("actualDateAtt", LocalDate.now());
        modelAndView.addObject("dayTasksAtt",dayTasks);
        modelAndView.addObject("daysListAtt",dates);
        modelAndView.addObject("rangeAtt", DataClass.getRANGE());
        modelAndView.setViewName("DAILY-views" + DataClass.getSeparator() + "tasks-view");
        return modelAndView;
    }
}
