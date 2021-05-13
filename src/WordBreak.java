import java.util.HashMap;
import java.util.Map;

public class WordBreak {

	public static void main(String args[]) {

		 String dictionary[] = { "mobile", "samsung", "sam", "sung", "ma",
		 "mango", "icecream", "and", "go", "i", "like",
		 "ice", "cream" };

//		String dictionary[] = { "i", "like", "ice", "cream" };

		TrieNode root = prepareTrie(dictionary);
//		printTrie(root, "");

		System.out.println(wordBreak("samsungandmangok", root));
	}

	static void printTrie(TrieNode node, String str) {
		if (node.isEof()) {
			System.out.println("EOF :: "+str);
		}
		if(node.getNext() != null){
			for (Map.Entry<Character, TrieNode> entry : node.getNext().entrySet()) {
				printTrie(entry.getValue(), str + entry.getKey());
			}
		} 
	}

	static TrieNode prepareTrie(String dict[]) {
		TrieNode root = new TrieNode();
		for (String str : dict) {
			char ch[] = str.toCharArray();
			TrieNode prev = root;
			int i = 0;
			for (; i < ch.length; i++) {
				if (prev.getNext() == null || prev.getNext().get(ch[i]) == null) {
					break;
				}
				prev = prev.getNext().get(ch[i]);
			}
			for (; i < ch.length; i++) {
				Map<Character, TrieNode> nextMap = prev.getNext();
				if (nextMap == null) {
					nextMap = new HashMap<>();
					prev.setNext(nextMap);
				}
				nextMap.put(ch[i], new TrieNode());
				prev = prev.getNext().get(ch[i]);
			}
			prev.setEof(true);
		}
		return root;
	}

	static boolean search(String str, TrieNode root) {
		char ch[] = str.toCharArray();
		TrieNode tmp = root;
		for (char c : ch) {
			if (tmp.getNext() != null && tmp.getNext().get(c) != null) {
				tmp = tmp.getNext().get(c);
			} else {
				return false;
			}
		}
		return tmp.isEof();
	}

	static boolean wordBreak(String str, TrieNode trie) {
		if (str.length() == 0) {
			return true;
		}
		for (int i = 1; i <= str.length(); i++) {
			if (search(str.substring(0, i), trie) && wordBreak(str.substring(i), trie)) {
				return true;
			}
		}
		return false;

	}

}
