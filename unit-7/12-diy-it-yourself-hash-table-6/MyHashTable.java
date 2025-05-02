
public class MyHashTable {
    private Computer[] table;
    private int prime;
    private static final Computer EMPTY = new Computer();

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

    // // findIndex method
    // public int findIndex(int key) {
    // // use double hashing
    // int bucket = hash(key, 0); // functionally the same as hashOne(key);
    // int startBucket = bucket;
    // int i = 0;

    // while (table[bucket] != null) {
    // if (table[bucket].getKey() == key) {
    // return bucket;
    // }
    // i++;
    // bucket = hash(key, i);
    // if (bucket == startBucket) {
    // break;
    // }
    // }
    // return -1;
    // }

    public int findIndex(int key) {
        int bucket = hash(key, 0);
        int startBucket = bucket;
        int i = 0;
        int firstTombstone = -1; // store the first deleted entry

        while (table[bucket] != null) {
            if (table[bucket].getKey() == key) {
                return bucket; // found key
            }
            if (table[bucket].serialNumber == -1 && firstTombstone == -1) {
                firstTombstone = bucket; // first available deleted slot
            }
            i++;
            bucket = hash(key, i);
            if (bucket == startBucket) {
                break;
            }
        }

        return firstTombstone != -1 ? firstTombstone : -1; // return tombstone if no exact match
    }

    // get method
    public Computer get(int key) {
        int index = findIndex(key);
        return index != -1 ? table[index] : null;
    }

    public double getLoadFactor() {
        int count = 0;
        for (Computer computer : table) {
            if (computer != null) {
                count++;
            }
        }
        return (double) count / table.length;
    }

    public void resize() {
        // double the size
        Computer[] oldTable = table;
        table = new Computer[oldTable.length * 2];
        for (Computer computer : oldTable) {
            if (computer != null && computer.serialNumber != -1) {
                insert(computer);
            }
        }
        System.out.println("Resized to " + table.length + "!");
    }

    public void resizeInsert(Computer computer) {
        this.resize();
        this.insert(computer);
    }

    // // insert method
    // public void insert(Computer computer) {
    // if (getLoadFactor() > 0.60) {
    // // System.out.println("[+] Triggering resize...");
    // this.resizeInsert(computer);
    // return;
    // }

    // int key = computer.getKey();
    // int bucket = hash(key, 0);
    // int startBucket = bucket;
    // int i = 0;
    // int collisionCount = 0;

    // while (table[bucket] != null && !(table[bucket].serialNumber == -1)) {
    // collisionCount++;
    // // System.out.println("[+] Collision detected at bucket " + bucket + "!. CC =
    // " + collisionCount);
    // if (collisionCount >= 4) {
    // // resize table, then retry insert
    // // System.out.println("[+] CC >= 4, forcing resize...");
    // resizeInsert(computer);
    // return;
    // }
    // i++;
    // bucket = hash(key, i);
    // if (bucket == startBucket) {
    // System.out.println("Table is full!");
    // return;
    // }
    // }

    // table[bucket] = computer;
    // }

    public void insert(Computer computer) {
        if (getLoadFactor() > 0.60) {
            this.resizeInsert(computer);
            return;
        }

        int key = computer.getKey();
        int bucket = hash(key, 0);
        int startBucket = bucket;
        int i = 0;
        int collisionCount = 0;
        int firstTombstone = -1;

        while (table[bucket] != null) {
            if (table[bucket].serialNumber == -1 && firstTombstone == -1) {
                firstTombstone = bucket; // remember first tombstone
            }
            collisionCount++;
            if (collisionCount >= 4) {
                resizeInsert(computer);
                return;
            }
            i++;
            bucket = hash(key, i);
            if (bucket == startBucket) {
                System.out.println("Table is full!");
                return;
            }
        }

        // if we found a tombstone, insert there
        if (firstTombstone != -1) {
            bucket = firstTombstone;
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