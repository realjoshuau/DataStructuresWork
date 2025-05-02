import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length: ");
        int length = scanner.nextInt();

        MyHashTable hashTable;
        if (length == -1) {
            hashTable = new MyHashTable();
        } else {
            hashTable = new MyHashTable(length);
        }

        int choice;
        do {
            System.out.println("1. Insert a new element");
            System.out.println("2. Remove an element");
            System.out.println("3. Find an element");
            System.out.println("4. Quit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Operating System: ");
                    String os = scanner.next();
                    System.out.print("Enter Manufacture Year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Serial Number: ");
                    int serialNumber = scanner.nextInt();
                    hashTable.insert(new Computer(os, year, serialNumber));
                    break;
                case 2:
                    System.out.print("Enter key: ");
                    int removeKey = scanner.nextInt();
                    hashTable.remove(removeKey);
                    break;
                case 3:
                    System.out.print("Enter key: ");
                    int findKey = scanner.nextInt();
                    int bucket = hashTable.findIndex(findKey);
                    if (bucket != -1) {
                        System.out.println("Found in bucket " + bucket + "!");
                        System.out.println(hashTable.get(findKey));
                    } else {
                        System.out.println("Not found!");
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}