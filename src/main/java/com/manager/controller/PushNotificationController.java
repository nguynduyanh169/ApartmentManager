/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager.controller;

import com.manager.service.FCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class PushNotificationController {
    
    @Autowired
    private FCMService service;
    
    @GetMapping("/push/{notify}")
    public String pushNotification(@PathVariable("notify") String notify) {
        return service.pushNotification(notify);
    }
}