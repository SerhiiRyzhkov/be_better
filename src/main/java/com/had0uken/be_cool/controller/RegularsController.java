package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.utilities.DataClass;
import com.had0uken.be_cool.enums.Status;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.service.TaskService;
import com.had0uken.be_cool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@Controller
public class RegularsController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    private List<Task> regular;


    public RegularsController() {
        regular=new ArrayList<>();
    }


    @RequestMapping("/regular")
    public ModelAndView regular(Authentication authentication){
        ModelAndView modelAndView = new ModelAndView();
        regular = taskService.getTasksByUserAndFrequency(userService.get(authentication.getName()), Frequency.FREQUENT);
        System.out.println(regular);
        modelAndView.addObject("regularAtt",regular);
        modelAndView.addObject("taskAtt", new Task());
        modelAndView.setViewName("regular-views" + DataClass.getSeparator() + "addRegView");
        return modelAndView;
    }

    @RequestMapping("/saveRegTask")
    public ModelAndView saveRegTask(@ModelAttribute("taskAtt") Task task, Authentication authentication){
        ModelAndView modelAndView = new ModelAndView();
        task.setDeadline("2999-01-01");
        task.setUserEmail(authentication.getName());
        task.setScore(0);
        task.setTotal(1);
        task.setStatus(Status.IN_PLAN);
        task.setFrequency(Frequency.FREQUENT);
        taskService.save(task);
        modelAndView.setViewName("redirect: regular");
        return modelAndView;
    }

}
