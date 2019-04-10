package Sandbox;

import java.util.ArrayList;

/**
 * Describe a backtracking algorithm for efficiently listing all k=element subsets of n items.
 * i.e.
 * For n=5, the 3-element subsets are
 * 1,2,3
 * 1,2,4
 * 1,2,5
 * 1,3,4
 * 1,4,5
 * 2,3,4
 * 2,3,5
 * 2,4,5
 * 3,4,5
 * Created by edwardwang on 11/17/17.
 */
public class BacktrackingSubsets {
    private ArrayList<int[]> solutionSet = new ArrayList<>();
    private int n,k;
    public BacktrackingSubsets(int n, int k){
        this.n = n;
        this.k = k;
    }

    public void backtracking(){
        backtracking(new int[3], 0);
    }

    private void backtracking(int[] solution, int index){
        if(is_a_solution(solution)){
            process_solution(solution);
        }else{
            ArrayList<Integer> candidates = construct_candidates(solution, index);
            for(Integer integer:candidates){
                solution[index] = integer;
                backtracking(solution, index+1);
                solution[index] = 0;
            }
        }
    }

    private boolean is_a_solution(int[] solution){
        for(int i=0;i<k;i++){
            if(solution[i]==0)return false;
        }
        return true;
    }

    private void process_solution(int[] solution){
        solutionSet.add(solution);
        System.out.print("(");
        for(int i=0;i<k;i++){
            System.out.print(solution[i]);
            if(i!=k-1){
                System.out.print( ", ");
            }
        }
        System.out.print(")");
        System.out.println();
    }

    private ArrayList<Integer> construct_candidates(int[] solution, int index){
        boolean contains = false;
        ArrayList<Integer> candidates = new ArrayList<>();
        for(int i =1;i<=n;i++){
            for(int j=0;j<index;j++){
                if(solution[j]==i){
                    contains = true;
                    break;
                }
            }
            if(!contains){
                candidates.add(i);
            }
            contains = false;
        }
        return candidates;
    }
}
