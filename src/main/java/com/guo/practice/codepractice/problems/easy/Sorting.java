package com.guo.practice.codepractice.problems.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Sorting {

    public static void main(String[] args) {

        /**
         * test bubble sort
         *
         */
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        testBubbleSort(numbers);


    }


    static void testBubbleSort(int[] array) {
        if (array.length == 0) {
            log.debug("empty array");
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                int temp = array[j];
                if (array[j - 1] > array[j]) {
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        log.debug("****** testBubbleSort: " + Arrays.toString(array));
    }
}
