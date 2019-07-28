package LeetCode;

import LeetCode.ReUsedObjects.TreeNode;

/**
 * Created by edwardwang on 1/7/19.
 */
public class TrimABinarySearchTree {
    //Example that has the input TreeNode, L, R and expected output
    static class TrimABinarySearchTreeTest
    {
        TreeNode input, output;
        int L,R;
        TrimABinarySearchTreeTest(TreeNode input, TreeNode output, int L, int R)
        {
            this.input = input;
            this.output = output;
            this.L = L;
            this.R = R;
        }
        //Perform BST traversal and make sure each node is same on both trees
        public boolean isCorrect(TreeNode solution)
        {
            return bstTraversal(output, solution);
        }

        /*
        * First check if they are null. This is usually the base case.
        *
        * If not null then check their value.
        *
        * If using booleans can && between results of left and right of BST to return result.
        * */
        private boolean bstTraversal(TreeNode output, TreeNode solution)
        {
            //check if both are empty
            if(output == null && solution == null) return true;
            else if(output != null && solution != null)
            {
                //if not null for each, check their value and recursively continue search
                return output.val == solution.val &&
                        bstTraversal(output.left, solution.left) &&
                        bstTraversal(output.right, solution.right);
            }
            return false;
        }

        //my incorrect way of checking this
        private boolean bstTraversalIncorrect(TreeNode output, TreeNode solution)
        {
            //if one is null and other is not
            if(output == null && solution != null ||
            output != null && solution == null) return false;
            //if not same value
            if(output.val != solution.val) return false;
            //in order traversal part
            return bstTraversalIncorrect(output.left, solution.left) &&
                    bstTraversalIncorrect(output.right, solution.right);
        }
    }
    public static void main(String[] args)
    {
        TrimABinarySearchTreeSolution solution = new TrimABinarySearchTreeSolution();
        //Tests
        /*
        testLessThanExample(solution);
        testGreaterThanExample(solution);
        */
        leetCodeExample1(solution);
        leetCodeExample2(solution);
        leetCodeExample3(solution);
    }

    //Create test tree nodes to confirm isCorrect functionality of TrimABinarySearchTreeTest
    private static void testTrimABinarySearchTreeTestIsCorrect()
    {
        TreeNode inputTree = new TreeNode(1);
        inputTree.right = new TreeNode(2);
        TreeNode outputTree = new TreeNode(1);
        outputTree.right = new TreeNode(2);
        TrimABinarySearchTreeTest test =
                new TrimABinarySearchTreeTest(inputTree, outputTree, 1, 1);
        System.out.println("Testing test isCorrect Method output: " + test.isCorrect(inputTree));
    }

    /**
     * This example has 0 as left of root and it needs to be replaced by the following largest
     * node at it's right subtree, which is 1.
     * */
    private static void testLessThanExample(TrimABinarySearchTreeSolution solution)
    {
        int L = 1, R = 3;
        TreeNode inputTree = new TreeNode(2);
        inputTree.left = new TreeNode(0);
        inputTree.left.right = new TreeNode(1);
        inputTree.right = new TreeNode(3);
        TreeNode outputTree = new TreeNode(2);
        outputTree.left = new TreeNode(1);
        outputTree.right = new TreeNode(3);
        TrimABinarySearchTreeTest test = new TrimABinarySearchTreeTest(inputTree, outputTree, L, R);
        System.out.println("Test Less Than Example - " +
                (test.isCorrect(solution.trimBST(test.input, test.L, test.R)) ?
                        "Correct" : "Incorrect"));
    }

    private static void testGreaterThanExample(TrimABinarySearchTreeSolution solution)
    {
        int L = 1, R = 2;
        TreeNode inputTree = new TreeNode(1);
        inputTree.right = new TreeNode(2);
        inputTree.right.right = new TreeNode(3);
        TreeNode outputTree = new TreeNode(1);
        outputTree.right = new TreeNode(2);
        TrimABinarySearchTreeTest test = new TrimABinarySearchTreeTest(inputTree, outputTree, L, R);
        System.out.println("Test Greater Than Example - " +
                (test.isCorrect(solution.trimBST(test.input, test.L, test.R)) ?
                        "Correct" : "Incorrect"));
    }

