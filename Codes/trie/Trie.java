package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	TrieNode root;
	public Trie() {
		this.root = new TrieNode();
	}
	public void addWord(String word) {
		root.addWord(word);
	}
	public boolean isPrefixPresent(String prefix) {
		return isPrefixPresent(prefix, false);
	}
	public boolean isPrefixPresent(String prefix, boolean exact) {
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			if (node.getChild(prefix.charAt(i)) == null)
				return false;
			node = node.getChild(prefix.charAt(i));
		}
		return exact ? node.terminates : true;
	}
	public String suggestions(String prefix) {
		StringBuilder result = new StringBuilder("");
		boolean flag = true;
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			if (node.getChild(prefix.charAt(i)) == null)
				 flag = false;
			node = node.getChild(prefix.charAt(i));
		}
		if (!flag)
			return null;
		else if (node.terminates)
			return prefix;
		else {
			TrieNode child = node;
			for (Map.Entry<Character, TrieNode> pair : node.children.entrySet()) {
				child = (TrieNode) pair.getValue();
				generateSuggestions(child, result, "" + prefix + pair.getKey());
			}
		}
		return result.toString();
	}
	private String generateSuggestions(TrieNode node, StringBuilder result, String prefix) {
		if (node.terminates) {
			result.append(prefix + "\n");
			return result.toString();
		}
		TrieNode child;
		for (Map.Entry<Character, TrieNode> pair : node.children.entrySet()) {
			child = (TrieNode) pair.getValue();
			generateSuggestions(child, result, "" + prefix + pair.getKey());
		}
		return result.toString();
	}
}
class TrieNode {
	char character;
	HashMap<Character, TrieNode> children;
	boolean terminates;
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
	}
	public TrieNode(char character) {
		this.character = character;
		children = new HashMap<Character, TrieNode>();
	}
	public void addWord(String word) {
		if (word == null || word.length() == 0)
			return;
		char firstChar = word.charAt(0);
		TrieNode child = getChild(firstChar);
		if (child == null) {
			child = new TrieNode(firstChar);
			children.put(firstChar, child);
		}
		if (word.length() > 1)
			child.addWord(word.substring(1));
		else
			child.setTerminates(true);
	}
	public TrieNode getChild(char input) {
		return children.get(input);
	}
	public void setTerminates(boolean t) {
		terminates = t;
	}
	public boolean terminates() {
		return terminates;
	}
}
