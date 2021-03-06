package com.guo.practice.codepractice.problems.leetcode.topInterview;

import com.guo.practice.codepractice.problems.model.Node;
import com.guo.practice.codepractice.problems.model.TreeNode;
import com.sun.source.tree.Tree;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class TreeQuestions {

    /**
     * Maximum Depth of Binary Tree
     * <p>
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/
     */
    @Test
    public void maxDepth(TreeNode root) {

        int[] count = {0, 0};
        traversal(root, count);

        log.debug("*** maxDepth *** " + Math.max(count[0], count[1]));


//        return 0;

    }

    private void traversal(TreeNode node, int[] count) {

        if (node.left != null) {

            count[0] = count[0]++;
            traversal(node.left, count);
        }

        if (node.right != null) {

            count[1] = count[1]++;
            traversal(node.right, count);
        }

    }


    @Test
    public void isValidBST() {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(6);


        boolean flag = true;

        TreeNode left = node.left;
        TreeNode right = node.right;

        if (node.right.val < node.val || node.left.val > node.val) {
            flag = false;
        }

        while (left != null && left.left != null) {
            if (left.val < left.left.val) {
                flag = false;
                break;
            }

            left = left.left;
        }

        while (right != null && right.right != null) {
            if (right.val > right.right.val) {
                flag = false;
                break;
            }
            right = right.right;
        }

        log.debug("****** isValidBST ****** " + flag);

    }

    @Test
    public void testGraphRootBetweenNodes() {

        Node node = new Node(5);
        node.left = new Node(1);
        node.right = new Node(4);
        node.right.left = new Node(3);
        node.right.right = new Node(6);

        // check root node not null
        if (node == null) {
            return;
        }


        ///////////////////////////////////////////////////
        ///////////    dfs   ///////////////////////////
        System.out.println("**************  DFS  ******************");

        testGraphDFS(node);


        ///////////////////////////////////////////////////

        System.out.println("**************  BFS  ******************");
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            // peek retrieve but not remove
            Node processNode = queue.peek();
            if (!processNode.isVisited()) {
                processNode.setVisited(true);
                visit(processNode);
            }
            queue.remove();
            if (processNode.left != null) {
                queue.add(processNode.left);
            }

            if (processNode.right != null) {
                queue.add(processNode.right);

            }


        }
        System.out.println("Loop end");


    }

    private void visit(Node node) {
        System.out.println("*** Visited Node value *** " + node.value);
    }

    public void testGraphDFS(Node root) {

        if (root == null) {
            return;
        }

        // pre-order
//        visit(root);
        if (root.left != null) {
            testGraphDFS(root.left);
        }
// in order
        visit(root);

        if (root.right != null) {
            testGraphDFS(root.right);
        }

// post order
//        visit(root);

    }

    @Test
    public void invertBinaryTreeTest() {


    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }


    @Test
    public void levelOrderBFSTest() {

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        List<List<Integer>> output = levelOrder(node);
        log.info(output.toString());
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> que = new LinkedList();
        que.add(root);

        while (!que.isEmpty()) {
            List<Integer> currentLevel = new ArrayList();
            int size = que.size();
            for (int i = 0; i < size; i++) {

                log.info("*** Queue size: "+ que.size() + " ------ i value: " + i );

                TreeNode removeNode = que.remove();
                currentLevel.add(removeNode.val);

                if (removeNode.left != null) {
                    que.add(removeNode.left);
                }
                if (removeNode.right != null) {
                    que.add(removeNode.right);
                }
            }

            lists.add(currentLevel);
        }
        return lists;

    }


}
