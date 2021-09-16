import java.util.*;

/* https://leetcode-cn.com/problems/word-search-ii/ */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        }, new String[]{"oath"});
    }

    static int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    char[][] board;
    int row;
    int col;

    static class Trie {
        String word;
        Map<Character, Trie> children;

        Trie() {
            this.word = "";
            this.children = new HashMap<>();
        }

        public void insert(String word) {
            Trie curr = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Trie());
                }
                curr = curr.children.get(c);
            }
            curr.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);

        this.board = board;
        this.row = board.length;
        this.col = board[0].length;

        Set<String> answers = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(trie, i, j, answers);
            }
        }
        return new ArrayList<>(answers);
    }

    public void dfs(Trie trie, int i, int j, Set<String> answers) {
        char c = board[i][j];
        if (!trie.children.containsKey(c)) return;

        Trie next = trie.children.get(c);
        if (!"".equals(next.word)) {
            answers.add(next.word);
            next.word = "";
        }
        if (!next.children.isEmpty()) {
            board[i][j] = '#';
            for (int[] dir : dirs) {
                int next_i = i + dir[0];
                int next_j = j + dir[1];
                if (next_i >= 0 && next_i < row && next_j >= 0 && next_j < col) {
                    dfs(next, next_i, next_j, answers);
                }
            }
            board[i][j] = c;
        } else {
            trie.children.remove(c);
        }
    }
}
