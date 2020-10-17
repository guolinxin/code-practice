package com.guo.practice.codepractice.problems.leetcode.topInterview;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

@Slf4j
public class SortSearchQuestion {


    /**
     * Merge Sorted Array
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/
     */
    @Test
    public void mergeSortedArray() {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        // check index value and loop backward, 0 inclusive.

        int index = m + n - 1;
        int firIndex = m - 1;
        int secIndex = n - 1;

        for (int i = index; i >= 0; i--) {
            if (secIndex <= 0) {
                break;
            }
            if (nums2[secIndex] > nums1[firIndex]) {
                nums1[i] = nums2[secIndex];
                secIndex--;
            } else {
                nums1[i] = nums1[firIndex];
                firIndex--;
            }
        }


    }

}
