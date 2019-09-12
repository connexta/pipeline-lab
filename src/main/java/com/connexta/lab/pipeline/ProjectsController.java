package com.connexta.lab.pipeline;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.connexta.lab.circleci.CircleCIClient;
import com.connexta.lab.circleci.api.projects.C2IProject;

@Controller
public class ProjectsController {

  private final CircleCIClient circleCIClient;

  public ProjectsController(CircleCIClient circleCIClient) {
    this.circleCIClient = circleCIClient;
  }

  @GetMapping("/projects")
  @ResponseBody
  public ResponseEntity<C2IProject[]> fetchProjects() {
    ResponseEntity<C2IProject[]> response = this.circleCIClient.fetchProjects();
    return ResponseEntity.ok().body(response.getBody());
  }
}
