package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.model.User;
import com.had0uken.be_cool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;


@EnableTransactionManagement
@Controller
public class AuthenticationRegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final String separator;
    public AuthenticationRegistrationController() {
        this.separator= File.separator;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth_and_reg-views" + separator + "login");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newUserAtt", new User());
        modelAndView.setViewName("auth_and_reg-views" + separator + "registration-view");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("newUserAtt") User user
            , @ModelAttribute("pass1Att") String pas1
            , @ModelAttribute("pass2Att") String pas2) {
        ModelAndView modelAndView = new ModelAndView();
            if (!pas1.equals(pas2)) {
                modelAndView.setViewName("auth_and_reg-views" + separator + "registration-view");
                modelAndView.addObject("messageAtt", "Passwords do not match!");
            } else {
                modelAndView.setViewName("auth_and_reg-views" + separator + "succes-registation-view");
                user.setPassword(bCryptPasswordEncoder.encode(pas1));
                user.setEnabled(true);
                userService.save(user);
        }
        return modelAndView;
    }



}