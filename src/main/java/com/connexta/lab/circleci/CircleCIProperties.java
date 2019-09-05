package com.connexta.lab.circleci;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.Pattern;

@ConfigurationProperties("circleci")
public class CircleCIProperties {

  /**
   * CircleCI private access token "user:token"
   */
  @Pattern(regexp = "\\w+:\\w+")
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
