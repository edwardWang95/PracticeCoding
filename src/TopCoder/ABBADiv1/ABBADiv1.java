package TopCoder.ABBADiv1;

/**
 * Problem Statement
 One day, Jamie noticed that many English words only use the letters A and B. Examples of such words include "AB"
 (short for abdominal), "BAA" (the noise a sheep makes), "AA" (a type of lava), and "ABBA" (a Swedish pop sensation).

 Inspired by this observation, Jamie created a simple game. You are given two strings: initial and target. The goal of
 the game is to find a sequence of valid moves that will change initial into target. There are two types of valid moves:

 Add the letter A to the end of the string.
 Add the letter B to the end of the string and then reverse the entire string. (After the reversal the newly-added B
 becomes the first character of the string). Return "Possible" (quotes for clarity) if there is a sequence of valid
 moves that will change initial into target. Otherwise, return "Impossible".

 Definition
 Class: ABBADiv1
 Method: canObtain
 Parameters: String, String
 Returns: String
 Method signature: String canObtain(String initial, String target)
 (be sure your method is public)
 Limits
 Time limit (s): 2.000
 Memory limit (MB): 256
 Constraints
 - The length of initial will be between 1 and 49, inclusive.
 - The length of target will be between 2 and 50, inclusive.
 - target will be longer than initial.
 - Each character in initial and each character in target will be either 'A' or 'B'.

 Examples
 0)
 "A"
 "BABA"
 Returns: "Possible"
 Jamie can perform the following moves:
 Initially, the string is "A".
 Jamie adds a 'B' to the end of the string and then reverses the string. Now the string is "BA".
 Jamie adds a 'B' to the end of the string and then reverses the string. Now the string is "BAB".
 Jamie adds an 'A' to the end of the string. Now the string is "BABA".
 Since there is a sequence of moves which starts with "A" and creates the string "BABA", the answer is "Possible".
 1)
 "BAAAAABAA"
 "BAABAAAAAB"
 Returns: "Possible"
 Jamie can add a 'B' to the end of the string and then reverse the string.
 2)
 "A"
 "ABBA"
 Returns: "Impossible"
 3)
 "AAABBAABB"
 "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB"
 Returns: "Possible"
 4)
 "AAABAAABB"
 "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB"
 Returns: "Impossible"
 This problem statement is the exclusive and proprietary property of TopCoder, Inc.
 Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc.
 is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 * Created by edwardwang on 10/13/16.
 */
public class ABBADiv1 {
    private static final String POSSIBLE = "Possible";
    private static final String IMPOSSIBLE = "Impossible";

    public static void main(String[] args){
        String initial = "A";
        String target = "ABBA";
        System.out.println(canObtain(initial, target));
    }


    public static String canObtain(String initial, String target){
        int counter = 0;
        char initialChar, targetChar;
        while(counter < target.length()){
            if(counter < initial.length()){
                initialChar = initial.charAt(counter);
            }else{
                initialChar = '\u0000';
            }
            targetChar = target.charAt(counter);
            if(initialChar!=targetChar || initialChar == '\u0000'){
                switch (targetChar){
                    case 'A':
                        initial += 'A';
                        break;
                    case 'B':
                        initial += 'B';
                        initial = flipString(initial);
                        break;
                }
            }
            System.out.println("Initial: "+initial);
            System.out.println("Target: "+target);
            System.out.println();
            counter ++;
        }
        if(isEqual(initial, target)){
            return POSSIBLE;
        }else{
            return IMPOSSIBLE;
        }
    }

    private static boolean isEqual(String initial, String target){
        try {
            for(int i=0;i<target.length();i++){
                if(initial.charAt(i) != target.charAt(i)){
                    return false;
                }
            }
            return true;
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    private static String flipString(String string){
        String temp = "";
        for(int i=string.length()-1;i>=0;i--){
            temp += string.charAt(i);
        }
        return temp;
    }
}
