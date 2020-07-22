package com.vitasofttest.controller;

import com.vitasofttest.service.AppService;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

  private final AppService appService;

  public AppController(AppService appService) {
    this.appService = appService;
  }

  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(method = RequestMethod.POST, value = "/post")
  public ResponseEntity<List<String>> postController(@RequestBody List<String> strings) {
    return new ResponseEntity<>(appService.post(strings), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/get/{monthNumberString}")
  public ResponseEntity<String> getController(@PathVariable String monthNumberString) {
    return appService.getService(monthNumberString);
  }
}
