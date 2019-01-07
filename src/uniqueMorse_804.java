import java.util.HashSet;
import java.util.Set;

public class uniqueMorse_804 {
    public static int uniqueMorseRepresentations(String[] words) {

        String[] alphabetMorse = {".-", "-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
                ".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        Set<String> morseCount = new HashSet<>();

        for(String str : words){
            //transfer all char in a word into morse code

            StringBuilder morseCode = new StringBuilder();
            for(int i=0; i<str.length(); i++){
                //get the correspond morse code for every char
                String morseChar = alphabetMorse[alphabet.indexOf(str.substring(i,i+1))];
                morseCode.append(morseChar);
            }

            morseCount.add(morseCode.toString());
        }

        return morseCount.size();
    }

    public static int uniqueMorseRepresentations2(String[] words){
        //solution for leetcode

        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};

        Set<String> seen = new HashSet<>();
        for (String word: words) {
            StringBuilder code = new StringBuilder();
            for (char c: word.toCharArray())
                code.append(MORSE[c - 'a']);
            seen.add(code.toString());
        }

        return seen.size();
    }

    public static void main(String[] args){
        String[] words = {"gin", "zen", "gig", "msg"};

        System.out.println(uniqueMorseRepresentations(words));
    }
}