    private static void leetCodeExample1(TrimABinarySearchTreeSolution solution)
    {
        int L = 1, R = 2;
        TreeNode inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(0);
        inputTree.right = new TreeNode(2);
        TreeNode outputTree = new TreeNode(1);
        outputTree.right = new TreeNode(2);
        TrimABinarySearchTreeTest test = new TrimABinarySearchTreeTest(inputTree, outputTree, L, R);
        System.out.println("Leet Code Example 1 - " +
                (test.isCorrect(solution.trimBST(test.input, test.L, test.R)) ?
                        "Correct" : "Incorrect"));
    }

    private static void leetCodeExample2(TrimABinarySearchTreeSolution solution)
    {
        int L = 1, R = 3;
        TreeNode inputTree = new TreeNode(3);
        inputTree.left = new TreeNode(0);
        inputTree.left.right = new TreeNode(2);
        inputTree.left.right.left = new TreeNode(1);
        inputTree.right = new TreeNode(4);
        TreeNode outputTree = new TreeNode(3);
        outputTree.left = new TreeNode(2);
        outputTree.left.left = new TreeNode(1);
        TrimABinarySearchTreeTest test = new TrimABinarySearchTreeTest(inputTree, outputTree, L, R);
        System.out.println("Leet Code Example 2 - " +
                (test.isCorrect(solution.trimBST(test.input, test.L, test.R)) ?
                        "Correct" : "Incorrect"));
    }

    private static void leetCodeExample3(TrimABinarySearchTreeSolution solution)
    {
        int L = 1, R = 1;
        TreeNode inputTree = new TreeNode(3);
        inputTree.left = new TreeNode(2);
        inputTree.left.left = new TreeNode(1);
        inputTree.right = new TreeNode(4);
        TreeNode outputTree = new TreeNode(1);
        TrimABinarySearchTreeTest test = new TrimABinarySearchTreeTest(inputTree, outputTree, L, R);
        System.out.println("Leet Code Example 3 - " +
                (test.isCorrect(solution.trimBST(test.input, test.L, test.R)) ?
                        "Correct" : "Incorrect"));
    }
}

class TrimABinarySearchTreeSolution {
    /**
     * Trims the BST for anything < L and > R
     * */
    public TreeNode trimBST(TreeNode node, int L, int R)
    {
        node = trimBSTLeft(node, L);
        node = trimBSTRight(node, R);
        return node;
    }

    /**
     * BST search lowest to highest
     * */
    private TreeNode trimBSTLeft(TreeNode node, int L)
    {
        //base case of recursive statement
        if(node == null) return null;
        //recursive traversal if within conditions
        if(node.val >= L)
        {
            if(node.left == null) return node;  //exit statement in case nothing left to check
            //return trimBSTLeft(node.left, L);
            node.left = trimBSTLeft(node.left, L);
            return node;
        }
        /**
         * Less than limit
         * 1] update current node to next largest node on its right subtree
         * 2] call recursive method from current node after update
         */
        node = getNextLargestTreeNode(node.right);
        return trimBSTLeft(node, L);
    }

    /**
     * BST search from highest to lowest
     * */
    private TreeNode trimBSTRight(TreeNode node, int R)
    {
        //base case of recursive statement
        if(node == null) return null;
        if(node.val <= R)
        {
            if(node.right == null) return node;
            node.right = trimBSTRight(node.right, R);
            //return trimBSTRight(node.right, R);
            return node;
        }
        node = getPreviousLargestTreeNode(node.left);
        return trimBSTRight(node, R);
    }

    private TreeNode getNextLargestTreeNode(TreeNode node)
    {
        //base statement
        if(node == null) return null;
        return node;
        //if(node.left == null) return node;
        //return getNextLargestTreeNode(node.left);
    }

    private TreeNode getPreviousLargestTreeNode(TreeNode node)
    {
        //start of with a null related base statement
        if(node == null) return null;
        return node;
        //if(node.right == null) return node;
        //return getPreviousLargestTreeNode(node.right);
    }
}