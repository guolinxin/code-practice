package com.guo.practice.codepractice.problems.easy;

/**
 * 1. create Node class in binary tree
 */
public class Node {
    private int value;
    private Node left;
    private Node right;

    // 2. create new node with value constructor
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // 3. getter and setter

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}