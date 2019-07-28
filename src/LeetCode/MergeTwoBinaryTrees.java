package LeetCode;

import LeetCode.ReUsedObjects.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by edwardwang on 10/20/17.
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args){
        int[] t1Array = new int[]{1,3,2,5};
        int[] t2Array = new int[]{2,1,3,1000,4,1000,7};
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        TreeNode t3 = mergeTrees(t1,t2);
        breadthFirstTraversal(t3);
    }

    static void breadthFirstTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            System.out.print(temp.val + " ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }

    static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //setup root
        TreeNode t3 = new TreeNode(0);
        recursiveMerge(t1,t3);
        //recursiveMerge(t2,t3);
        return t3;
    }

    static void recursiveMerge(TreeNode t1, TreeNode t2){
        TreeNode temp = t2;
        if(t1 == null) return;
        if(temp == null){
            temp = new TreeNode(combineNodeValues(t1,temp));
        }else {
            temp.val += combineNodeValues(t1,temp);
        }
        if(t1.left!=null)recursiveMerge(t1.left,temp.left);
        if(t1.right!=null)recursiveMerge(t1.right,temp.right);
    }

    static int combineNodeValues(TreeNode node1, TreeNode node2){
        int result = 0;
        if(node1 != null){
            result += node1.val;
        }
        if(node2 != null){
            result += node2.val;
        }
        return result;
    }

}

