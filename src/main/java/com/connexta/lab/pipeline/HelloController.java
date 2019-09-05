package com.connexta.lab.pipeline;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  public HelloController() {
  }

  @GetMapping("/speak")
  @ResponseBody
  public ResponseEntity sayHello() {
    return ResponseEntity.ok().body("Hello!");
  }
}
