/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucll.r0452425_tasks.ui.controller;

import com.ucll.tasks_domain.model.TasksUser;
import com.ucll.tasks_domain.service.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Tom
 */
@Controller
public class RegisterController extends TasksController {
    
    @RequestMapping("/register")
    public ModelAndView showRegister(){
        return new ModelAndView("register");
    }
    
    @RequestMapping("/processRegister")
    public ModelAndView processRegister(@ModelAttribute("tasksUser") TasksUser user){
        String errorMessage = null;
        try {
            service.registerUser(user);
        } catch (ServiceException e) {
            errorMessage = e.getMessage();
        }
        if(errorMessage!=null){
            return new ModelAndView("register","error",errorMessage);
        }
        else {
            return new ModelAndView("login","loginSuccess","Succesfully logged in");
        }
    }
    
}
