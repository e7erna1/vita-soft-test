package com.vitasofttest.controller;

import com.vitasofttest.service.AppService;
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
    List<String> strings1 = appService.post(strings);
    for (String s : strings1) {
      System.out.println(s);
    }
    return new ResponseEntity<>(appService.post(strings), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/get/{monthNumberString}")
  public ResponseEntity<String> getController(@PathVariable String monthNumberString) {
    int monthNumberInteger;
    try {
      monthNumberInteger = Integer.parseInt(monthNumberString);
    } catch (NumberFormatException exception) {
      return appService.incorrectData();
    }
    if (monthNumberInteger < 1 || monthNumberInteger > 12) {
      return appService.incorrectData();
    } else {
      return new ResponseEntity<>(appService.get(monthNumberInteger), HttpStatus.OK);
    }
  }
}
