package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Status;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.service.TaskService;
import com.had0uken.be_cool.service.UserService;
import com.had0uken.be_cool.utilities.DataClass;
import com.had0uken.be_cool.utilities.PointCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@EnableTransactionManagement
@Controller
public class StatisticController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @Autowired
    private final PointCounter pointCounter=new PointCounter();

    @RequestMapping("/statistic")
    public ModelAndView statistic(Authentication authentication){
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        modelAndView.setViewName("statistic-views"+DataClass.getSeparator()+"statistic");
        return modelAndView;
    }
    @RequestMapping("/showStat")
    public ModelAndView showStat(String startDate, String endDate, Authentication authentication){
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        List<Task> taskList = taskService.getTasksByUserAndFrequency(userService.get(authentication.getName())
                , Frequency.INFREQUENT).stream().filter(el->
                (DataClass.getLocalDate(el.getDeadline()).isBefore(DataClass.getLocalDate(endDate))&&
                        DataClass.getLocalDate(el.getDeadline()).isAfter(DataClass.getLocalDate(startDate))||
                        DataClass.getLocalDate(el.getDeadline()).isEqual(DataClass.getLocalDate(startDate))||
                        DataClass.getLocalDate(el.getDeadline()).isEqual(DataClass.getLocalDate(endDate)))).
                collect(Collectors.toList());


        if(taskList.size()==0)
        {
            modelAndView.setViewName("statistic-views"+DataClass.getSeparator()+"empty-stat");
            return modelAndView;
        }

        int failed = 0;
        int finished = 0;
        int points = 0;
        for(Task t: taskList){
            if(t.getStatus().equals(Status.FAILED))failed++;
            if(t.getStatus().equals(Status.FINISHED))finished++;
            points+=pointCounter.getPoints(t.getType(),t.getStatus());
        }


        modelAndView.addObject("reportAtt",pointCounter.getReport(finished*100/taskList.size()));
        modelAndView.addObject("FailProcAtt", failed*100/taskList.size());
        modelAndView.addObject("FinishProcAtt", finished*100/taskList.size());
        modelAndView.addObject("pointsAtt",points);
        modelAndView.addObject("finishedAtt",finished);
        modelAndView.addObject("failedAtt",failed);
        modelAndView.addObject("totalAmountAtt",taskList.size());
        modelAndView.addObject("startDateAtt",startDate);
        modelAndView.addObject("endDateAtt",endDate);
        modelAndView.setViewName("statistic-views"+DataClass.getSeparator()+"show-statistic");
        return modelAndView;
    }
}
