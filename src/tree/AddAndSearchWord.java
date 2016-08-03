package tree;

/**
 * Created by shuxuannie on 7/19/16.
 */
public class AddAndSearchWord {
    private TrieNode root;

    public AddAndSearchWord() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.have = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode cur = root;
        int len = word.length();
        return dfs(root, word, 0, len);
    }

    private boolean dfs(TrieNode node, String word, int pos, int len) {
        if (node == null || (pos == len && !node.have))
            return false;
        if (pos == len && node.have)
            return true;
        if (word.charAt(pos) == '.') {
            for (int i = 0; i < 26; i++) {
                boolean re = dfs(node.children[i], word, pos + 1, len);
                if (re)
                    return re;
            }
            return false;
        } else {
            int c = word.charAt(pos) - 'a';
            return dfs(node.children[c], word, pos + 1, len);
        }
    }

    public static void main(String[] args) {
        String word = "bad";
        AddAndSearchWord obj = new AddAndSearchWord();
        obj.addWord(word);
        obj.search("bad");

    }
}

class TrieNode {
    boolean have;
    TrieNode[] children;

    public TrieNode() {
        this.have = false;
        children = new TrieNode[26];
    }
}