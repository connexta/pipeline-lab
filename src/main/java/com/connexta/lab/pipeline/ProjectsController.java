package com.connexta.lab.pipeline;

import com.connexta.lab.circleci.CircleCIClient;
import com.connexta.lab.circleci.api.CircleCIProject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProjectsController {

  private final CircleCIClient circleCIClient;

  public ProjectsController(CircleCIClient circleCIClient) {
    this.circleCIClient = circleCIClient;
  }

  @GetMapping("/projects")
  @ResponseBody
  public ResponseEntity<CircleCIProject[]> fetchProjects() {
    ResponseEntity<CircleCIProject[]> response = this.circleCIClient.fetchProjects();
    return ResponseEntity.ok().eTag(response.getHeaders().getETag()).body(response.getBody());
  }
}
