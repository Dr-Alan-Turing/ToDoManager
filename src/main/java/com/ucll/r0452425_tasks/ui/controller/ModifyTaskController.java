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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Tom
 */
@Controller
@SessionAttributes("loggedInUserId")
public class ModifyTaskController extends CreateOrModifyTaskController {
    
    @RequestMapping("/modifyTask")
    public ModelAndView showModifyTask(@RequestParam(value="id") long id, @ModelAttribute("loggedInUserId") long userId) throws ServiceException {
        if(service.getTaskById(id)==null) return new ModelAndView("redirect:/overviewTasks.htm");
        return super.showCreateOrModifyTask("modifyTask", service.getTaskById(id), userId);
    }
    
    @RequestMapping("/processModifyTask")
    public ModelAndView processModifyTask(@ModelAttribute("task") Task task, @ModelAttribute("loggedInUserId") long userId) throws ServiceException {
        return super.processCreateOrModifyTask("modifyTask", task, userId);
    }
    
}
