package com.guo.practice.codepractice.problems;

import com.guo.practice.codepractice.problems.easy.BinaryTree;
import com.guo.practice.codepractice.problems.easy.Node;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class BinaryTreeTest {

    @Test
    public void testBinaryTreeInsert() {
        BinaryTree tree = new BinaryTree();
        Node node = tree.insertValue(9);

        Assertions.assertEquals(9, node.getValue());
    }

    @Test
    public void testFindValue() {
        BinaryTree tree = new BinaryTree();
        tree.insertValue(9);
        Assertions.assertEquals(9, tree.findValueLoop(9).getValue());
        Assertions.assertEquals(9, tree.findValueRecursive(9).getValue());
    }


    @Test
    public void testRemoveValue() {
        BinaryTree tree = new BinaryTree();
        tree.insertValue(9);
        tree.insertValue(4);
        tree.insertValue(6);
        tree.insertValue(20);
        tree.insertValue(170);
        tree.insertValue(15);
        tree.insertValue(1);
        Assertions.assertEquals(9, tree.findValueLoop(9).getValue());
        Assertions.assertEquals(9, tree.findValueRecursive(9).getValue());


        tree.removeValue(170);
        tree.removeValue(4);

        Assertions.assertNull(tree.findValueLoop(9));

    }


    @Test
    public void testBreadthFirst() {
        BinaryTree tree = new BinaryTree();
        tree.insertValue(9);
        tree.insertValue(4);
        tree.insertValue(6);
        tree.insertValue(20);
        tree.insertValue(170);
        tree.insertValue(15);
        tree.insertValue(1);

//        List<Integer> list = tree.breadthFirstSearch();
        List<Integer> list = tree.bfsRecursive();
        Assertions.assertFalse(list.isEmpty());
    }
}
