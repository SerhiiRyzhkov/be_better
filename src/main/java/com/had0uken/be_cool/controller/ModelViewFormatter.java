package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Status;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.service.TaskService;
import com.had0uken.be_cool.service.UserService;
import com.had0uken.be_cool.utilities.DataClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
@Component
public class ModelViewFormatter {


    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    private List<Task> toDo;
    private List<Task> frequently;


    public List<Task> getToDo() {
        return toDo;
    }

    public ModelAndView postRange(Authentication authentication,Integer task_index, Integer sliderValue, Type type){
        ModelAndView modelAndView = new ModelAndView();
        taskService.updateTaskScore(toDo.get(task_index),sliderValue);
        modelAndView.setViewName("redirect: "+getUrl(type)+ "?delta=5");
        return modelAndView;
    }

    public ModelAndView showTypeView(Authentication authentication, Map<LocalDate,String> dates, Type type){
        ModelAndView modelAndView = new ModelAndView();
        toDo = taskService.getTasksByUserAndDateAndType(userService.get(authentication.getName()), getDeadLine(type),type);
        frequently= taskService.getTasksByUserAndTypeAndFrequency(userService.get(authentication.getName()), type, Frequency.FREQUENT);
        modelAndView.addObject("urlAtt", getUrl(type));
        modelAndView.addObject("prefixAtt",getPrefix(type));
        modelAndView.addObject("frequentlyAtt", frequently);
        modelAndView.addObject("actualDateAtt", LocalDate.now());
        modelAndView.addObject("toDoAtt", toDo);
        modelAndView.addObject("datesListAtt",dates);
        modelAndView.addObject("rangeAtt", DataClass.getRANGE());
        modelAndView.setViewName(type+"-views" + DataClass.getSeparator() + "tasks-view");
        return modelAndView;
    }

    public ModelAndView setTodayMethod(Type type){
        ModelAndView modelAndView = new ModelAndView();
        DataClass.setDay(LocalDate.now());
        modelAndView.setViewName("redirect: "+getUrl(type)+ "?delta=5");
        return modelAndView;
    }

    private String getUrl(Type type){
        switch (type){
            case DAILY -> {
                return "days";
            }
            case WEEKLY -> {
                return "weeks";
            }
            case MONTHLY -> {
                return "month";
            }
            case YEARLY -> {
                return "years";
            }
        }
        return null;
    }

    private String getPrefix(Type type){
        switch (type){
            case DAILY -> {
                return "_D";
            }
            case WEEKLY -> {
                return "_W";
            }
            case MONTHLY -> {
                return "_M";
            }
            case YEARLY -> {
                return "_Y";
            }
        }
        return null;
    }

    private String getDeadLine(Type type){
        switch (type){
            case DAILY -> {
                return DataClass.getDay().toString();
            }
            case WEEKLY -> {
                return DataClass.getDay().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).toString();
            }
            case MONTHLY -> {
                return DataClass.getDay().with(TemporalAdjusters.lastDayOfMonth()).toString();
            }
            case YEARLY -> {
                return DataClass.getDay().with(TemporalAdjusters.lastDayOfYear()).toString();
            }
        }
        return null;
    }
    public ModelAndView complete(Task task, Type type){
        ModelAndView modelAndView = new ModelAndView();
        switch (task.getStatus()){
            case IN_PROCESS -> task.setStatus(Status.FINISHED);
            case FINISHED -> task.setStatus(Status.IN_PLAN);
            case IN_PLAN -> task.setStatus(Status.FAILED);
            case FAILED -> task.setStatus(Status.IN_PROCESS);
        }
        taskService.save(task);
        modelAndView.setViewName("redirect: "+getUrl(type)+"?delta="+DataClass.getRANGE());

        return modelAndView;
    }


    public ModelAndView addingNewTask(Authentication authentication, Type type){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("taskAtt", new Task());
        modelAndView.addObject("prefixAtt",getPrefix(type));
        modelAndView.setViewName(type+"-views"+ DataClass.getSeparator() + "addingNewTaskView");
        return modelAndView;
    }

    public ModelAndView saveTask(Task task, Authentication authentication, Type type){
        ModelAndView modelAndView = new ModelAndView();
        task.setDeadline(getDeadLine(type));
        task.setUserEmail(authentication.getName());
        task.setScore(0);
        if(task.getTotal()==null)task.setTotal(1);
        task.setStatus(Status.IN_PLAN);
        task.setType(type);
        task.setFrequency(Frequency.INFREQUENT);
        taskService.save(task);
        modelAndView.setViewName("redirect: "+getUrl(type)+"?delta="+DataClass.getRANGE());
        return modelAndView;
    }

    public ModelAndView addFreqToday(@RequestParam("index") Integer index, Authentication authentication, Type type){
        ModelAndView modelAndView = new ModelAndView();
        Task task = new Task();
        task.setUserEmail(authentication.getName());
        task.setTitle(frequently.get(index).getTitle());
        task.setDescription(frequently.get(index).getDescription());
        task.setScore(0);
        task.setTotal(1);
        task.setStatus(Status.IN_PLAN);
        task.setDeadline(DataClass.getDay().toString());
        taskService.save(task);
        frequently = taskService.getTasksByUserAndFrequency(userService.get(authentication.getName()),Frequency.FREQUENT);
        modelAndView.addObject("frequentlyAtt",frequently);
        modelAndView.setViewName("redirect: "+getUrl(type)+"?delta="+DataClass.getRANGE());
        return modelAndView;
    }

}