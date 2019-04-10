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
//        test1(solution);
//        test2(solution);
//        test3(solution);
//        test4(solution);
//        test5(solution);
        test6(solution);
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

    private static void test5(MinimumSwapsToMakeSequenceIncreasingSolution solution)
    {
        System.out.println("Test 5");
        int A[] = {2,1,6,9,10,13,13,16,19,26,23,24,25,27,32,31,35,36,37,39};
        int B[] = {0,5,8,8,10,12,14,15,22,22,28,29,30,31,30,33,33,36,37,38};
        int expectedOutput = 6;
        int output = solution.minSwap(A, B);
        System.out.println(output == expectedOutput ? "Correct" : "Incorrect\tExpected: "+expectedOutput + "\t\tOutput: "+output);
    }

    private static void test6(MinimumSwapsToMakeSequenceIncreasingSolution solution)
    {
        System.out.println("Test 6");
        int A[] = {1,8, 4, 6, 7, 8,16,18,19,29,25,26,35,31,38,35,37,41,39,43,48,49,46,47,50,52,54,55,63,58,67,63,69,71,74,73,76,77,80,78,79,80,86,87,90,93,95,96,97,100,101,105,106,108,108,109,116,111,119,121,122,124,130,125,126,127,128,140,144,135,148,151,143,154,155,157,160,156,158,159,168,170,163,173,175,176,177,180,177,182,183,184,185,190,191,194,194,195,196,200};
        int B[] = {7,3,12,14,19,22,24,26,27,21,30,31,28,36,33,39,40,38,42,43,44,45,50,55,56,57,58,61,56,64,60,68,70,71,72,75,74,75,77,81,82,83,81,84,91,93,95,96,99,100,102,103,104,107,113,114,110,118,112,113,114,115,124,132,133,134,135,131,134,145,137,140,152,144,150,151,154,163,165,166,160,161,172,164,168,171,172,173,181,183,184,187,189,191,192,193,195,198,199,197};
        int expectedOutput = 29;
        int output = solution.minSwap(A, B);
        System.out.println(output == expectedOutput ? "Correct" : "Incorrect\tExpected: "+expectedOutput + "\t\tOutput: "+output);
    }
}

class MinimumSwapsToMakeSequenceIncreasingSolution {
    //use global variable to increase searching speeds
    private int smallestSwaps;

    public int minSwap(int[] A, int[] B) {
        smallestSwaps = A.length;
        return minSwap(A,B,0, 0);
    }

    private int minSwap(int[] A, int[] B, int i, int minSwaps){
        while(i < A.length){
            if(minSwaps > smallestSwaps) return A.length;
            if(i!= 0 && !isStrictlyIncreasing(A, B, i)){
                int prevMin = A.length, currMin = B.length;
                //swap current i value
                if(isGoodSwap(A, B, i)){
                    swap(A,B,i);
                    currMin = minSwap(A, B, i+1, minSwaps+1);
                    swap(A,B,i);
                }
                //swap previous i value
                if(isGoodSwap(A, B, i-1)){
                    swap(A,B,i-1);
                    prevMin = minSwap(A, B, i+1, minSwaps+1);
                    swap(A,B,i-1);
                }
                return (currMin < prevMin) ? currMin : prevMin;
            }
            i++;
        }
        System.out.println(minSwaps);
        if(minSwaps < smallestSwaps){
            smallestSwaps = minSwaps;
            printArray(A);
            printArray(B);
            System.out.println();
        }
        return minSwaps;
    }

    private boolean isStrictlyIncreasing(int[] A, int[] B, int i) {
        return i!=0 && A[i-1]<A[i] && B[i-1]<B[i];
    }

    //Confirms that swapping values between arrays still leaves increasing order
    private boolean isGoodSwap(int[] A, int[] B, int i){
        return (i-1>=0) &&
                (A[i-1]<B[i] && B[i-1]<A[i]) &&
                A[i]!=B[i];
    }

    private void swap(int[] A, int[] B, int i){
        int temp = A[i];
        A[i] = B[i];
        B[i] = temp;
    }

    private void printArray(int[] A){
        for(int i:A){
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
