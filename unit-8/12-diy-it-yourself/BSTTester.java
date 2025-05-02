
import java.util.Scanner;

class BSTTester {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst = new MyBinarySearchTree<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println(
                    "1. Insert a new element\n2. Remove an element\n3. Find an element\n4. Display nodes in order\n5. Print tree height\n6. Quit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    bst.insert(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter key: ");
                    System.out.println(bst.remove(scanner.nextInt()) ? "" : "Not found.");
                    break;
                case 3:
                    System.out.print("Enter key: ");
                    Integer key = scanner.nextInt();
                    System.out.println(bst.search(key) != null ? key + " was found." : key + " was not found!");
                    break;
                case 4:
                    bst.treePrint();
                    break;
                case 5:
                    System.out.println("The tree has a height of " + bst.treeHeight());
                    break;
                case 6:
                    // System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
