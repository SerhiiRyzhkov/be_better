package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.utilities.DataClass;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@EnableTransactionManagement
@Controller
public class DaysController implements TimeScales{
    @Autowired
    private ModelViewFormatter modelViewFormatter;
    private final Type type = Type.DAILY;
    private final Map<LocalDate,String> dates = new LinkedHashMap<>();
    private List<Task> dateTasks=new ArrayList<>();

    @Override
    @RequestMapping(value = {"/days"}, method = RequestMethod.GET)
    public ModelAndView showTypeView(@RequestParam("delta") Integer delta, Authentication authentication) {
        shift(delta);
        ModelAndView modelAndView = modelViewFormatter.showTypeView(authentication,dates,type);
        dateTasks= modelViewFormatter.getToDo();
        return modelAndView;
    }
    @Override
    @RequestMapping(value = "setToday_D")
    public ModelAndView setToday(){
        return modelViewFormatter.setTodayMethod(type);
    }
    @Override
    @RequestMapping(value = {"/complete_D"}, method = RequestMethod.GET)
    public ModelAndView completeTask(@RequestParam("index") Integer index, Authentication authentication) {
        return modelViewFormatter.complete(dateTasks.get(index), type);
    }

    @Override
    @RequestMapping("/addingNewTask_D")
    public ModelAndView addingNewTask(Authentication authentication){
        return modelViewFormatter.addingNewTask(authentication,type);
    }
    @Override
    @RequestMapping("/saveTask_D")
    public ModelAndView saveTask(@ModelAttribute("taskAtt") Task task,Authentication authentication){
        return modelViewFormatter.saveTask(task,authentication,type);
    }
    @Override
    @RequestMapping("/addFrequentlyToday_D")
    public ModelAndView addFreqToday(@RequestParam("index") Integer index, Authentication authentication){
        return modelViewFormatter.addFreqToday(index,authentication,type);
    }

    private void shift(int delta){
        dates.clear();
        if(delta>5) DataClass.setDay(DataClass.getDay().plusDays(delta-5));
        else if(delta<5) DataClass.setDay(DataClass.getDay().minusDays(5-delta));
        LocalDate start = DataClass.getDay().minusDays(5);
        LocalDate end = DataClass.getDay().plusDays(6);
        while (!start.equals(end))
        {
            dates.put(start,start+" "+ start.getDayOfWeek().toString());
            start=start.plusDays(1);
        }
    }

}
