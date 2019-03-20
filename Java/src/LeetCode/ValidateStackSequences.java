package LeetCode;

import java.util.Stack;

/**
 * 946. Validate Stack Sequences
 * Given two sequences pushed and popped with distinct values,
 * return true if and only if this could have been the result of a sequence of
 * push and pop operations on an initially empty stack.
 * */
public class ValidateStackSequences {
    public static void main(String[] args){
        //runAllTests();
        test2();
    }

    /**
     * Run all tests here. In main() can specify which tests to run if specific one's are needed.
     * */
    private static void runAllTests(){
        test1();
        test2();
    }

    private static void test1(){
        int pushed[] = {1,2,3,4,5};
        int popped[] = {4,5,3,2,1};
        boolean expectedOutput = true;
        conductTest(pushed,popped,expectedOutput);
    }

    private static void test2(){
        int pushed[] = {2,1,0};
        int popped[] = {1,2,0};
        boolean expectedOutput = true;
        conductTest(pushed,popped,expectedOutput);
    }

    private static void conductTest(int pushed[], int popped[], boolean expectedOutput){
        ValidateStackSequencesSolution solution = new ValidateStackSequencesSolution();
        boolean output = solution.validateStackSequences(pushed,popped);
        System.out.println(output == expectedOutput ?
                "Correct" : "Incorrect - Output: "+output+"\t\tExpected: "+expectedOutput);
    }
}

class ValidateStackSequencesSolution{
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0,j=0;
        Stack<Integer> stack = new Stack<>();
        while(i<pushed.length || j<popped.length){
            //pop
            if(j < popped.length && !stack.isEmpty() && popped[j]==stack.peek()){
                stack.pop();
                j++;
            }else if (i==pushed.length && popped[j]!=stack.peek()){
                return false;
            }
            //push
            if(i < pushed.length){
                stack.push(pushed[i]);
                i++;
            }
        }
        return true;
    }
}
