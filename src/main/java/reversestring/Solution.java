package reversestring;

public class Solution {
    public static void main(String[] args) {
        String x = new Solution().reverseWords("    the sky      is blue");
        System.out.println("|" + x + "|");
    }


    public String reverseWords(String phrase) {

        return reverseWords(phrase.toCharArray());

    }

    public String reverseWords(char[] phrase) {
            if (phrase.length == 0) return "";
        int revertStart = 0;
        boolean hadReverted = false;
        for (int i = 0; i < phrase.length; i++) {
            if (' ' == phrase[i]) {
                revertWord(phrase, revertStart, i);
                hadReverted = true;
                revertStart = i + 1;
            }
        }

        if (hadReverted) {
            revertWord(phrase, revertStart, phrase.length);
            revertWord(phrase, 0, phrase.length);
        }

        StringBuilder stringBuilder = new StringBuilder();

        boolean isSpace = phrase[0] == ' ';
        for (int i = 0; i < phrase.length; i++) {
            char c = phrase[i];

            if (c != ' ') {
                stringBuilder.append(c);
                isSpace = false;
            } else {

                if (!isSpace) {
                    stringBuilder.append(' ');
                    isSpace = true;
                }
            }
        }

        return stringBuilder.toString().trim();
    }

    //e exclusive
    private void revertWord(char[] phrase, int s, int e) {
        for (int i = s; i < e; i++) {
            char c = phrase[i];
            phrase[i] = phrase[e - 1];
            phrase[e - 1] = c;
            --e;
        }
    }
}
