package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.service.UserService;
import com.had0uken.be_cool.utilities.DataClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@EnableTransactionManagement
@Controller

public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping("/admin")
    public ModelAndView adminMenu(Authentication authentication) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        modelAndView.setViewName("admin-views" + DataClass.getSeparator() + "admin-view");
        return modelAndView;
    }

    @RequestMapping("/admin/listOfUsers")
    public ModelAndView modelAndView(Authentication authentication) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        modelAndView.addObject("allUsersAtt", userService.getAll());
        modelAndView.setViewName("admin-views" + DataClass.getSeparator() + "listOfUsers");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/banUser")
    public ModelAndView banUser(@RequestParam("userId") int index) {
        ModelAndView model = new ModelAndView();
        userService.banUser(userService.getAll().get(index));
        model.setViewName("redirect:" + DataClass.getSeparator() + "admin" + DataClass.getSeparator() + "listOfUsers");

        return model;
    }

    @RequestMapping(value = "/admin/unBanUser")
    public ModelAndView unBanUser(@RequestParam("userId") int index) {
        ModelAndView model = new ModelAndView();
        userService.unbanUser(userService.getAll().get(index));
        model.setViewName("redirect:" + DataClass.getSeparator() + "admin" + DataClass.getSeparator() + "listOfUsers");
        return model;
    }

}
