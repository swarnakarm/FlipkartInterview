import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintJson {

	public static void main(String[] args) {
		String[] equations = new String[] {"a>b=1", "a>b=2", "a>c>e=3", "a>c>f=4", "b>a=5", "a>b>c=5", "b=7", "a>b>c>d=99",
				"a>b=99" };
		Trie root = prepareTrie(equations);
		System.out.println("{"+root.print()+"}");
	}

	static class Trie {
		Map<String, Trie> greater;
		Map<String, Trie> equals;
		List<String> val;
		boolean eof;

		String print() {
			String result = "";
			if (eof) {
				if (val.size() > 1) {
					String str = "[";
					for (int i = 0; i < val.size(); i++) {
						str += val.get(i);
						if (i + 1 != val.size()) {
							str += ",";
						}
					}
					str += "]";
					return str;
				} else {
					return "\"" + val.get(0) + "\"";
				}
			}
			
			if (this.greater != null) {
				int i=0;
				for (Map.Entry<String, Trie> entry : greater.entrySet()) {
					result += "\"" + entry.getKey() + "\"" + ":{" + entry.getValue().print() + "}";
					result += i+1 == greater.size() ? "" : ",";
					i++;
				}
			}  
			if (this.equals != null) {
				if(this.greater != null){
					result += ",";
				}
				int i=0;
				for (Map.Entry<String, Trie> entry : equals.entrySet()) {
					result += "\"" + entry.getKey() + "\"" + ":" + entry.getValue().print();
					result += i+1 == equals.size() ? "" : ",";
					i++;
				}
			}
			return result;
		}

	}

	static Trie prepareTrie(String[] equations) {
		Trie root = new Trie();
		for (String equation : equations) {
			Trie tmp = root;
			char ch[] = equation.toCharArray();
			boolean equals = false;
			int i = 1;
			int prev = 0;
			for (; i < ch.length; i++) {
				if (ch[i] == '>') {
					String subStr = equation.substring(prev, i);
					if (tmp.equals == null || !tmp.equals.containsKey(subStr)) {
						if (tmp.greater == null) {
							tmp.greater = new HashMap<>();
						}
						if (null == tmp.greater.get(subStr)) {
							tmp.greater.put(subStr, new Trie());
						}
						tmp = tmp.greater.get(subStr);
						prev = i + 1;
					} else {
						break;
					}
				} else if (ch[i] == '=') {
					String subStr = equation.substring(prev, i);
					if (tmp.greater == null || !tmp.greater.containsKey(subStr)) {
						if (tmp.equals == null) {
							tmp.equals = new HashMap<>();
						}
						if (null == tmp.equals.get(subStr)) {
							Trie terminatedNode = new Trie();
							terminatedNode.eof = true;
							tmp.equals.put(subStr, terminatedNode);
						}
						tmp = tmp.equals.get(subStr);
						if (tmp.val == null) {
							tmp.val = new ArrayList<>();
						}
						prev = i + 1;
						equals = true;
					}
					break;
				}
			}
			if (equals) {
				tmp.val.add(equation.substring(prev));
			}
		}
		return root;
	}

}
