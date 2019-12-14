/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class FCMService {
    
    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPath;
    
    public void initialize() {
        System.out.println("Start init");
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials
                            .fromStream(new ClassPathResource(firebaseConfigPath).getInputStream()))
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase application has been initialized");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String pushNotificationByTopic(String topic, String title, String content) {
        initialize();
        FirebaseApp app = FirebaseApp.getInstance();
        System.out.println("Firebase App: " + app.getName());
        
        int end;
        if (topic.lastIndexOf("@gmail.com") != -1) {
            end = topic.lastIndexOf("@gmail.com");
        } else {
            end = topic.lastIndexOf("@fpt.edu.vn");
        }
        
        Message message = Message.builder()
                .putData("content", content)
                .setNotification(new Notification(title, content))
                .setTopic(topic.substring(0, end))
                .build();
        
        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        return response;
    }
    
    public String pushNotificationByApp(String title, String content) {
        initialize();
        FirebaseApp app = FirebaseApp.getInstance();
        System.out.println("Firebase App: " + app.getName());
        
        Message message = Message.builder()
                .putData("content", content)
                .setNotification(new Notification(title, content))
                .setTopic("AHTAPARTMENT")
                .build();
        
        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        return response;
    }
}
