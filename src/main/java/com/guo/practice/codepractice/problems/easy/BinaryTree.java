package com.guo.practice.codepractice.problems.easy;

public class BinaryTree {

    // 2. start with root node
    Node root;

    public BinaryTree() {
    }

    /**
     * insert new node
     *
     * @param value
     * @return
     */
    public Node insertValue(int value) {
        return insertNodeLoop(this.getRoot(), value);
//        return insertNodeRecursive(this.getRoot(), value);
    }

    /**
     * @param node
     * @param value
     * @return
     */
    private Node insertNodeLoop(Node node, int value) {
        Node newNode = new Node(value);
        if (node == null) {
            this.root = newNode;
            return getRoot();
        }

        Node currentNode = node;

        // return to break while loop when compete add new node
        while (true) {
            // add new node to left
            if (currentNode.getValue() > value) {
                if (currentNode.getLeft() != null) {
                    currentNode = node.getLeft();
                } else {
                    currentNode.setLeft(newNode);
                    return node;
                }
            } else {
                if (currentNode.getRight() != null) {
                    currentNode = currentNode.getRight();
                } else {
                    currentNode.setRight(newNode);
                    return node;
                }
            }
        }
    }


    /**
     * Only can insert to null, so make sure left or right is null
     *
     * @param node
     * @param value
     * @return
     */
    private Node insertNodeRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (node.getValue() > value) {
            // add new node to left of the node
            // recursive until node is null
            insertNodeRecursive(node.getLeft(), value);
        } else {
            // add new node to right of the node
            insertNodeRecursive(node.getRight(), value);
        }

        return node;
    }


    /**
     * Find node bu value
     *
     * @param value
     * @return
     */
    public Node findValueLoop(int value) {
        Node currentNode = this.root;
        if (currentNode == null) {
            return currentNode;
        }

        // while loop loop current nodes
        while (true) {
            if (value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else if (value == currentNode.getValue()) {
                return currentNode;
            }
        }
    }

    /**
     * recursive way to find value
     *
     * @return
     */
    public Node findValueRecursive(int value) {
        return getNodeRecursive(getRoot(), value);
    }

    private Node getNodeRecursive(Node node, int value) {

        if (node == null) {
            return null;
        }

        if (node.getValue() > value) {
            getNodeRecursive(node.getLeft(), value);
        } else if (node.getValue() < value) {
            getNodeRecursive(node.getRight(), value);
        } else if (node.getValue() == value) {
            return node;
        }

        return null;
    }


    public Node getRoot() {
        return root;
    }

}


