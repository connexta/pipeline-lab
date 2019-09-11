package com.connexta.lab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.connexta.lab.circleci.CircleCIProperties;

// Identifies this as a Spring Boot Application (does 3 annotations in 1)
@SpringBootApplication
// Need to enable certain configuration files to read properties
@EnableConfigurationProperties(CircleCIProperties.class)
public class BuildPipelineMonitor {

  private static Logger LOGGER = LogManager.getLogger(BuildPipelineMonitor.class);

  public static void main(String[] args) {
    SpringApplication.run(BuildPipelineMonitor.class, args);
  }
}
