package com.guo.practice.codepractice.problems.leetcode.topInterview;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

@Slf4j
public class GraphQuestion {


    /**
     * https://leetcode.com/problems/find-center-of-star-graph/
     */
    @Test
    public void findCenterTest() {

        int[][] graph = {{1, 2}, {2, 3}, {4, 2}};

        int outPut = findCenter(graph);
        log.info("center: " + outPut);

    }

    private int findCenter(int[][] edges) {
        // Center should exit in each edge.
        // So we can know which node is the center in the first edge
        // by compare the node in first edge and second edge.
        // Time complexity: O(1)
        // Space complexity: O(1)

        if (edges[1][0] == edges[0][0] || edges[1][1] == edges[0][0]) return edges[0][0];
        return edges[0][1];
    }

    private int findCenter2(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] rows : edges) {
            map.put(rows[0], map.getOrDefault(rows[0], 0) + 1);
            map.put(rows[1], map.getOrDefault(rows[1], 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) == map.size() - 1) return i;
        }
        return 0;
    }

}
