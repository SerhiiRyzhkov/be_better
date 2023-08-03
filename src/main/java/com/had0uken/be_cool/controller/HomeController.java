package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.enums.Status;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.model.User;
import com.had0uken.be_cool.service.TaskService;
import com.had0uken.be_cool.service.UserService;
import org.apache.taglibs.standard.lang.jstl.ELEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    private final int RANGE = 5;

    private List<Task> dayTasks;




    public HomeController() {
        this.separator= File.separator;
        dates = new ArrayList<>();
        day=LocalDate.now();
    }
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView home(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        day=LocalDate.now();
        modelAndView.addObject("rangeAtt",RANGE);
        modelAndView.setViewName("home-views" + separator + "home");
        return modelAndView;

    }
    @RequestMapping(value = {"/days"}, method = RequestMethod.GET)
    public ModelAndView days(@RequestParam("delta") Integer delta, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        shift(delta);
        dayTasks = taskService.getTasksByUserAndDate(userService.get(authentication.getName()),day.toString());


        modelAndView.addObject("actualDateAtt",LocalDate.now());
        modelAndView.addObject("dayTasksAtt",dayTasks);
        modelAndView.addObject("daysListAtt",dates);
        modelAndView.addObject("rangeAtt",RANGE);
        modelAndView.setViewName("home-views" + separator + "days");
        return modelAndView;
    }

    @RequestMapping(value = "setToday")
    public ModelAndView setToday(){
        ModelAndView modelAndView = new ModelAndView();
        day=LocalDate.now();
        modelAndView.setViewName("redirect: days?delta=5");
        return modelAndView;
    }

    @RequestMapping(value = {"/complete"}, method = RequestMethod.GET)
    public ModelAndView completeTask(@RequestParam("index") Integer index, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();

        Task task = dayTasks.get(index);
        switch (task.getStatus()){
            case IN_PROCESS -> task.setStatus(Status.FINISHED);
            case FINISHED -> task.setStatus(Status.IN_PLAN);
            case IN_PLAN -> task.setStatus(Status.FAILED);
            case FAILED -> task.setStatus(Status.IN_PROCESS);
        }
        taskService.save(task);
        modelAndView.setViewName("redirect: days?delta="+RANGE);
        return modelAndView;
    }



    @RequestMapping("/addingNewTask")
    public ModelAndView addingNewTask(Authentication authentication){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("taskAtt", new Task());
    modelAndView.setViewName("home-views" + separator + "addingNewTaskView");
    return modelAndView;
    }

    @RequestMapping("/saveTask")
    public ModelAndView saveTask(@ModelAttribute("taskAtt") Task task,Authentication authentication){
        ModelAndView modelAndView = new ModelAndView();
        task.setDeadline(day.toString());
        task.setUserEmail(authentication.getName());
        task.setScore(0);
        task.setTotal(1);
        task.setStatus(Status.IN_PROCESS);
        task.setType(Type.DAILY);
        taskService.save(task);
        modelAndView.setViewName("redirect: days?delta="+RANGE);
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
