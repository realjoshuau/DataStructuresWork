
public class MyHashTable {
    private Computer[] table;
    private int prime;

    // constructors
    public MyHashTable(int length) {
        table = new Computer[length];
        this.prime = getClosestPrimeLessThan(length);
    }

    public MyHashTable() {
        this(16);
    }

    private int getClosestPrimeLessThan(int n) {
        for (int i = n - 1; i > 1; i--) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                return i;
            }
        }
        return 2;
    }

    public int hashOne(int key) {
        return key % table.length;
    }

    public int hashTwo(int key) {
        return (prime - (key % prime));
    }

    // hash function
    public int hash(int key, int i) {
        return (hashOne(key) + hashTwo(key) * i) % table.length;
    }

    public int find(int key) {
        return this.findIndex(key);
    }

    // findIndex method
    public int findIndex(int key) {
        // use double hashing
        int bucket = hash(key, 0); // functionally the same as hashOne(key);
        int startBucket = bucket;
        int i = 0;

        while (table[bucket] != null) {
            if (table[bucket].getKey() == key) {
                return bucket;
            }
            i++;
            bucket = hash(key, i);
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
        int bucket = hash(key, 0);
        int startBucket = bucket;
        int i = 0;

        while (table[bucket] != null && !(table[bucket].serialNumber == -1)) {
            i++;
            bucket = hash(key, i);
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