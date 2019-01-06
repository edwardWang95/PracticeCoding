/**
 * Created by edwardwang on 1/9/18.
 */

class BrailleTest{
    public static void main(String[] args){
        String test = "The quick brown fox jumps over the lazy dog";
        String testAnswer = "000001011110110010100010000000111110101001010100100100101000000000110000111010101010010111101110000000110100101010101101000000010110101001101100111100011100000000101010111001100010111010000000011110110010100010000000111000100000101011101111000000100110101010110110";
        System.out.println(test);
        Braille braille = new Braille();
        System.out.println(braille.answer(test));
        System.out.println(testAnswer);
        System.out.println(braille.answer("").equals(""));
    }
}

public class Braille {
    //use this to convert capitalized chars to lower case
    private String capitalization = "000001";
    private String space = "000000";
    private int[][] brailleVals = new int[][]{
            {2},
            {4},
            {4,5},
            {5},
            {2,4},
            {2,4,5},
            {2,5}
    };

    public String answer(String plaintext) {
        if(plaintext.equals("")){
            return "";
        }
        String words[] = plaintext.split("\\s+");
        String result = "";
        Boolean isAllCaps;
        for(int i=0;i<words.length;i++){
            isAllCaps = false;
            if(isEntireWordCapitalized(words[i])){
                result += capitalization + capitalization;
                isAllCaps = true;
            }
            for(char c: words[i].toCharArray()){
                result += convertCharToBraille(c, isAllCaps);
            }
            if(i < words.length - 1){
                result += space;
            }
        }
        return result;
    }

    private String convertCharToBraille(char c, boolean isAllCaps){
        String result = "";
        StringBuilder temp;
        if(isCapitalized(c) && !isAllCaps){
            result += capitalization;
        }
        int index = getIndex(c);
        if(index == 22){    //w
            result += "010111";
        }else{
            if(index > 22){
                index -= 1;
            }
            int quotient = index / 10;
            int remainder = index % 10 - 1;
            temp = new StringBuilder(updateBrailleByQuotient(quotient));
            if(remainder >= 0){
                if(remainder == 7 || remainder == 8){
                    temp.setCharAt(0, '0');
                    remainder -= 3;
                }
                for(int i : brailleVals[remainder]){
                    temp.setCharAt(i-1,'1');
                }
                result += temp;
            }
        }
        return result;
    }

    private int getIndex(int currValue){
        if(65 <= currValue && currValue <= 90){
            return(currValue - 65);  //capitalized
        }else{
            return(currValue - 97);  //lowercase
        }
    }

    /**
     * Braille works on 3 levels.
     * 1: nothing added to string
     * 2: add '3' to string [2:string index]
     * 3: add '3' and '6' to string [5:string index]
     */
    private String updateBrailleByQuotient(int indexLevel){
        if(indexLevel == 0) {
            return "100000";
        }else if(indexLevel == 1){
            return "101000";
        }else if(indexLevel == 2){
            return "101001";
        }
        return space;
    }

    private boolean isCapitalized(char c){
        return (65 <= c && c <= 90);
    }

    //Capitalized ASCII: 65 - 90
    //lower case: 97 - 122
    private boolean isEntireWordCapitalized(String text){
        int counter = 0;
        for(int c: text.toCharArray()){
            if(65 <= c && c <= 90){
                counter ++;
            }
        }
        return counter == text.length();
    }

}
