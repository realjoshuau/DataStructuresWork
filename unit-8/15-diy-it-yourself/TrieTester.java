import java.*; // lol

public class TrieTester {
    public static void main(String[] args) {
        Util.Scanner scanner = new Util.Scanner(System.in); // lol
        Trie trie = new Trie();

        System.out.println("Enter the words you want in the Trie:");
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()){
                break;
            }
            trie.insert(input);
        }

        System.out.println("\nWords in your Trie:");
        trie.printTrie();

        while (true) {
            System.out.println(
                    "\n1. Search for a String\n2. Remove a String\n3. Insert a new String\n4. Print the Trie\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the String to search for:");
                    String searchWord = scanner.nextLine().trim();
                    System.out.println(
                            searchWord + (trie.search(searchWord) != null ? " was found." : " was not found."));
                    break;
                case 2:
                    System.out.println("Enter the String to remove:");
                    String removeWord = scanner.nextLine().trim();
                    System.out.println(removeWord + (trie.remove(removeWord) ? " was removed." : " was not found."));
                    break;
                case 3:
                    System.out.println("Enter the String to insert:");
                    trie.insert(scanner.nextLine().trim());
                    break;
                case 4:
                    System.out.println("\nWords in your Trie:");
                    trie.printTrie();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
