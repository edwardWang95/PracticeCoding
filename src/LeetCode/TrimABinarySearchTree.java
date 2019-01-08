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
        //testTrimABinarySearchTreeTestIsCorrect();
        TrimABinarySearchTreeTest test = buildTree1();
        TrimABinarySearchTreeSolution solution = new TrimABinarySearchTreeSolution();
        System.out.println("Test1 - " +
                (test.isCorrect(solution.trimBST(test.input, test.L, test.R)) ?
                        "Correct" : "Incorrect"));
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