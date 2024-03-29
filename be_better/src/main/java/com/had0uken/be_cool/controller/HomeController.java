package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.utilities.DataClass;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@EnableTransactionManagement
@Controller
public class HomeController {


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView home(Authentication authentication) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        DataClass.setDay(LocalDate.now());
        modelAndView.setViewName("redirect:" + "days" + "?delta=" + DataClass.getRANGE());
        return modelAndView;
    }

    @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
    public ModelAndView about(Authentication authentication) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        DataClass.setDay(LocalDate.now());
        modelAndView.setViewName("home-views" + DataClass.getSeparator() + "about-view");
        return modelAndView;
    }

}