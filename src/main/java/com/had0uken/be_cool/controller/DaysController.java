package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.utilities.DataClass;
import com.had0uken.be_cool.enums.Status;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.service.TaskService;
import com.had0uken.be_cool.service.UserService;
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
import java.util.stream.Collectors;


@EnableTransactionManagement
@Controller
public class DaysController {


    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    private final Map<LocalDate,String> dates;


    private List<Task> dayTasks;

    private List<Task>regular;


    public DaysController() {
        regular=new ArrayList<>();
        dates=new LinkedHashMap<>();
    }

    @RequestMapping(value = {"/days"}, method = RequestMethod.GET)
    public ModelAndView days(@RequestParam("delta") Integer delta, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        shift(delta);
        dayTasks = taskService.getTasksByUserAndDate(userService.get(authentication.getName()),DataClass.getDay().toString());
        regular = taskService.getTasksByUserAndTypeAndFrequency(userService.get(authentication.getName()), Type.DAILY,Frequency.FREQUENT);



        modelAndView.addObject("regularAtt",regular);
        modelAndView.addObject("actualDateAtt",LocalDate.now());
        modelAndView.addObject("dayTasksAtt",dayTasks);
        modelAndView.addObject("daysListAtt",dates);
        modelAndView.addObject("rangeAtt", DataClass.getRANGE());
        modelAndView.setViewName("DAILY-views" + DataClass.getSeparator() + "tasks-view");
        return modelAndView;
    }

    @RequestMapping(value = "setToday")
    public ModelAndView setToday(){
        ModelAndView modelAndView = new ModelAndView();
        DataClass.setDay(LocalDate.now());
        modelAndView.setViewName("redirect: days?delta=5");
        return modelAndView;
    }

    @RequestMapping(value = {"/complete"}, method = RequestMethod.GET)
    public ModelAndView completeTask(@RequestParam("index") Integer index, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();

        Task task = dayTasks.get(index);
        switch (task.getStatus()){
            case IN_PROCESS -> task.setStatus(Status.FINISHED);
            case FINISHED -> task.setStatus(Status.IN_PLAN);
            case IN_PLAN -> task.setStatus(Status.FAILED);
            case FAILED -> task.setStatus(Status.IN_PROCESS);
        }
        taskService.save(task);
        modelAndView.setViewName("redirect: tasks-view?delta="+DataClass.getRANGE());
        return modelAndView;
    }



    @RequestMapping("/addingNewTask")
    public ModelAndView addingNewTask(Authentication authentication){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("taskAtt", new Task());
    modelAndView.setViewName("DAILY-views" + DataClass.getSeparator() + "addingNewTaskView");
    return modelAndView;
    }

    @RequestMapping("/saveTask")
    public ModelAndView saveTask(@ModelAttribute("taskAtt") Task task,Authentication authentication){
        ModelAndView modelAndView = new ModelAndView();
        task.setDeadline(DataClass.getDay().toString());
        task.setUserEmail(authentication.getName());
        task.setScore(0);
        task.setTotal(1);
        task.setStatus(Status.IN_PLAN);
        task.setFrequency(Frequency.INFREQUENT);
        taskService.save(task);
        modelAndView.setViewName("redirect: days?delta="+DataClass.getRANGE());
        return modelAndView;
    }

    @RequestMapping("/addRegularToday")
    public ModelAndView addRegularToday(@RequestParam("index") Integer index, Authentication authentication){
        ModelAndView modelAndView = new ModelAndView();
        Task task = new Task();
        task.setUserEmail(authentication.getName());
        task.setTitle(regular.get(index).getTitle());
        task.setDescription(regular.get(index).getDescription());
        task.setScore(0);
        task.setTotal(1);
        task.setStatus(Status.IN_PLAN);
        task.setDeadline(DataClass.getDay().toString());
        taskService.save(task);
        regular = taskService.getTasksByUserAndFrequency(userService.get(authentication.getName()),Frequency.FREQUENT);

        modelAndView.addObject("regularAtt",regular);
        modelAndView.setViewName("redirect: days?delta="+DataClass.getRANGE());
        return modelAndView;
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
