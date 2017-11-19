package Sandbox;

/**
 * Dynamic Programming for checking smallest changes for editing strings.
 *
 * Dynamic Programming removes the need for recursion by retaining memory in a
 * table.
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
        editDistanceDynamicProgramming(m,n);
        System.out.println("Edit Distance: "+memory[m.length()-1][n.length()-1]);
    }

    private int editDistanceRecursive(String m, String n, int i , int j){
        System.out.println(m.charAt(i) + " " + n.charAt(j));
        //if m is empty
        if(i==0)memory[i][j] = j;
        //if n is empty
        if(j==0)memory[i][j] = i;
        //if characters are the same
        if(m.charAt(i) == n.charAt(j)) editDistanceRecursive(m,n,i-1,j-1);
        //if characters aren't the same, find the cheapest option
            //Substitution: i-1 && j-1
            //Insertion: based on string m ==> i, j-1
            //Deletion: i-1, j
        return 1 + min(editDistanceRecursive(m,n,i-1,j-1),editDistanceRecursive(m,n,i-1,j),editDistanceRecursive(m,n,i,j-1));
    }

    private void editDistanceDynamicProgramming(String m, String n){
        for(int i=0;i<m.length();i++){
            for(int j=0;j<n.length();j++){
                if(i==0)memory[i][j] = j;
                else if(j==0)memory[i][j] = i;
                else if(m.charAt(i)==n.charAt(j)) memory[i][j] = memory[i-1][j-1];
                else memory[i][j] = 1+min(memory[i-1][j-1],memory[i][j-1],memory[i-1][j]);
            }
        }
    }

    private int  min(int i, int j, int k){
        return Math.min(Math.min(i,j),k);
    }
}
