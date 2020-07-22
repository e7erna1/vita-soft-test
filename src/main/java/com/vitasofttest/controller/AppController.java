package com.vitasofttest.controller;

import com.vitasofttest.service.AppService;
import java.util.List;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

  private final AppService appService;

  public AppController(AppService appService) {
    this.appService = appService;
  }

  @PostMapping(value = "/post")
  public ResponseEntity<List<String>> sortStringController(@RequestBody List<String> strings) {
    return new ResponseEntity<>(appService.sortStringService(strings), HttpStatus.OK);
  }

  @GetMapping(value = "/get/{monthNumberString}")
  public ResponseEntity<String> getMonthController(@PathVariable String monthNumberString) {
    return new ResponseEntity<>(appService.getMonthService(monthNumberString),
        (!appService.getMonthService(monthNumberString).equals("INCORRECT INPUT DATA")
            ? HttpStatus.OK : HttpStatus.BAD_REQUEST));
  }
}
