package com.guo.practice.codepractice.problems;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class thews {

    @Test
    public void selectUniqueString() {
        String notUnique = "aabbcdeeffgghiijkll";
        String unique = getUniqueString(notUnique);

        System.out.println(unique);
    }

    private String getUniqueString(String notUnique) {

        // create a cha[] from string
        char[] carry = notUnique.toCharArray();
        // create map and save character as key and count as value
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < carry.length; i++) {
            map.put(carry[i], map.getOrDefault(carry[i] , 0) + 1);
        }

        // loop through the key and find value 1, create new string
        StringBuilder stringBuilder = new StringBuilder();

        map.keySet().forEach(key -> {
            if (map.get(key).intValue() == 1) {
                stringBuilder.append(key);
            }
        });

        return stringBuilder.toString();
    }
}
