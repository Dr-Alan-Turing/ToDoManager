/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucll.r0452425_tasks.ui.controller;

import com.ucll.tasks_domain.model.Task;
import com.ucll.tasks_domain.service.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Tom
 */
@Controller
@SessionAttributes("loggedInUserId")
public class CreateTaskController extends CreateOrModifyTaskController {
    
    @RequestMapping("/createTask")
    public ModelAndView showCreateTask(@ModelAttribute("loggedInUserId") long userId) throws ServiceException {
        return super.showCreateOrModifyTask("createTask", new Task(), userId);
    }
    
    @RequestMapping("/processCreateTask")
    public ModelAndView processCreateTask(@ModelAttribute("task") Task task, @ModelAttribute("loggedInUserId") long userId) throws ServiceException {
        return super.processCreateOrModifyTask("createTask", task, userId);
    }
    
}
