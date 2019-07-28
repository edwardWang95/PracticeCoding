package LeetCode.ReUsedObjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {
    @Test
    void test1(){
        Integer[] rootArray = {1,2,3,4};
        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.left.left = new TreeNode(4);
        expected.right = new TreeNode(3);
        assertEquals(expected, new TreeNode(rootArray));
    }

    @Test
    void test2(){
        Integer[] rootArray = {1,2,3,null,4,null,5};
    }
}