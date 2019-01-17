package LeetCode;

import java.util.ArrayList;

/**
 * 901. Online Stock Span
 * Write a class StockSpanner which collects daily price quotes for some stock, and
 * returns the span of that stock's price for the current day.
 *
 * The span of the stock's price today is defined as the maximum number of consecutive days
 * (starting from today and going backwards) for which the price of the stock was less than
 * or equal to today's price.
 *
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85],
 * then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 * */
public class OnlineStockSpan {
    public static void main(String[] args)
    {
        System.out.println("Online Stock Span");
        test1();
        test2();
    }
    /**
     * Your StockSpanner object will be instantiated and called as such:
     * StockSpanner obj = new StockSpanner();
     * int param_1 = obj.next(price);
     *
     * To have a null return within an array, rather than an int primitive variable
     * use the Integer object that wraps around the int variable.
     */
    private static void test1()
    {
        System.out.println("Online Stock Spanner Test 1:\t");
        StockSpanner obj = new StockSpanner();
        String[] inputString = {"StockSpanner","next","next","next","next","next","next","next"};
        Integer[] input = {null, 100, 80, 60, 70, 60, 75, 85};
        Integer[] expectedOutput = {null, 1, 1, 1, 2, 1, 4, 6};
        ArrayList<Integer> output = new ArrayList<>();
        for(int i=0;i<inputString.length;i++)
        {
            if(inputString[i].equals("StockSpanner"))output.add(null);
            else if (inputString[i].equals("next"))
            {
                output.add(obj.next(input[i]));
                //System.out.println("Price: "+ input[i]+"\tOutput: "+output.get(i) + "\tExpected: "+expectedOutput[i]);
                if(!output.get(i).equals(expectedOutput[i])) break;
                //System.out.println();
            }
        }
        System.out.println(output.size() != input.length ? "Incorrect\n" : "Correct\n");
    }

    private static void test2()
    {
        System.out.println("Online Stock Spanner Test 2:\t");
        StockSpanner obj = new StockSpanner();
        Integer[] input = {73, 99, 41, 68, 32, 22, 72, 1, 83, 53};
        ArrayList<Integer> output = new ArrayList<>();
        for(int i=0;i<input.length;i++)
        {
            //System.out.print("Price: "+ input[i]);
            output.add(obj.next(input[i]));
            //System.out.print("\tOutput: "+output.get(i)+"\n");
            //System.out.println();
        }
    }
}

/**
 * This challenge has a time limit, so it's focus will be on speed.
 * */
class StockSpanner
{
    ArrayList<Integer> prices = new ArrayList<Integer>();

    public StockSpanner()
    {

    }

    /**
     * Every price starts with a value of 1.
     * Search all previous stock values to and increment the count if they are less than current price.
     *
     * Array list so I can dynamically increase the size, merge sort into the array and then update the
     * counter based on it's location.
     * bucket sort based on tens values into insertion sort
     * */
    public int next(int price)
    {
        if(price < 0 || price > 100000) return 0;
        //return getSortedIndex(price);
        int temp = getSortedIndex(price);
        printArrayList();
        return temp;

    }

    private void printArrayList()
    {
        System.out.println("Print Array List");
        for(int i: prices) System.out.print(i+", ");
        System.out.println();
    }

    private int getSortedIndex(int val)
    {
        //base case if empty
        if(prices.size() == 0)
        {
            prices.add(val);
        }else
        {
            //return binaryInsertionSort(val, prices.size()/2, -prices.size());
            return binaryInsertionSort(val, 0, prices.size());
        }
        return 1;
    }

    private int binaryInsertionSort(int val, int left, int right)
    {
        int middle = (right - left)/2;
        //base case for end of the binary insertion sort
        if(left == middle)
        {
            //add in value and return that plus 1 for the value itself
            prices.add(middle, val);
            return middle+1;
        }else {
            //O(log(n)) shifting to closest insertion location
            if (prices.get(middle) > val) return binaryInsertionSort(val, left, middle);
            else if (prices.get(middle) < val) return binaryInsertionSort(val, middle, right);
        }
        return 1;
    }

    //O(log(n)) search for location to insert
    private int binaryInsertionSort2(int val, int middle, int previousMiddle)
    {
        //base case for end of the binary insertion sort
        if(middle == previousMiddle)
        {
            //minute shifts after getting closest to middle value
            if(prices.get(middle) < val)
            {
                //if(middle+1 < prices.size())middle++;
                middle++;
            }
            else if(prices.get(middle) > val && middle != 0 && prices.size()%2==0)middle--;    //if even amount of values then decrement
        }else if(middle == prices.size()){
            middle = prices.size()-1;
        }else {
            //O(log(n)) shifting to closest insertion location
            if(previousMiddle == -prices.size()) previousMiddle = prices.size();
            if (prices.get(middle) > val) return binaryInsertionSort(val, middle/2 /*- (previousMiddle - middle)/2*/, middle);
            else if (prices.get(middle) < val) return binaryInsertionSort(val, middle + middle/2, middle);
        }
        //add in value and return that plus 1 for the value itself
        prices.add(middle, val);
        return middle+1;
    }
}
