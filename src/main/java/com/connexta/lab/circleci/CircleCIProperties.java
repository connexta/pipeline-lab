package com.connexta.lab.circleci;

import javax.validation.constraints.Pattern;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("circleci")
public class CircleCIProperties {

  /** CircleCI User API access token "circle_ci_api_token:" */
  @Pattern(regexp = "\\w+:\\w+")
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
