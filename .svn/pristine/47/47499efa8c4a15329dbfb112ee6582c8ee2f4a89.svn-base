/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucll.r0452425_tasks.converter;

import com.ucll.tasks_domain.model.TasksUser;
import com.ucll.tasks_domain.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Tom
 */
public class UserConverter implements Converter<String,TasksUser> {
    
    @Autowired
    private TasksService service;
    
    @Override
    public TasksUser convert(String s) {
        int id = Integer.parseInt(s);
        return service.getUserById(id);
    }
    
}
