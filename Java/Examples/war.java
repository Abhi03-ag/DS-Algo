class war {
	public static int rotateWords(String input1, int input2) {
		if (input1 != null && !input1.isEmpty()) {
			String words[] = input1.split("\\s+");
			int rotation = input2;
			int count = 0;
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				int word_len = word.length();
				rotation = rotation % word_len;
				int j = 0, k = word_len - rotation;
				boolean value = true;
				while (j != word_len - rotation) {
					char ch = word.charAt(j);
					char ch1 = word.charAt(k);
					if (ch1 != ch) {
						value = false;
						break;
					}
					j++;
					k = (k + 1) % word_len;
				}
				if (value)
					count++;
				rotation = input2;
			}
			return count;
		}
		return 0;

	}
	public static void main(String args[]) {
		System.out.println(rotateWords("paritosh is kajalkajal", 5));
	}
}