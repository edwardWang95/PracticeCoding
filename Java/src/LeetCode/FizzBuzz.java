package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.

 But for multiples of three it should output “Fizz” instead of the number and for
 the multiples of five output “Buzz”. For numbers which are multiples of both three
 and five output “FizzBuzz”.
 * Created by edwardwang on 2/7/17.
 */

class FizzBuzzTest{
    public static void main(String[] args){
        int n = 1;
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> solution = fizzBuzz.fizzBuzz(n);
        for(String string:solution)
            System.out.println(string);
    }
}
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> solution = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0){
                if(i%5==0){
                    solution.add("FizzBuzz");
                    continue;
                }
                solution.add("Fizz");
            }else if(i%5==0){
                solution.add("Buzz");
            }else{
                solution.add(Integer.toString(i));
            }
        }
        return solution;
    }
}
