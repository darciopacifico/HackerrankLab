package isanagram;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("mam", "rat"));
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[256];
        int[] arr2 = new int[256];
        for (char c : s.toCharArray()) arr[c]++;
        for (char c : t.toCharArray()) arr2[c]++;
        for (int x = 0; x < 256; x++) {
            if (arr[x] != arr2[x]) return false;
        }
        return true;
    }

    public boolean isAnagramx(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] chars = new int[256];

        for (char c : s.toCharArray()) chars[c]++;
        for (char c : t.toCharArray()) chars[c]--;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] != 0) return false;
        }

        return true;
    }


}
