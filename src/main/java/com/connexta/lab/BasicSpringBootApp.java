package com.connexta.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Identifies this as a Spring Boot Application (does 3 annotations in 1)
@SpringBootApplication
public class BasicSpringBootApp {

  public static void main(String[] args) {
    SpringApplication.run(BasicSpringBootApp.class, args);
  }
}
