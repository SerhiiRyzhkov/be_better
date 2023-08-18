package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.utilities.DataClass;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;


@EnableTransactionManagement
@Controller
public class DaysController extends AbstractTimeScalesController implements TimeScales{
    private final Type type = Type.DAILY;


    @Override
    protected void setType(Type type) {
        super.setType(this.type);
    }

    @RequestMapping(value = {"/days"}, method = RequestMethod.GET)
    @Override
    public ModelAndView showTypeView(Integer delta, Authentication authentication) {
        setType(this.type);
        return super.showTypeView(delta, authentication);
    }

    @RequestMapping(value = "setToday_D")
    @Override
    public ModelAndView setToday(Authentication authentication) {
        return super.setToday(authentication);
    }

    @RequestMapping(value = {"/complete_D"}, method = RequestMethod.GET)
    @Override
    public ModelAndView completeTask(Integer index, Authentication authentication) {
        return super.completeTask(index, authentication);
    }
    @RequestMapping(value = {"/transfer_D"}, method = RequestMethod.GET)
    @Override
    public ModelAndView transferTask(Integer index, Authentication authentication) {
        return super.transferTask(index, authentication);
    }

    @RequestMapping(value = {"/delete_D"}, method = RequestMethod.GET)
    @Override
    public ModelAndView deleteTask(Integer index, Authentication authentication) {
        return super.deleteTask(index, authentication);
    }

    @RequestMapping("/addingNewTask_D")
    @Override
    public ModelAndView addingNewTask(Authentication authentication) {
        return super.addingNewTask(authentication);
    }

    @RequestMapping("/setRoutine_D")
    @Override
    public ModelAndView setRoutine(Authentication authentication)
    {
        return super.setRoutine(authentication);
    }


    @RequestMapping("/saveTask_D")
    @Override
    public ModelAndView saveTask(Task task, Authentication authentication) {
        return super.saveTask(task, authentication);
    }
    @RequestMapping("/addFrequentlyToday_D")
    @Override
    public ModelAndView addFreqToday(Integer index, Authentication authentication) {
        return super.addFreqToday(index, authentication);
    }

    protected void shift(int delta){
        super.getDates().clear();
        if(delta>DataClass.getRANGE()) DataClass.setDay(DataClass.getDay().plusDays(delta-DataClass.getRANGE()));
        else if(delta<DataClass.getRANGE()) DataClass.setDay(DataClass.getDay().minusDays(DataClass.getRANGE()-delta));
        LocalDate start = DataClass.getDay().minusDays(DataClass.getRANGE());
        LocalDate end = DataClass.getDay().plusDays(DataClass.getRANGE()+1);
        while (!start.equals(end))
        {
            super.getDates().put(start,start.getMonthValue()+"-"+start.getDayOfMonth()+"\n"+ start.getDayOfWeek().toString());
            start=start.plusDays(1);
        }
    }

}
