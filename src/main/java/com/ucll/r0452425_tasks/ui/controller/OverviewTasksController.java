/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucll.r0452425_tasks.ui.controller;

import com.ucll.tasks_domain.model.Task;
import com.ucll.tasks_domain.service.NotLoggedInException;
import com.ucll.tasks_domain.service.ServiceException;
import com.ucll.tasks_domain.service.UnauthorisedActionException;
import java.util.List;
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
public class OverviewTasksController extends TasksController {
    
    @RequestMapping("/overviewTasks")
    protected ModelAndView getTasks(@RequestParam(value="category", required=false) Long id, @ModelAttribute("loggedInUserId") long userId) throws ServiceException {
        try {
            long categoryId = id==null?0:id;
            List<Task> tasks;
            long currentCategoryId = 0;
            if(service.getCategoryById(categoryId)!=null){
                tasks = service.getTasks(service.getUserById(userId), categoryId);
                currentCategoryId = categoryId;
            }
            else {
                tasks = service.getAllTasks(service.getUserById(userId));
            }
            ModelAndView mav = new ModelAndView("overviewTasks", "tasks", tasks);
            mav.addObject("categories", service.getCategories(service.getUserById(userId)));
            mav.addObject("currentCategoryId",currentCategoryId);
            return mav;
        } catch(NotLoggedInException e){
            return new ModelAndView("redirect:/login.htm");
        } catch(UnauthorisedActionException e){
            return new ModelAndView("redirect:/overviewTasks.htm");
        }
    }
    
}
