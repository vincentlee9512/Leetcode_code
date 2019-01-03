public class Jewels_and_Stones_771 {

    //solved in Javascript
    //This file does not contain any valid code.

    public static int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            throw new IllegalArgumentException("The length of the input string is zero. String: "+ s);
        }

        int max = 1;

        int currentLength = 1;
        StringBuilder holder = new StringBuilder();

        //loop thought input string,
        for(int i=0; i<s.length(); i++){

            if(holder.indexOf(s.substring(i, i+1)) == -1){
                //the next character is not in the holder string.

            }else{
                //the next character is in the holder string.
            }

        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println(Jewels_and_Stones_771.lengthOfLongestSubstring(s1));
        System.out.println(Jewels_and_Stones_771.lengthOfLongestSubstring(s2));
        System.out.println(Jewels_and_Stones_771.lengthOfLongestSubstring(s3));

    }
}
