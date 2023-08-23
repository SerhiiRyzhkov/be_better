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
public class WeekController extends AbstractTimeScalesController implements TimeScales {
    private final Type type = Type.WEEKLY;


    @Override
    protected void setType(Type type) {
        super.setType(this.type);
    }

    @RequestMapping(value = {"/weeks"}, method = RequestMethod.GET)
    @Override
    public ModelAndView showTypeView(Integer delta, Authentication authentication) {
        setType(this.type);
        return super.showTypeView(delta, authentication);
    }

    @RequestMapping(value = "setToday_W")
    @Override
    public ModelAndView setToday(Authentication authentication) {
        return super.setToday(authentication);
    }

    @RequestMapping(value = {"/complete_W"}, method = RequestMethod.GET)
    @Override
    public ModelAndView completeTask(Integer index, Authentication authentication) {
        return super.completeTask(index, authentication);
    }

    @RequestMapping(value = {"/transfer_W"}, method = RequestMethod.GET)
    @Override
    public ModelAndView transferTask(Integer index, Authentication authentication) {
        return super.transferTask(index, authentication);
    }


    @RequestMapping(value = {"/delete_W"}, method = RequestMethod.GET)
    @Override
    public ModelAndView deleteTask(Integer index, Authentication authentication) {
        return super.deleteTask(index, authentication);
    }

    @RequestMapping("/addingNewTask_W")
    @Override
    public ModelAndView addingNewTask(Authentication authentication) {
        return super.addingNewTask(authentication);
    }

    @RequestMapping("/setRoutine_W")
    @Override
    public ModelAndView setRoutine(Authentication authentication) {
        return super.setRoutine(authentication);
    }

    @RequestMapping("/saveTask_W")
    @Override
    public ModelAndView saveTask(Task task, Authentication authentication) {
        return super.saveTask(task, authentication);
    }

    @RequestMapping("/addFrequentlyToday_W")
    @Override
    public ModelAndView addFreqToday(Integer index, Authentication authentication) {
        return super.addFreqToday(index, authentication);
    }

    @RequestMapping("/postRange_W")
    @Override
    public ModelAndView postRange(Integer task_index, Integer sliderValue, Authentication authentication) {
        return super.postRange(task_index, sliderValue, authentication);
    }

    protected void shift(int delta) {
        super.getDates().clear();
        if (delta > DataClass.getRANGE()) DataClass.setDay(DataClass.getDay().plusWeeks(delta - DataClass.getRANGE()));
        else if (delta < DataClass.getRANGE())
            DataClass.setDay(DataClass.getDay().minusWeeks(DataClass.getRANGE() - delta));

        LocalDate start = DataClass.getDay().minusWeeks(DataClass.getRANGE());
        LocalDate end = DataClass.getDay().plusWeeks(DataClass.getRANGE() + 1);
        while (start.isBefore(end)) {
            super.getDates().put(start, start.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).toString().substring(8) +
                    "-" + start.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).toString().substring(8) + " " + start.getMonth());
            start = start.plusWeeks(1);
        }
    }
}