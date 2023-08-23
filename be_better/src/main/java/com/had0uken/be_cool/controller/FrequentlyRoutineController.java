package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@EnableTransactionManagement
@Controller
public class FrequentlyRoutineController extends TaskManager {


    @RequestMapping("/frequent")
    public ModelAndView showListsF(@RequestParam("type") String scale, Authentication authentication) {
        return super.showLists(authentication, Type.valueOf(scale), Frequency.FREQUENT);
    }

    @RequestMapping("/routine")
    public ModelAndView showListsR(@RequestParam("type") String scale, Authentication authentication) {
        return super.showLists(authentication, Type.valueOf(scale), Frequency.ROUTINE);
    }

    @RequestMapping("/deleteTask")
    public ModelAndView deleteTask(Authentication authentication, @RequestParam("id") int id) {
        return super.deleteTask(authentication, id);
    }

    @RequestMapping("/updateTask")
    public ModelAndView updateTask(Authentication authentication, @RequestParam("id") int id) {
        return super.updateTask(authentication, id);
    }

    @RequestMapping("/saveTask")
    public ModelAndView saveOrUpdate(Authentication authentication, @ModelAttribute("taskAtt") Task task, @RequestParam("id") long id) {
        return super.saveOrUpdateTask(authentication, task, id);
    }

    @RequestMapping("addNewTask")
    public ModelAndView addNewTask(Authentication authentication) {
        return super.addNewTask(authentication);
    }

}