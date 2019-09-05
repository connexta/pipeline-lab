package com.connexta.lab.circleci.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CircleCIProject {
  // Authentication information
  private final String username;

  // Version control information
  private final String vcsType;

  public String getUsername() {
    return username;
  }

  private final String vcsURL;

  // Repo Information
  private final String repoName;
  private final String defaultBranch;
  private final String language;

  // CircleCI specific information
  private final boolean following;

  public CircleCIProject(
      @JsonProperty("username") String username,
      @JsonProperty("vcs_type") String vcsType,
      @JsonProperty("vcs_url") String vcsURL,
      @JsonProperty("reponame") String repoName,
      @JsonProperty("default_branch") String defaultBranch,
      @JsonProperty("language") String language,
      @JsonProperty("following") Boolean followingBool) {
    this.username = username;
    this.vcsType = vcsType;
    this.vcsURL = vcsURL;
    this.repoName = repoName;
    this.defaultBranch = defaultBranch;
    this.language = language;
    this.following = followingBool.booleanValue();
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

  public String getDefaultBranch() {
    return defaultBranch;
  }

  public String getLanguage() {
    return language;
  }

  public boolean isFollowing() {
    return following;
  }
}
