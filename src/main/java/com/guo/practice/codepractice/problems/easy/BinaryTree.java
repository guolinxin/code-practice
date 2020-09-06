package com.guo.practice.codepractice.problems.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
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


    /**
     * Remove value from tree ????????
     *
     * @return
     */
    public Node removeValue(int value) {
        return deleteNodeRecursive(getRoot(), value);
    }

    private Node deleteNodeRecursive(Node node, int value) {

        // TODO: 06/09/2020 try remove value in better way

        if (node == null) {
            return null;
        }

        if (value < node.getValue()) {
            deleteNodeRecursive(node.getLeft(), value);
            return node;
        } else if (value > node.getValue()) {
            deleteNodeRecursive(node.getRight(), value);
            return node;
        } else if (value == node.getValue()) {

            // case 1 : node has no child
            if (node.getRight() == null && node.getLeft() == null) {
                node = null;
                return null;
            }

            // case 2 : node has one child
            if (node.getLeft() == null) {
                return node.getRight();
            }

            if (node.getRight() == null) {
                return node.getLeft();
            }


            // case 3 : node has 2 children

            // find smallest value
            int smallest = findSmallestValue(node);
            node.setValue(smallest);
            node.setRight(deleteNodeRecursive(node.getRight(), smallest));
            return node;

        }

        return null;
    }

    private int findSmallestValue(Node node) {
        return node.getLeft() == null ? node.getValue() : findSmallestValue(node.getLeft());
    }


    /**
     * Breadth first search - BFS
     *
     * @return
     */
    public List<Integer> breadthFirstSearchLoop() {

        // 1. use queue to insert / remove nodes and loop through all nodes
        List<Integer> results = new ArrayList<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {

            Node removedNode = nodeQueue.poll();

            results.add(removedNode.getValue());

            if (removedNode.getLeft() != null) {
                nodeQueue.add(removedNode.getLeft());
            }

            if (removedNode.getRight() != null) {
                nodeQueue.add(removedNode.getRight());
            }
        }

        log.debug("*** breadthFirstSearch : " + Arrays.toString(results.toArray()));
        return results;

    }

    public List<Integer> bfsRecursive() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        return breadthFirstSearchRecursive(queue, new ArrayList<>());
    }

    private List<Integer> breadthFirstSearchRecursive(Queue<Node> queue, List<Integer> list) {
        if (queue.isEmpty()) {
            return Collections.emptyList();
        }

        // remove first from queue. fifo
        Node removedNode = queue.poll();
        if (removedNode.getLeft() != null) {
            list.add(removedNode.getValue());
            queue.add(removedNode.getLeft());
            return breadthFirstSearchRecursive(queue, list);
        }

        if (removedNode.getRight() != null) {
            list.add(removedNode.getValue());
            queue.add(removedNode.getRight());
            return breadthFirstSearchRecursive(queue, list);
        }

        return list;
    }

    public Node getRoot() {
        return root;
    }

}


