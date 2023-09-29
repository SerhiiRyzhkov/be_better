package com.had0uken.be_cool.utilities;

import com.had0uken.be_cool.enums.Status;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.model.User;
import com.had0uken.be_cool.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Component
public class PointCounter {
    @Autowired
    private TaskService taskService;

    private final int DAILY_POINTS = 3;
    private final int WEAKLY_POINTS = 5;
    private final int MONTHLY_POINTS = 10;
    private final int YEARLY_POINTS = 50;


    public int getPoints(Type type, Status status) {
        int k = 0;
        if (status.equals(Status.FINISHED)) k = 1;
        if (status.equals(Status.FAILED)) k = -3;

        switch (type) {
            case DAILY -> {
                return k * DAILY_POINTS;
            }
            case WEEKLY -> {
                return k * WEAKLY_POINTS;
            }
            case MONTHLY -> {
                return k * MONTHLY_POINTS;
            }
            case YEARLY -> {
                return k * YEARLY_POINTS;
            }
        }
        return 0;
    }


    public int getCount(User user, LocalDate date, Type type) {
        LocalDate start;
        LocalDate end;
        switch (type) {
            case DAILY -> {
                start = date;
                end = date;
            }
            case WEEKLY -> {
                start = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
                end = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            }

            case MONTHLY -> {
                start = date.withDayOfMonth(1);
                end = date.with(TemporalAdjusters.lastDayOfMonth());
            }
            case YEARLY -> {
                start = date.withDayOfYear(1);
                end = Year.of(date.getYear()).isLeap() ? date.withDayOfYear(366) : date.withDayOfYear(365);
            }
            default -> {
                start = null;
                end = null;
            }
        }
        int result = 0;

        List<Task> tasks = taskService.getTasksByUser(user);

        for (Task task : tasks) {
            LocalDate deadline = DataClass.getLocalDate(task.getDeadline());

            if (deadline.isAfter(start) && deadline.isBefore(end) || deadline.isEqual(date)) {
                result += getPoints(task.getType(), task.getStatus());
            }
        }

        return result;
    }

    public String getReport(int percents) {
        if (percents == 100)
            return "Congratulations! You've successfully completed all your tasks. Your dedication and organization have paid off. Keep up the excellent work next time.";
        else if (percents < 30)
            return "Your task completion rate is below 30%. Keep up the effort and try to accomplish more tasks next time.";
        else if (percents < 60)
            return "You've completed less than 60% of your tasks. There's room for improvement. Focus on managing your tasks effectively to achieve better results.";
        else
            return "Your task completion rate is impressive, but there's still some room for improvement. Aim for even higher completion rates in the upcoming period to maximize your productivity.";
    }


}
