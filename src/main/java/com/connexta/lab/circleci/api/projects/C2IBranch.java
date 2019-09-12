package com.connexta.lab.circleci.api.projects;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.connexta.lab.circleci.api.workflows.C2IBuild;
import com.connexta.lab.circleci.api.workflows.C2IJob;
import com.fasterxml.jackson.annotation.JsonProperty;

public class C2IBranch {
  private static final Logger LOGGER = LogManager.getLogger(C2IBranch.class);
  private final boolean isUsingWorkflows;
  // While the JSON calls this "workflows" they are really individual job summaries
  private final Map<String, C2IJob> latestJobs;
  private final List<C2IBuild> recentBuilds;
  private final List<C2IBuild> runningBuilds;
  private final C2IBuild lastNonSuccessBuild;
  private final Map<String, C2IJob> latestCompletedJobs;

  public C2IBranch(
      @JsonProperty("is_using_workflows") boolean usingWorkflows,
      @JsonProperty("latest_workflows") Map<String, C2IJob> latestJobs,
      @JsonProperty("recent_builds") List<C2IBuild> recentBuilds,
      @JsonProperty("last_non_success") C2IBuild lastNonSuccessBuild,
      @JsonProperty("running_builds") List<C2IBuild> runningBuilds,
      @JsonProperty("latest_completed_workflows") Map<String, C2IJob> latestCompletedJobs) {
    this.latestJobs = latestJobs;
    this.isUsingWorkflows = usingWorkflows;
    this.recentBuilds = recentBuilds;
    this.lastNonSuccessBuild = lastNonSuccessBuild;
    this.runningBuilds = runningBuilds;
    this.latestCompletedJobs = latestCompletedJobs;
  }

  public boolean isUsingWorkflows() {
    return isUsingWorkflows;
  }

  public Map<String, C2IJob> getLatestJobs() {
    return latestJobs;
  }

  public List<C2IBuild> getRecentBuilds() {
    return recentBuilds;
  }

  public C2IBuild getLastNonSuccessBuild() {
    return lastNonSuccessBuild;
  }

  public List<C2IBuild> getRunningBuilds() {
    return runningBuilds;
  }

  public Map<String, C2IJob> getLatestCompletedJobs() {
    return latestCompletedJobs;
  }
}
