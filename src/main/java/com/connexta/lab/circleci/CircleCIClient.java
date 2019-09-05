package com.connexta.lab.circleci;

import com.connexta.lab.circleci.api.CircleCIProject;
import com.google.common.net.HttpHeaders;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import com.google.common.base.Charsets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class CircleCIClient {
  // Provides a generic RESTAPI template to communicate
  private final RestTemplate restTemplate;

  private static final String PROJECTS_URL = "https://circleci.com/api/v1.1/projects";

  public CircleCIClient(RestTemplateBuilder builder, CircleCIProperties properties) {
    /*
       1) Add an interceptor to inject our authentication token for API invocation
    */
    this.restTemplate =
        builder
            .additionalInterceptors(new CircleCIAppTokenInterceptor(properties.getToken()))
            .build();
  }

  /** Call Server for projects JSON */
  public ResponseEntity<CircleCIProject[]> fetchProjects() {
    return this.restTemplate.getForEntity(PROJECTS_URL, CircleCIProject[].class);
  }

  public List<CircleCIProject> fetchProjectList() {
    return Arrays.asList(fetchProjects().getBody());
  }

  /** Provides the CircleCI API Token from Properties file for Authentication */
  private static class CircleCIAppTokenInterceptor implements ClientHttpRequestInterceptor {
    private final String token;

    CircleCIAppTokenInterceptor(String token) {
      this.token = token;
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
    public ClientHttpResponse intercept(
        HttpRequest httpRequest,
        byte[] bytes,
        ClientHttpRequestExecution clientHttpRequestExecution)
        throws IOException {
      if (StringUtils.hasText(token)) {
        byte[] basicAuthValue = token.getBytes(Charsets.UTF_8.name());
        httpRequest.getHeaders().set(HttpHeaders.AUTHORIZATION, token);
      }
      return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
  }
}
