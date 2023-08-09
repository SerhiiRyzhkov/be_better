package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.model.Task;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Map;

public interface TimeScales {
    ModelAndView showTypeView(@RequestParam("delta") Integer delta, Authentication authentication);
    ModelAndView setToday(Authentication authentication);

    ModelAndView deleteTask(Integer index, Authentication authentication);

    ModelAndView addingNewTask(Authentication authentication);
    ModelAndView completeTask(@RequestParam("index") Integer index, Authentication authentication);
    ModelAndView saveTask(@ModelAttribute("taskAtt") Task task, Authentication authentication);
    ModelAndView addFreqToday(@RequestParam("index") Integer index, Authentication authentication);
    Map<LocalDate, String> getDates();
    ModelAndView postRange(@RequestParam("task_index") Integer task_index,
                                  @RequestParam("sliderValue") Integer sliderValue,
                           Authentication authentication);
    ModelAndView setRoutine(Authentication authentication) ;


}
