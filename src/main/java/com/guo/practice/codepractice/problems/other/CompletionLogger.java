package com.guo.practice.codepractice.problems.other;

public interface CompletionLogger {

    default void log(String msg)
    {
        System.out.println("Completed: " + msg);
    }
}
