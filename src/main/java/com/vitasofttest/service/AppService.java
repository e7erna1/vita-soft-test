package com.vitasofttest.service;


import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AppService {

  public List<String> sortStringService(List<String> strings) {
    return strings.stream()
        .sorted(CharSequence::compare)
        .sorted(Comparator.comparingInt(String::length))
        .map(s -> "(" + s.length() + "): " + s)
        .collect(Collectors.toCollection(LinkedList::new));
  }

  public String getMonthService(String monthNumberString) {
    int monthNumberInteger;
    try {
      monthNumberInteger = Integer.parseInt(monthNumberString);
      if (monthNumberInteger < 1 || monthNumberInteger > 12) {
        throw new NumberFormatException();
      }
    } catch (NumberFormatException exception) {
      return exceptionHandler(exception);
    }
    return getMonth(monthNumberInteger);
  }

  private String getMonth(int monthNumber) {
    return switch (monthNumber) {
      case 1 -> "Я-Н-В-А-Р-Ь";
      case 2 -> "Ф-Е-В-Р-А-Л-Ь";
      case 3 -> "М-А-Р-Т";
      case 4 -> "А-П-Р-Е-Л-Ь";
      case 5 -> "М-А-Й";
      case 6 -> "И-Ю-Н-Ь";
      case 7 -> "И-Ю-Л-Ь";
      case 8 -> "А-В-Г-У-С-Т";
      case 9 -> "С-Е-Н-Т-Я-Б-Р-Ь";
      case 10 -> "О-К-Т-Я-Б-Р-Ь";
      case 11 -> "Н-О-Я-Б-Р-Ь";
      default -> "Д-Е-К-А-Б-Р-Ь";
    };
  }

  private String exceptionHandler(Exception e) {
    return "INCORRECT INPUT DATA";
  }
}
