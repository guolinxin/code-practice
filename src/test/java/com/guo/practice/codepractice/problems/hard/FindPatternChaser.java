package com.guo.practice.codepractice.problems.hard;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * Using the Java language, have the function PatternChaser(str) take str which will be a string and
 * return the longest pattern within the string. A pattern for this challenge will be defined as: if
 * at least 2 or more adjacent characters within the string repeat at least twice. So for example
 * "aabecaa" contains the pattern aa, on the other hand "abbbaac" doesn't contain any pattern. Your
 * program should return yes/no pattern/null. So if str were "aabejiabkfabed" the output should be
 * yes abe. If str were "123224" the output should return no null. The string may either contain all
 * characters (a through z only), integers, or both. But the parameter will always be a string type.
 * The maximum length for the string being passed in will be 20 characters. If a string for example
 * is "aa2bbbaacbbb" the pattern is "bbb" and not "aa". You must always return the longest pattern
 * possible.
 */
class FindPatternChaser {

  String findPatternSlidingWindow(String str) {
    String pattern = "";

    if (str.length() > 20) {
      return "over 20 characters";
    }

    String tempPat = "";
    int strLength = str.length();

    for (int i = 0; i < strLength-1; i++) {
      Character current = str.charAt(i);
      int j = i + 1;
      while(j<strLength){
        String currentStr = str.substring(i, j);
        String remainStr = str.substring(j, strLength);
        if(currentStr.length() > 1 && remainStr.contains(currentStr) && currentStr.length()> tempPat.length()){
          tempPat = currentStr;
        }
        j++;
      }
    }

    if (tempPat.length() > 1) {
      pattern = "yes " + tempPat;
    } else {
      pattern = "no null";
    }

    return pattern;
  }


  @Test
  public void testPat() {
//    String input = "aabejiabkfabed";
    String input = "aabecaa";

    String output = findPatternSlidingWindow(input);
    System.out.println(output);
  }
}
