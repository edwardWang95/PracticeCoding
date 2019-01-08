package LeetCode;

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

            return false;
        }

        //recursive traversal inorder of both trees to make sure they have same values
        private boolean bstTraversal(TreeNode output, TreeNode solution)
        {
            //base check for recursive statements
            if(output == null && solution != null ||
            output != null && solution == null) return false;
            else if(output.val != solution.val) return false;
            //in order traversal part
            bstTraversal(output.left, output.left);
            bstTraversal(output.right, output.right);
            return true;
        }
    }
    public static void main(String[] args)
    {
        testTrimABinarySearchTreeTestIsCorrect();
        /*
        TrimABinarySearchTreeTest test = buildTree1();
        TrimABinarySearchTreeSolution solution = new TrimABinarySearchTreeSolution();
        System.out.println("Test1 - " +
                (test.isCorrect(solution.trimBST(test.input, test.L, test.R)) ? "Correct" : "Incorrect"));
        */
    }

    //Create test tree nodes to confirm isCorrect functionality of TrimABinarySearchTreeTest
    private static void testTrimABinarySearchTreeTestIsCorrect()
    {
        int L = 1, R = 2;
        TreeNode inputTree = new TreeNode(1);
        inputTree.right = new TreeNode(2);
        TreeNode outputTree = new TreeNode(1);
        outputTree.right = new TreeNode(2);
        TrimABinarySearchTreeTest trimABinarySearchTreeTest = new TrimABinarySearchTreeTest(inputTree, outputTree, L, R);
        System.out.println("Testing test isCorrect Method output: " + trimABinarySearchTreeTest.isCorrect(outputTree));
    }

    private static TrimABinarySearchTreeTest buildTree1()
    {
        int L = 1, R = 2;
        TreeNode inputTree = new TreeNode(1);
        inputTree.left = new TreeNode(0);
        inputTree.right = new TreeNode(2);
        TreeNode outputTree = new TreeNode(1);
        outputTree.right = new TreeNode(2);
        return new TrimABinarySearchTreeTest(inputTree, outputTree, L, R);
    }
}

class TrimABinarySearchTreeSolution {
    public TreeNode trimBST(TreeNode root, int L, int R)
    {
        TreeNode newTree = new TreeNode(root.val);

        return newTree;
    }
}