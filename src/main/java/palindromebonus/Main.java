package palindromebonus;

public class Main {
    public static void main(String[] args) {

        System.out.println(new Main().validPalindrome("abcdcba"));
        System.out.println(new Main().validPalindrome("abccba"));

        System.out.println(new Main().validPalindrome("abxcdcba"));
        System.out.println(new Main().validPalindrome("abcdcyba"));

    }

    public boolean validPalindrome(String word) {
        return isPalindrome(word, 1);
    }

    private boolean isPalindrome(String word, int bonusCheck) {

        int l = 0;
        int r = word.length() - 1;

        while (l < r) {

            char cl = word.charAt(l);
            char cr = word.charAt(r);

            if (cl == cr) {
                l++;
                r--;
            } else if (bonusCheck > 0) {
                return isPalindrome(word.substring(l + 1, r + 1), bonusCheck - 1) ||
                        isPalindrome(word.substring(l, r), bonusCheck - 1);

            } else {
                return false;
            }
        }

        return true;
    }

}
