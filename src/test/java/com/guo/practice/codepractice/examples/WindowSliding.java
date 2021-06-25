package com.guo.practice.codepractice.examples;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

/**
 * https://www.geeksforgeeks.org/window-sliding-technique/
 * <p>
 * This technique shows how a nested for loop in some problems can be converted to a single for loop to reduce the time complexity.
 * Finding subarrays in an array that satisfy given conditions
 * <p>
 * https://youtu.be/jM2dhDPYMQM
 */
@Slf4j
public class WindowSliding {

    int[] arr = {-1, -2, 2, 3, 1, -3, 2};


    /**
     * Given an array of integers, find minimum / maximum sum subarray of the required size
     */
    @Test
    public void findSubArrayByGivenSize() {
        int subArraySize = 2;

        int minimum = arr[0] + arr[1];
        int maximum = 0;
        int i = 0;

        // init start / end index
        int maxStartIndex = 0;
        int maxEndIndex = 1;
        int minStartIndex = 0;
        int minEndIndex = 1;

        for (int j = subArraySize - 1; j < arr.length; j++) {

            if ((arr[i] + arr[j]) > maximum) {
                maximum = arr[i] + arr[j];
                maxStartIndex = i;
                maxEndIndex = j;
            }

            if ((arr[i] + arr[j]) < minimum) {
                minimum = arr[i] + arr[j];
                minStartIndex = i;
                minEndIndex = j;
            }

            i++;
        }

        log.info(String.format("Minimum sum : %s  --- Max sum: %s ", minimum, maximum));

        log.info(String.format("Minimum sub array: [%s, %s]", arr[minStartIndex], arr[minEndIndex]));
        log.info(String.format("Maximum sub array: [%s, %s]", arr[maxStartIndex], arr[maxEndIndex]));

        Random random = new Random();


    }

    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts - 1) return 1.0;
        double dp[] = new double[n + 1];
        double possibility = 0.0;
        double wSum = 1.0;

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = wSum / maxPts;
            if (i < k) {
                wSum += dp[i];
            } else {
                possibility += dp[i];
            }
            if (i - maxPts >= 0) {
                wSum -= dp[i - maxPts];
            }
        }
        return possibility;
    }

}
