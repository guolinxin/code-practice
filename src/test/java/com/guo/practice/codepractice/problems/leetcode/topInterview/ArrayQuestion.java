package com.guo.practice.codepractice.problems.leetcode.topInterview;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

@Slf4j
public class ArrayQuestion {

    @Test
    public void plusOne() {

        int[] digits = {1,2,3,4};
        int[] nums2 = {4,3,9,9};

        int count = digits.length;
        for(int i = count-1; i>=0;i--){
            if(digits[i]< 9){
                digits[i]++;
                log.debug("****** plusOne ****** " + Arrays.toString(digits));
            }

            digits[i] = 0;
        }

        int[] newNum = new int[count +1];
        newNum[0] = 0;

//        log.debug("****** plusOne ****** " + Arrays.toString(newNum));


    }

}
