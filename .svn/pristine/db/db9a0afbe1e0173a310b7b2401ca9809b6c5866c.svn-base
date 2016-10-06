/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucll.r0452425_tasks.ui.controller;

import com.ucll.tasks_domain.model.TasksUser;
import com.ucll.tasks_domain.service.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Tom
 */
@Controller
@SessionAttributes({"loggedInUserId", "weather"})
public class LoginController extends TasksController {
    
    @RequestMapping("/login")
    public ModelAndView showLogin(){
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("weather", service.getWeather());
        return mav;
    }
    
    @RequestMapping("/processLogin")
    public ModelAndView processLogin(@RequestParam(value="email") String email, @RequestParam(value="password") String password) throws ServiceException{
        TasksUser loggedInUser = service.getAuthenticatedUser(email, password);
        ModelAndView mav;
        if(loggedInUser==null){
            mav = new ModelAndView("login");
            mav.addObject("error", "The email address and password do not match. Please try again");
            mav.addObject("email", email);
        }
        else {
            mav = new ModelAndView(new RedirectView("overviewTasks.htm?category=0", false, true, false));
            mav.addObject("loggedInUserId", loggedInUser.getId());
        }
        return mav;
    }
    
}
