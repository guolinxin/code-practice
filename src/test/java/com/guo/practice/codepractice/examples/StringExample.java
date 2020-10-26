package com.guo.practice.codepractice.examples;

import org.junit.jupiter.api.Test;

public class StringExample {

    @Test
    public void stringReplace(){

        String s = "aa bb cc ss";
        s = s.replaceAll("\\s", "KK " );
        System.out.println(s);

    }


}
