import java.util.*;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new HashMap<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		ArrayList<WordOccurrence> sortedWordCounts = new ArrayList<WordOccurrence>();

		// Display key and value for each entry
		map.forEach((k, v) -> sortedWordCounts.add(new WordOccurrence(k,v)));

		Collections.sort(sortedWordCounts);

		for (WordOccurrence pair: sortedWordCounts) {
			System.out.printf("%-10s %d\n", pair.getWord(), pair.getCount());
		}
	}
}