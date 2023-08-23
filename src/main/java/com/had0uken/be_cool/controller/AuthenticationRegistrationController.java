package com.had0uken.be_cool.controller;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Status;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.model.User;
import com.had0uken.be_cool.service.TaskService;
import com.had0uken.be_cool.service.UserService;
import com.had0uken.be_cool.utilities.DataClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@EnableTransactionManagement
@Controller
public class AuthenticationRegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private String message="";
    private ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        modelAndView.addObject("newUserAtt",new User());
        modelAndView.setViewName("auth_and_reg-views" + DataClass.getSeparator() + "signInUp");
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("newUserAtt") User user, @ModelAttribute("pass1Att") String pas1
            , @ModelAttribute("pass2Att") String pas2) {
        modelAndView.setViewName("redirect: /login");
        if(userService.isPresent(user.getEmail())){
            message="A user is already registered with this e-mail address";
        }
        else if(!user.getEmail().matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}")){
            message="You should use a valid email";
        }
        else if(!pas1.equals(pas2)){
            message="Password do not match";
        }
        else
        {
            message="Registration successful";
            user.setPassword(bCryptPasswordEncoder.encode(pas1));
            user.setEnabled(true);
            userService.save(user);
        }
        modelAndView.addObject("messageAtt",message);
        message="";
    return modelAndView;
    }




