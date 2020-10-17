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

    @Test
    public void fibonacci() {
        System.out.println(fib1(8));
        System.out.println(fib2(9));
    }

    /**
     * @param index
     * @return
     */
    private int fib1(int index) {
        if (index == 0 || index == 1) {
            return index;
        }
        return fib1(index - 1) + fib1(index - 2);
    }

    private int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int n0 = 0;
        int n1 = 1;
        int temp;

        // n is index -> i should equal to n
        for (int i = 2; i <= n; i++) {
            temp = n0 + n1;
            n0=n1;
            n1 = temp;
        }
        return n1;
    }


}
