package com.had0uken.be_cool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@EnableTransactionManagement
@Controller
public class HomeController {
    private final String separator;

    public HomeController() {
        this.separator= File.separator;
    }
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView welcomePage(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home-views" + separator + "home");
        return modelAndView;

    }
}
