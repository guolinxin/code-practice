package com.guo.practice.codepractice.problems.leetcode.topInterview;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class InterviewQuestions {

    @Test
    public void convertNUmberToString() {
        int input = 1245;

        String output = "";


        // cant use String.valueOf if int have leading zeros
//        String str = String.valueOf(input);




        int leadingZeros = Integer.numberOfLeadingZeros(input);
        StringBuilder sb = new StringBuilder();
        if (leadingZeros > 0) {
            String unsignedString = Integer.toOctalString(input);
            for(int i=0; i<leadingZeros; i++){
                sb.append("0");
            }
            sb.append(unsignedString);
        }

        Integer intObj = Integer.valueOf(input);
        String bit  = Integer.toBinaryString(input);

        System.out.println(Integer.rotateLeft(1234000, 5));

StringBuffer sb = new StringBuffer();
sb.reverse()
        String strPattern = "^0+";

        System.out.println(output);

    }
}
