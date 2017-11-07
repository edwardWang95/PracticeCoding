package Sandbox;

/**
 * Created by edwardwang on 10/31/17.
 */
public class SandboxMain {
    public static void main(String[] args){
        dynamicProgrammingTest();
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
    static void dynamicProgrammingTest(){
        String X = "chocolate";
        String Y = "chips";
        String Z1 = "cchocohilaptes";
        String Z2 = "chocochilatspe";
        DyanmicProgramming dyanmicProgramming = new DyanmicProgramming();
        System.out.println("Normal Programming");
        dyanmicProgramming.setXYZ(X,Y,Z1);
        System.out.println("Z1: " + dyanmicProgramming.isZCorrectNormal());
        dyanmicProgramming.setXYZ(X,Y,Z2);
        System.out.println("Z2: " + dyanmicProgramming.isZCorrectNormal());
        System.out.println("Dynamic Programming");
        dyanmicProgramming.setXYZ(X,Y,Z1);
        //System.out.println("Z1: " + dyanmicProgramming.isZCorrectDynamicProgramming());
        dyanmicProgramming.setXYZ(X,Y,Z2);
        //System.out.println("Z2: " + dyanmicProgramming.isZCorrectDynamicProgramming());
    }
}
