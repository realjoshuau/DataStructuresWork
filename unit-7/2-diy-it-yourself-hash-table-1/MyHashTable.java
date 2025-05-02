public class MyHashTable {
    private int[] table;

    // constructors
    public MyHashTable(int length) {
        table = new int[length];
        for (int i = 0; i < length; i++) {
            table[i] = -1;
        }
    }

    public MyHashTable() {
        this(16);
    }

    // hash function
    public int hash(int key) {
        return key % table.length;
    }

    // find method
    public int find(int element) {
        int bucket = hash(element);
        if (table[bucket] == element) {
            return bucket;
        }
        return -1;
    }

    // insert method
    public void insert(int element) {
        int bucket = hash(element);
        if (table[bucket] == -1) {
            table[bucket] = element;
        } else {
            System.out.println("Collision in bucket " + bucket + "!");
        }
    }

    // remove method
    public void remove(int element) {
        int bucket = hash(element);
        if (table[bucket] == element) {
            table[bucket] = -1;
        } else {
            System.out.println(element + " was not found!");
        }
    }
}