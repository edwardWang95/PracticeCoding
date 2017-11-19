package Sandbox;

/**
 * Created by edwardwang on 10/31/17.
 */
public class SandboxMain {
    public static void main(String[] args){
        backtrackingSubsets();
    }

    static void derangementTest(){
        Derangement derangement = new Derangement();
        derangement.derangement(3);
    }

    static void multisetsTest(){
        int test[] = {1,1,2,2};
        int NMax = 6;
        Multisets multisets = new Multisets(test,NMax);
        multisets.printPermutations();
    }

    static void backtrackingSubsets(){
        int k = 3;  //elements in a subset
        int n = 5;  //total numbers
        BacktrackingSubsets backtrackingSubsets = new BacktrackingSubsets(n,k);
        backtrackingSubsets.backtracking();
    }
}
