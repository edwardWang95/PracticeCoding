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
        String m = " thou-shalt-not";
        String n = " you-should-not";

        String x = " ababa";
        String y = " bzbzb";

        String test1a = " watch the movie raising arizona?";
        String test1b = " watch da mets raze arizona?";

        String test2a = " this is what happens when I type slow";
        String test2b = " htishisth whaty havpens when ui type fasht";

        String test3a = " leonard skiena";
        String test3b = " lynard skynard";

        EditStrings editStrings = new EditStrings(test3a,test3b);
        editStrings.dynamicProgramming();
    }
}
