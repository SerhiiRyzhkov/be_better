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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public abstract class TaskManager {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    private Frequency frequency;
    private Type type;



    private List<Task> getList(Authentication authentication,Type type){
        return taskService.getTasksByUserAndTypeAndFrequency(userService.get(authentication.getName()),this.type,this.frequency);
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


        protected ModelAndView showLists(Authentication authentication, Type type, Frequency frequency){
            setType(type);
            setFrequency(frequency);
            ModelAndView modelAndView = DataClass.getModelAndView(authentication);
            modelAndView.addObject("typesAtt",Type.values());
            modelAndView.addObject("listAtt", getList(authentication,getType()));
            modelAndView.addObject("typeAtt",type);
            modelAndView.addObject("frequencyAtt",frequency.toString().toLowerCase());
            modelAndView.setViewName("task-management-views"+ DataClass.getSeparator()+"show-tasks-view");
             return modelAndView;
        }

        protected ModelAndView deleteTask(Authentication authentication, long id){
            ModelAndView modelAndView = DataClass.getModelAndView(authentication);
            taskService.delete(taskService.getById(id));
            modelAndView.setViewName("redirect: /"+frequency.toString().toLowerCase()+"?type="+type);
            return modelAndView;
        }

        protected ModelAndView updateTask(Authentication authentication, int id){
            ModelAndView modelAndView = DataClass.getModelAndView(authentication);
            Task task = taskService.getById(id);
            modelAndView.addObject("idAtt",task.getId());
            modelAndView.addObject("taskAtt",task);
            modelAndView.addObject("freqAtt",frequency.toString().toLowerCase());
            modelAndView.setViewName("task-management-views"+ DataClass.getSeparator()+"add-or-update-task-view");
            return modelAndView;
        }

        protected ModelAndView saveOrUpdateTask(Authentication authentication, Task task, long id){
            ModelAndView modelAndView = DataClass.getModelAndView(authentication);
            task.setType(type);
            task.setStatus(Status.IN_PLAN);
            task.setUserEmail(authentication.getName());
            task.setDeadline(DataClass.getTERM());
            task.setFrequency(frequency);
            task.setScore(0);
            if(task.getTotal()==null)task.setTotal(1);
            taskService.saveOrUpdate(task);
            modelAndView.setViewName("redirect: /"+frequency.toString().toLowerCase()+"?type="+type);
            return modelAndView;
        }

        protected ModelAndView addNewTask(Authentication authentication){
            ModelAndView modelAndView = DataClass.getModelAndView(authentication);
            modelAndView.addObject("period",!type.equals(Type.DAILY));
            modelAndView.addObject("taskAtt",new Task());
            modelAndView.addObject("idAtt",0);
            modelAndView.addObject("typeAtt",type.toString());
            modelAndView.addObject("freqAtt",frequency.toString().toLowerCase());
            modelAndView.setViewName("task-management-views"+ DataClass.getSeparator()+"add-or-update-task-view");
            return modelAndView;
        }

}
