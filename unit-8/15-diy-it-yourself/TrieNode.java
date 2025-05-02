
class TrieNode {
    private char letter;
    private TrieNode[] children;
    private boolean isTerminal;
    
    public TrieNode(char letter) {
        this.letter = letter;
        this.children = new TrieNode[26]; // one for each uppercase letter
        this.isTerminal = false;
    }
    
    public char getLetter() {
        return letter;
    }
    
    public TrieNode addChild(char letter) {
        int index = letter - 'A';
        if (children[index] == null) {
            children[index] = new TrieNode(letter);
        }
        return children[index];
    }
    
    public TrieNode getChild(char letter) {
        return children[letter - 'A'];
    }
    
    public void removeChild(char letter) {
        children[letter - 'A'] = null;
    }
    
    public TrieNode[] getChildren() {
        return children;
    }
    
    public boolean isTerminal() {
        return isTerminal;
    }
    
    public void setTerminal(boolean isTerminal) {
        this.isTerminal = isTerminal;
    }
}