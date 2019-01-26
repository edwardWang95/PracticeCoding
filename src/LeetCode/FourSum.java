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
    int total, startingIndex;   //startingIndex used for pruning - where to look for next values to add from int array
    public FourSumCandidate(){}
    public FourSumCandidate(int startingIndex, int value)
    {
        this.startingIndex = startingIndex;
        list.add(value);
    }
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
    public int getSize()
    {
        return list.size();
    }
    public boolean isSolution(int target)
    {
        return list.size() == 4 && total == target;
    }
    //after confirming solution, sort before it is added into solutions list
    public void sort()
    {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String output = "";
        for(int i=0;i<4;i++) output += " " + list.get(i);
        return output;
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
        constructCandidates(nums);
        for(FourSumCandidate candidate: candidates)
        {
            backtrack(candidate, nums, target);
        }
        return solution;
    }

    /**
     * Create a list of values that can create a 4 sized list to increase speed.
     * */
    private void constructCandidates(int[] nums)
    {
        for(int i=0;i<nums.length - 3;i++)
        {
            FourSumCandidate candidate = new FourSumCandidate(i, nums[i]);
            candidates.add(candidate);
        }
    }

    /**
     * Check if current candidate is a solution. Add to list of solutions if it is.
     *
     * Prune candidates for more possible values to add on to create solutions.
     *
     * @param currSolution pruned integers that are possible solutions to current list
     * @param target target value for solution
     * */
    private void backtrack(FourSumCandidate currSolution, int nums[], int target)
    {
        //base case
        if(currSolution.isSolution(target))
        {
            //have it sorted to match expected output
            currSolution.sort();
            solution.add(currSolution.list);
        }
        else
        {
            List<Integer> newCandidates = pruneCandidates(currSolution, nums, target);
            while(!(newCandidates.size() ==0))
            {
                //add newCandidate value to current solution
                currSolution.addValue(newCandidates.get(0));
                //backtrack
                backtrack(currSolution, nums, target);
                //remove value
                currSolution.removeValue();
                newCandidates.remove(0);
            }
            //if current size is 4 and not a solution, return
            //construct candidates based on current solutions
        }
    }

    /**
     * Returns list of possible values that can be candidates to current solution.
     * Don't return anything if the size is already 4.
     * */
    private List<Integer> pruneCandidates(FourSumCandidate currSolution, int[] nums, int target)
    {
        List<Integer> candidates = new ArrayList<>();
        for(int i=currSolution.startingIndex;i<nums.length;i++)
        {
            //if already at 3 items, don't add items that don't match target
            if(currSolution.getSize() == 3)
            {
                if(currSolution.total + nums[i] == target) candidates.add(nums[i]);
            }else candidates.add(nums[i]);
        }
        return candidates;
    }
}
