/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucll.r0452425_tasks.ui.controller;


import com.ucll.tasks_domain.model.Category;
import com.ucll.tasks_domain.model.ModelException;
import com.ucll.tasks_domain.service.NotLoggedInException;
import com.ucll.tasks_domain.service.ServiceException;
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
public class CreateCategoryController extends TasksController {
    
    @RequestMapping("/processCreateCategory")
    public ModelAndView processCreateCategory(@RequestParam(value="name") String name, @ModelAttribute(value="loggedInUserId") long userId) throws ServiceException {
        try {
            Map<String,String> errorMessage = new HashMap<String,String>();
            long id = 0;
            try {
                Category category = new Category();
                category.setName(name);
                category.setOwner(service.getUserById(userId));
                id = service.addCategory(service.getUserById(userId), category);
            } catch(ModelException e){
                errorMessage.put("invalidCategory",e.getMessage());
            } catch (ServiceException e) {
                errorMessage.put("categoryExists",e.getMessage());
            }
            if(!errorMessage.values().isEmpty()){
                ModelAndView mav = new ModelAndView("overviewTasks","tasks",service.getAllTasks(service.getUserById(userId)));
                mav.addObject("categories", service.getCategories(service.getUserById(userId)));
                mav.addObject("errorMessage", errorMessage);
                return mav;
            }
            else {
                return new ModelAndView(new RedirectView("overviewTasks.htm?category="+id, false, true, false));
            }
        } catch (NotLoggedInException e){
            return new ModelAndView("redirect:/login.htm");
        }
    }
    
}
