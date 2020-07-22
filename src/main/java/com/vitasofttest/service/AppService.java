package com.vitasofttest.service;


import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppService {

  public List<String> post(List<String> strings) {
    Map<Integer, String> map = new TreeMap<>();
    List<String> list = new LinkedList<>();
    for (String s : strings) {
      map.put(s.length(), s);
    }
    for (int i: map.keySet()) {
      list.add("\"(" + i + "): " + map.get(i) + "\"");
    }
    return list;
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

  public ResponseEntity<String> incorrectData() {
    return new ResponseEntity<>("INCORRECT INPUT DATA", HttpStatus.BAD_REQUEST);
  }
}
