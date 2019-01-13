package LeetCode;

/**
 * Created by edwardwang on 12/10/17.
 */
public class LeetCode {
    public static void main(String[] args){
        System.out.println("Leet Code");
        longestSubstring();
    }

    static void longestSubstring(){
        System.out.println("Longest Substring");
        String test = "abcabcbb";
        String test2 = "ivqpsqbpqjogwnswtimdlbxcwgeaenwokndefetwpjenwwksgwxszuwxb";
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println("Length of longest substring: "+longestSubstring.lengthOfLongestSubstring(test));
    }
}
