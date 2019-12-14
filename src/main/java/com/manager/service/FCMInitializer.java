///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.manager.service;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import java.io.IOException;
//import javax.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author Admin
// */
//@Service
//public class FCMInitializer {
//
//    @Value("${app.firebase-configuration-file}")
//    private String firebaseConfigPath;
//
//    @PostConstruct
//    public void initialize() {
//        System.out.println("Start init");
//        try {
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials
//                            .fromStream(new ClassPathResource(firebaseConfigPath).getInputStream()))
//                    .build();
//            if (FirebaseApp.getApps().isEmpty()) {
//                FirebaseApp.initializeApp(options, "ApartmentCitizen");
//                System.out.println("Firebase application has been initialized");
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
