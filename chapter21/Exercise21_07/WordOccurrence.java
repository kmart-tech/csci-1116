public class WordOccurrence implements Comparable<WordOccurrence> {
    private final String word;
    private final int count;

    WordOccurrence(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public int compareTo(WordOccurrence otherWord) {
        if (count > otherWord.count) {
            return 1;
        }
        else if (count == otherWord.count) {
            return 0;
        }
        else return -1;
    }
}
