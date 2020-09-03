package com.guo.practice.codepractice.problems.easy;

import java.util.LinkedList;

public class ArrayCollection {

    public static void main(String[] args) {
        System.out.println("*** ArrayCollection Main *** ");

        int[] arr1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        removeDupeFromSortedArray(arr1);
//        removeDuplicates(arr1);


    }

    //    https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/
    static void removeDupeFromSortedArray(int[] arr1) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        int i = 0;
        for (int j = 1; j < arr1.length; j++) {
            if (arr1[i] != arr1[j]) {
                System.out.println(arr1[i]);
                linkedList.addLast(arr1[i]);
                i++;
                arr1[i] = arr1[j];
            }
        }
    }

    // suggested solution
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
//                System.out.println(nums[i]);
            }
        }
        return i + 1;
    }


    //        ------------------------------------------------------------------------        //

    /**
     * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/564/
     * https://youtu.be/Q-8JkdUliVM
     *
     * @param array
     * @return
     */
    static int buyAndSaleStock(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int price = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                price += array[i - 1] - array[i];
            }
        }

        return price;
    }


}
