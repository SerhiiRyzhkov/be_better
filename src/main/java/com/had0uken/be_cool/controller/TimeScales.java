package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.model.Task;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface TimeScales {
    ModelAndView showTypeView(@RequestParam("delta") Integer delta, Authentication authentication);
    ModelAndView setToday();
    ModelAndView addingNewTask(Authentication authentication);
    ModelAndView completeTask(@RequestParam("index") Integer index, Authentication authentication);
    ModelAndView saveTask(@ModelAttribute("taskAtt") Task task, Authentication authentication);
    ModelAndView addFreqToday(@RequestParam("index") Integer index, Authentication authentication);

}
