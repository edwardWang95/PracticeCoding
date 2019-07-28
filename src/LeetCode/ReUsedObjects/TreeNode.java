package LeetCode.ReUsedObjects;

import java.util.LinkedList;
import java.util.Queue;

/**
 * When: Re-used object for many LeetCode questions
 * Then: Return publicly accesible values w/o accessor methods for
 *      simplified use
 * */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) { this.val = val; }

    /**
     * Given:Integer array for binary tree in layer by layer
     *       -1 = null using.
     * When: Creating test tree
     * Then: Return tree node root to newly created tree from array
     * Example: [1,2,3,4]
     *              1
     *            2  3
     *           4
     * */
    public TreeNode(Integer[] treeArray){
        if(treeArray.length <= 0) return;
        val = treeArray[0];
        createBinaryTreeFromArrayOrder(this, treeArray, 1);
    }

    /**
     * Given:Tree root, Integer array, Index
     * When: Called recursively for TreeNode binary tree constructor form int array order
     * Then: Recursively create Binary tree from array at the index
     * */
    private void createBinaryTreeFromArrayOrder(TreeNode root, Integer[] order,
                                                    int nodeIndex){
        if(nodeIndex == order.length - 1) return;
        TreeNode node = new TreeNode(order[nodeIndex]);
        int parentIndex = getBinaryTreeParentIndex(nodeIndex);
        TreeNode parentNode = binarySearch(root, order[parentIndex]);
        if(isLeftChild(nodeIndex))parentNode.left = node;
        else parentNode.right = node;
        printBFS();
        createBinaryTreeFromArrayOrder(root, order, nodeIndex + 1);
    }

    /**
     * Given:Node index from array
     * When: Creating binary tree from array order setup
     * Then: Return parent index of the given array
     *
     * Get the layer from square root base 2
     * - 2 ^ layer - 1[due to array starting at 0 not 1]
     * - e.g. layer 2 start 2^2 = 4 - 1 = 3
     * - e.g. layer 3 start 2^3 = 8 - 1 = 7
     * */
    private int getBinaryTreeParentIndex(int nodeIndex){
        int currentLayer = (int)Math.ceil(Math.log(nodeIndex));
        int indexAwayFromLayerStart = nodeIndex - (int)Math.pow(currentLayer,2);
        int parentLengthAwayFromBeginningLayer = indexAwayFromLayerStart/2;
        return (int)Math.pow(indexAwayFromLayerStart, 2) - 1 +
                parentLengthAwayFromBeginningLayer;
    }


    /**
     * Given:Binary tree node and value to find
     * Then: Return node that matches value
     * Time: O(logN)
     * */
    private TreeNode binarySearch(TreeNode node, int val){
        if(node.val == val) return node;
        else if(node.val < val) return binarySearch(node.right, val);
        else return binarySearch(node.left, val);
    }

    /**
     * Given:Node index
     * When: Checking if index is either left or right child based on index
     * Then: Return true if not divisible by 2
     * */
    private boolean isLeftChild(int nodeIndex){
        return nodeIndex % 2 != 0;
    }

    /**
     * Given:This tree node
     * When: Debugging
     * Then: Print out tree representation using BFS
     * */
    private void printBFS(){
        bfs(this);
    }

    private void bfs(TreeNode node){
        System.out.println(node.val + " ");
        Queue<TreeNode> queue = new LinkedList<>();
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
        while(!queue.isEmpty()){
            bfs(queue.peek());
            queue.remove();
        }
    }

    /**
     * -1 value = null
     * */
    public boolean isNull(){
        return val == -1;
    }

    @Override
    public boolean equals(Object obj) {
        return isEqual(this, (TreeNode) obj);
    }

    /**
     * Given:TreeNode node of tree to compare against
     * When: equals()
     * Then: return true if all values match else false
     * */
    private boolean isEqual(TreeNode node, TreeNode tree2Node){
        if((node == null && tree2Node != null) ||
        (node != null && tree2Node == null))return false;
        if(node.val != tree2Node.val) return false;
        if(node.left != null) return isEqual(left, tree2Node.left);
        if(node.right != null) return isEqual(right, tree2Node.right);
        return true;
    }
}

