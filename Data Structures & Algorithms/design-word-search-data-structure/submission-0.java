class Trie {
    boolean isEnding;
    Map<Character, Trie> children = new HashMap<>();

    public void add(String word) {
        if (word.length() == 0) {
            isEnding = true;
            return;
        }

        char c = word.charAt(0);
        Trie child = children.computeIfAbsent(c, k -> new Trie());
        child.add(word.substring(1));
        children.put(c, child);
    }

    public boolean search(String word) {
        if (word.length() == 0) {
            return isEnding;
        }

        char c = word.charAt(0);
        String nextWord = word.substring(1);
        if (c == '.') {
            for (Trie child : children.values()) {
                if (child.search(nextWord)) {
                    return true;
                }
            }
        }

        Trie child = children.get(c);
        if (child == null) {
            return false;
        }

        return child.search(nextWord);
    }
}

class WordDictionary {
    Trie trie = new Trie();

    public WordDictionary() {
        
    }

    public void addWord(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }
}
