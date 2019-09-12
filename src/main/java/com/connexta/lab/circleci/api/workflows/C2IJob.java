package com.connexta.lab.circleci.api.workflows;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class C2IJob {
  private final String id;
  private final String status;
  private final Date createdAt;

  public C2IJob(
      @JsonProperty("status") String status,
      @JsonProperty("created_at") Date createdAt,
      @JsonProperty("id") String id) {
      this.id = id;
      this.createdAt = createdAt;
      this.status = status;
  }

  public String getId() {
    return id;
  }

  public String getStatus() {
    return status;
  }

  public Date getCreatedAt() {
    return createdAt;
  }
}
