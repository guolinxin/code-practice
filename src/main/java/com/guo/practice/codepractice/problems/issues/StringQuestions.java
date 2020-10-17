package com.guo.practice.codepractice.problems.issues;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class StringQuestions {

    public static void main(String[] args) {
        log.debug("*** running main ***");

        /**
         * reverse string array
         */

        String str = "Hannahhhhh";
        printReverseArray(str.toCharArray());
    }

    public static char[] printReverseArray(char[] s) {

//
//        char[] newChar = new char[s.length];
//        int j =0;
//
//        for(int i=s.length -1; i>0;i--){
//            newChar[j] = s[i];
//            j++;
//        }
//
//        log.debug("*** printReverseArray ***" + Arrays.toString(newChar));
//        return newChar;
        // time: O(n)
        // space O(n)

//        /////////////////////////////////////////

        int leftPointer = 0;
        int rightPointer = s.length - 1;

        while (leftPointer < rightPointer) {
            char temp = s[leftPointer];
            s[leftPointer] = s[rightPointer];
            s[rightPointer] = temp;

            leftPointer++;
            rightPointer--;
        }
        log.debug("*** printReverseArray ***" + Arrays.toString(s));

        return s;

    }
}
