
import java.util.*;
public class GFG {

	static String getKey(String str) {
		final int MAX_CHAR = 26;
		int[] count = new int[MAX_CHAR];
		for (int j = 0; j < str.length(); j++)
			count[str.charAt(j) - 'a']++;
		String key = "";
		for (int j = 0; j < MAX_CHAR; j++)
			if (count[j] > 0)
				key = key + count[j];
		return key;
	}

	static void wordsWithSameCharSet(String words[], String correctWords[], int n , String Query) {
		HashMap<String, ArrayList<String>> Hash = new HashMap<>();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			set.add(words[i].toLowerCase());
		}
		for (String s : set) {
			String key = getKey(s);
			if (Hash.containsKey(key)) {
				ArrayList<String> get_al = Hash.get(key);
				get_al.add(s);
				Hash.put(key, get_al);
			} else {
				ArrayList<String> new_al = new ArrayList<>();
				new_al.add(s);
				Hash.put(key, new_al);
			}
		}
		String result = "";
		String reKey = getKey(Query);
		System.out.println("The grouped keywords are: ");
		for (String word : correctWords) {
			String key = getKey(word.toLowerCase());
			if (key.equals(reKey))
				result = word;
			ArrayList<String> lst = Hash.get(key);
			Collections.sort(lst);
			System.out.println(lst);
		}
		System.out.println("The correct keyword for the search key " + Query + " is " + result);
	}

	// Driver program to test above function
	public static void main(String args[]) {
		String words[] = {"Science", "sicence", "science", "departmnet", "depratment", "computer", "comptuer", "computer", "Sceince"};
		String correctWords[] = {"department", "computer", "science"};
		String query = "sicence";
		int n = words.length;
		wordsWithSameCharSet(words, correctWords, n, query);
	}
}
