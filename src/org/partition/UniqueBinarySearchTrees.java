package org.partition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(2);
        //  1  null 2  null null
        //  2  1  null null null
        print(res);
    }

    private static void print(List<TreeNode> res) {
        for (TreeNode node : res) {
            printTree(node);
            System.out.println();
        }
    }

    private static void printTree(TreeNode node) {
        if (node == null) {
            System.out.print(" " + "null");
            return;
        }
        System.out.print(" " + node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        return generateSubtrees(1, n);
    }

    private static List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; ++i) {
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
