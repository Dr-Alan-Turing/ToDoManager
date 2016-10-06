/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucll.r0452425_tasks.converter;

import com.ucll.tasks_domain.model.Category;
import com.ucll.tasks_domain.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author Tom
 */
public class CategoryConverter implements Converter<String,Category> {
    
    @Autowired
    private TasksService service;
    
    @Override
    public Category convert(String s) {
        int id = Integer.parseInt(s);
        return id==0?null:service.getCategoryById(id);
    }
    
    
    
}