//String userEmail, String title, String description, Integer score, Integer total, Status status, Type type, String deadline, Frequency frequency
    private void setStartPackOfTasks(User user){
        List<Task> starterPack = new ArrayList<>();
        //Infrequent
        //YEAR
        starterPack.add(new Task(user.getEmail(),"Save 2000$ for a down payment on a house","Before the end of the year, you need to save up $2,000 for a contribution to the house. This money must be untouchable. Throughout the year I will note how the process goes.",0,2000, Status.IN_PLAN, Type.YEARLY, DataClass.getDeadLine(Type.YEARLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Increase the maximum number of pull-ups to 30 during this year","Practice pull-ups day after day. Bring the maximum number of repetitions to 30 times. And do it this year.",0,30, Status.IN_PLAN, Type.YEARLY, DataClass.getDeadLine(Type.YEARLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Learn Spanish","Spanish is one of the most widely spoken languages in the world. It is spoken by millions of people across different continents and is the official or national language in many countries. Knowing Spanish will allow you to expand your horizons.",0,1, Status.IN_PLAN, Type.YEARLY, DataClass.getDeadLine(Type.YEARLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Find a new job","A new job means new opportunities, better conditions, an opportunity to learn new skills and make new connections.",0,1, Status.IN_PLAN, Type.YEARLY, DataClass.getDeadLine(Type.YEARLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Move to other city","Moving to another city allows you to open up new opportunities that are not available in your city. In addition, a fresh environment will positively affect your well-being and allow you to develop in new areas.",0,1, Status.IN_PLAN, Type.YEARLY, DataClass.getDeadLine(Type.YEARLY), Frequency.INFREQUENT));
        //MONTH
        starterPack.add(new Task(user.getEmail(),"Paint the garage","My garage started to look just awful. Good weather is predicted this month, so the goal is to paint the garage this month.",0,1, Status.IN_PLAN, Type.MONTHLY, DataClass.getDeadLine(Type.MONTHLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Read 2 books on medicine","Examinations soon. And I'm worried that I'm ready for them. So I'll start preparing now. My goal for the month is to read two medical books.",0,2, Status.IN_PLAN, Type.MONTHLY, DataClass.getDeadLine(Type.MONTHLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Help grandma with the garden.","For a long time I promised to come to help my grandmother with the garden. Need to do it this month. As long as the weather is good. Promises must be kept!",0,1, Status.IN_PLAN, Type.MONTHLY, DataClass.getDeadLine(Type.MONTHLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Ask for a pay raise","I put off this conversation for a long time. This month my plan is more than 100% closed. This is a great time to talk to your boss about a raise.",0,1, Status.IN_PLAN, Type.MONTHLY, DataClass.getDeadLine(Type.MONTHLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Register a car at the service station","The car has been making suspicious sounds for several months now. You can't delay any further. Sign up for the service station this month, while the problem has not worsened.",0,1, Status.IN_PLAN, Type.MONTHLY, DataClass.getDeadLine(Type.MONTHLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Run 50 km this month","Conquering the round figure of 50 km will motivate me to go to the stadium in the evening and run.",0,50, Status.IN_PLAN, Type.MONTHLY, DataClass.getDeadLine(Type.MONTHLY), Frequency.INFREQUENT));
        //WEEK
        starterPack.add(new Task(user.getEmail(),"Learn 100 new Spanish words","Week after week I will replenish my vocabulary. The task for this week is 100 new learned words.",0,100, Status.IN_PLAN, Type.WEEKLY, DataClass.getDeadLine(Type.WEEKLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Biking to work at least 2 times","At least 2 times replacing a car with a bicycle will allow me to reduce fuel costs, and also have a positive effect on my health.",0,2, Status.IN_PLAN, Type.WEEKLY, DataClass.getDeadLine(Type.WEEKLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Go to the barbershop","My hair is already terrible. This week I must visit the barbershop and tidy up my hair and beard.",0,1, Status.IN_PLAN, Type.WEEKLY, DataClass.getDeadLine(Type.WEEKLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Go to the cinema","This week is the last when the film I wanted to see is at the box office. There is nowhere to put it off. I have to watch it this week!",0,1, Status.IN_PLAN, Type.WEEKLY, DataClass.getDeadLine(Type.WEEKLY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Successfully close at least 5 deals at work","This week I'm going to be productive. The goal for the week is at least 5 successful trades.",0,5, Status.IN_PLAN, Type.WEEKLY, DataClass.getDeadLine(Type.WEEKLY), Frequency.INFREQUENT));
        //DAY
        starterPack.add(new Task(user.getEmail(),"Clean the apartment","K keeping a house clean is important for a variety of reasons that contribute to physical, mental, and emotional well-being. Today is my the only free day. So I need to do it today",0,1, Status.IN_PLAN, Type.DAILY, DataClass.getDeadLine(Type.DAILY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"30 mins of yoga","It was a difficult week. So, yoga will inevitably help me to relax.",0,1, Status.IN_PLAN, Type.DAILY, DataClass.getDeadLine(Type.DAILY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Go to a gym","Today a leg day! Lets go!!!",0,1, Status.IN_PLAN, Type.DAILY, DataClass.getDeadLine(Type.DAILY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Check job site","Check what new vacancies have been opened this week",0,1, Status.IN_PLAN, Type.DAILY, DataClass.getDeadLine(Type.DAILY), Frequency.INFREQUENT));
        starterPack.add(new Task(user.getEmail(),"Clear out trash in the attic","I've been hoarding junk in the attic for years. Time to deal with it!",0,1, Status.IN_PLAN, Type.DAILY, DataClass.getDeadLine(Type.DAILY), Frequency.INFREQUENT));

        //frequent
        //YEAR
        starterPack.add(new Task(user.getEmail(),"Complete an online course in a new subject area.","Education and self-development is incredibly important. You always need to become the best copy of yourself. Therefore, it is impossible that at least one new skill was not obtained in a year. Online courses in today's realities are a very convenient solution for this. Therefore, the goal is to complete at least 1 online course this year.",0,1, Status.IN_PLAN, Type.YEARLY, DataClass.getDeadLine(Type.YEARLY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"Do not gain weight in a year and stay at your normal weight.","Many people gain weight over the years. I will check my weight at the end of the year and see if I am getting fat.",0,1, Status.IN_PLAN, Type.YEARLY, DataClass.getDeadLine(Type.YEARLY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"Learn a new foreign language","Learning foreign languages will help me in my career, discovering new content and meeting new people.",0,1, Status.IN_PLAN, Type.YEARLY, DataClass.getDeadLine(Type.YEARLY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"At least 1 increasing of salary","You can't stay at the same level of pay as last year. You have to make progress every year.",0,1, Status.IN_PLAN, Type.YEARLY, DataClass.getDeadLine(Type.YEARLY), Frequency.ROUTINE));
        //MONTH
        starterPack.add(new Task(user.getEmail(),"Read at least two new books"," Books are a rich source of knowledge, information, and insights. They provide opportunities to learn about a wide range of topics, from history and science to culture and philosophy.",0,2, Status.IN_PLAN, Type.MONTHLY, DataClass.getDeadLine(Type.MONTHLY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"Save 10% of salary","Set aside at least 10 percent of your salary.",0,1, Status.IN_PLAN, Type.MONTHLY, DataClass.getDeadLine(Type.MONTHLY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"Spend at least 1 weekend with a family","Family is the most important. It is not always possible to spend enough time with them. Therefore, the goal is to spend at least 1 weekend with your family this month, without being distracted by other people or circumstances.",0,1, Status.IN_PLAN, Type.MONTHLY, DataClass.getDeadLine(Type.MONTHLY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"At least 1 volunteerism every month","I'll research local volunteer opportunities and select causes that resonate with me. Creating a calendar of events will help me plan ahead and allocate time for volunteering. By participating in different projects, I'll contribute positively to my community, connect with like-minded individuals, and make a tangible impact.",0,1, Status.IN_PLAN, Type.MONTHLY, DataClass.getDeadLine(Type.MONTHLY), Frequency.ROUTINE));
       //WEEK
        starterPack.add(new Task(user.getEmail(),"Weekly apartment cleaning","A clean house reduces the presence of allergens, dust, and germs that can lead to respiratory issues, allergies, and infections. Regular cleaning helps create a healthier environment for you and your family.",0,1, Status.IN_PLAN, Type.WEEKLY, DataClass.getDeadLine(Type.WEEKLY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"At least 3 workouts a week","Workouts help improve cardiovascular fitness, muscular strength, endurance, flexibility, and balance. This contributes to better overall physical health and functionality.",0,3, Status.IN_PLAN, Type.WEEKLY, DataClass.getDeadLine(Type.WEEKLY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"Go to the barbershop","My hair is already terrible. This week I must visit the barbershop and tidy up my hair and beard.",0,1, Status.IN_PLAN, Type.WEEKLY, DataClass.getDeadLine(Type.WEEKLY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"Go to the cinema","This week is the last when the film I wanted to see is at the box office. There is nowhere to put it off. I have to watch it this week!",0,1, Status.IN_PLAN, Type.WEEKLY, DataClass.getDeadLine(Type.WEEKLY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"Successfully close at least 5 deals at work","This week I'm going to be productive. The goal for the week is at least 5 successful trades.",0,5, Status.IN_PLAN, Type.WEEKLY, DataClass.getDeadLine(Type.WEEKLY), Frequency.ROUTINE));
        //DAY
        starterPack.add(new Task(user.getEmail(),"Clean the apartment","K keeping a house clean is important for a variety of reasons that contribute to physical, mental, and emotional well-being. Today is my the only free day. So I need to do it today",0,1, Status.IN_PLAN, Type.DAILY, DataClass.getDeadLine(Type.DAILY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"30 mins of yoga","It was a difficult week. So, yoga will inevitably help me to relax.",0,1, Status.IN_PLAN, Type.DAILY, DataClass.getDeadLine(Type.DAILY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"Go to a gym","Today a leg day! Lets go!!!",0,1, Status.IN_PLAN, Type.DAILY, DataClass.getDeadLine(Type.DAILY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"Check job site","Check what new vacancies have been opened this week",0,1, Status.IN_PLAN, Type.DAILY, DataClass.getDeadLine(Type.DAILY), Frequency.ROUTINE));
        starterPack.add(new Task(user.getEmail(),"Clear out trash in the attic","I've been hoarding junk in the attic for years. Time to deal with it!",0,1, Status.IN_PLAN, Type.DAILY, DataClass.getDeadLine(Type.DAILY), Frequency.ROUTINE));

    }



}