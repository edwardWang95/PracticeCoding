package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 456. 132 Pattern
 *
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that
 * i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether
 * there is a 132 pattern in the list.
 *
 * Note: n will be less than 15,000.
 *
 * Example1
 * Input: [1, 2, 3, 4]
 * Output: False
 * Explanation: There is no 132 pattern in the sequence.
 *
 * Example 2:
 * Input: [3, 1, 4, 2]
 * Output: True
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 *
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * Output: True
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 * */
public class OneThreeTwoPattern {
    public static void main(String[] args){
        System.out.println("Leetcode 456. 132 Pattern");
        test1();
        test2();
    }

    private static void test1(){
        int [] nums = {1,2,3,4};
        boolean expected = false;
        printTestAndResult(1, nums, expected);
    }

    private static void test2(){
        int [] nums = {3, 1, 4, 2};
        boolean expected = true;
        printTestAndResult(2, nums, expected);
    }

    private static void printTestAndResult(int testNum, int[] nums, boolean expected){
        OneThreeTwoPatternSolution solution = new OneThreeTwoPatternSolution();
        boolean actual = solution.find132pattern(nums);
        System.out.println("Test: "+testNum);
        System.out.print("Input:\t");
        for(int i:nums) System.out.print(i+"\t");
        System.out.print("\n");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        System.out.println(expected==actual ? "Passed\n" : "Failed\n");
    }
}

class OneThreeTwoPatternSolution{
    public boolean find132pattern(int[] nums) {
        return find132pattern(nums, 0, 1, 2);
    }

    public boolean find132pattern(int[] nums, int i, int j, int k) {
        if(isSolution(nums, i, j, k)){
            return true;
        }else{
            for(;i<nums.length-2;i++){
                ArrayList<Integer> jList = jCandidates(nums, i, j, k);
                while(jList.size() != 0){
                    j = jList.get(0);
                    ArrayList<Integer> kList = kCandidates(nums, i, j, k);
                    while(kList.size() != 0) {
                        k = kList.get(0);
                        if(find132pattern(nums, i, j, k)) return true;
                        kList.remove(0);
                    }
                    jList.remove(0);
                }
            }
        }
        return false;
    }

    private boolean isSolution(int[] nums, int i, int j, int k){
        return (i < j && j < k) && (nums[i] < nums[k] && nums[k] < nums[j]);
    }

    private ArrayList<Integer> jCandidates(int[] nums, int i, int j, int k){
        ArrayList<Integer> candidates = new ArrayList<>();
        if(i >= j || j >= k) return candidates;
        for(;i < j && j < k; j++){
            if(nums[i] < nums[j] && nums[k] < nums[j]) candidates.add(j);
        }
        return candidates;
    }

    private ArrayList<Integer> kCandidates(int[] nums, int i, int j, int k){
        ArrayList<Integer> candidates = new ArrayList<>();
        if(i >= k || j >= k) return candidates;
        for(;k < nums.length; k++){
            if(nums[i] < nums[k] && nums[k] < nums[j]) candidates.add(j);
        }
        return candidates;
    }
}
