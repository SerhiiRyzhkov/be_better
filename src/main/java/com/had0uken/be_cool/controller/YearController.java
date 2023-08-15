package com.had0uken.be_cool.controller;


import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.utilities.DataClass;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@EnableTransactionManagement
@Controller
public class YearController extends AbstractTimeScalesController implements TimeScales{
    private final Type type = Type.YEARLY;


    @Override
    protected void setType(Type type) {
        super.setType(this.type);
    }

    @RequestMapping(value = {"/years"}, method = RequestMethod.GET)
    @Override
    public ModelAndView showTypeView(Integer delta, Authentication authentication) {
        setType(this.type);
        return super.showTypeView(delta, authentication);
    }

    @RequestMapping(value = "setToday_Y")
    @Override
    public ModelAndView setToday(Authentication authentication) {
        return super.setToday(authentication);
    }

    @RequestMapping(value = {"/complete_Y"}, method = RequestMethod.GET)
    @Override
    public ModelAndView completeTask(Integer index, Authentication authentication) {
        return super.completeTask(index, authentication);
    }
    @RequestMapping(value = {"/transfer_Y"}, method = RequestMethod.GET)
    @Override
    public ModelAndView transferTask(Integer index, Authentication authentication) {
        return super.transferTask(index, authentication);
    }
    @RequestMapping(value = {"/delete_Y"}, method = RequestMethod.GET)
    @Override
    public ModelAndView deleteTask(Integer index, Authentication authentication) {
        return super.deleteTask(index, authentication);
    }
    @RequestMapping("/addingNewTask_Y")
    @Override
    public ModelAndView addingNewTask(Authentication authentication) {
        return super.addingNewTask(authentication);
    }
    @RequestMapping("/setRoutine_Y")
    @Override
    public ModelAndView setRoutine(Authentication authentication)
    {
        return super.setRoutine(authentication);
    }

    @RequestMapping("/saveTask_Y")
    @Override
    public ModelAndView saveTask(Task task, Authentication authentication) {
        return super.saveTask(task, authentication);
    }
    @RequestMapping("/addFrequentlyToday_Y")
    @Override
    public ModelAndView addFreqToday(Integer index, Authentication authentication) {
        return super.addFreqToday(index, authentication);
    }

    @RequestMapping("/postRange_Y")
    @Override
    public ModelAndView postRange(Integer task_index, Integer sliderValue, Authentication authentication) {
        return super.postRange(task_index, sliderValue, authentication);
    }

    protected void shift(int delta){
        super.getDates().clear();
        if(delta>DataClass.getRANGE()) DataClass.setDay(DataClass.getDay().plusYears(delta-DataClass.getRANGE()));
        else if(delta<DataClass.getRANGE())DataClass.setDay(DataClass.getDay().minusYears(DataClass.getRANGE()-delta));

        LocalDate start = DataClass.getDay().minusYears(DataClass.getRANGE());
        LocalDate end = DataClass.getDay().plusYears(DataClass.getRANGE()+1);
        while (start.isBefore(end)){
            super.getDates().put(start, String.valueOf(start.getYear()));
            start=start.plusYears(1);
        }
    }
}