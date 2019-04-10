package Sandbox;
import java.util.LinkedList;

/**
 *
 * A derangement is a permutation p of {1,...,n} such that no item is in its proper position, i.e.e pi != i for all
 * 1 <= i <= n. Write an efficient backtracking program with pruning that constructs lal derangements of n items.
 * Created by edwardwang on 10/31/17.
 */
public class Derangement {
    private int value = 1;
    //Call to the method. You have to do this because the derangement call is recursive and will
    //include the linked list in its parameter which you don't want included from higher level caller.
    public void derangement(int value){
        this.value = value;
        dRecursive(new LinkedList<Integer>());
    }

    /*
    Recursive doesn't need to return boolean like in youtube example.
     */
    public void dRecursive(LinkedList<Integer> result){
        //recursive method complete statement
        if(result.size() == value){
            //completed ==> print out linked list
            for(int i=0;i<result.size();i++){
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }else{
            //add element
            for(int i=1;i<=value;i++){
                //See if current linked list is missing any values from 1 ... n
                //Make sure value being added is not in its right place
                if(!result.contains(i) && i!=(result.size()+1)){
                    result.add(i);
                    dRecursive(result);
                    result.removeLast();
                }
            }
        }

    }
}
