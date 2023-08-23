package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Status;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.service.TaskService;
import com.had0uken.be_cool.service.UserService;
import com.had0uken.be_cool.utilities.DataClass;
import com.had0uken.be_cool.utilities.PointCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;

@Component
public class ModelViewFormatter {


    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @Autowired
    private final PointCounter pointCounter = new PointCounter();
    private List<Task> toDo;
    private List<Task> frequently;

    public List<Task> getToDo() {
        return toDo;
    }

    public ModelAndView postRange(Authentication authentication, Integer task_index, Integer sliderValue, Type type) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        taskService.updateTaskScore(toDo.get(task_index), sliderValue);
        modelAndView.setViewName("redirect: " + DataClass.getUrl(type) + "?delta=" + DataClass.getRANGE());
        return modelAndView;
    }

    public ModelAndView showTypeView(Authentication authentication, Map<LocalDate, String> dates, Type type) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        toDo = taskService.getTasksByUserAndDateAndType(userService.get(authentication.getName()), DataClass.getDeadLine(type), type);
        frequently = taskService.getTasksByUserAndTypeAndFrequency(userService.get(authentication.getName()), type, Frequency.FREQUENT);
        modelAndView.addObject("urlAtt", DataClass.getUrl(type));
        modelAndView.addObject("scaleAtt", DataClass.getUrl(type).toUpperCase());
        modelAndView.addObject("prefixAtt", DataClass.getPrefix(type));
        modelAndView.addObject("frequentlyAtt", frequently);
        modelAndView.addObject("actualDateAtt", LocalDate.now());
        modelAndView.addObject("toDoAtt", toDo);
        modelAndView.addObject("rangeAtt", DataClass.getRANGE());
        modelAndView.addObject("datesListAtt", dates);
        modelAndView.addObject("typeAtt", DataClass.getScale(type));
        modelAndView.addObject("pointsAtt", pointCounter.getCount(userService.get(authentication.getName()), DataClass.getDay(), type));
        modelAndView.addObject("showRangeAtt", !type.equals(Type.DAILY));
        modelAndView.setViewName("scale-views" + DataClass.getSeparator() + "tasks-view");
        return modelAndView;
    }

    public ModelAndView setTodayMethod(Authentication authentication, Type type) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        DataClass.setDay(LocalDate.now());
        modelAndView.setViewName("redirect: " + DataClass.getUrl(type) + "?delta=" + DataClass.getRANGE());
        return modelAndView;
    }


    public ModelAndView complete(Task task, Type type, Authentication authentication) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        switch (task.getStatus()) {
            case IN_PROCESS -> task.setStatus(Status.FINISHED);
            case FINISHED -> task.setStatus(Status.IN_PLAN);
            case IN_PLAN -> task.setStatus(Status.FAILED);
            case FAILED -> task.setStatus(Status.IN_PROCESS);
        }
        taskService.update(task);
        modelAndView.setViewName("redirect: " + DataClass.getUrl(type) + "?delta=" + DataClass.getRANGE());

        return modelAndView;
    }

    public ModelAndView transfer(Task task, Type type, Authentication authentication) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        Task copy = taskService.getCopy(task);
        copy.setDeadline(DataClass.getLocalDate(task.getDeadline()).plusDays(1).toString());
        copy.setStatus(Status.IN_PLAN);
        taskService.save(copy);
        modelAndView.setViewName("redirect: " + DataClass.getUrl(type) + "?delta=" + DataClass.getRANGE());
        return modelAndView;
    }

    public ModelAndView delete(Task task, Type type, Authentication authentication) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        taskService.delete(task);
        modelAndView.setViewName("redirect: " + DataClass.getUrl(type) + "?delta=" + DataClass.getRANGE());

        return modelAndView;
    }


    public ModelAndView addingNewTask(Authentication authentication, Type type) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        modelAndView.addObject("taskAtt", new Task());
        modelAndView.addObject("scaleAtt", DataClass.getUrl(type).toUpperCase());
        modelAndView.addObject("period", !type.equals(Type.DAILY));
        modelAndView.addObject("prefixAtt", DataClass.getPrefix(type));
        modelAndView.addObject("pointsAtt", pointCounter.getCount(userService.get(authentication.getName()), DataClass.getDay(), type));
        modelAndView.addObject("urlAtt", DataClass.getUrl(type));
        modelAndView.addObject("rangeAtt", DataClass.getRANGE());
        modelAndView.addObject("typeAtt", type);
        modelAndView.setViewName("scale-views" + DataClass.getSeparator() + "addingNewTaskView");
        return modelAndView;
    }

    public ModelAndView setRoutine(Authentication authentication, Type type) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        modelAndView.addObject("prefixAtt", DataClass.getPrefix(type));
        List<Task> routine = taskService.getTasksByUserAndTypeAndFrequency(userService.get(authentication.getName()), type, Frequency.ROUTINE);
        routine.stream()
                .map(r -> {
                    Task task = taskService.getCopy(r);
                    task.setFrequency(Frequency.INFREQUENT);
                    task.setType(type);
                    task.setDeadline(DataClass.getDeadLine(type));
                    return task;
                })
                .forEach(taskService::save);
        modelAndView.setViewName("redirect: " + DataClass.getUrl(type) + "?delta=" + DataClass.getRANGE());
        return modelAndView;
    }

    public ModelAndView saveTask(Task task, Authentication authentication, Type type) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        task.setDeadline(DataClass.getDeadLine(type));
        task.setUserEmail(authentication.getName());
        task.setScore(0);
        if (task.getTotal() == null) task.setTotal(1);
        task.setStatus(Status.IN_PLAN);
        task.setType(type);
        task.setFrequency(Frequency.INFREQUENT);
        taskService.save(task);
        modelAndView.setViewName("redirect: " + DataClass.getUrl(type) + "?delta=" + DataClass.getRANGE());
        return modelAndView;
    }

    public ModelAndView addFreqToday(@RequestParam("index") Integer index, Authentication authentication, Type type) {
        ModelAndView modelAndView = DataClass.getModelAndView(authentication);
        Task task = new Task();
        task.setUserEmail(authentication.getName());
        task.setTitle(frequently.get(index).getTitle());
        task.setDescription(frequently.get(index).getDescription());
        task.setScore(0);
        task.setTotal(1);
        task.setStatus(Status.IN_PLAN);
        task.setType(type);
        task.setFrequency(Frequency.INFREQUENT);
        task.setDeadline(DataClass.getDay().toString());
        taskService.save(task);
        frequently = taskService.getTasksByUserAndFrequency(userService.get(authentication.getName()), Frequency.FREQUENT);
        modelAndView.addObject("frequentlyAtt", frequently);
        modelAndView.setViewName("redirect: " + DataClass.getUrl(type) + "?delta=" + DataClass.getRANGE());
        return modelAndView;
    }


}