package com.guo.practice.codepractice.problems;

import com.guo.practice.codepractice.problems.easy.BinaryTree;
import com.guo.practice.codepractice.problems.model.Node;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class BinaryTreeTest {

    private BinaryTree tree;

    @BeforeEach
    public void before() {
        tree = new BinaryTree();
        tree.insertValue(9);
        tree.insertValue(4);
        tree.insertValue(6);
        tree.insertValue(20);
        tree.insertValue(170);
        tree.insertValue(15);
        tree.insertValue(1);
    }

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
        Assertions.assertEquals(9, tree.findValueLoop(9).getValue());
        Assertions.assertEquals(9, tree.findValueRecursive(9).getValue());


//        tree.removeValue(170);
//        tree.removeValue(4);

//        Assertions.assertNull(tree.findValueLoop(9));

    }


    @Test
    public void testBreadthFirst() {
//        List<Integer> list = tree.breadthFirstSearch();
        List<Integer> list = tree.bfsRecursive();
        Assertions.assertFalse(list.isEmpty());
    }

    //    DFSpre [ 9, 4, 1, 6, 20, 15, 170 ]
    //    DFSin [ 1, 4, 6, 9, 15, 20, 170 ]
    //    DFSpost [ 1, 6, 4, 15, 170, 20, 9 ]

    @Test
    public void testInOrderTraversal() {
        List<Integer> l = tree.inOrderDFS();
        log.debug("**** testInOrderTraversal: " + Arrays.toString(l.toArray()));
        Assertions.assertTrue(l.get(3) == 9);
    }

    @Test
    public void testPreOrderTraversal() {
        List<Integer> list = tree.preOrderDFS();
        log.debug("**** testPreOrderTraversal: " + Arrays.toString(list.toArray()));
        Assertions.assertTrue(list.get(3) == 6);
    }

    @Test
    public void testPostOrderTraversal() {
        List<Integer> list = tree.postOrderDFS();
        log.debug("**** testPostOrderTraversal: " + Arrays.toString(list.toArray()));
        Assertions.assertTrue(list.get(3) == 15);

    }
}
