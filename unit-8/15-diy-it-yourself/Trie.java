
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('-'); // Root does not store a letter
    }

    public TrieNode insert(String word) {
        TrieNode current = root;
        for (char letter : word.toCharArray()) {
            current = current.addChild(letter);
        }
        current.setTerminal(true);
        return current;
    }

    public TrieNode search(String word) {
        TrieNode current = root;
        for (char letter : word.toCharArray()) {
            current = current.getChild(letter);
            if (current == null)
                return null;
        }
        return current.isTerminal() ? current : null;
    }

    public boolean remove(String word) {
        return remove(root, word, 0);
    }


    private boolean remove(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isTerminal()) {
                return false;
            }
            current.setTerminal(false);
            return isEmpty(current.getChildren());
        }

        char letter = word.charAt(index);
        TrieNode child = current.getChild(letter);
        if (child == null) {
            return false;
        }

        boolean shouldDelete = remove(child, word, index + 1) && !child.isTerminal();

        if (shouldDelete) {
            current.removeChild(letter);
            return isEmpty(current.getChildren());
        }
        return false; // return false if the node was not deleted.
    }
    private boolean isEmpty(TrieNode[] children) {
        for (TrieNode child : children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    public void printTrie() {
        printTrie(root, "");
    }

    private void printTrie(TrieNode current, String word) {
        if (current.isTerminal()) {
            System.out.println(word);
        }
        for (TrieNode child : current.getChildren()) {
            if (child != null) {
                printTrie(child, word + child.getLetter());
            }
        }
    }
}