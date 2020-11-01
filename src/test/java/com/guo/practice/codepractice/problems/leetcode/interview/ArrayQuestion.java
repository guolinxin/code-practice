package com.guo.practice.codepractice.problems.leetcode.interview;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        System.out.println(fibD(10));
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
            n0 = n1;
            n1 = temp;
        }
        return n1;
    }

    /**
     * Dynamic
     *
     * @param n
     * @return
     */
    Map<Integer, Integer> fibMap = new HashMap<>();

    private int fibD(int n) {
        if (fibMap.containsKey(n)) {
            return fibMap.get(n);
        }
        if (n == 0 || n == 1) return n;
        int fibValue = fibD(n - 1) + fibD(n - 2);
        fibMap.put(n, fibValue);
        return fibValue;
    }

    @Test
    public void testSET() {
        Set<String> set = new HashSet<>();
        String str = "java11";
        set.add(str);
        set.add(str);

        set.forEach(System.out::println);
    }

    @Test
    public void firstUniqueChar() {
        String str = "aabbcddeffghhi";
        String firstUnique = findFirstUnique(str);

//        System.out.println(firstUnique);
    }

    private String findFirstUnique(String str) {
        // 1. if all characters are alphabet
        // create boolean array with 26 and only lower case

        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count[c - 'a'] = count[c - 'a'] + 1;

            System.out.println(count[c - 'a']);
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (count[c - 'a'] == 1) {
                return String.valueOf(str.charAt(i));
            }
        }


        return "";

    }

    @Test
    public void testLetter() {
        String lettere = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 26; i++) {
            Character c = lettere.charAt(i);
            int intc = lettere.charAt(i);
            System.out.println("letter: " + c + " -> number: " + intc);
        }
    }

    @Test
    public void findDupInArrayTest() {
//        Input:[4,3,2,7,8,2,3,1]
//        Output:[2,3]
        int[] intArr = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = new ArrayList();
        // 1 sort array

        Arrays.sort(intArr);

        // compare element 1 and 2 if equal,
        for(int i=0;i< intArr.length; i++){
            if(intArr.length == i + 1){
                break;
            }
            if(intArr[i] == intArr[i+1]){
                list.add(intArr[i]);
            }
        }

        list.stream().forEach(System.out::println);

    }


}
