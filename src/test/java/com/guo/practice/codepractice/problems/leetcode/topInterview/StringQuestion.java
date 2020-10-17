package com.guo.practice.codepractice.problems.leetcode.topInterview;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

@Slf4j
public class StringQuestion {


    /**
     * https://leetcode.com/problems/reverse-integer/
     */
    @Test
    public void reverseNumberTest() {
        int x = 1534236469;
        String s = String.valueOf(x);
        x = reverseString(s).intValue();

        // java 8 string builder
//        String temp = Integer.valueOf(new StringBuilder(-x).reverse().toString());

        if (x > 0) {
        } else {
//            Integer.parseInt();
        }


        log.debug("*** reverseNumberTest *** " + x);

    }

    private BigInteger reverseString(String str) {


        String prefix = "";
        if (!Character.isDigit(str.charAt(0))) {
            prefix = String.valueOf(str.charAt(0));
            str = str.substring(1, str.length());
        }

        char[] cha = str.toCharArray();
        int left = 0;
        int right = cha.length - 1;

        while (left < right) {
            char temp = cha[left];
            cha[left] = cha[right];
            cha[right] = temp;

            left++;
            right--;
        }

        String result = prefix;
        for (Character c : cha) {
            result += c;
        }

        // MAX integer value: 2147483647

        return new BigInteger(result);

    }


    /**
     * https://leetcode.com/problems/first-unique-character-in-a-string/
     */
    @Test
    public void firstUniqChar() {

        String s = "dddccdbba";

        // create map to store count
        Map<Character, Integer> map = new HashMap();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // loop through string.charAt(i), no need to convert string to array
            // if first time, count = 1, more time +1
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // its important that we use "n", not map size
        for (int j = 0; j < n; j++) {
            if (map.get(s.charAt(j)) == 1) {
                // return index
//                return j;

                log.debug("**** firstUniqChar *** " + j);
            }
        }

//        return -1;

        log.debug("**** firstUniqChar *** " + 1);

    }


    @Test
    public void sequence() {

        int n = 1;
        int m = 5;

        String sequence = "";

        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(n, m)
                .forEach(i -> {
                    if (i % 3 == 0 && i % 5 == 0) {
                        sb.append("FizzBuzz");
                    } else {
                        if (i % 5 == 0) {
                            sb.append("Buzz");
                        } else if (i % 3 == 0) {
                            sb.append("Fizz");
                        } else {
                            sb.append(i);
                        }
                    }
                });
        sequence = sb.toString();

    }


    public int balancePoint(int[] input) {


//        int leftSum = input[0];
//        int rightSum = 0;;
//        for(int i=0; i<input.length;i++)//notice we start from 2nd as 1st value is set
//            rightSum += input[i];//each sum is sum of previous sum plus current value
//
//        for(int i=0; i<input.length-1;i++)
//        {
//            if(leftSum==rightSum){
//                return i;
//            }
//
//            leftSum+=input[i+1];
//            rightSum-=input[i];
//        }


        int leftSum = 0;
        int rightSum = 0;
        int i = 0;
        int j = input.length - 1;
        for (i = 0; i < input.length; i++) {
            leftSum += input[i];
            rightSum += input[j];
            j--;
            if (leftSum == rightSum) {
                return i;
            }
        }

//        for (int j = 0; j < input.length; j++) {
//            if(leftSum == rightSum){
//                return j;
//            }
//            leftSum += input[j + 1];
//            rightSum -= input[j];
//        }

        return -1;//otherwise we return -1 as not found
    }

    @Test
    public void test1() {
        int[] input = {1, 2, 9, 4, -1};
        int[] input2 = new int[]{2, 7, 4, 5, -3, 8, 9, -1};

        int output = balancePoint(input);
        System.out.println(output);
    }

}
