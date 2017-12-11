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
        HashMap<String, Integer> map = new HashMap<>();
        String temp = s.charAt(0)+"";
        int length = 0;
        int c;
        for(int i =0;i<s.length();i++){
           c = (int)s.charAt(i);
           if(!map.containsKey(c)){
               map.put(c,0);
               length++;
           }
        }
        return temp.length();
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
