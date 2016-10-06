/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucll.r0452425_tasks.ui.controller;

import com.ucll.tasks_domain.service.NotLoggedInException;
import com.ucll.tasks_domain.service.ServiceException;
import com.ucll.tasks_domain.service.UnauthorisedActionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@SessionAttributes("loggedInUserId")
public class MarkOrUnmarkTaskAsDoneController extends TasksController {
    
    @RequestMapping("/markTaskAsDone")
    public ModelAndView markTaskAsDone(@RequestParam(value="id") long id, @ModelAttribute("loggedInUserId") long userId) throws ServiceException {
        try {
            service.markTaskAsDone(service.getUserById(userId), id);
            long categoryId = service.getTaskById(id).getCategory()==null?0:service.getTaskById(id).getCategory().getId();
            return new ModelAndView(new RedirectView("overviewTasks.htm?category="+categoryId, false, true, false));
        } catch (NotLoggedInException e) {
            return new ModelAndView("redirect:/login.htm");
        } catch (UnauthorisedActionException e) {
            return new ModelAndView("redirect:/overviewTasks.htm");
        }
    }
    
    @RequestMapping("/unmarkTaskAsDone")
    public ModelAndView unmarkTaskAsDone(@RequestParam(value="id") long id, @ModelAttribute("loggedInUserId") long userId) throws ServiceException {
        try {
            service.unmarkTaskAsDone(service.getUserById(userId), id);
            long categoryId = service.getTaskById(id).getCategory()==null?0:service.getTaskById(id).getCategory().getId();
            return new ModelAndView(new RedirectView("overviewTasks.htm?category="+categoryId, false, true, false));
        } catch (NotLoggedInException e) {
            return new ModelAndView("redirect:/login.htm");
        } catch (UnauthorisedActionException e) {
            return new ModelAndView("redirect:/overviewTasks.htm");
        }
    }
}
