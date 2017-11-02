package Sandbox;

/**
 * Created by edwardwang on 10/31/17.
 */
public class SandboxMain {
    public static void main(String[] args){
        multisetsTest();
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
}
