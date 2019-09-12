package com.connexta.lab.circleci.api.projects;

import com.google.common.base.Objects;

public class C2IFeatureFlag {
  private final String flag;
  private final boolean status;

  public C2IFeatureFlag(String flagName, boolean status) {
    this.flag = flagName;
    this.status = status;
  }

  public String getFlag() {
    return flag;
  }

  public boolean isStatus() {
    return status;
  }

  @Override
  public String toString() {
    return "C2IFeatureFlag{" + "flag='" + flag + '\'' + ", status=" + status + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    C2IFeatureFlag that = (C2IFeatureFlag) o;
    return Objects.equal(getFlag(), that.getFlag());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getFlag(), isStatus());
  }
}
