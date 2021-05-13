import java.util.Map;

public class TrieNode {

	private Map<Character, TrieNode> next;
	
	private boolean eof;

	public Map<Character, TrieNode> getNext() {
		return next;
	}

	public void setNext(Map<Character, TrieNode> next) {
		this.next = next;
	}

	public boolean isEof() {
		return eof;
	}

	public void setEof(boolean eof) {
		this.eof = eof;
	}
	
}
