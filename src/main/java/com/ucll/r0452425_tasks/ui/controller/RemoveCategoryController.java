/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucll.r0452425_tasks.ui.controller;

import com.ucll.tasks_domain.service.NotLoggedInException;
import com.ucll.tasks_domain.service.ServiceException;
import com.ucll.tasks_domain.service.UnauthorisedActionException;
import java.util.HashMap;
import java.util.Map;
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
public class RemoveCategoryController extends TasksController {
    
    @RequestMapping("/removeCategory")
    public ModelAndView removeCategory(@RequestParam(value="id") long id, @ModelAttribute("loggedInUserId") long userId) throws ServiceException {
        try {
            if(id==0){
                ModelAndView mav = new ModelAndView("overviewTasks","tasks",service.getAllTasks(service.getUserById(userId)));
                mav.addObject("categories", service.getCategories(service.getUserById(userId)));
                Map<String,String> errorMessage = new HashMap<String,String>();
                errorMessage.put("deletingAll","Cannot delete category 'All'");
                mav.addObject("errorMessage",errorMessage);
                mav.addObject("currentCategoryId",0);
                return mav;
            } else {
                service.removeCategory(service.getUserById(userId), id);
                return new ModelAndView(new RedirectView("overviewTasks.htm?category=0", false, true, false));
            }
        } catch(NotLoggedInException e){
            return new ModelAndView("redirect:/login.htm");
        } catch(UnauthorisedActionException e){
            return new ModelAndView("redirect:/overviewTasks.htm");
        }
    }
    
}
