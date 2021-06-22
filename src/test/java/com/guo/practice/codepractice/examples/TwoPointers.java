package com.guo.practice.codepractice.examples;

import org.junit.jupiter.api.Test;

/**
 * Searching pairs in a sorted array.
 * https://www.geeksforgeeks.org/two-pointers-technique/
 */
public class TwoPointers {

    /**
     * Searching pairs in a sorted array.
     * find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.
     */
    @Test
    public void findPairWithGivenSum() {
        int targetSum = 11;
        int[] arr = {0, 1, 2, 2, 3, 4, 5, 6, 7};

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            int tempSum = arr[i] + arr[j];
            if (tempSum != targetSum) {
                i++;
            } else {
                System.out.println(String.format("element: [%s, %s]", arr[i], arr[j]));
            }
        }
    }


    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     * <p>
     * because its sorted, duplicate will be together, so, two pointer
     */
    @Test
    public void removeDupeFromSortedArray() {
//        int[] arr1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; need to reduce the arr1
        int[] arr1 = {1, 1, 2};

        if (arr1.length == 0) {
            System.out.println(0);
        }

        int i = 0;
        for (int j = 1; j < arr1.length; j++) {
            if (arr1[i] != arr1[j]) {
                i++;
                arr1[i] = arr1[j];
            }
        }
        System.out.println(i + 1);
    }


}
