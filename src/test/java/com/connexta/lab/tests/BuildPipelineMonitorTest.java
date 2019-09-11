package com.connexta.lab.tests;

// Required for Log4j2

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// Required for Test Execution

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildPipelineMonitorTest {

  private static Logger LOGGER = null;

  @BeforeClass
  public static void setLogger() throws MalformedURLException {
    System.setProperty("log4j.configurationFile", "log4j2-testConfig.xml");
    LOGGER = LogManager.getLogger();
  }

  @Test
  public void loggerConfiguration() {
    //    LOGGER.debug("Debug Message !");
    //    LOGGER.info("Info Message !");
    //    LOGGER.error("Error Message !");
  }

  @Test
  public void contextLoads() {
    // Starts the application and attempts to validate that a context loads
  }
}
