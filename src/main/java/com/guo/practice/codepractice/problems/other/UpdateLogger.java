package com.guo.practice.codepractice.problems.other;


public interface UpdateLogger {
    default void log(String msg)
    {
        System.out.println("Update: " + msg);
    }
}
