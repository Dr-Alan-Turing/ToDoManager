/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucll.r0452425_tasks.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Tom
 */
@Controller
@SessionAttributes("loggedInUserId")
public class LogoutController extends TasksController {
    
    @RequestMapping("/logout")
    public ModelAndView processLogout(SessionStatus status, @ModelAttribute("loggedInUserId") long userId){
        status.setComplete();
        return new ModelAndView("redirect:/login.htm");
    }
    
}
