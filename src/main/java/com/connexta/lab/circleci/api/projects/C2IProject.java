package com.connexta.lab.circleci.api.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class C2IProject {
  private static final Logger LOGGER = LogManager.getLogger(C2IProject.class);
  // Authentication information
  private final String username;
  // Version control information
  private final String vcsType;
  private final String vcsURL;
  // Repo Information
  private final String repoName;
  private final String language;
  // CircleCI specific information
  private final boolean following;
  private Map<String,C2IBranch> branches;
  private List<C2IFeatureFlag> featureFlags;

  public C2IProject(
      @JsonProperty("username") String username,
      @JsonProperty("vcs_type") String vcsType,
      @JsonProperty("vcs_url") String vcsURL,
      @JsonProperty("reponame") String repoName,
      @JsonProperty("language") String language,
      @JsonProperty("following") Boolean followingBool,
      @JsonProperty("branches") Map<String,C2IBranch> branches) {
    this.username = username;
    this.vcsType = vcsType;
    this.vcsURL = vcsURL;
    this.repoName = repoName;
    this.language = language;
    this.following = followingBool;
    this.branches = branches;
  }

  public String getUsername() {
    return username;
  }

  public String getVcsType() {
    return vcsType;
  }

  public String getVcsURL() {
    return vcsURL;
  }

  public String getRepoName() {
    return repoName;
  }

  public String getLanguage() {
    return language;
  }

  public boolean isFollowing() {
    return following;
  }

  public List<C2IFeatureFlag> getFeatureFlags() {
    return featureFlags;
  }

  public Map<String,C2IBranch> getBranches() {
    return branches;
  }

  @JsonProperty("feature_flags")
  private void unpackFeatureFlags(Map<String, Object> flags) {
    this.featureFlags = new ArrayList<>();
    for (Map.Entry<String, Object> entry : flags.entrySet()) {
      // Saw "fleet": null 2019-09-12 @j-fontaine, ignoring those flags
      if (entry.getValue() != null) {
        featureFlags.add(new C2IFeatureFlag(entry.getKey(), (Boolean) entry.getValue()));
      }
    }
    LOGGER.debug("Found {}", featureFlags);
  }
}
