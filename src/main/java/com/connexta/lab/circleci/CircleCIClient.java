package com.connexta.lab.circleci;

import java.io.IOException;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.connexta.lab.circleci.api.projects.C2IProject;
import com.google.common.base.Charsets;
import com.google.common.net.HttpHeaders;

@Component
public class CircleCIClient {
  // Provides a generic RESTAPI template to communicate
  private final RestTemplate restTemplate;

  private static final String PROJECTS_URL = "https://circleci.com/api/v1.1/projects";
  private static final Logger LOGGER = LogManager.getLogger(CircleCIClient.class);
  private static final String ENV_CIRCLECI_TOKEN = "CIRCLECI_TOKEN";

  public CircleCIClient(RestTemplateBuilder builder, CircleCIProperties properties) {
    /*
       1) Add an interceptor to inject our authentication token for API invocation
        - NOTE:  The interceptor will only be constructed and injected once.
    */
    this.restTemplate =
        builder
            .additionalInterceptors(new CircleCIAppTokenInterceptor(properties.getToken()))
            .build();
    LOGGER.trace("Construction Completed");
  }

  /** Call Server for projects JSON */
  public ResponseEntity<C2IProject[]> fetchProjects() {
    LOGGER.debug("Starting to fetch Projects...");
    return this.restTemplate.getForEntity(PROJECTS_URL, C2IProject[].class);
  }

  /**
   * Provides the CircleCI API Token from Properties file for Authentication - API Token can be
   * provided via the application.properties file "circleci.token=" - API Token can be provided via
   * a system variable CIRCLECI_TOKEN
   */
  private static class CircleCIAppTokenInterceptor implements ClientHttpRequestInterceptor {
    private static String token;
    private static final Logger LOGGER = LogManager.getLogger(CircleCIAppTokenInterceptor.class);

    CircleCIAppTokenInterceptor(String tokenParam) {
      LOGGER.trace("Initializing interceptor...");
      // Fallback to system environment variable if token undefined
      token = (StringUtils.isEmpty(tokenParam) ? System.getenv(ENV_CIRCLECI_TOKEN) : tokenParam);
      // If token is still empty -- we don't have anything
      if (StringUtils.isEmpty(token)) {
        LOGGER.warn("No authentication token found for CircleCI API invocation");
      } else {
        LOGGER.debug("Falling back to system token");
      }
    }

    /**
     * Intercepts the call chain and injects an Authorization head in this case
     *
     * @param httpRequest the original request to the server
     * @param bytes the original payload to the server
     * @param clientHttpRequestExecution the execution chain for the request(?)
     * @return ClientHttpResponse with an Authorization header added w/ token
     * @throws IOException if an issue from any of the Http classes fires
     */
    @Override
    public ClientHttpResponse intercept(
        HttpRequest httpRequest,
        byte[] bytes,
        ClientHttpRequestExecution clientHttpRequestExecution)
        throws IOException {
      LOGGER.trace("Intercepting for Token");
      if (StringUtils.hasText(token)) {
        byte[] basicAuthValue = token.getBytes(Charsets.UTF_8.name());
        // HEADER: Authorization --> Basic <64-bit encoded token>
        httpRequest
            .getHeaders()
            .set(
                HttpHeaders.AUTHORIZATION,
                "Basic ".concat(Base64.getEncoder().encodeToString(basicAuthValue)));
      } else {
        LOGGER.warn("Empty token found");
      }
      return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
  }
}
