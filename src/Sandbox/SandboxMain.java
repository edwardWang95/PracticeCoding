package Sandbox;

/**
 * Created by edwardwang on 10/31/17.
 */
public class SandboxMain {
    public static void main(String[] args){
        editStrings();
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

    static void editStrings(){
        String m = "watch the movie raising arizona?";
        String n = "watch da mets raze arizona?";
        EditStrings editStrings = new EditStrings(m,n);
        editStrings.dynamicProgramming();
    }
}
