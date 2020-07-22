package com.vitasofttest.service;


import java.util.*;
import java.util.stream.Collectors;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class AppService {

  public List<String> post(List<String> strings) {
    return strings.stream().sorted(Comparator.comparingInt(String::length))
        .map(s -> "(" + s.length() + "): " + s).collect(Collectors.toCollection(LinkedList::new));
  }

  public ResponseEntity<String> getService(String monthNumberString) {
    int monthNumberInteger;
    try {
      monthNumberInteger = Integer.parseInt(monthNumberString);
    } catch (NumberFormatException exception) {
      return incorrectData();
    }
    if (monthNumberInteger < 1 || monthNumberInteger > 12) {
      return incorrectData();
    } else {
      return new ResponseEntity<>(get(monthNumberInteger), HttpStatus.OK);
    }
  }

  public String get(int monthNumber) {
    return getRusName(monthNumber);
  }

  private String getRusName(int monthNumber) {
    if (monthNumber == 1) {
      return "Я-Н-В-А-Р-Ь";
    } else if (monthNumber == 2) {
      return "Ф-Е-В-Р-А-Л-Ь";
    } else if (monthNumber == 3) {
      return "М-А-Р-Т";
    } else if (monthNumber == 4) {
      return "А-П-Р-Е-Л-Ь";
    } else if (monthNumber == 5) {
      return "М-А-Й";
    } else if (monthNumber == 6) {
      return "И-Ю-Н-Ь";
    } else if (monthNumber == 7) {
      return "И-Ю-Л-Ь";
    } else if (monthNumber == 8) {
      return "А-В-Г-У-С-Т";
    } else if (monthNumber == 9) {
      return "С-Е-Н-Т-Я-Б-Р-Ь";
    } else if (monthNumber == 10) {
      return "О-К-Т-Я-Б-Р-Ь";
    } else if (monthNumber == 11) {
      return "Н-О-Я-Б-Р-Ь";
    } else {
      return "Д-Е-К-А-Б-Р-Ь";
    }
  }

  private ResponseEntity<String> incorrectData() {
    return new ResponseEntity<>("INCORRECT INPUT DATA", HttpStatus.BAD_REQUEST);
  }
}
