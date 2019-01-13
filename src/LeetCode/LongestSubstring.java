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
        String temp = "";
        int substringLength = 0;
        int startChar = 0;
        int endChar = 0;
        if(s.length()==0){
            return 0;
        }
        char c;
        for(int i=0;i<s.length();i++){
           c = s.charAt(i);
           if(!contains(temp,c)){
               temp += c;
               endChar = i;
           }else{
               if((i+1 < s.length()) && s.charAt(i) == s.charAt(i+1)){
                   startChar = i+1;
               }else{
                   startChar = getLocationOfFirstInstance(s.substring(startChar, s.length()-1),c) + 1;
               }
                /*
               if(s.charAt(i+1) != s.charAt(i)){
                   //startChar++;
                   //startChar = startChar + getLocationOfDuplicate(s, c);
                   startChar = getLocationOfFirstInstance(s.substring(startChar),c) + 1;
               }else{
                   startChar = i;
               }
               */
               endChar = startChar;
               i = startChar;
               temp = s.charAt(i)+"";
           }
            if(endChar-startChar + 1 > substringLength){
                substringLength = endChar-startChar + 1;
            }
            System.out.println("Substring: "+temp);
            //System.out.println(s.charAt(startChar)+"\t"+s.charAt(endChar));
        }
        return substringLength;
    }

    private int getLocationOfFirstInstance(String s, char c){
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)==c){
                return i;
            }
        }
        return 0;
    }

    private boolean contains(String s, char c){
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)==c){
                return true;
            }
        }
        return false;
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
