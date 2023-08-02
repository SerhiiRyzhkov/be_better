package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.model.User;
import com.had0uken.be_cool.service.TaskService;
import com.had0uken.be_cool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@EnableTransactionManagement
@Controller
public class HomeController {


    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    private final String separator;

    private List<LocalDate> dates;

    private LocalDate day;




    public HomeController() {
        this.separator= File.separator;
        dates = new ArrayList<>();
        day=LocalDate.now();
    }
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView home(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        day=LocalDate.now();
        modelAndView.setViewName("home-views" + separator + "home");
        return modelAndView;

    }
    @RequestMapping(value = {"/days"}, method = RequestMethod.GET)
    public ModelAndView days(@RequestParam("delta") Integer delta, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();

        shift(delta);
        System.out.println("here19!");

        System.out.println(userService.get(authentication.getName()));

        List<Task> dayTasks = taskService.getTasksByUser(userService.get(authentication.getName()));



        modelAndView.addObject("dayTasksAtt",dayTasks);
        modelAndView.addObject("daysListAtt",dates);
        modelAndView.setViewName("home-views" + separator + "days");
        return modelAndView;
    }

    private void shift(int delta){
        dates.clear();
        if(delta>5)
            day=day.plusDays(delta-5);
        else if(delta<5)
            day=day.minusDays(5-delta);
        LocalDate start = day.minusDays(5);
        LocalDate end = day.plusDays(6);
        while (!start.equals(end))
        {
            dates.add(start);
            start=start.plusDays(1);
        }
    }
}
