package LeetCode;

/**
 * 654: Maximum Binary Tree
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

 The root is the maximum number in the array.
 The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 Construct the maximum tree by the given array and output the root node of this tree.

 Input: [3,2,1,6,0,5]
 Output: [6,3,5,null,2,0,null,null,1]
    -Display output using breadth first search
 * Created by edwardwang on 10/18/17.
 */
public class MaximumBinaryTree {
    public static void main(String args[]){
        System.out.println("LeetCode: 654: Maximum Binary Tree");
        int[] input = new int[]{3,2,1,6,0,5};
        TreeNode tree = constructMaximumBinaryTree(input);
    }

    static TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int rootIndex = getMaxIndex(nums);
        TreeNode root = new TreeNode(nums[rootIndex]);
        for(int i=0;i<(rootIndex-1);i++){
            if(nums[i] != 0){

            }
            addNewNode(root.left, root, nums[i],root.val);
        }
        if(rootIndex < nums.length){
            for(int i=nums.length-1;i>(rootIndex+1);i--){
                addNewNode(root.right, root, nums[i], root.val);
            }
        }
        return root;
    }

    static void addNewNode(TreeNode currNode, TreeNode prevNode, int value, int rootValue){
        if(currNode == null){
            if((prevNode.val/rootValue) > (value/rootValue)){
                prevNode.left = new TreeNode(value);
            }else{
                prevNode.right = new TreeNode(value);
            }
        }else{
            if((currNode.val/rootValue) > (value/rootValue)){
                addNewNode(currNode.left, currNode, value, rootValue);
            }else{
                addNewNode(currNode.right, currNode, value, rootValue);
            }
        }
    }

    static int getMaxIndex(int[] nums){
        int maxIndex = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    //Breadth First Search Display
    static void printTree(TreeNode node){

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
