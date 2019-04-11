package Sandbox;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by edwardwang on 11/7/17.
 * Suppose you are given 3 strings, X, Y and Z. X = n, Y = m, Z = n+m.
 * Z is a shuffle of X and Y iff the characters of X and Y are maintining left to right
 * order.
 * Example:
 * X = chocolate
 * Y = chips
 * Correct ==> cchocohilaptes
 * Wrong   ==> chocochilatspe --> because 'sp' where in chips it is p before s
 *
 * Dynamic
 * Hint: THe values of dynamic programming matrix should be Boolean not numeric.
 */
public class DynamicProgramming {
    private String X,Y,Z;
    public DynamicProgramming(){
        X = "";
        Y = X;
        Z = Y;
    }

    public void setXYZ(String X, String Y, String Z){
        this.X = X;
        this.Y = Y;
        this.Z = Z;
    }

    /**
     * Check if Z is a correct shuffle of X and Y using the normal way.
     * Time Complexity: O(n)
     * @return if Z is a shuffle of X and Y
     */
    public boolean isZCorrectNormal(){
        int xCounter = 0;
        int yCounter = 0;
        char xCharArray[] = X.toCharArray();
        char yCharArray[] = Y.toCharArray();
        for(char c: Z.toCharArray()){
            //check head of X array
            if(xCounter < xCharArray.length && xCharArray[xCounter]==c){
                xCounter++;
            }else if(yCounter < yCharArray.length && yCharArray[yCounter]==c){
                yCounter++;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * Check if Z is a correct shuffle of X and Y using the dynamic programming way.
     * Wrapper for the recursion function.
     * Time Complexity: O(n)
     * @return if Z is a shuffle of X and Y
     */
    public boolean isZCorrectDynamicProgramming(){
        isZCorrectDynamicProgramming(0,0, 0);
        return false;
    }

    /**
     *
     * @return is current char within X or Y going left to right order.
     */
    private boolean isZCorrectDynamicProgramming(int xCounter, int yCounter, int zCounter){
        boolean[] prevChecked = new boolean[Z.length()];
        boolean isXComplete = false;
        boolean isYComplete = false;
        //base cases
        //When last element of X or Y is passed, stop looking at these elements.
        if(xCounter > X.length()){
            isXComplete = true;
        }
        if(yCounter > Y.length()){
            isYComplete = true;
        }
        while(!isXComplete || !isYComplete){
            if(X.toCharArray()[xCounter]==Z.toCharArray()[zCounter]){

            }else if (Y.toCharArray()[xCounter]==Z.toCharArray()[zCounter]){

            }
        }

        for(int i =0;i<Z.length();i++){

        }

        return zCounter == Z.length();
    }
}
