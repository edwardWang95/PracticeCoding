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
 * A solutions set is:
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
 * Keep track of candidate solutions and it's total value to improve time.
 * */
class FourSumList
{
    List<FourSumCandidate> list = new ArrayList<>();
    int total;   //startingIndex used for pruning - where to look for next values to add from int array
    public void addValue(FourSumCandidate num)
    {
        list.add(num);
        total += num.getVal();
    }
    public void removeValue()
    {
        total -= list.get(list.size()-1).getVal();
        list.remove(list.size()-1);
    }
    public int getSize()
    {
        return list.size();
    }
    //after confirming solutions, sort the list before it is added into solutions list
    public List<FourSumCandidate> getList()
    {
        return list;
    }
    public int getTotal()
    {
        return total;
    }
    public List<Integer> getSortedList()
    {
        List<Integer> sortedList = new ArrayList<>();
        for(FourSumCandidate candidate: list)sortedList.add(candidate.getVal());
        quickSort(sortedList, 0, sortedList.size()-1);
        printSortedList(sortedList);
        return sortedList;
    }

    private void quickSort(List<Integer> sortedList, int low, int high)
    {
        if(low < high)
        {
            int partition = partition(sortedList, low, high);
            quickSort(sortedList, low, partition - 1);
            quickSort(sortedList, partition + 1, high);
        }
    }

    private int partition(List<Integer> list, int low, int high)
    {
        int pivot = list.get(high);
        int i = low - 1;
        for(int j=low;j<high;j++)
        {
            if(list.get(j) <= pivot)
            {
                i++;
                //swap positions of i and j
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        //swap last iterated element with pivot
        int temp = list.get(i + 1);
        list.set(i+1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }

    /**
     * Only prints out the resulting sorted List
     * */
    public void printSortedList(List<Integer> sortedList) {
        for(int i=0;i<4;i++) System.out.print(sortedList.get(i) + " ");
        System.out.println();
    }
}

/**
 * Need to keep track of value and index of where it was found in nums[]
 * */
class FourSumCandidate
{
    int val, index;
    public FourSumCandidate(int val, int index)
    {
        this.val = val;
        this.index = index;
    }
    public int getVal() {
        return val;
    }
    public int getIndex() {
        return index;
    }
}

class FourSumSolution
{
    private List<List<Integer>> solutions = new ArrayList<>();
    /**
     * Dynamic programming - bottom to top: Backtracking - Memoization
     * Top to bottom is regular recursions
     * */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        backtrack(new FourSumList(), nums, target);
        return solutions;
    }

    /**
     * Check if current candidate is a solutions. Add to list of solutions if it is.
     *
     * Prune candidates for more possible values to add on to create solutions.
     *
     * @param solution pruned integers that are possible solutions to current list
     * @param target target value for solutions
     * */
    private void backtrack(FourSumList solution, int nums[], int target)
    {
        //base case
        if(isSolution(solution, target))
        {
            List<Integer> possSolution = solution.getSortedList();
            if(!isRepeat(possSolution)) solutions.add(possSolution);
        }
        else
        {
            List<FourSumCandidate> newCandidates = pruneCandidates(solution, nums, target);
            while(!(newCandidates.size() ==0))
            {
                //add newCandidate value to current solutions
                solution.addValue(newCandidates.get(0));
                //backtrack
                backtrack(solution, nums, target);
                //remove value
                solution.removeValue();
                newCandidates.remove(0);
            }
            //if current size is 4 and not a solutions, return
            //construct candidates based on current solutions
        }
    }

    private boolean isSolution(FourSumList solution, int target)
    {
        return solution.getList().size() == 4 && solution.getTotal() == target;
    }

    private boolean isRepeat(List<Integer> possSolution)
    {
        for(List<Integer> currSolution: solutions) if(currSolution.equals(possSolution)) return true;
        return false;
    }

    /**
     * Returns list of possible values that can be candidates to current solutions.
     * Don't return anything if the size is already 4.
     * */
    private List<FourSumCandidate> pruneCandidates(FourSumList solution, int[] nums, int target)
    {
        List<FourSumCandidate> candidates = new ArrayList<>();
        if(solution.getSize() == 0) //starting point
        {
            for(int i=0;i<nums.length - 3;i++)
            {
                candidates.add(new FourSumCandidate(nums[i], i));
            }

        }else
        {
            //i = index of most recently added candidate
            for(int i=solution.getList().get(solution.getSize() - 1).getIndex()+1; i<nums.length; i++)
            {
                //if already at 3 items, don't add items that don't match target
                if(solution.getSize() == 3)
                {
                    if(solution.total + nums[i] == target) candidates.add(new FourSumCandidate(nums[i], i));
                }else candidates.add(new FourSumCandidate(nums[i], i));
            }
        }
        return candidates;
    }
}
