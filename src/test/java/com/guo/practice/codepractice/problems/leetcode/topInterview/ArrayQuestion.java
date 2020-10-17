package com.guo.practice.codepractice.problems.leetcode.topInterview;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

@Slf4j
public class ArrayQuestion {

    @Test
    public void plusOne() {

        int[] digits = {1, 2, 3, 4};
        int[] nums2 = {4, 3, 9, 9};

        int count = digits.length;
        for (int i = count - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                log.debug("****** plusOne ****** " + Arrays.toString(digits));
            }

            digits[i] = 0;
        }

        int[] newNum = new int[count + 1];
        newNum[0] = 0;

//        log.debug("****** plusOne ****** " + Arrays.toString(newNum));


    }

    @Test
    public void rotateArray1() {
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] array2 = {2, 3, 4, 5, 6, 7, 1};

        for (int i = 0; i < 3; i++) {
            rotateArrayFun(array1);
        }
        System.out.println(array1);

    }

    private int[] rotateArrayFun(int[] array) {
        int first = array[0];
        int i;
        for (i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[i] = first;

        return array;
    }


}
