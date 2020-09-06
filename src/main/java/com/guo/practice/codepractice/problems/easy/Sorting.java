package com.guo.practice.codepractice.problems.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Sorting {

    public static void main(String[] args) {

        /**
         * test bubble sort
         *
         */
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        testBubbleSort(numbers);
        testSelectingSort(numbers);
        testInsertionSort(numbers);


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


    static void testSelectingSort(int[] array) {
        if (array.length == 0) {
            log.debug("empty array");
        }

        for (int i = 0; i < array.length; i++) {
            int temp = array[i];

            // set i to minimum
            int min = i;

            /////////////////////
            // j = i + 1
            //////////////////////
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            array[i] = array[min];
            array[min] = temp;
        }

        log.debug("****** testSelectingSort: " + Arrays.toString(array));
    }


    static void testInsertionSort(int[] array) {
        if (array.length == 0) {
            log.debug("empty array");
            return;
        }

        Integer[] boxedArray = Arrays.stream(array).boxed().toArray(Integer[]::new);

        List<Integer> list = new ArrayList<>(Arrays.asList(boxedArray));

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(0)) {
                list.add(0, list.get(i));
                list.remove(i + 1);
            } else {
                // else check where should the number be placed and move it.
                if (list.get(i) < list.get(i - 1)) {
                    for (int j = 1; j < i; j++) {
                        if (list.get(i) < list.get(j)) {
                            list.add(j, list.remove(i));
                            // end inner loop after element moved.
                            break;
                        }
                    }
                }

            }
        }


        log.debug("****** testInsertionSort: " + Arrays.toString(array));
    }

    public static long solution(long[] numbers) {
        // Type your solution here

        int len = numbers.length;
        if (len == 0) {
            return 0;
        }

        long max = numbers[0];

        for (int i =1; i<len; i++){
            long temp = numbers[i];
            if (numbers[i] > numbers[i - 1]) {
                if (temp > max) {
                    max = temp;
                }
            } else {
                if (numbers[i - 1] > max) {
                    max = numbers[i - 1];
                }
            }

        }

        return max;
    }


//#1 - Sort 10 schools around your house by distance:
//    insertion sort ---> fewer items

//#2 - eBay sorts listings by the current Bid amount:
    //    radix or counting sort  ---> small number range, fix length integers.

//#3 - Sport scores on ESPN
    //    Quick sort or merge sort


//#4 - Massive database (can't fit all into memory) needs to sort through past year's user data
//    merge sort --> not sorting in memory, don't want quick sort worst case


//#5 - Almost sorted Udemy review data needs to update and add 2 new reviews
// insertion sort --> nearly sorted


//#6 - Temperature Records for the past 50 years in Canada
    // radix , counting sort. integer within small range.
    // quick sort if have double / float

//#7 - Large user name database needs to be sorted. Data is very random.
// merge sort


//#8 - You want to teach sorting for the first time
// bubble sort


}
