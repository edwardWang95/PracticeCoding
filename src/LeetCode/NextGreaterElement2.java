package LeetCode;

/**
 * 503. Next Greater Element II
 *
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element. The Next Greater Number of a number x is the
 * first greater number to its traversing-order next in the array, which means you could search
 * circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 *
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * */
public class NextGreaterElement2 {
    public static void main(String[] args)
    {
        NextGreaterElement2Solution solution = new NextGreaterElement2Solution();
        //test1(solution);
        test2(solution);
    }

    private static void test1(NextGreaterElement2Solution solution)
    {
        System.out.println("Test 1");
        int[] input = {1, 2, 1};
        int[] expectedOutput = {2, -1, 2};
        int[] output = solution.nextGreaterElements(input);
        boolean isCorrect = true;
        for(int i=0;i<expectedOutput.length;i++)
        {
            if(output[i] != expectedOutput[i])
            {
                isCorrect = false;
                break;
            }
        }
        System.out.println(isCorrect ? "Correct" : "Incorrect");
    }

    /**
     * Error: Time Limit Exceeded
     * */
    private static void test2(NextGreaterElement2Solution solution)
    {
        System.out.println("Test 2");
        int[] input = {5, 4, 3, 2, 1};
        int[] expectedOutput = {-1, 5, 5, 5, 5};
        int[] output = solution.nextGreaterElements(input);
        boolean isCorrect = true;
        for(int i=0;i<expectedOutput.length;i++)
        {
            System.out.println("Expected: "+ expectedOutput[i]+"\t\tOutput: "+output[i]);
            if(output[i] != expectedOutput[i])
            {
                isCorrect = false;
                break;
            }
        }
        System.out.println(isCorrect ? "Correct" : "Incorrect");
    }
}

class NextGreaterElement2Solution
{
    public NextGreaterElement2Solution()
    {

    }

    /**
     * Current solution runs 45.08% faster than all other submissions.
     * */
    public int[] nextGreaterElements(int[] nums)
    {
        int newArray[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            newArray[i] = getNextGreaterElement(i, nums);
        }
        return newArray;
    }

    private int getNextGreaterElement(int index, int[] array)
    {
        int j=index+1;
        do {
            if(index == 0 && j==array.length) break;    //handle case if index is at 0 and don't want looping
            if(j == array.length) j=0;  //keep j in circular loop
            if(array[j] > array[index]) return array[j];
            j++;
        }
        while(j != index);
        return -1;
    }
}
