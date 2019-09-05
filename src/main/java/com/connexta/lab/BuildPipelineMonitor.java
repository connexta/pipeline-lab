package com.connexta.lab;

import com.connexta.lab.circleci.CircleCIProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

// Identifies this as a Spring Boot Application (does 3 annotations in 1)
@SpringBootApplication
// Need to enable certain configuration files to read properties
@EnableConfigurationProperties(CircleCIProperties.class)
public class BuildPipelineMonitor {

  public static void main(String[] args) {
    SpringApplication.run(BuildPipelineMonitor.class, args);
  }
}
