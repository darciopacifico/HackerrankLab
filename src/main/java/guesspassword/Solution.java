package guesspassword;

public class Solution {
    public static void main(String[] args) {
        new Solution().findSecretWord(new String[]{
                "sjdfhg",
                "tjerwd",
                "wrevzr",
                "adffgg"
        }, word -> 0);
    }

    public void findSecretWord(String[] wordlist, Master master) {
        int[] letterCount = new int[26];


        double[] letterProb = new double[26];

        for (int i = 0; i < wordlist.length; i++) {
            String word = wordlist[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                letterCount[c - 'a']++;
            }
        }

        System.out.println(letterCount);
    }
}
