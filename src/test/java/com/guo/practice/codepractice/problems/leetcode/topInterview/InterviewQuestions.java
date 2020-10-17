package com.guo.practice.codepractice.problems.leetcode.topInterview;

import org.junit.jupiter.api.Test;

import java.util.function.ToDoubleBiFunction;

public class InterviewQuestions {

    @Test
    public void convertNUmberToString() {
        int input = -1234;

        input = 01234;

        System.out.println(String.valueOf("STRING valueOf: " + String.valueOf(input)));

        String output = "";


        int posInput = input;
        if (input == 0) {
            // return "0";
            output = "0";
        }

        if (input < 0) {
            posInput = Math.abs(input);
        }

        // Get each digit using math
        // e.g.: reminder 1234 % 10 = 4
        // ( 1234 - 4 ) / 10 --> 123
        // 123 % 10 = 3
        // 120 / 10 --> 12
        // 12 --> 2
        // 10 % 10 = 1

        // 0 % 10 = 0;

        StringBuilder sb = new StringBuilder();

        while (posInput > 0) {

            int reminder = posInput % 10;
            sb.append(reminder);

            // update posInput
            posInput = (posInput - reminder) / 10;
        }

        // update output
        output = input > 0 ? sb.reverse().toString() : "-" + sb.reverse().toString();

        System.out.println(output);
        System.out.println(reverseStr(output));

    }

    public static String reverseStr(String str) {
        StringBuilder sb = new StringBuilder();
        int size = str.length() - 1;

        // reverse string size >=0 
        // // TODO: 01/10/2020  Don't forgot reverss have case = 0 ******
        for (int i = size; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }


}
