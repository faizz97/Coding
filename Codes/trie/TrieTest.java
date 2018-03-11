package trie;

public class TrieTest {
	public static void main(String args[]) {
		Trie trie = new Trie();
		trie.addWord("faisal");
		trie.addWord("apple");
		trie.addWord("fanny");
		trie.addWord("appstore");
		System.out.println(trie.isPrefixPresent("appl"));
		System.out.println(trie.suggestions("app"));
	}
}
