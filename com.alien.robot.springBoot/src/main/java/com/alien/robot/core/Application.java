/**
   PACKAGE:com.alien.robot.core 
   USE: This package is main package that contain the executable class to run spring-boot server

 * Copyright 2020 Alien 
   Created on 31/07/20207:32:40 AM  by ayman Elgharabawy
 */
package com.alien.robot.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// TODO: Auto-generated Javadoc
/**
 * The Class Application.
 */
@SpringBootApplication
@ServletComponentScan
public class Application {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
