package com.guo.practice.codepractice.problems.easy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
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

//        LinkedList linkedList = new LinkedList();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(4);
//        linkedList.add(5);
//
//        ListNode listNode = new ListNode(1);
//
//
//        ListNode currentNode = new ListNode(2);
//
//        listNode.next = currentNode;
//        int count = 3;
//        while (count < 6) {
//            currentNode.next = new ListNode(count);
//            currentNode = currentNode.next;
//
//            count++;
//
//        }
//
//
////       ListNode listN =  reverseSingleLinkedList(listNode);
//        log.debug("*** reverse linked list ***");
//
//
//        ListNode ln = reverseBetween(listNode, 2, 4);
//
//        log.debug("*** reverse linked list Between *** " + ln);

        //        ------------------------------------------------------------------------        //

//        int[] nums = {3, 3};
//        int[] arr = twoSum(nums, 6);

        // mergeIntervals

//        int[][] intervalarray = new int[][]{
//                {1, 3},
//                {2, 6},
//                {8, 10},
//                {15, 18}
//        };
//
//        mergeIntervals(intervalarray);

        //        ------------------------------------------------------------------------        //

        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};
        intersect(arr1, arr2);


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
     * https://leetcode.com/problems/intersection-of-two-arrays-ii/
     *
     * @param nums1
     * @param nums2
     * @return
     *
     *
     * time: O(m + n)
     * space: O(min(m,n))
     */

    public static int[] intersect(int[] nums1, int[] nums2) {

        // time: O(m + n)

        // 1. because we need to show intersect from duplicate values as well
        // 2. make sure largest in map
//        if (nums1.length > nums2.length) {
//            return intersect(nums2, nums1);
//        }
//
//        // new map to store array
//        Map<Integer, Integer> map = new HashMap();
//        // list to store out put
//        List<Integer> output = new ArrayList<>();
//
//        for (int i = 0; i < nums2.length; i++) {
//            if (map.containsKey(nums2[i])) {
//                map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
//            } else {
//                map.put(nums2[i], 1);
//            }
//        }
//
//        for (int j = 0; j < nums1.length; j++) {
//            if (map.containsKey(nums1[j])) {
//                if (map.get(nums1[j]) > 0) {
//                    output.add(nums1[j]);
//                    map.put(nums1[j], map.get(nums1[j]) - 1);
//                }
//            }
//        }
//
//        int[] result = new int[output.size()];
//        for (int k = 0; k < output.size(); k++) {
//            result[k] = output.get(k);
//        }
//        log.debug("*** intersect *** :" + Arrays.toString(result));


//        ////////////////////////////////////////////////

        List<Integer> list1 = getArrayList(nums1);
        List<Integer> list2 = getArrayList(nums2);

        list2.retainAll(list1);
        int[] result = new int[list2.size()];


        for(int i = 0; i< list2.size(); i++){
            result[i] = list2.get(i).intValue();
        }
        log.debug("*** intersect *** :" + Arrays.toString(result));

        return result;

    }

    private static List<Integer> getArrayList(int[] array){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< array.length; i++){
            list.add(array[i]);
        }
        return list;
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

        // 1. loop to node of index n

        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        // front of current list
        ListNode front = prev;
        // last node of current list
        ListNode tail = curr;

        while (n > 0) {
            // temp next
            ListNode temp = curr.next;
            // swap next to pre, similar to make pre (next) to null
            curr.next = prev;
            // move forward list
            prev = curr;
            curr = temp;
            n--;
        }

        if (front != null) {
            front.next = prev;
        } else {
            front = head;
        }

        // link tail to
        tail.next = curr;
        return head;
    }


    /**
     * Two Sum
     */
    public static int[] twoSum(int[] nums, int target) {
        //////////////////////////////
        // brute force
        //////////////////////////////

        // assume only one solution
        /*
        for(int i = 0; i< nums.length; i++){
            for(int j = i + 1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                  return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("Error processing twoSum");
        */

        //////////////////////////////
        // HashMap
        //////////////////////////////

        if (nums.length == 2) {
            return new int[]{0, 1};
        }

        Map<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return result;

    }


    /**
     * Number of Islands
     * <p>
     * loop through 2d array
     */
    public static int numIslands(char[][] grid) {
        // count island
        // if bfs number 1,
        int count = 0;

        // loop through 2D array
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; i++) {
                // if found island, check around island with bsf
                if (grid[i][j] == '1') {
                    // count + 1
                    count++;

                    // check around island '1'
                    callBSF(grid, i, j);
                }
            }
        }

        // return count
        return count;

    }

    private static void callBSF(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        // set island number to 0
        grid[i][j] = '0';

        // check around island with BFS
        callBSF(grid, i + 1, j); // up
        callBSF(grid, i - 1, j); // down
        callBSF(grid, i, j + 1); // right
        callBSF(grid, i, j - 1); // left

    }


    /**
     * Merge Intervals
     */
    public static int[][] mergeIntervals(int[][] intervals) {
        // if only one array, there will be no intervals
        if (intervals.length <= 1) {
            return intervals;
        }

        // Make sure array is sorted
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

//        interval size will be dynamic, we need dynamic array
        List<int[]> outPutArray = new ArrayList<>();

        // create current array for loop and add current array in out put list
        // update current array value if required
        int[] currentArray = intervals[0];
        outPutArray.add(currentArray);
        for (int i = 1; i < intervals.length; i++) {
            // due to array only have 2 values in each array
            // compare begin and end in arrays

            int currentBegin = currentArray[0];
            int currentEnd = currentArray[1];

            // get next begin / end
            int nextBegin = intervals[i][0];
            int nextEnd = intervals[i][1];

            // consider equal value as well
            if (currentEnd >= nextBegin) {
                // update current array value
                currentArray[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentArray = intervals[i];
                outPutArray.add(currentArray);
            }
        }

        return outPutArray.toArray(new int[outPutArray.size()][]);
    }


    /**
     * Valid Parentheses
     * https://leetcode.com/problems/valid-parentheses/
     * <p>
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     */
    public boolean isValid(String s) {

        // TODO: 09/09/2020  practice
        // reason using stack: bracket open should followed by close

        Stack<Character> stack = new Stack<>();

        // 1. check length can be divided by 2
 

        // 2. Create hash map with key close bracket / value beginning bracket

        // we use close to find open

        // 3. check stack is empty / char is valid / the value in stack is matching


        // 4. push char to stack if not match

        // return stack empty check


        return stack.isEmpty();
    }


}
