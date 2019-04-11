package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
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

}

class OneThreeTwoPatternSolution{
    public boolean find132pattern(int[] nums) {
        return find132pattern(nums, 0, 0, 0);
    }

    public boolean find132pattern(int[] nums, int i, int j, int k) {
        if(isSolution(nums, i, j, k)){
            return true;
        }else{
            List<Integer> jList = jCandidates();
            List<Integer> kList = kCandidates();
        }
        return false;
    }

    private boolean isSolution(int[] nums, int i, int j, int k){
        return (i < j && j < k) && (nums[i] < nums[k] && nums[k] < nums[j]);
    }

    private List<Integer> jCandidates(int[] nums, int i, int j, int k){
        List<Integer> candidates = new ArrayList<>();
        
        return candidates;
    }

    private List<Integer> kCandidates(int[] nums, int i, int j, int k){
        List<Integer> candidates = new ArrayList<>();

        return candidates;
    }
}
