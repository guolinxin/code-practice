package com.guo.practice.codepractice.problems.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ArrayCollection {


    public static void main(String[] args) {
        System.out.println("*** ArrayCollection Main *** ");

// removeDupeFromSortedArray
//        int[] arr1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        removeDupeFromSortedArray(arr1);
//        removeDuplicates(arr1);
//
//        ------------------------------------------------------------------------        //
//
//        int[] array = {7, 1, 5, 3, 6, 4};
//        log.debug("*** buyAndSaleStock: " + buyAndSaleStock(array));
//
//        ------------------------------------------------------------------------        //
//
//        int[] array = {1, 2, 3, 4, 5, 6, 7};
//        rotateArrayBySteps(array, 3);

//        ------------------------------------------------------------------------        //
//
//        int[] array = {1,1,1,3,3,4,3,2,4,2};
//        int[] array = {1,2,3,1};
//        log.debug("*** containDuplicate: " + containDuplicate(array));
//
//
//        int[] array = {4, 1, 2, 1, 2};
//        singleNumber(array);


//        ------------------------------------------------------------------------        //

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        ListNode listNode = new ListNode(1);


        ListNode currentNode = new ListNode(2);

        listNode.next = currentNode;
        int count = 3;
        while (count < 6) {
            currentNode.next = new ListNode(count);
            currentNode = currentNode.next;

            count++;

        }


//       ListNode listN =  reverseSingleLinkedList(listNode);
        log.debug("*** reverse linked list ***");


        ListNode ln = reverseBetween(listNode, 2, 4);

        log.debug("*** reverse linked list Between *** " + ln);

    }

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/
     *
     * @param arr1
     */
    static int removeDupeFromSortedArray(int[] arr1) {

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

        return i + 1;
    }

    // suggested solution
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
//                log.debug("removeDuplicates: " + nums[i]);

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
                price += (array[i] - array[i - 1]);
            }
        }
        return price;
    }


    /**
     * Rotate Array
     * <p>
     * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/646/
     */
    static void rotateArrayBySteps(int[] array, int steps) {
        // primitive can not auto create to arraylist
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i = 0; i < array.length; i++) {
            linkedList.addLast(array[i]);
        }

        // steps is action and it start from 1 NOT 0
        for (int i = 1; i <= steps; i++) {
            Integer num = linkedList.getLast();
            linkedList.removeLast();
            linkedList.addFirst(num);
        }

        log.info("*** rotateArrayBySteps: " + Arrays.toString(linkedList.toArray()));

    }

    // suggested solution
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    //        ------------------------------------------------------------------------        //


    /**
     * Contains Duplicate
     * <p>
     * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/578/
     */
    static boolean containDuplicate(int[] array) {
        // if sorted, we can compare i with i + 1
        // use map to check not sorted
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.isEmpty() && map.get(array[i]) != null) {
                return true;
            }
            map.put(array[i], true);
        }
        return false;
    }


    //        ------------------------------------------------------------------------        //

    /**
     * singleNumber
     * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/549/
     */

    static int singleNumber(int[] nums) {
        int number = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        Set<Integer> keyset = map.keySet();
        for (Integer key : keyset) {
            if (map.get(key).intValue() == 1) {
                number = key.intValue();
            }
        }

        log.debug("*** single number: " + number);

        return number;

    }

    static int singlenumbersolutions(int[] nums) {
        int number = 0;
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i])) {
                integers.remove(nums[i]);
            } else {
                integers.add(nums[i]);
            }
        }
        Object[] array = integers.toArray();
        return (int) array[0];
    }


    /**
     * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/674/
     *
     * @param nums1
     * @param nums2
     * @return
     */

    public int[] intersect(int[] nums1, int[] nums2) {

        Set<Integer> integerSet = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){

            // TODO: 06/09/2020
        }

        return nums2;

    }


    /**
     * reverse linked list
     * https://leetcode.com/problems/reverse-linked-list/
     */

    public static ListNode reverseSingleLinkedList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            ListNode nextTemp = current.next;
            // 1. next and pre swap, , next become null
            current.next = prev;

            // 2. move forward prev one step
            // prev become curr
            prev = current;

            // 3. move forward current one step
            // current become next
            current = nextTemp;

            // continue looping
        }

        // return first element
        return prev;
    }

    /**
     * https://leetcode.com/problems/reverse-linked-list-ii/
     * hard
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode prev = null;
        ListNode curr = head;

        // 1. loop to position
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            // n need too minus as well
            n--;
        }

        // 2. store location of listNodes
        ListNode connection = prev;
        ListNode tail = curr;

        // 3. start reverse
        while (n > 0) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            n--;
        }

        if (connection != null) {
            // link next to revered linked list
            connection.next = prev;
        } else {
            head = prev;
        }

        // link tail to
        tail.next = curr;
        return head;

    }
}
