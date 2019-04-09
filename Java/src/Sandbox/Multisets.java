package Sandbox;

/**
 * Multisets are allowed to have repeated elements. A multiset of n items may thus have
 * fewer than n! distinct permutations. For example, {1, 1, 2, 2} has only six different
 * permutations: {1,1,2,2}, {1,2,1,2}, {1,2,2,1}, {2,1,1,2}, {2,1,2,1}, and {2, 2, 1, 1}.
 * Design and implement an efficient algorithm for constructing all permutations of a
 * multiset.
 * Created by edwardwang on 11/2/17.
 */
public class Multisets {
    private int[] multiset;
    private int NMAX = 0;
    private boolean isFinished = false;

    public Multisets(int[] multiset, int NMAX){
        this.multiset = multiset;
        this.NMAX = NMAX;
    }
    public void printPermutations(){
        backtrack(multiset, 0, 6);
    }

    /**
     *
     * @param a : given partial solution and try to extend it by adding another element
     * @param k : index of the multiset
     * @param n : # of candidates
     */
    private void backtrack(int a[], int k, int n){
        int candidates[] = new int[NMAX];
        int ncandidates = 0;

        if(is_a_solution(k,n)){
            process_solution(a,k);
        }else{
            k++;
            construct_candidates(a,k,n,candidates,ncandidates);
            /*
            for(int i=0;i<NMAX;i++){
                a[k] = c[i];
                backtrack(a,k,n);
                if(isFinished) return;
            }
            */
            //or - from lecture 15
            while(candidates.length != 0){
                a[k] = candidates[k];
                removeKElementFromArray(k, candidates);
                backtrack(a, k, n);
            }
        }
    }

    private void removeKElementFromArray(int k, int[] candidates){
        int newCandidates[] = new int[candidates.length - 1];
        int counter = 0;
        for(int i=0;i<candidates.length;i++){
            if(i!=k){
                newCandidates[counter] = candidates[i];
                counter++;
            }
        }
        candidates = newCandidates;
    }

    /**
     * This routine fills an array c with the complete set of possible candidates for the kth position of a, given the contents of the first k − 1 positions.
     * The number of candidates returned in this array is denoted by candidates.
     *
     * Prune the possible candidates based on the output by avoiding repeating permutation
     * elements ==> S[subscript(k)] = {1,...,n} - a.
     * @param a : Input array where a is a solution whenever k = n.
     * @param k : Position within a.
     * @param n : Total number of possibilities.
     * @param c : Array of possible candidates for the kth position of a
     * @param candidates : pointer to
     */
    private void construct_candidates(int a[], int k, int n, int c[], int candidates){
        boolean in_permutation[] = new boolean[NMAX];
        //init array of in_permutation items of size NMAX
        for(int i=1;i<NMAX;i++){
            in_permutation[i] = false;
        }
        //set all elements up to kth index
        for(int i=0;i<k;i++){
            in_permutation[a[i]] = true;
        }
        candidates = 0;
        for(int i=1;i<=n;i++){
            c[i] = i;
            candidates ++;
        }
    }

    /**
     * Tests whether first k elements of array a are a complete solution for given problem.
     * @param k : k elements
     * @param n : pass general information to evaluate whether a is a solution or not/
     *          Here n is the index of a for loop.
     */
    private boolean is_a_solution(int k, int n){
        return (k==n);
    }

    /**
     * Processes a complete solution once its constructed.
     * @param a : Input array where a is a solution whenever k = n.
     * @param k : Kth index.
     */
    private void process_solution(int a[], int k){
        for(int i=1;i<=k;i++){
            System.out.print(a[i] + " ");
            System.out.println();
        }
    }
}
