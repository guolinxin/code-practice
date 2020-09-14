package com.guo.practice.codepractice.problems.leetcode.topInterview;

import com.guo.practice.codepractice.problems.model.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

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
    public void isValidBST( ) {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(6);




        boolean flag = true;

        TreeNode left = node.left;
        TreeNode right = node.right;

        if(node.right.val < node.val || node.left.val > node.val){
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

}
