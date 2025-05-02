
public class MyHashTable {
    private Computer[] table;

    // constructors
    public MyHashTable(int length) {
        table = new Computer[length];
    }

    public MyHashTable() {
        this(16);
    }

    // hash function
    public int hash(int key) {
        return key % table.length;
    }

    public int find(int key) {
        return this.findIndex(key);
    }

    // findIndex method
    public int findIndex(int key) {
        int bucket = hash(key);
        int startBucket = bucket;
        // use quadratic probing
        int C1 = 1;
        int C2 = 1;
        int i = 0;

        while (true) {
            if (table[bucket] == null) {
                return -1;
            } else if (table[bucket].getKey() == key) {
                return bucket;
            }
            i++;
            bucket = (startBucket + C1 * i + C2 * i * i) % table.length;
            if (bucket == startBucket) {
                break;
            }            
        }
        return -1;
    }

    // get method
    public Computer get(int key) {
        int index = findIndex(key);
        return index != -1 ? table[index] : null;
    }

    // insert method
    public void insert(Computer computer) {
        int key = computer.getKey();
        int bucket = hash(key);
        int startBucket = bucket;
        // use quadratic probing
        int C1 = 1;
        int C2 = 1;
        int i = 0;

        while (table[bucket] != null && table[bucket].getKey() != -1) {
            i++;
            bucket = (startBucket + C1 * i + C2 * i * i) % table.length;
            if (bucket == startBucket) {
                System.out.println("Table is full!");
                return;
            }
        }
    
        table[bucket] = computer;
    }

    // remove method
    public Computer remove(int key) {
        int index = findIndex(key);
        if (index != -1) {
            Computer removed = table[index];
            table[index] = new Computer(); // mark as removed
            return removed;
        } else {
            System.out.println(key + " was not found!");
            return null;
        }
    }
}