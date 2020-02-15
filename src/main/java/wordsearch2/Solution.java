package wordsearch2;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public static final char VISITED = '-';

    public static void main(String[] args) {

        System.out.println(new Solution().findWords(
                new char[][]{new char[]{'a'}},
                new String[]{"b"}
        ));
        System.out.println(new Solution().findWords(
                new char[][]{new char[]{'a'}},
                new String[]{"a"}
        ));

        System.out.println(new Solution().findWords(
                new char[][]{
                        new char[]{'a', 'b'},
                        new char[]{'a', 'a'}

                }, new String[]{"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"}
        ));


        System.out.println(new Solution().findWords(
                new char[][]{
                        new char[]{'o', 'a', 'a', 'n'},
                        new char[]{'e', 't', 'a', 'e'},
                        new char[]{'i', 'h', 'k', 'r'},
                        new char[]{'i', 'f', 'l', 'v'},

                }, new String[]{"oath", "pea", "eat", "rain"}
        ));
    }

    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = getTrieForWords(words);

        List<String> foundWords = new LinkedList<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                findWord(board, foundWords, trie.child[board[r][c] - 'a'], r, c);
            }
        }
        return foundWords;
    }

    private void findWord(char[][] board, List<String> foundWords, Trie trie, int row, int col) {

        if (trie == null) return;

        if (trie.word != null) {
            foundWords.add(trie.word);
            trie.word = null; // deduplicate
        }

        char cSave = board[row][col];

        board[row][col] = VISITED;

        if (row > 0) {
            consumeAdjacent(board, foundWords, trie, row - 1, col);
        }

        if (row < board.length - 1) {
            consumeAdjacent(board, foundWords, trie, row + 1, col);
        }

        if (col > 0) {
            consumeAdjacent(board, foundWords, trie, row, col - 1);
        }

        if (col < board[0].length - 1) {
            consumeAdjacent(board, foundWords, trie, row, col + 1);
        }

        board[row][col] = cSave;

    }

    private void consumeAdjacent(char[][] board, List<String> foundWords, Trie trie, int row, int col) {
        char c = board[row][col];
        if (c == VISITED) return;

        Trie trieChild = trie.child[c - 'a'];
        findWord(board, foundWords, trieChild, row, col);
    }

    private Trie getTrieForWords(String[] words) {
        Trie root = new Trie();

        for (String word : words) {
            addWord(0, root, word);
        }
        return root;
    }

    private void addWord(int i, Trie trie, String word) {
        if (i >= word.length()) {
            trie.end = true;
            trie.word = word;
            return;
        }

        char c = word.charAt(i);
        Trie child = trie.child[c - 'a'];
        if (child == null) {
            child = new Trie();
            trie.child[c - 'a'] = child;
        }

        addWord(i + 1, child, word);

    }


    public class Trie {
        public String word;
        public boolean end;

        public Trie[] child = new Trie[26];

    }

}