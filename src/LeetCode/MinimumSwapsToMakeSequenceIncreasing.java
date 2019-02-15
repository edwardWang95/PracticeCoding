package LeetCode;

/**
 * 801. Minimum Swaps To Make Sequences Increasing
 *
 * We have two integer sequences A and B of the same non-zero length.
 *
 * We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.
 *
 * At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
 *
 * Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
 *
 * Example:
 * Input: A = [1,3,5,4], B = [1,2,3,7]
 * Output: 1
 * Explanation:
 * Swap A[3] and B[3].  Then the sequences are:
 * A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
 * which are both strictly increasing.
 * */
public class MinimumSwapsToMakeSequenceIncreasing
{
    public static void main(String[] args)
    {
        MinimumSwapsToMakeSequenceIncreasingSolution solution = new MinimumSwapsToMakeSequenceIncreasingSolution();
        //test1(solution);
        //test2(solution);
        //test3(solution);
        test4(solution);
    }

    private static void test1(MinimumSwapsToMakeSequenceIncreasingSolution solution)
    {
        System.out.println("Test 1");
        int A[] = {1, 3, 5, 4};
        int B[] = {1, 2, 3, 7};
        int expectedOutput = 1;
        int output = solution.minSwap(A, B);
        System.out.println(output == expectedOutput ? "Correct" : "Incorrect = " + output);
    }

    private static void test2(MinimumSwapsToMakeSequenceIncreasingSolution solution)
    {
        System.out.println("Test 2");
        int A[] = {3,3,8,9,10};
        int B[] = {1,7,4,6,8};
        int expectedOutput = 1;
        int output = solution.minSwap(A, B);
        System.out.println(output == expectedOutput ? "Correct" : "Incorrect\tExpected: "+expectedOutput + "\t\tOutput: "+output);
    }

    private static void test3(MinimumSwapsToMakeSequenceIncreasingSolution solution)
    {
        System.out.println("Test 3");
        int A[] = {0,3,4,9,10};
        int B[] = {2,3,7,5,6};
        int expectedOutput = 1;
        int output = solution.minSwap(A, B);
        System.out.println(output == expectedOutput ? "Correct" : "Incorrect\tExpected: "+expectedOutput + "\t\tOutput: "+output);
    }

    private static void test4(MinimumSwapsToMakeSequenceIncreasingSolution solution)
    {
        System.out.println("Test 4");
        int A[] = {0,7,8,10,10,11,12,13,19,18};
        int B[] = {4,4,5,7,11,14,15,16,17,20};
        int expectedOutput = 4;
        int output = solution.minSwap(A, B);
        System.out.println(output == expectedOutput ? "Correct" : "Incorrect\tExpected: "+expectedOutput + "\t\tOutput: "+output);
    }
}

class MinimumSwapsToMakeSequenceIncreasingSolution
{
    public int minSwap(int[] A, int[] B) {
        return minSwap(A,B,0, 0);
    }

    private int minSwap(int[] A, int[] B, int i, int minSwaps){
        while(i < A.length){
            if(i!= 0){
                if(A[i-1]>=A[i] || B[i-1]>=B[i]){
                    int leftMin = A.length, rightMin = B.length;
                    if(i-2<0)
                    {
                        swap(A,B,i-1);
                        leftMin = minSwap(A, B, i, minSwaps+1);
                        swap(A,B,i);
                        swap(A,B,i);
                        rightMin = minSwap(A, B, i+1, minSwaps+1);
                    }else {
                        //swap left
                        if(A[i-2]<=B[i-1] && B[i-2]<=A[i-1]){
                            swap(A,B,i-1);
                            leftMin = minSwap(A, B, i, minSwaps+1);
                            swap(A,B,i);
                        }
                        //swap right
                        if(A[i-1]<=B[i] && B[i-1]<=A[i]){
                            swap(A,B,i);
                            rightMin = minSwap(A, B, i+1, minSwaps+1);
                        }
                    }
                    return (rightMin < leftMin) ? rightMin : leftMin;
                }
            }
            i++;
        }
        return minSwaps;
    }

    private void swap(int[] A, int[] B, int i){
        int temp = A[i];
        A[i] = B[i];
        B[i] = temp;
    }
}
