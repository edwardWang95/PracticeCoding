package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3.
    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Created by edwardwang on 12/10/17.
 */
public class LongestSubstring {
    public LongestSubstring(){}
    public int lengthOfLongestSubstring(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int substringLength = 0;
        int startChar = 0;
        int endChar = 0;
        if(s.length()==0){
            return 0;
        }
        int c;
        for(int i =0;i<s.length();i++){
           c = (int)s.charAt(i);
           if(!map.containsKey(c)){
               map.put(c,0);
               endChar = i;
           }else{
               if(endChar-startChar+1 > substringLength){
                   substringLength = endChar-startChar + 1;
               }
               startChar = i;
               //endChar = i+1;
               map = new HashMap<>();
               map.put(c,0);
           }
        }
        return substringLength;
    }
    public int lengthOfLongestSubstring2(String s) {
        int length = 0;
        String temp = s.charAt(0)+"";
        for(int i =1;i<s.length();i++) {
            if(true){
                temp += s.charAt(i);
            }
        }
        return temp.length();
    }

}
