package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 18. 4Sum
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets
 * in the array which gives the sum of target.
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * */
public class FourSum {
    public static void main(String[] args)
    {
        FourSumSolution solution = new FourSumSolution();
        test1(solution);
    }

    private static void test1(FourSumSolution solution)
    {
        int nums[] = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> expectedOutput= new ArrayList<List<Integer>>();
        List<Integer> one = new ArrayList<>();
        one.add(-1);
        one.add(0);
        one.add(0);
        one.add(1);
        List<Integer> two = new ArrayList<>();
        two.add(-2);
        two.add(-1);
        two.add(1);
        two.add(2);
        List<Integer> three = new ArrayList<>();
        three.add(-2);
        three.add(0);
        three.add(0);
        three.add(2);
        expectedOutput.add(one);
        expectedOutput.add(two);
        expectedOutput.add(three);
        List<List<Integer>> output = solution.fourSum(nums, target);
        System.out.println(expectedOutput.equals(output)? "Correct" : "Incorrect");
    }
}

/**
 * Keep track of candidate solution and it's total value to improve time.
 * */
class FourSumCandidate
{
    List<Integer> list = new ArrayList<>();
    int total;
    public void addValue(int num)
    {
        list.add(num);
        total += num;
    }
    public void removeValue()
    {
        total -= list.get(list.size()-1);
        list.remove(list.size()-1);
    }
}

class FourSumSolution
{
    private List<List<Integer>> solution= new ArrayList<>();
    private List<FourSumCandidate> candidates= new ArrayList<>();
    /**
     * Dynamic programming - bottom to top: Backtracking - Memoization
     * Top to bottom is regular recursions
     * */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        constructCandidates(nums, target);
        backtrack(new ArrayList<>(), target);
        return solution;
    }

    /**
     * Create a list of values that can fit within bounds
     * */
    private void constructCandidates(int[] nums, int target)
    {
        for(int i=0;i<nums.length - 3;i++)
        {
            FourSumCandidate candidate = new FourSumCandidate();
            candidate.addValue(nums[i]);
            candidates.add(candidate);
        }
    }

    private void backtrack(List<FourSumCandidate> newSolution, int target)
    {
        //base case
        /*
        if(isSolution(newSolution, target))
        {
            solution.add(newSolution);
        }else
        {
            //construct candidates based on current solutions
            List<List<Integer>> newCandidates = pruneCandidate();
        }
        */
    }

    /**
     * If the solution adds up to target and is of size 0, add it to solution list
     * */
    private boolean isSolution(List<Integer> newSolution, int target)
    {
        if(newSolution.size() != 4) return false;
        int total = 0;
        for(Integer i: newSolution)
        {
            total += i;
        }
        return total == target;
    }

    private void sortList()
    {

    }

    private List<List<Integer>> pruneCandidate(int[] nums, List<Integer> currSolution)
    {
        List<List<Integer>> candidates = new ArrayList<>();

        return candidates;
    }
}
