package Sandbox;

/**
 * Dynamic Programming for editing strings and figuring out best alignment
 *
 * Created by edwardwang on 11/19/17.
 */
public class EditStrings {
    private String m,n;
    private int memory[][];
    public EditStrings(String m, String n){
        this.m = m;
        this.n = n;
        memory = new int[m.length()][n.length()];
    }

    public void dynamicProgramming(){
        System.out.println("String 1: "+m);
        System.out.println("String 2: "+n);
        editDistanceDynamicProgramming(m,n);
        System.out.println("Edit Distance: "+memory[m.length()-1][n.length()-1]);
        traceBack();
        printOutMemory();
    }

    private void editDistanceDynamicProgramming(String m, String n){
        for(int i=0;i<m.length();i++){
            for(int j=0;j<n.length();j++){
                if(i==0){
                    memory[i][j] = j;
                }
                else if(j==0){
                    memory[i][j] = i;
                }
                else if(m.charAt(i)==n.charAt(j)){
                    memory[i][j] = memory[i-1][j-1];
                }
                else{
                    //Substitution: i-1 && j-1
                    //Insertion: based on string m ==> i, j-1
                    //Deletion: i-1, j
                    memory[i][j] = 1 + min(memory[i-1][j-1],memory[i][j-1],memory[i-1][j]);
                }
            }
        }
    }

    private void traceBack(){
        int substitution = 0, insertion = 0, deletion = 0;
        String mTrace = ""+m.charAt(m.length() - 1);
        String nTrace = ""+n.charAt(n.length() - 1);
        int i = m.length() - 1;
        int j = n.length() - 1;
        while(i!=0 && j!=0){
            substitution = memory[i-1][j-1];
            insertion = memory[i][j-1];
            deletion = memory[i-1][j];
            if(substitution <= insertion && substitution <= deletion){
                System.out.println("Substitution: \tM=" + m.charAt(i-1) + " N=" + n.charAt(j-1));
                --i;
                --j;
                mTrace = m.charAt(i) + mTrace;
                nTrace = n.charAt(j) + nTrace;
            }else if(insertion <= substitution && insertion <= deletion){
                System.out.println("Insertion: \t\tM=" + m.charAt(i-1) + " N=" + n.charAt(j-1));
                --j;
                nTrace = n.charAt(j) + nTrace;
            }else if(deletion <= substitution && deletion <= insertion){
                System.out.println("Deletion: \t\tM=" + m.charAt(i-1) + " N=" + n.charAt(j-1));
                --i;
                mTrace = m.charAt(i) + mTrace;
            }
        }
        if(mTrace.length() <= nTrace.length()){
            System.out.println("Best alignment is : " + mTrace);
        }else{
            System.out.println("Best alignment is : " + nTrace);
        }
    }

    private void printOutMemory(){
        for(int i=0;i<m.length();i++){
            for(int j=0;j<n.length();j++){
                System.out.print(memory[i][j]+"\t ");
            }
            System.out.println();
        }
    }

    private int  min(int i, int j, int k){
        return Math.min(Math.min(i,j),k);
    }
}
