package com.guo.practice.codepractice.problems.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 1. create Node class in binary tree
 */
@Setter
@Getter
public class Node {
    public int value;
    public Node left;
    public Node right;
    public boolean visited;

    // 2. create new node with value constructor
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // 3. getter and setter wit lombok




}
