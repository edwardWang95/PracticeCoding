package LeetCode;

import java.util.ArrayList;

class KeyBoard500Test{
    private static String[] input = {"Hello","Alaska","Dad","Peace"};
    //private static String[] input = {"Dad"};
    public static void main(String[] args){
        KeyBoard500 keyBoard500 = new KeyBoard500();
        String[] output = keyBoard500.findWords(input);
        for(String words: output){
            System.out.println(words);
        }
    }
}

/**
 * Created by edwardwang on 2/7/17.
 */
public class KeyBoard500 {
    //each row of characters
    private char[] row1 = {'q','w','e','r','t','y','u','i','o','p'};
    private char[] row2 = {'a','s','d','f','g','h','j','k','l','0'};
    private char[] row3 = {'z','x','c','v','b','n','m','0','0','0'};

    public String[] findWords(String[] words) {
        ArrayList<String> foundWords = new ArrayList<>();

        for(String word: words) {
            //System.out.println("Word:" +word);
            if (isValid(word.toLowerCase())){
                //System.out.println("Is Valid");
                foundWords.add(word);
            }
        }

        return getStringArray(foundWords);
    }

    private boolean isValid(String word){
        //check which row the word is in
            //A:65 && a:97
        char[] row = new char[0];
        char c;
        for(int i=0;i<word.length();i++){
            c = word.charAt(i);
            if(row.length==0){
                //find which row to reference
                row = getRow(c);
            }
            //check each character to see if they are in the row
            for(int j=0;j<row.length;j++){
                if(c == row[j] || (c+32)==row[j]){
                    break;
                }else if(j==row.length-1 && c!=row[j]){
                    return false;
                }
            }

        }
        return true;
    }

    private char[] getRow(char c){
        for(int i=0;i<row1.length;i++){
            if(c == row1[i]) {
                //System.out.println("Row1");
                return row1;
            }
            if(c == row2[i]) {
                //System.out.println("Row2");
                return row2;
            }
            if(c == row3[i]){
                //System.out.println("Row3");
                return row3;
            }
        }
        return null;
    }

    private String[] getStringArray(ArrayList<String> list){
        String[] result = new String[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

}
