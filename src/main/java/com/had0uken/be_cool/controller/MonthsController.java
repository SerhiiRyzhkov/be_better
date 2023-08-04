package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.service.TaskService;
import com.had0uken.be_cool.service.UserService;
import com.had0uken.be_cool.utilities.DataClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@EnableTransactionManagement
@Controller
public class MonthsController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    private Map<LocalDate,Integer> dates;

    private List<Task>regular;

    private List<Task> monthTasks;

    public MonthsController() {
       dates=new LinkedHashMap<>();
    }



    @RequestMapping("/month")
    public ModelAndView month(@RequestParam("delta") Integer delta, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        shift(delta);
        monthTasks = taskService.getTasksByUserAndDateAndType(userService.get(authentication.getName()), DataClass.getDay().getMonth().toString(), Type.MONTHLY);
        regular = taskService.getTasksByUserAndTypeAndFrequency(userService.get(authentication.getName()), Type.MONTHLY,Frequency.FREQUENT);
        modelAndView.addObject("regularAtt",regular);
        modelAndView.addObject("actualDateAtt",LocalDate.now());
        modelAndView.addObject("dayTasksAtt",monthTasks);

        modelAndView.addObject("daysListAtt",dates);
        modelAndView.addObject("rangeAtt", DataClass.getRANGE());
        modelAndView.setViewName("MONTHLY" + "-views" + DataClass.getSeparator() + "months");
        return modelAndView;


    }

    private void shift(int delta){
        dates.clear();
        if(delta>5)DataClass.setDay(DataClass.getDay().plusMonths(delta-5));
        else if(delta<5)DataClass.setDay(DataClass.getDay().minusDays(5-delta));

        LocalDate start = DataClass.getDay().minusMonths(5);
        LocalDate end = DataClass.getDay().plusMonths(6);
        while (start.isBefore(end)){
            dates.put(start,start.getYear());
            start=start.plusMonths(1);
        }
    }
}

