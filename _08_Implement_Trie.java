/**** Method 1 ****/
//Time Complexity: O(l) l is length of the word
//Space Complexity: O(l)

//Successfully submitted in LeetCode

// We create a TrieNode with 26 TrieNode array and IsEnd, the keep the initial node as root, and while inserting check in the root children array if the char is present or not, if yes we traverse it and continue until we reach there is not children node and add the remaining over there. For Search and prefix we do the same but instead of inserting we return false if we didn't find a children node.

public class _08_Implement_Trie {

  class Trie {

    class TrieNode {

      TrieNode[] children;
      boolean isEnd;

      public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
      }
    }

    TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    public void insert(String word) {
      TrieNode curr = root;

      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);

        if (curr.children[c - 'a'] == null) {
          curr.children[c - 'a'] = new TrieNode();
        }

        curr = curr.children[c - 'a'];
      }
      curr.isEnd = true;
    }

    public boolean search(String word) {
      TrieNode curr = root;

      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);

        if (curr.children[c - 'a'] == null) {
          return false;
        }

        curr = curr.children[c - 'a'];
      }

      return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
      TrieNode curr = root;

      for (int i = 0; i < prefix.length(); i++) {
        char c = prefix.charAt(i);

        if (curr.children[c - 'a'] == null) {
          return false;
        }

        curr = curr.children[c - 'a'];
      }

      return true;
    }
  }
}
