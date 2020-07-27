package com.vitasofttest.service;


import java.util.*;
import java.util.regex.Pattern;
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
    String monthNameRus;
    try {
      monthNameRus = checkAndGetMonthRusName(monthNumberString);
    } catch (NumberFormatException exception) {
      monthNameRus = exceptionHandler();
    }
      return monthNameRus;
  }

  private String checkAndGetMonthRusName(String monthNumberString) {
    checkValidString(monthNumberString);
    return monthRusNameStringFromInt(Integer.parseInt(monthNumberString));
  }

  private void checkValidString(String monthNumberString) {
    if (!Pattern.matches("^([1-9]|1[012])$", monthNumberString)) {
      throw new NumberFormatException();
    }
    int monthNumberInteger = Integer.parseInt(monthNumberString);
    if (monthNumberInteger < 1 || monthNumberInteger > 12) {
      throw new NumberFormatException();
    }
  }

  private String monthRusNameStringFromInt(int monthNumber) {
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

  private String exceptionHandler() {
    return "INCORRECT INPUT DATA";
  }
}
