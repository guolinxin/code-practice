package com.guo.practice.codepractice.problems.other;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class QuickTest {

    public static void main(String[] args) {
        testArray();

    }

    static void testArray() {

        int[] basket = {2, 56, 34, 2, 1, 7, 8};
        int[] arr = Arrays.stream(basket).sorted().toArray();
        Arrays.sort(basket);

        log.debug("Stream sorted: " + Arrays.toString(arr));
        log.debug("Arrays sorted: " + Arrays.toString(basket));
    }

}
