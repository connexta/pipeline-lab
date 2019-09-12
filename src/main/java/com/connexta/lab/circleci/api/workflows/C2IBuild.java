package com.connexta.lab.circleci.api.workflows;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class C2IBuild {

  private final String outcome;
  private final String status;
  private final String vcsRev;
  private final String buildNumber;
  private final boolean isWorkflowJob;
  private final Date pushedAt;
  private final Date addedAt;

  public C2IBuild(
      @JsonProperty("outcome") String outcome,
      @JsonProperty("status") String status,
      @JsonProperty("vcs_revision") String vcsRev,
      @JsonProperty("build_num") String buildNumber,
      @JsonProperty("is_workflow_job") boolean isWorkflowJob,
      @JsonProperty("pushed_at") Date pushedAt,
      @JsonProperty("added_at") Date addedAt) {
      this.outcome = outcome;
      this.status = status;
      this.vcsRev = vcsRev;
      this.buildNumber = buildNumber;
      this.isWorkflowJob = isWorkflowJob;
      this.pushedAt = pushedAt;
      this.addedAt = addedAt;
  }

  public String getOutcome() {
    return outcome;
  }

  public String getStatus() {
    return status;
  }

  public String getVcsRev() {
    return vcsRev;
  }

  public String getBuildNumber() {
    return buildNumber;
  }

  public boolean isWorkflowJob() {
    return isWorkflowJob;
  }

  public Date getPushedAt() {
    return pushedAt;
  }

  public Date getAddedAt() {
    return addedAt;
  }
}
